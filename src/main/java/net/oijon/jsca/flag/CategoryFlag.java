package net.oijon.jsca.flag;

import net.oijon.jsca.category.Category;


public class CategoryFlag extends Flag {

	String name;
	
	public CategoryFlag(String name, String[] sounds) {
		flagType = "category";
		this.name = name;
		this.data = sounds;
	}
	
	public CategoryFlag(Category c) {
		flagType = "category";
		this.name = c.getName();
		this.data = c.getSounds();
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + "," + super.toString();
	}
	
}
