package myinjection.service;

import java.util.ArrayList;

public class MyServiceDSImpl implements MyServiceDS {
	private ArrayList<String> list;
	
	public MyServiceDSImpl() {
		System.out.println("###Constructor MyServiceDSImpl");
		list = new ArrayList<String>(10);
		for (int i = 0; i < 10; i++) {
			list.add("ElementDS "+i);
		}
	}
	
	/* (non-Javadoc)
	 * @see myinjection.service.MyServiceDS2#getList()
	 */
	@Override
	public String[] getList(){
		return (String[]) list.toArray(new String[list.size()]);
	}
}
