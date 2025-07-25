package com.example.demo.validation;

public class ItemValidation {

    // Private constructor to prevent instantiation
    private ItemValidation() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Validates a general item name string.
     * 
     * @param itemName The string to validate.
     * @throws IllegalArgumentException if the item name is null or blank.
     */
    public static void validateItemName(String itemName) {
        if (itemName == null || itemName.isBlank()) {
            throw new IllegalArgumentException("Item name cannot be null or blank.");
        }
    }

    public static Long parseAndValidateLongId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID format. ID must be a valid number.");
        }
    }


    // (other static validation methods can go here...)
}
