package com.substring.foodie.substring_foodie.utils;

import java.util.UUID;

public class Helper {
    public static String generateRandomId()
    {
        //id generation logic
        return UUID.randomUUID().toString();
    }
}
