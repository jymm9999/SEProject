package ServerSystem;

public class MenuManager {
	
	private static final int insert = 0;
	private static final int delete = 1;
	private static final int update = 2;
	
	public static int[] getMenuindex() {		
		return Menu.getMenuindex();
	}
	public static String[] getMenuname() {
		return Menu.getMenuname();
	}
	public static float[] getPrice() {
		return Menu.getPrice();
	}
		
	private static int tempmenuindex;
	private static String tempmenuname;
	private static float tempprice;
	
	public static void setTempmenuindex(int tempmenuindex) {
		MenuManager.tempmenuindex = tempmenuindex;
	}
	public static void setTempmenuname(String tempmenuname) {
		MenuManager.tempmenuname = tempmenuname;
	}
	public static void setTempprice(float tempprice) {
		MenuManager.tempprice = tempprice;
	}
	

	public static void adjustDB(int state){
		if(state == insert){
			Menu.addDB(tempmenuname, tempprice);
		}
		else if(state == delete){
			Menu.deleteDB(tempmenuindex);
		}
		else if(state == update){
			
			Menu.updateDB(tempmenuindex, tempmenuname, tempprice);
		}
	}
}
