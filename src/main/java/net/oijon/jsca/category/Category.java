package net.oijon.jsca.category;

import java.util.ArrayList;
import java.util.Arrays;

public class Category {

	String name;
	ArrayList<String> data = new ArrayList<String>();
	
	public Category(String name, ArrayList<String> data) {
		this.name = name;
		this.data = data;
	}
	
	public Category(String rawData) {
		String[] splitRaw = rawData.split("=");
		this.name = splitRaw[0];
		String data = splitRaw[1].substring(1, splitRaw[1].length() - 1);
		this.data = new ArrayList<String>(Arrays.asList(data.split(",")));
	}
	
	public void addData(String d) {
		data.add(d);
	}
	
	public void removeData(int i) {
		data.remove(i);
	}
	
	public void removeData(String d) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(d)) {
				data.remove(i);
				return;
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String[] getSounds() {
		String[] sounds = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			sounds[i] = data.get(i);
		}
		return sounds;
	}
}
