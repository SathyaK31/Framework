package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.UserBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;
// fetching sql properties and getting connection with DB
public class UserDAO {

	Properties properties; 
	//loading sql properties
	public UserDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// getting connection with DB
	public List<UserBean> getLogins(){
		String sql = properties.getProperty("get.user"); 
		
		GetConnection gc  = new GetConnection(); 
		List<UserBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<UserBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				UserBean temp = new UserBean(); 
				temp.setfirstname(gc.rs1.getString(1));
				temp.setlastname(gc.rs1.getString(2));
				temp.setEmail(gc.rs1.getString(3));
				temp.setPhone(gc.rs1.getString(4));
				temp.setLogin(gc.rs1.getString(5));
				temp.setPassword(gc.rs1.getString(6));
				temp.setProfile(gc.rs1.getString(7));
				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new UserDAO().getLogins().forEach(System.out :: println);
	}
	
	
}
