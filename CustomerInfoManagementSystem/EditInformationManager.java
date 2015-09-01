package CustomerInfoManagementSystem;

import java.util.StringTokenizer;

public class EditInformationManager {

	private static String clientInfo="";
	
	public static void getClientInfo(String data) {
		clientInfo = data;
		StringTokenizer st = new StringTokenizer(clientInfo);
	     while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken("/"));
	     }
	}
	
}
