package com.example.calories_calculator.service;

import com.example.calories_calculator.api.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.LinkedHashMap;

@Service
public class Nutritions implements NutritionsInterface {


    private final String url = "https://api.calorieninjas.com/v1/nutrition?query=";


    public ResponseEntity<Product> response(String input) {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");
        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> response = restTemplate.exchange(
                url + input,
                HttpMethod.GET,
                request,
                Product.class
        );
        return response;
    }


    public LinkedHashMap<String, Object> getNutritions(String input) {

        ResponseEntity<Product> userProduct = response(input);

        if (userProduct.getStatusCode() == HttpStatus.OK) {


        } else {

            System.out.println(userProduct.getStatusCode());
        }

        LinkedHashMap<String, Object> result = new LinkedHashMap<>();


        result.put("Name:", userProduct.getBody().getItems().get(0).getName());
        result.put("Serving Size [G]: ", userProduct.getBody().getItems().get(0).getServingSizeG());
        result.put("Calories:", userProduct.getBody().getItems().get(0).getCalories());
        result.put("Fat Total [G]", userProduct.getBody().getItems().get(0).getFatTotalG());
        result.put("Cholesterol [Mg]", userProduct.getBody().getItems().get(0).getCholesterolMg());
        result.put("Sodium [Mg]", userProduct.getBody().getItems().get(0).getSodiumMg());
        result.put("Carbohydrates Total [G]", userProduct.getBody().getItems().get(0).getCarbohydratesTotalG());
        result.put("Protein [G]", userProduct.getBody().getItems().get(0).getProteinG());

        return result;
    }


    public double getcaloriesPerServing(String input, double portion) {

        double caloriesPerServing = (double) getNutritions(input).get("Calories:") * (portion / 100);

        return caloriesPerServing;
    }


}
