package it.infocamere.mainwindow;

//import it.infocamere.testejb.SimpleFacade;


import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Window;

public class MainWindowController extends SelectorComposer<Window> {
	Logger logger = Logger.getLogger(this.getClass());
	@Wire
	Panel panel;

	public void doAfterCompose(Window w) {
		try {
			super.doAfterCompose(w);
			
			while (panel.getFirstChild() != null) {
				panel.removeChild(panel.getFirstChild());
			}

			Executions
					.createComponents("/WEB-INF/pages/panel.zul", panel, null);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
