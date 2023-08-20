package net.oijon.jsca.flag;

/**
 * Acts as a '_' in a sound change rule. This is used as the reference for where the target
 * would be in a string for a sound change. For example, if we had the sound change p/b/a_a,
 * then "apa" would turn into "aba", as the '_' would be where the target would change if needed.
 * @author alex
 *
 */
public class PlaceholderFlag extends Flag {

	public PlaceholderFlag() {
		flagType = "placeholder";
		data = new String[1];
		data[0] = "_";
	}
	
}
