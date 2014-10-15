package myinjection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import myinjection.service.MyService;
import myinjection.service.MyServiceDS;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "MyInjection"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		System.out.println("Activator:Started "+PLUGIN_ID);

		
//		System.out.println("Find service by 'context.getServiceReferences(MyService.class,null)'");
//		Collection<ServiceReference<MyService>> services = context.getServiceReferences(MyService.class,null);
//		for (Iterator iterator = services.iterator(); iterator.hasNext();) {
//			ServiceReference<MyService> serviceReference = (ServiceReference<MyService>) iterator.next();
//			System.out.println("Found srv: " + serviceReference.toString());
//			
//		}
//
//		System.out.println("Find elements by 'context.getServiceReference(MyService.class.getName())'");
//		ServiceReference<?> serviceReference = context.getServiceReference(MyService.class.getName());
//				MyService service = (MyService) context.getService(serviceReference);
//				ArrayList<String> list = service.getList();
//				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//					String el = (String) iterator.next();
//					System.out.println("Found elem:" + el);
//				}

	
		System.out
				.println("Find service by 'context.getServiceReferences(MyServiceDS.class,null)'");
		Collection<ServiceReference<MyServiceDS>> services2 = context
				.getServiceReferences(MyServiceDS.class, null);
		for (Iterator iterator = services2.iterator(); iterator.hasNext();) {
			ServiceReference<MyServiceDS> serviceReference2 = (ServiceReference<MyServiceDS>) iterator.next();
			System.out.println("Found srv: " + serviceReference2.toString());

		}	
	
		System.out.println("Find elements by 'context.getServiceReference(MyServiceDS.class.getName())'");
		ServiceReference<?> serviceReference2 = context.getServiceReference(MyServiceDS.class.getName());
				MyServiceDS service2 = (MyServiceDS) context.getService(serviceReference2);
				 String[] arr = service2.getList();
				for (int i = 0; i < arr.length; i++) {
					System.out.println("Found elem:" + arr[i]);
				}

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		System.out.println("Activator:Stopping "+PLUGIN_ID);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
