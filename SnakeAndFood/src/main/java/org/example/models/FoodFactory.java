package org.example.models;

public class FoodFactory {
    public static Item createFood(String type) {
        if ("bonus".equals(type)) {
            String utf = "\uD83C\uDF4E"; // Example UTF for bonus food (red apple)
            return new BonusFood(utf); // Create bonus food
        }
        String utf = "\uD83C\uDF4F"; // Example UTF for normal food (green apple)
        return new NormalFood(utf); // Default to normal food
    }
}
