package it.infocamere.desktop;

import it.infocamere.mainwindow.MainWindow;
import it.infocamere.mainwindow.MainWindowController;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;

public class DesktopUtils {
	private static Logger logger = Logger.getLogger(DesktopUtils.class);
	
	
	public static void storeMainWindowInDesktop(MainWindow w){
		Executions.getCurrent().getDesktop().setAttribute(DesktopAttributes.MAIN_WINDOW,w);
	}
	
	public static MainWindow getMainWindowFromDesktop(){
		return (MainWindow)Executions.getCurrent().getDesktop().getAttribute(DesktopAttributes.MAIN_WINDOW);
	}
	public static void storeMainWindowControllerInDesktop(MainWindowController w){
		Executions.getCurrent().getDesktop().setAttribute(DesktopAttributes.MAIN_WINDOW_CONTROLLER,w);
	}
	
	public static MainWindowController getMainWindowControllerFromDesktop(){
		return (MainWindowController)Executions.getCurrent().getDesktop().getAttribute(DesktopAttributes.MAIN_WINDOW_CONTROLLER);
	}
	
	
	
	

}
