package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginUserRepository {

	// SQL_FIND_BY_EMAILクエリ: メールアドレスを使ってデータベースからログインユーザーを検索するSQLクエリ
	private static final String SQL_FIND_BY_EMAIL = """
		SELECT
			employee_id as user_name,
			password,
			role as role_name,
			name_kanji as name_k
			     FROM employee
                 where employee_id = :account_id
			     """;

	// LOGIN_USER_EXTRACTOR: SQLクエリの実行結果からLoginUserオブジェクトを生成するためのResultSetExtractor
	private static final ResultSetExtractor<LoginUser> LOGIN_USER_EXTRACTOR = (rs) -> {
		String name_k = null;
		String userName = null;
		String password = null;
		List<String> roleList = new ArrayList<>();

		// ResultSetから結果を取り出してLoginUserオブジェクトを作成
		while (rs.next()) {
			if (name_k == null) {
				userName = rs.getString("user_name");
				password = rs.getString("password");
				name_k = rs.getString("name_k");
			}
			roleList.add(rs.getString("role_name"));
			System.out.println("user="+userName + "  role_id=" + roleList+"  password="+password+"  kanji="+name_k);
		}

		// 結果がない場合はnullを返し、ある場合はLoginUserオブジェクトを返す
		if (name_k == null) {
			return null;
		}
		return new LoginUser( userName, password,name_k, roleList);
	};

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// コンストラクタ: NamedParameterJdbcTemplateを注入する
	public LoginUserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	// findByEmailメソッド: メールアドレスを使ってデータベースからログインユーザーを検索し、Optionalで結果を返す
	public Optional<LoginUser> findByName(String user_name) {
		//System.out.println("SYSS" + user_name);
		MapSqlParameterSource params = new MapSqlParameterSource("account_id", user_name);
		LoginUser loginUser = namedParameterJdbcTemplate.query(SQL_FIND_BY_EMAIL, params, LOGIN_USER_EXTRACTOR);
		return Optional.ofNullable(loginUser);
	}
}
