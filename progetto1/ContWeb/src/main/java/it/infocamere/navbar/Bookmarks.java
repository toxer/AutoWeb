package it.infocamere.navbar;

public enum Bookmarks {
	bookmark_1("bookmark_1"),bookmark_2("bookmark_2");
	private String bookmark;

	private Bookmarks(String bookmark) {
		this.bookmark=bookmark;
	}
	
	public String toString(){
		return bookmark;
	}
}
