package com.darwinsys.random;

import java.util.random.RandomGeneratorFactory;

public class ShowStreamableGenerators {

    public static void main(String[] args) {
        // Print the algo names by group
        System.out.println("Streamable Generators:");
        RandomGeneratorFactory.all()
                .filter(rgFactory -> rgFactory.isStreamable())
                .map(rgFactory-> rgFactory.name())
                .sorted()
                .forEach(System.out::println);
    }
}
