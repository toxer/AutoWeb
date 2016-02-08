package it.infocamere.test;

import it.infocamere.desktop.DesktopUtils;
import it.infocamere.exception.ExecutionException;
import it.infocamere.mainwindow.MainWindow;
import it.infocamere.utils.LongOperation;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Panel;

public class BusyTestController extends SelectorComposer<Panel> {
	Logger logger = Logger.getLogger(BusyTestController.class);

	public void doAfterCompose(Panel comp) {
		try {
			super.doAfterCompose(comp);
		} catch (Exception exc) {
			throw new ExecutionException(exc);
		}
	}

	@Wire
	Button busy;

	@Listen("onClick=#busy")
	public void busyClick() {
		logger.info("Click");
		final MainWindow mainWindow = DesktopUtils.getMainWindowFromDesktop();

		
		new LongOperation() {

			@Override
			protected void execute() throws InterruptedException {
				//codice da eseguire
				Thread.sleep(2000); // you'll do the heavy work here instead of
									// sleeping
				throw new ExecutionException();
			}

			@Override
			protected void onCleanup() {
				Clients.clearBusy(mainWindow);
				
				//codice di uscita anche in caso di errore
				
			};
		}.start();
		Clients.showBusy(mainWindow, "WAITING...");

	}

}
