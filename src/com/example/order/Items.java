package com.example.order;

public class Items {
	static String menu_items[]=new String[30];
	static int n;

	
	
	public static String getMenu_items(int i) {
		return menu_items[i];
	}
	public static void setMenu_items(int i,String m) {
		menu_items[i] = m;
	}
	
	
	public static int getN() {
		return n;
	}
	public static void setN(int n) {
		Items.n = n;
	}

}
