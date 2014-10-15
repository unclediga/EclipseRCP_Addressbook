package de.ralfebert.rcputils.wired;

import org.eclipse.riena.core.wire.Wire;
import org.eclipse.riena.core.wire.WirePuller;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import de.ralfebert.rcputils.databinding.ModelDataBindingEditorPart;

public abstract class WiredModelDataBindingEditorPart<INPUT extends IEditorInput, MODEL> extends ModelDataBindingEditorPart<INPUT, MODEL> {

	private WirePuller wire;

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		if (bundle != null) {
			wire = Wire.instance(this).andStart(bundle.getBundleContext());
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		if (wire != null) {
			wire.stop();
			wire = null;
		}
	}


}