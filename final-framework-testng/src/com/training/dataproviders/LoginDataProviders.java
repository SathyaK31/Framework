package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.UserBean;
import com.training.dao.ELearningDAO;
import com.training.dao.UserDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-user-inputs")
	public Object [][] getDBuserData() {

		List<UserBean> list1 = new UserDAO().getLogins(); 
		
		Object[][] result = new Object[list1.size()][]; 
		int count = 0; 
		for(UserBean temp : list1){
			Object[]  obj = new Object[7]; 
			obj[0] = temp.getfirstname(); 
			obj[1] = temp.getlastname(); 
			obj[2]=temp.getEmail();
			obj[3]=temp.getPhone();
			obj[4]=temp.getLogin();
			obj[5]=temp.getPassword();
			obj[6]=temp.getProfile();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getDataLogin(){
		String fileName ="C:/Users/SathyaK/Desktop/SELENIUM TRAINING/Project/TestData.xlsx"; 
		String sheetName="Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	@DataProvider(name = "excel-inputs-adduser")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/SathyaK/Desktop/SELENIUM TRAINING/Project/TestData.xlsx"; 
		String sheetName="Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	@DataProvider(name = "excel-inputs-invaliduser")
	public Object[][] getExcelData3(){
		String fileName ="C:/Users/SathyaK/Desktop/SELENIUM TRAINING/Project/TestData.xlsx"; 
		String sheetName="Sheet3";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
