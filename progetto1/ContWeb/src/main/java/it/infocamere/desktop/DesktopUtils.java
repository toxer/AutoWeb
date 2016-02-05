package it.infocamere.desktop;

import it.infocamere.mainwindow.MainWindow;
import it.infocamere.mainwindow.MainWindowController;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Borderlayout;

public class DesktopUtils {
	private static Logger logger = Logger.getLogger(DesktopUtils.class);
	
	public static Desktop getDesktop(){
		return Executions.getCurrent().getDesktop();
	}

	public static void setMainWindowInDesktop(MainWindow w) {
		Executions.getCurrent().getDesktop()
				.setAttribute(DesktopAttributes.MAIN_WINDOW, w);
	}

	public static MainWindow getMainWindowFromDesktop() {
		return (MainWindow) Executions.getCurrent().getDesktop()
				.getAttribute(DesktopAttributes.MAIN_WINDOW);
	}

	public static void setMainWindowControllerInDesktop(MainWindowController w) {
		Executions.getCurrent().getDesktop()
				.setAttribute(DesktopAttributes.MAIN_WINDOW_CONTROLLER, w);
	}

	public static MainWindowController getMainWindowControllerFromDesktop() {
		return (MainWindowController) Executions.getCurrent().getDesktop()
				.getAttribute(DesktopAttributes.MAIN_WINDOW_CONTROLLER);
	}

	public static void setMainBorderLayout(Borderlayout borderLayout) {
		Executions
				.getCurrent()
				.getDesktop()
				.setAttribute(DesktopAttributes.MAIN_BORDER_LAYOUT,
						borderLayout);
	}

	public static Borderlayout getMainBorderLayout() {
		return (Borderlayout) Executions.getCurrent().getDesktop()
				.getAttribute(DesktopAttributes.MAIN_BORDER_LAYOUT);
	}
	
	/**
	 * Se attivata la modalità, fa uscire un messaggio di conferma prima di effettuare
	 * la navigazione
	 * 
	 */
	public static void enablePreventNavigation(){
		getMainWindowFromDesktop().setAttribute("preventNav",true);
	}

	public static void disablePreventNavigation(){
		getMainWindowFromDesktop().removeAttribute("preventNav");
	}
	
	public static boolean isNavigationPrevented(){
		return getMainWindowFromDesktop().getAttribute("preventNav")!=null?(Boolean)getMainWindowFromDesktop().getAttribute("preventNav"):false;
	}
	
}
