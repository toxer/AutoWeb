package it.infocamere.navbar;

import it.infocamere.desktop.DesktopUtils;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.BookmarkEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Panelchildren;

public class NavbarController extends SelectorComposer<Panelchildren>{
	//riferimenti
	
	
	Logger logger = Logger.getLogger(NavbarController.class);
	Panelchildren comp;


	public void doAfterCompose(Panelchildren comp){
		try{
			this.comp = comp;
			super.doAfterCompose(comp);
			
			
		}
		catch (Exception exc){
			throw new RuntimeException(exc);
		}
	}
	
	
		
	
	@Listen("onClick=menuitem")
	public void elementSelect(Event evt){
		String bookmark = (String)evt.getTarget().getAttribute("bookmark");
		if (bookmark!=null){
				
			Executions.getCurrent().getDesktop().setBookmark(bookmark);
			//notifico l'evento di cambio bookmark esplicitamente
			BookmarkEvent bookEvent = new BookmarkEvent(Events.ON_BOOKMARK_CHANGE,bookmark);
			Events.postEvent(bookEvent);
		}
	}
	
	
	
	

}
