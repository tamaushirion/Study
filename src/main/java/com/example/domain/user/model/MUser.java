package com.example.domain.user.model;

import lombok.Data;

@Data
public class MUser {
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private Integer role;
}
