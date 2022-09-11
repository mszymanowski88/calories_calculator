package com.example.calories_calculator.service;

import java.util.LinkedHashMap;

public interface NutritionsInterface {

    LinkedHashMap<String, Object> getNutritions(String input);
    double getcaloriesPerServing(String input, double portion);
}
