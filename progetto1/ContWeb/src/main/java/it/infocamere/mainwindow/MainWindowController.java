package it.infocamere.mainwindow;

//import it.infocamere.testejb.SimpleFacade;


import it.infocamere.desktop.DesktopUtils;
import it.infocamere.navbar.BookmarksManager;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Panel;

public class MainWindowController extends SelectorComposer<MainWindow> {
	Logger logger = Logger.getLogger(this.getClass());
	@Wire
	Panel panel;
	@Wire
	Borderlayout mainBorderLayout;
	MainWindow window;
	public void doAfterCompose(MainWindow window) {
		try {
			this.window = window;
			logger.info("Start controller");
			super.doAfterCompose(window);
			DesktopUtils.setMainWindowInDesktop(window);
			DesktopUtils.setMainWindowControllerInDesktop(this);
			DesktopUtils.setMainBorderLayout(mainBorderLayout);
			BookmarksManager.setNavbar("/WEB-INF/pages/navbar/navbar_1.zul");
			
		
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	
	
	

	
}
