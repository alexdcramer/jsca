package net.oijon.jsca.flag;

public class DataFlag extends Flag {
	
	public DataFlag(String value) {
		flagType = "value";
		this.data = new String[1];
		this.data[0] = value;
	}
	
}
