package myinjection.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		System.out.println("Activator:Started myinjection.service");
		context.registerService(MyService.class.getName(), new MyService(), null);
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Activator:Stopping myinjection.service");
	}

}
