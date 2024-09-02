package com.example.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignupForm {
	
	private String userName;
	@Email
	private String email;
	@Length(min = 8, max = 50)
	private String password;
	
	private String confirmPassword;
	
	@AssertTrue(message = "新しいパスワードと一致しません。")
    public boolean isPasswordValid() {
        if (password == null || password.isEmpty()) {
            return true;
        }

        return password.equals(confirmPassword);
    } 
}
