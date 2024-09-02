package com.example.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
@Data
public class PasswordForm {

	@Length(min = 8, max = 50)
	private String oldPassword;
	
	@Length(min = 8, max = 50)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String newPassword;
	
	private String newConfirmPassword;
	
	@AssertTrue(message = "新しいパスワードと一致しません")
    public boolean isPasswordValid() {
        if (newPassword == null || newPassword.isEmpty()) {
            return true;
        }
        return newPassword.equals(newConfirmPassword);
	}
}
