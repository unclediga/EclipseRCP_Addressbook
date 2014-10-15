package myinjection.service;

import java.util.ArrayList;

public class MyService {
	private ArrayList<String> list;
	public MyService() {
		list = new ArrayList<String>(10);
		for (int i = 0; i < 10; i++) {
			list.add("Element "+i);
		}
	}
	
	public ArrayList<String> getList(){
		return list;
	}
}
