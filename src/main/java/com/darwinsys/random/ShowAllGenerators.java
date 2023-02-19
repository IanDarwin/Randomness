package com.darwinsys.random;

import java.util.random.RandomGeneratorFactory;

public class ShowAllGenerators {

    public static final String TITLE = "%10s %-25s %10s";
    public static final String FORMAT = "%10s %-25s %10g";

    public static void main(String[] args) {
        // Print the algo names by group
        System.out.println(String.format(TITLE, "Group", "Name", "Period"));
        RandomGeneratorFactory.all()
                .map(rgFactory -> String.format(FORMAT,
                        rgFactory.group(), rgFactory.name(), rgFactory.period().doubleValue()))
                .sorted()
                .forEach(System.out::println);
    }
}
