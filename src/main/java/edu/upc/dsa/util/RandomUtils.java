package edu.upc.dsa.util;

import net.moznion.random.string.RandomStringGenerator;

public class RandomUtils {

    //creacion del id aleatorio
    public static String getId() {
        RandomStringGenerator generator = new RandomStringGenerator();
        String randomString = generator.generateByRegex("\\w+\\d*[0-9]{0,8}");

        return randomString;
    }
}
