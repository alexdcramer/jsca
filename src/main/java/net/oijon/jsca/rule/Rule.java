package net.oijon.jsca.rule;

import net.oijon.jsca.category.Categories;

public class Rule {
	
	String trgt;
	String env;
	String cnd;
	String exc;
	Categories cats;
	
	public Rule() {
		
	}
	
	public Rule(String trgt, String env, String cnd, String exc, Categories cats) {
		this.trgt = trgt;
		this.env = env;
		this.cnd = cnd;
		this.exc = exc;
		this.cats = cats;
	}
	
	public String parse(String input) {
		
		for (int i = 0; i < cats.size(); i++) {
			
		}
		
		String output = new String();
		
		return output;
	}

}
