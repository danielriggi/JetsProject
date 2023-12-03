package com.skilldistillery.jets;

import java.util.Random;

public class RandomNameGenerator {

    private static final String[] FIRST_NAMES = {"John", "Alice", "Bob", "Eva", "Charlie", "Olivia", "Leigh", "Cora", "Dom"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Baron", "Rodrigo", "Allen"};
    
    
    public static String generateFirstName() {
        return getRandomElement(FIRST_NAMES);
    }
    
    public static String generateLastName() {
        return getRandomElement(LAST_NAMES);
    }
    
    public static void main(String[] args) {
        String randomFirstName = getRandomElement(FIRST_NAMES);
        String randomLastName = getRandomElement(LAST_NAMES);

        String randomFullName = randomFirstName + " " + randomLastName;

        System.out.println("Random Name: " + randomFullName);
    }
     
    private static String getRandomElement(String[] array) {
        Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }
}

