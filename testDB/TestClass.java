package testDB;

import OrderSystem.*;

public class TestClass {
	public static void main(String[] args){
		int t = 5;
		String a = "delete from orderinfo where orderindex = "+t+";";
		System.out.println(a);
	}
}
