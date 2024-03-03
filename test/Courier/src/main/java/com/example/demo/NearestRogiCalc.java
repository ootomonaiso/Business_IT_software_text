package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class NearestRogiCalc {
	@Autowired
    private JdbcTemplate jdbcTemplate;{

	try {
		// INSERT文のSQLクエリを定義
		String sql = "INSERT INTO `store` (`nearest_rogi_id`) VALUES (?)";
		// JdbcTemplateを使ってSQLを実行
		jdbcTemplate.update(sql);
		System.out.println("Data saved successfully.");
	} catch (Exception e) {
		System.err.println("Error saving data: " + e.getMessage());
	}
}}
