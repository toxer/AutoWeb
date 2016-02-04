package it.infocamere.navbar;

import org.apache.log4j.Logger;

public class BookmarksManager {
	static Logger logger = Logger.getLogger(BookmarksManager.class);
	
	// gestione dei bookmarks. In base a quello scelto di modifica il layout
	// delle pagine
	// il metodo viene invocato dalla index.zul
	public static void onBookmarkChange(String bookmark) {
		logger.info("Select bookmark: " + bookmark);
		// converto nell'enumeration
		try {
		
			Bookmarks bookmarckEnum = Bookmarks.valueOf(bookmark);

			switch (bookmarckEnum) {
			default:
				logger.error("Non trovata azione per il bookmark");
				break;
			}
		} catch (java.lang.IllegalArgumentException iax) {
			logger.error("ATTENZIONE, BOOKMARK " + bookmark
					+ " non presente nell'enumeration Bookmarks");
		//	iax.printStackTrace();
			return;
		}
	}

}
