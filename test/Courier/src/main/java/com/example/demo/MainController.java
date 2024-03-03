package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
@Configuration
@Controller
public class MainController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    

    @RequestMapping("/") // ホーム
    public String mainGet(Model model) {
        System.out.println("top page");
        model.addAttribute("errorMessage", ""); // 初期化として空のエラーメッセージをセット
        System.out.println(passwordEncoder.encode("aaa"));
        return "TopPage";
        

    }
    @PostMapping("/customer/check")
    public String verifyTextField(@RequestParam("inputText") String inputText, Model model, HttpSession session) {
        List<String> validValues = getValidValuesFromDatabase();
        if (validValues.contains(inputText)) {
            // 一致する場合はリンク先に飛ばす

            // 入力されたIDをセッションに保存
            session.setAttribute("inputId", inputText);
            return "redirect:/customer";
        } else {
            // 一致しない場合はエラーメッセージを表示
            model.addAttribute("errorMessage", "入力した文字列は無効です。");
            return "TopPage";
        }
    }

    private List<String> getValidValuesFromDatabase() {
        String sql = "SELECT id FROM customer"; // customerテーブルのidカラムを取得するクエリ
        return jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("id");
            }
        });
    }

	
	@RequestMapping("login")
	public String loginGet(Model model) {

		return "Login";
	}

	@RequestMapping("/customer")
	public String customerPage(HttpSession session, Model model) {
	    String inputId = (String) session.getAttribute("inputId");
	    
	    return "CustomerPage";
	}

	

	
	@RequestMapping("employee")
	public String employeeGet(Model model) {
	    	
	        List<Point> points = new ArrayList<>();
	        
	        // Find the index of point with id:1
	        int startIdx = 0;
	        for (int j = 0; j < points.size(); j++) {
	            if (points.get(j).id == 1) {
	                startIdx = j;
	                break;
	            }
	        }

	        // Rotate the points list so that point with id:1 is at the beginning
	        Collections.rotate(points, -startIdx);
	        
	        
	        points.add(new Point(1, 0, 0,111));
	        points.add(new Point(2, 1, 6,222));
	        points.add(new Point(3, 3, 1,333));
	        points.add(new Point(4, 2, 4,444));
	        points.add(new Point(5, 4, 3,555));
	        points.add(new Point(6, 1, 2,666));
	        points.add(new Point(7, 3, 4,777));
	        points.add(new Point(8, 8, 3,888));
	        points.add(new Point(9, 3, 0,999));
	        points.add(new Point(10, 4, 2,101010));
	        // 他のクラスからTwoOptTSPのfindOptimalRouteメソッドを呼び出す
	        List<Point> result = TwoOptTSP.findOptimalRoute(points);

	        
	        // 結果を表示する
	        List<Integer> orderList = new ArrayList<>();
	        boolean foundOne = false;

	        for (Point point : result) {
	            if (point.id == 1) {
	                foundOne = true;
	            }
	            if (foundOne) {
	                orderList.add(point.customerId);
	            }
	        }

	        for (Point point : result) {
	            if (point.id == 1) {
	                break;
	            }
	            orderList.add(point.customerId);
	        }
	        
	        String elements = orderList.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
			System.out.println("[" + elements + "]");
			
	        System.out.println("Shortest route (displayed by store ID):   "+elements);
	        try {
				// INSERT文のSQLクエリを定義
				String sql = "INSERT INTO `route` (`sequence`) VALUES (?)";
				// JdbcTemplateを使ってSQLを実行
				jdbcTemplate.update(sql,elements);
				System.out.println("Data saved successfully.");
			} catch (Exception e) {
				System.err.println("Error saving data: " + e.getMessage());
			}
	        

	    
		return "Employee";
	}

	@RequestMapping("admin")
	public String AdminGet(Model model) {
		System.out.println("adminpage");
		return "AdminPage";
	}

	@RequestMapping("failre")
	public String failureGet(Model model) {
		System.out.println("AA");
		return "Failure";
	}
	
	@RequestMapping("example")
	public String exampleGet(Model model) {
		System.out.println("LoginSuccess");
		return "LoginSuccess";
	}
}


@Controller
class CustomerOrderController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/customer/order/form")
	public String showForm(Model model) {
		System.out.println("Showing form");
		model.addAttribute("customerOrder", new CustomerOrderEntity());
		return "form";
	}

	@PostMapping("/save")
	public String saveData(@ModelAttribute CustomerOrderEntity customerOrder) {
		// フォームから受け取ったデータを取得
		Integer s_Post = customerOrder.getSenderPost();
		String s_address = customerOrder.getSenderAddress();
	    String  s_nameKanji= customerOrder.getSenderNameKanji();
	    String  s_nameKana= customerOrder.getSenderNameKana();
	    LocalDate  s_date = customerOrder.getSenderDate();
	    Integer r_Post = customerOrder.getRecipientPost();
	    String r_address = customerOrder.getRecipientAddress();
	    String r_nameKanji = customerOrder.getRecipientNameKanji();
	    String r_nameKana = customerOrder.getRecipientNameKana();
	    LocalDate r_date = customerOrder.getRecipientDate();
	    Integer num = customerOrder.getNum();

		try {
			// INSERT文のSQLクエリを定義
			String sql = "INSERT INTO `customer` (`s_postcode`, `s_address`,`s_name_kanji`,`s_name_kana`,`s_date`,`r_postcode`, `r_address`,`r_name_kanji`,`r_name_kana`,`r_date`,`num`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			// JdbcTemplateを使ってSQLを実行
			jdbcTemplate.update(sql, s_Post, s_address, s_nameKanji,s_nameKana,s_date,r_Post,r_address,r_nameKanji,r_nameKana,r_date,num);
			System.out.println("Data saved successfully.");
		} catch (Exception e) {
			System.err.println("Error saving data: " + e.getMessage());
		}
		return "redirect:/customer/order/form";
	}
}