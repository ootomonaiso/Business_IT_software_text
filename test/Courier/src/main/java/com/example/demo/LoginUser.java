package com.example.demo;

import java.util.List;

public record LoginUser(String user_name, String password, String name_k, List<String> roleList) {
}