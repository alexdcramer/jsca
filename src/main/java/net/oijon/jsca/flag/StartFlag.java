package net.oijon.jsca.flag;

/**
 * Acts as a '#' at the start in a sound change rule. This is used as a marker for the start of
 * a word. For example, if we had the sound change p/b/#_, then "paa" would turn into "baa",
 * as the '#' would mark that it changes at the beginning of words.
 * @author alex
 *
 */
public class StartFlag extends Flag {

	public StartFlag() {
		flagType = "start";
		data = new String[1];
		data[0] = "#";
	}
	
}
