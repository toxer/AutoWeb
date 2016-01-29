package it.infocamere.testWeb;

//import it.infocamere.testejb.SimpleFacade;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

public class MainWindowController extends SelectorComposer<Window>{
	Logger logger = Logger.getLogger(this.getClass());
	@Wire 
	Label testLabel;
	
	public void doAfterCompose(Window w){
		try{
			super.doAfterCompose(w);
			logger.info("OK");
			//DateTime d = new DateTime();
			DateTime d = new DateTime();
			testLabel.setValue(d.toString( DateTimeFormat.forPattern("MMMM, yyyy")));
		//	SimpleFacade f = new SimpleFacade();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
	
	

}
