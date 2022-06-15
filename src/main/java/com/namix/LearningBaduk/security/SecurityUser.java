package com.namix.LearningBaduk.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.namix.LearningBaduk.entity.User;

public class SecurityUser implements UserDetails {

	/*
	 * private static final long serialVersionUID = 1L; private String userId;
	 * private String userPassword; private String userNickname; private String
	 * userEmail; private int userReport; private String userRole; private Date
	 * userDate;
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public SecurityUser(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(user.getUserRole()));
		return auth;
		
	}

	@Override
	public String getPassword() {
		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/*
	 * public String getUserId() { return userId; }
	 * 
	 * public void setUserId(String userId) { this.userId = userId; }
	 * 
	 * public String getUserPassword() { return userPassword; }
	 * 
	 * public void setUserPassword(String userPassword) { this.userPassword =
	 * userPassword; }
	 * 
	 * public String getUserNickname() { return userNickname; }
	 * 
	 * public void setUserNickname(String userNickname) { this.userNickname =
	 * userNickname; }
	 * 
	 * public String getUserEmail() { return userEmail; }
	 * 
	 * public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
	 * 
	 * public int getUserReport() { return userReport; }
	 * 
	 * public void setUserReport(int userReport) { this.userReport = userReport; }
	 * 
	 * public String getUserRole() { return userRole; }
	 * 
	 * public void setUserRole(String userRole) { this.userRole = userRole; }
	 * 
	 * public Date getUserDate() { return userDate; }
	 * 
	 * public void setUserDate(Date userDate) { this.userDate = userDate; }
	 */

}
