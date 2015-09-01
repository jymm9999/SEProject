package OrderSystem;

import Connect.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;



public class OrderManager {
	
	
	private static final int insert = 0;
	private static final int delete = 1;

	private static String registerInfo = "";
	private static String loginInfo = "";

	private static String loginID;
	private static String loginPW;

	public static void getRegister(String data) {
		registerInfo = data;
		StringTokenizer st = new StringTokenizer(registerInfo);
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken("/"));
		}
	}

	public static void getLogin(String data) {
		loginInfo = data;
		StringTokenizer st = new StringTokenizer(loginInfo);
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken("/"));
		}
	}
	
	public static int[] getOrderindex() {		
		return Order.getOrderindex();
	}
	public static String[] getMenuname() {
		return Order.getMenuname();
	}
	public static float[] getPrice() {
		return Order.getPrice();
	}
	public static String[] getCustomerid() {
		return Order.getCustomerid();
	}
	public static String[] getCustomername() {
		return Order.getCustomername();
	}
	public static String[] getPhonenumber() {
		return Order.getPhonenumber();
	}
	public static String[] getCustomeraddress() {
		return Order.getCustomeraddress();
	}
	public static int[] getMemberstate() {
		return Order.getMemberstate();
	}
	public static int[] getDeliverystate() {
		return Order.getDeliverystate();
	}
	public static int[] getOrdernumber() {
		return Order.getOrdernumber();
	}

	private static int temporderindex;
	private static String tempmenuname;
	private static float tempprice;
	private static String tempcustoemrid;
	private static String tempcustomername;
	private static String tempphonenumber;
	private static String tempcustomeraddress;
	private static int tempmemberstate;
	private static int tempdeliverystate;
	private static int tempordernumber;
	
	
	public static void setTemporderindex(int temporderindex) {
		OrderManager.temporderindex = temporderindex;
	}

	public static void setTempmenuname(String tempmenuname) {
		OrderManager.tempmenuname = tempmenuname;
	}

	public static void setTempprice(float tempprice) {
		OrderManager.tempprice = tempprice;
	}

	public static void setTempcustoemrid(String tempcustoemrid) {
		OrderManager.tempcustoemrid = tempcustoemrid;
	}

	public static void setTempcustomername(String tempcustomername) {
		OrderManager.tempcustomername = tempcustomername;
	}

	public static void setTempphonenumber(String tempphonenumber) {
		OrderManager.tempphonenumber = tempphonenumber;
	}

	public static void setTempcustomeraddress(String tempcustomeraddress) {
		OrderManager.tempcustomeraddress = tempcustomeraddress;
	}

	public static void setTempmemberstate(int tempmemberstate) {
		OrderManager.tempmemberstate = tempmemberstate;
	}

	public static void setTempdeliverystate(int tempdeliverystate) {
		OrderManager.tempdeliverystate = tempdeliverystate;
	}

	public static void setTempordernumber(int tempordernumber) {
		OrderManager.tempordernumber = tempordernumber;
	}


	public static void adjustDB(int state){
		if(state == insert){
			Order.addDB(tempmenuname, tempprice, tempcustoemrid,
					tempcustomername, tempphonenumber, tempcustomeraddress,
					tempmemberstate, tempdeliverystate, tempordernumber);
		}
		else if(state == delete){
			Order.deleteDB(temporderindex);
		}
	}
	
	
}
