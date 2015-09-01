package ServerSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connect.DBConnect;

public class Menu {
	
	private static int[] menuindex;
	private static String[] menuname;
	private static float[] price;
	
	public void getInfo() {

		int count = 0;
		int iter = 0;
		try {
			Statement orderStatement = DBConnect.connect().createStatement();
			ResultSet orderResultset = orderStatement
					.executeQuery("select count(*) as cnt from menu;");

			while (orderResultset.next()) {
				count = orderResultset.getInt("cnt");
			}

			menuindex = new int[count];
			menuname = new String[count];
			price = new float[count];

			orderResultset = orderStatement
					.executeQuery("select * from menu;");

			while (orderResultset.next()) {
				menuindex[iter] = orderResultset.getInt("menuindex");
				menuname[iter] = orderResultset.getString("menuname");
				price[iter] = orderResultset.getFloat("price");

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
	
	
	
	public static void deleteDB(int index) {
		int tempindex = index;
		try {

			Statement orderStatement = DBConnect.connect().createStatement();
			orderStatement
					.executeUpdate("delete from menu where menuindex = "
							+ tempindex + ";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
