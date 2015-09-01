package OrderSystem;

import java.util.StringTokenizer;

public class NonOrderManager {
	
	private static String nonClientInfo="";
	
	public static void getNonClientInfo(String data) {
		nonClientInfo = data;
		StringTokenizer st = new StringTokenizer(nonClientInfo);
	     while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken("/"));
	     }
	}
}
