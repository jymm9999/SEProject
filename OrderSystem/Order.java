package OrderSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connect.DBConnect;

public class Order {

	private static int[] orderindex;
	private static String[] menuname;
	private static float[] price;
	private static String[] customerid;
	private static String[] customername;
	private static String[] phonenumber;
	private static String[] customeraddress;
	private static int[] memberstate;
	private static int[] deliverystate;
	private static int[] ordernumber;

	public void getInfo() {

		int count = 0;
		int iter = 0;
		try {
			Statement orderStatement = DBConnect.connect().createStatement();
			ResultSet orderResultset = orderStatement
					.executeQuery("select count(*) as cnt from orderinfo;");

			while (orderResultset.next()) {
				count = orderResultset.getInt("cnt");
			}

			orderindex = new int[count];
			menuname = new String[count];
			price = new float[count];
			customerid = new String[count];
			customername = new String[count];
			phonenumber = new String[count];
			customeraddress = new String[count];
			memberstate = new int[count];
			deliverystate = new int[count];
			ordernumber = new int[count];

			orderResultset = orderStatement
					.executeQuery("select * from orderinfo;");

			while (orderResultset.next()) {
				orderindex[iter] = orderResultset.getInt("orderindex");
				menuname[iter] = orderResultset.getString("menuname");
				price[iter] = orderResultset.getFloat("price");
				customerid[iter] = orderResultset.getString("customerid");
				customername[iter] = orderResultset.getString("customername");
				phonenumber[iter] = orderResultset.getString("phonenumber");
				customeraddress[iter] = orderResultset
						.getString("customeraddress");
				memberstate[iter] = orderResultset.getInt("memberstate");
				deliverystate[iter] = orderResultset.getInt("deliverystate");
				ordernumber[iter] = orderResultset.getInt("ordernumber");

				iter++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int[] getOrderindex() {
		return orderindex;
	}

	public static String[] getMenuname() {
		return menuname;
	}

	public static float[] getPrice() {
		return price;
	}

	public static String[] getCustomerid() {
		return customerid;
	}

	public static String[] getCustomername() {
		return customername;
	}

	public static String[] getPhonenumber() {
		return phonenumber;
	}

	public static String[] getCustomeraddress() {
		return customeraddress;
	}

	public static int[] getMemberstate() {
		return memberstate;
	}

	public static int[] getDeliverystate() {
		return deliverystate;
	}

	public static int[] getOrdernumber() {
		return ordernumber;
	}

	public static void deleteDB(int index) {
		int tempindex = index;
		try {

			Statement orderStatement = DBConnect.connect().createStatement();
			orderStatement
					.executeUpdate("delete from orderinfo where orderindex = "
							+ tempindex + ";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addDB(String menuname, float price, String customerid,
			String customername, String phonenumber, String customeraddress,
			int memberstate, int deliverystate, int ordernumber) {

		int count = 0;
		
		try {
			Statement orderStatement = DBConnect.connect().createStatement();
			ResultSet orderResultset = orderStatement
					.executeQuery("select count(*) as cnt from orderinfo;");

			while (orderResultset.next()) {
				count = orderResultset.getInt("cnt");
			}
			int tempindex = count+1;
			
			orderStatement = DBConnect.connect().createStatement();
			orderStatement
					.executeUpdate("insert into orderinfo values("+tempindex+","+menuname+","+price+","+customerid +
							","+customername +"," + phonenumber + "," + customeraddress + "," + memberstate +
							"," + deliverystate + "," + ordernumber+ ");");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
