package com.BikkadIT.UserManagementApplication.biding;

import lombok.Data;

@Data
public class UnlockAccountForm {
    private String email;
	
	private String tempPwd;
	
	private String newPwd;
	
	private String confirmPwd;


}
