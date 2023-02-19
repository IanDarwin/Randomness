package com.darwinsys.random;

import java.util.random.*;

public class ShowDefaultRandom {
	public static void main(String[] args) {
		RandomGenerator rg = RandomGeneratorFactory.getDefault().create();
		System.out.println(rg.getClass());
	}
}
