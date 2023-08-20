package net.oijon.jsca.flag;

import java.util.Arrays;

public abstract class Flag {

	String flagType = "abstract";
	String[] data;
	
	public Flag() {
	}
	
	public String getType() {
		return flagType;
	}
	
	public String[] getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return flagType + ",[" + Arrays.toString(data) + "]";
	}
}
