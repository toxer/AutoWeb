package it.infocamere.panel;

import it.infocamere.SimpleRemote.SimpleRemoteInterface;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Panelchildren;

public class PanelController extends SelectorComposer<Panelchildren> {
	@Wire
	Label result;
	static Context ctx = null;
	
	public void doAfterCompose(Panelchildren w) {
		try {
			super.doAfterCompose(w);
			if (ctx == null){
				ctx = new InitialContext();
			}
			
			//effettuo il lookup dell'ejb
			
			SimpleRemoteInterface srf = (SimpleRemoteInterface)ctx.lookup("java:global/Test/ContEjb/SimpleFacade!it.infocamere.SimpleRemote.SimpleRemoteInterface");
			result.setValue(srf.SimpleTestCall());
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
