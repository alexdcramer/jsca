package net.oijon.jsca.rule;

import java.util.ArrayList;

public class Ruleset {

	ArrayList<Rule> rules;
	
	public static Ruleset EMPTY = new Ruleset();
	
	public Ruleset() {
		
	}
	
	public Ruleset(String rules) {
		String[] splitRules = rules.split("\n");
		for (int i = 0; i < splitRules.length; i++) {
			
		}
	}
	
	public void addRule(Rule rule) {
		
	}
	
	public void removeRule(int i) {
		
	}
}
