package com.darwinsys.random;

public class DatumHash {
	public static void main(String[] args) {
		Datum d = new Datum(123, "Ian", 1999);
		// Loop by 175 just to get a good range of values
		for (int i = 1; i <= 2020; i+=175) {
			d.setId(2000 % i);
			d.setYearJoined(i);
			System.out.println(d +" hashCode: "+d.hashCode());
		}
	}
}

