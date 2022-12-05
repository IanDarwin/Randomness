package com.darwinsys.random;

import java.util.Random;

public class BackCompatTest {
    public static void main(String[] args) {
        Random gen = new Random(12345);
        for (int i = 0; i < 10; i++) {
            System.out.println(gen.nextDouble());
        }
    }
}
