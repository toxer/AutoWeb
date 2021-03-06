package it.infocamere.navbar;

import it.infocamere.desktop.DesktopUtils;
import it.infocamere.exception.ExecutionException;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.East;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.North;
import org.zkoss.zul.South;
import org.zkoss.zul.West;

/**
 * Classe deputata alla gestione dei bookmarks e della navigazione. I metodi
 * statici permettono di comporre dinamicamente il layout
 * 
 * Se è attivato il preventNavigation appare un messaggio di conferma
 * 
 * @author marco
 *
 */
public class BookmarksManager {
	static Logger logger = Logger.getLogger(BookmarksManager.class);

	// gestione dei bookmarks. In base a quello scelto di modifica il layout
	// delle pagine
	// il metodo viene invocato dalla index.zul
	public static void onBookmarkChange(final String bookmark) {
		logger.info("Select bookmark: " + bookmark);
		// converto nell'enumeration
		try {

			final Bookmarks bookmarckEnum = Bookmarks.valueOf(bookmark);

			if (!DesktopUtils.isNavigationPrevented()) {
				selectActionForBookmark(bookmark, bookmarckEnum);
			} else {
				Messagebox.show(
						"Non tutti i dati sono stai salvati. procedere?",
						"Attenzione", Messagebox.OK | Messagebox.CANCEL,
						Messagebox.QUESTION,
						new org.zkoss.zk.ui.event.EventListener<Event>() {
							public void onEvent(Event e) {
								if (Messagebox.ON_OK.equals(e.getName())) {
									DesktopUtils.disablePreventNavigation();
									selectActionForBookmark(bookmark,
											bookmarckEnum);
								} else if (Messagebox.ON_CANCEL.equals(e
										.getName())) {
									// ripristino l'ultima navigazione
									DesktopUtils.getDesktop().setBookmark(
											(String) DesktopUtils.getDesktop()
													.getAttribute(
															"lastBookmark"));

								}
							}
						});
			}

		} catch (java.lang.IllegalArgumentException iax) {
			logger.error("ATTENZIONE, BOOKMARK " + bookmark
					+ " non presente nell'enumeration Bookmarks");
			DesktopUtils.disablePreventNavigation();
			// iax.printStackTrace();
			return;
		}
	}

	/**
	 * Qui vanno effettivamente mappate le azioni per la navigazione
	 * 
	 * @param bookmark
	 * @param bookmarckEnum
	 */
	private static void selectActionForBookmark(String bookmark,
			Bookmarks bookmarckEnum) {
		// effettuo il cambio nella barra dell'url

		// controllo se posso effettuare la navigazione

		DesktopUtils.getDesktop().setBookmark(bookmark);
		// mi salvo il valore dell'ultima navigazione
		DesktopUtils.getDesktop().setAttribute("lastBookmark", bookmark);
		switch (bookmarckEnum) {
		case bookmark_1:
			logger.info("Navigazione a bookmark1");
			composeLayout("/WEB-INF/pages/test/ejbTest.zul");
			break;
		case bookmark_2:
			DesktopUtils.enablePreventNavigation();
			logger.info("Attivato prevent");
			break;
		case bookmark_3:
			composeLayout("/WEB-INF/pages/test/busyTest.zul");
			break;
		default:

			logger.error("Non trovata azione per il bookmark");
			break;
		}
	}

	/**
	 * Se il parametro è vero, viene ripulito il pannello indicato
	 * 
	 * @param centerPanel
	 * @param eastPanel
	 * @param westPanel
	 * @param southPanel
	 * @param northPanel
	 */
	public static void clearPanels(boolean centerPanel, boolean eastPanel,
			boolean westPanel, boolean southPanel, boolean northPanel) {
		Borderlayout bl = DesktopUtils.getMainBorderLayout();
		Center center = bl.getCenter();
		East east = bl.getEast();
		West west = bl.getWest();
		South south = bl.getSouth();
		North north = bl.getNorth();
		if (centerPanel) {
			emptyComponent(center);
		}
		if (eastPanel) {
			emptyComponent(east);
		}
		if (westPanel) {
			emptyComponent(west);
		}

		if (southPanel) {
			emptyComponent(south);
		}
		if (northPanel) {
			emptyComponent(north);
		}
	}

	public static void setNavbar(String navbarZul) {
		emptyComponent(DesktopUtils.getMainBorderLayout().getNorth());
		DesktopUtils
				.getMainBorderLayout()
				.getNorth()
				.appendChild(Executions.createComponents(navbarZul, null, null));
	}

	/**
	 * Pulisce tutto eccetto la navbar
	 */
	public static void clearAll() {
		clearPanels(true, true, true, true, false);
	}

	/**
	 * I componenti da aggiungere al border layout da file zul.
	 * 
	 * @param components
	 */

	/**
	 * Ordine dei componenti: 1)center 2)east 3)west 4)south 5)north
	 * 
	 * @param components
	 */

	public static void composeLayout(String... zuls) {
		Component c[] = new Component[zuls.length];
		int index = 0;
		for (String zul : zuls) {
			c[index] = Executions.createComponents(zul, null, null);
			index++;
		}
		composeLayout(c);

	}

	/**
	 * I componenti da aggiungere al border layout.
	 * 
	 * @param components
	 */

	/**
	 * Ordine dei componenti: 1)center 2)east 3)west 4)south 5)north
	 * 
	 * @param components
	 */

	public static void composeLayout(Component... components) {
		Borderlayout bl = DesktopUtils.getMainBorderLayout();
		Center center = bl.getCenter();
		East east = bl.getEast();
		West west = bl.getWest();
		South south = bl.getSouth();
		North north = bl.getNorth();
		int index = 0;
		for (Component c : components) {
			switch (index) {
			case 0:
				emptyComponent(center);
				center.appendChild(c);
				break;
			case 1:
				emptyComponent(east);
				east.appendChild(c);
				break;
			case 2:
				emptyComponent(west);
				west.appendChild(c);
				break;
			case 3:
				emptyComponent(south);
				south.appendChild(c);
				break;
			case 4:
				emptyComponent(north);
				north.appendChild(c);
				break;
			}
			index++;
		}

	}

	private static void emptyComponent(Component c) {
		if (c != null) {
			while (c.getFirstChild() != null) {
				c.removeChild(c.getFirstChild());
			}
		}
	}

}
