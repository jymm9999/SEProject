package OrderSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connect.DBConnect;

public class Customer {

	private static String[] customerid;
	private static String[] customerpass;
	private static String[] customername;
	private static String[] phonenumber;
	private static String[] customeraddress;
	
	public void getInfo() {

		int count = 0;
		int iter = 0;
		try {
			Statement orderStatement = DBConnect.connect().createStatement();
			ResultSet orderResultset = orderStatement
					.executeQuery("select count(*) as cnt from customer;");

			while (orderResultset.next()) {
				count = orderResultset.getInt("cnt");
			}

			customerid = new String[count];
			customerpass = new String[count];
			customername = new String[count];
			phonenumber = new String[count];
			customeraddress = new String[count];

			orderResultset = orderStatement
					.executeQuery("select * from customer;");

			while (orderResultset.next()) {
				customerid[iter] = orderResultset.getString("customerid");
				customerpass[iter] = orderResultset.getString("customerpass");
				customername[iter] = orderResultset.getString("customername");
				phonenumber[iter] = orderResultset.getString("phonenumber");
				customeraddress[iter] = orderResultset.getString("customeraddress");

				iter++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static int[] getMenuindex() {
		return menuindex;
	}

	public static String[] getMenuname() {
		return menuname;
	}

	public static float[] getPrice() {
		return price;
	}
	

	public static void checkDB(String customerid, String customerpass){
		
		
	}
	
	public static void addDB(String menuname, float price) {

		int count = 0;
		
		try {
			Statement orderStatement = DBConnect.connect().createStatement();
			ResultSet orderResultset = orderStatement
					.executeQuery("select count(*) as cnt from menu;");

			while (orderResultset.next()) {
				count = orderResultset.getInt("cnt");
			}
			int tempindex = count+1;
			
			orderStatement = DBConnect.connect().createStatement();
			orderStatement
					.executeUpdate("insert into menu values("+tempindex+","+menuname+","+price+");");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void updateDB(int menuindex, String menuname, float price){
		
		try {

			Statement orderStatement = DBConnect.connect().createStatement();
			orderStatement
					.executeUpdate("update menu set menuname = " + menuname+
							", price = " +price+" where  menuindex ="+menuindex +";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
