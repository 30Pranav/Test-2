package com.ShoppingProject;
/*
 * @author pranav
 * date:20/12/2023
 * class Registration 
 * get the user data from console
 * having field userName,userEmail,userpPassword,userAddress
 * save the data in database
 */

import static java.lang.System.in;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Registration {

	private String userName;
	private String userEmail;
	private String userPassword;
	private String userPhone;
	private String userAddress;
	
	Scanner scanner = new Scanner(in);

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "Registration [userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userPhone=" + userPhone + ", userAddress=" + userAddress + "]";
	}

	// method register used to get data
	public void register() {

		System.out.println("Welcome to AssortShopping center");
		System.out.println("Registration Here");

		System.out.println("Enter userName");
		String userName = scanner.next();
		this.setUserName(userName);

		System.out.println("Enter userEmail ");
		String userEmail = scanner.next();
		this.setUserEmail(userEmail);

		System.out.println("Enter userPassword");
		String userPassword = scanner.next();
		this.setUserPassword(userPassword);

		System.out.println("Enter userPhone");
		String userPhone = scanner.next();
		this.setUserPhone(userPhone);

		System.out.println("Enter userAddress");
		String userAddress = scanner.next();
		this.setUserAddress(userAddress);

		try {
			Connection con = Connections.connection();
			PreparedStatement statement = con.prepareStatement(
					"insert into registration (userName,userEmail,userPassword,userPhone,userAddress)values (?,?,?,?,?)");

			statement.setString(1, userName);
			statement.setString(2, userEmail);
			statement.setString(3, userPassword);
			statement.setString(4, userPhone);
			statement.setString(5, userAddress);

			int i = statement.executeUpdate();
			if (i > 0) {
				System.out.println("Registration Successful");
			}

			statement.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
