package it.infocamere.mainwindow;

//import it.infocamere.testejb.SimpleFacade;


import it.infocamere.desktop.DesktopUtils;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Window;

public class MainWindowController extends SelectorComposer<MainWindow> {
	Logger logger = Logger.getLogger(this.getClass());
	@Wire
	Panel panel;
	MainWindow window;
	public void doAfterCompose(MainWindow window) {
		try {
			this.window = window;
			logger.info("Start controller");
			super.doAfterCompose(window);
			DesktopUtils.storeMainWindowInDesktop(window);
			DesktopUtils.storeMainWindowControllerInDesktop(this);
			
			
		
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	
	
	

	
}
