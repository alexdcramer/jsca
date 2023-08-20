package net.oijon.jsca.category;

import java.util.ArrayList;

public class Categories extends ArrayList<Category> {

	private static final long serialVersionUID = 6496194393323439006L;
	
	public static Categories EMPTY = new Categories();
	
	public Categories() {
		
	}
	
	public Categories(ArrayList<Category> cats) {
		for (int i = 0; i < cats.size(); i++) {
			this.add(cats.get(i));
		}
	}
	
	public Categories(String rawData) {
		String[] lines = rawData.split("\n");
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			this.add(new Category(line));
		}
	}
	
	
}
