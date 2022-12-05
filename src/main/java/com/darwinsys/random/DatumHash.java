package com.darwinsys.random;

import java.util.*;
import java.util.stream.IntStream;

public class DatumHash {
	public static void main(String[] args) {
		Datum d = new Datum(123, "Ian", 1999);
		IntStream.range(200, 2020).forEach(i->{
			if (i % 175 != 0)
				return;
			d.setId(i - 2000);
			d.setYearJoined(i);
			System.out.println(d +" hashCode: "+d.hashCode());
		});
	}
}

