package net.oijon.jsca.flag;

import java.util.ArrayList;

import net.oijon.jsca.category.Categories;
import net.oijon.jsca.flag.exception.MultiPlaceholderException;

public class Flagpole extends ArrayList<Flag> {

	private static final long serialVersionUID = -955318946806060304L;

	private void addPlaceholder(PlaceholderFlag f) throws MultiPlaceholderException {
		boolean hasPlaceholderAlready = false;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i) instanceof PlaceholderFlag) {
				hasPlaceholderAlready = true;
				break;
			}
		}		
		if (hasPlaceholderAlready) {
			throw new MultiPlaceholderException("Only one placeholder flag allowed per rule");
		} else {
			super.add(f);
		}
	}
	
	private boolean partOfCat(String r) {
		if (this.get(this.size() - 1) instanceof CategoryFlag) {
			String catname = ((CategoryFlag) this.get(this.size() - 1)).getName();
			
			if (catname.length() > r.length()) {
				int diff = catname.length() - r.length();
				catname = catname.substring(diff);
			}
			
			String[] possibleSubstrings = new String[catname.length()];
			for (int i = 0; i < catname.length(); i++) {
				possibleSubstrings[i] = catname.substring(i);
			}
			String maxname = r.substring(0, catname.length());
			
			for (int i = 0; i < catname.length(); i++) {
				String substring = maxname.substring(i, catname.length());
				if (substring.equals(possibleSubstrings[i])) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean partOfStartOrEnd(String r) {
		if (r.charAt(0) == '#') {
			return true;
		}
		return false;
	}
	
	private boolean partOfPlaceholder(String r) {
		if (r.charAt(0) == '_') {
			return true;
		}
		return false;
	}
	
	private boolean partOfFlag(String r) {
		if (partOfCat(r) | partOfStartOrEnd(r) | partOfPlaceholder(r)) {
			return true;
		}
		return false;
	}
	
	private void parseCategories(String r, Categories c) {
		for (int j = 0; j < c.size(); j++) {
			// check if remaining length is less than the length for the cat name
			if (r.length() <= c.get(j).getName().length()) {
				String catname = c.get(j).getName();
				// substrings from scan start to scan start + length of catname
				if (r.substring(0, catname.length()).equals(catname)) {
					add(new CategoryFlag(c.get(j)));
				}
			}
		}
	}
	
	private void parsePlaceholders(String r) {
		if (partOfPlaceholder(r)) {
			add(new PlaceholderFlag());
		}
	}
	
	private void parseStartOrEnd(String r) {
		if (partOfStartOrEnd(r)) {
			if (r.length() > 1) {
				add(new StartFlag());
			} else {
				//add(new EndFlag());
			}
		}
	}
	
	private void parseData(String r) {
		if (!partOfFlag(r)) {
			add(new DataFlag(String.valueOf(r.charAt(0))));
		}
	}
	
	public void parseRule(String r, Categories c) {
		
		for (int i = 0; i < r.length(); i++) {
			String substring = r.substring(i, r.length());
			parsePlaceholders(substring);
			parseCategories(substring, c);
			parseStartOrEnd(substring);
			parseData(substring);
		}
	}
	
	@Override
	public boolean add(Flag f) {
		if (f instanceof PlaceholderFlag) {
			try {
				PlaceholderFlag pf = (PlaceholderFlag) f;
				addPlaceholder(pf);
				return true;
			} catch (MultiPlaceholderException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return super.add(f);
		}
	}
	
	@Override
	public String toString() {
		String returnString = "";
		for (int i = 0; i < this.size(); i++) {
			returnString += "[" + this.get(i).toString() + "]";
		}
		return returnString;
	}
	
}
