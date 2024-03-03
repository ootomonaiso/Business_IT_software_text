package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MainController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("") // ホーム
    public String mainGet(Model model) {
        return "TopPage";
    }

    @RequestMapping("senisaki")//検索用のあれ
    public String senisakiGet(Model model) {
        return "Senisaki";
    }
   

    @RequestMapping("errorPage")//エラーページ動いてるかわからん
    public String errorPageGet(Model model) {
        return "Error";
    }

    @PostMapping("Result")
    public String resultPost(String searchName, Model model) {
        // データベースから検索
        List<Map<String, Object>> searchResult = jdbcTemplate.queryForList(
                "SELECT * FROM book_database WHERE BookName LIKE ?", "%" + searchName + "%");
        // 検索結果をModelに設定
        model.addAttribute("searchResult", searchResult);

        // ログに処理情報を表示
        System.out.println("Processing ResultPost - POST request");
        System.out.println("Search Result: " + searchResult);

        return "Result";
    }
    

    @RequestMapping("addbook") 
    public String addbookGet(Model model) {
        return "addbook";
    }

    //書籍登録
    @PostMapping("addbook") 
    public String addbookPost(String bookName, Integer code, boolean status, Model model) {
        jdbcTemplate.update(
                "INSERT INTO book_database (BookName, Code, Status) VALUES (?, ?, ?)",
                bookName, code, status);

        // ログに処理情報を表示 booknameを代入してる
        System.out.println("Processing addBookPost - POST request");
        System.out.println("Added Book: " + bookName);

        // ホームにリダイレクト
        return "redirect:/addresult";
    }
    
    	//結果出すマン
    @RequestMapping("/addresult")
    public String addResult(Model model) {
        // SELECT *
        List<Map<String, Object>> allBooks = jdbcTemplate.queryForList("SELECT * FROM book_database");

        // 検索結果と追加されたラベル名を設定
        model.addAttribute("allBooks", allBooks);
        model.addAttribute( "Added successfully!"); // 任意のメッセージ

        // ぷりんてぃん
        System.out.println("Processing addResult - Displaying all books and added label");

        // addresultページを表示
        return "addresult";
    }
}

