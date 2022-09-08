package com.example.calories_calculator;

import com.example.calories_calculator.api.Item;
import com.example.calories_calculator.api.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
public class CaloriesCalcController {





    private final String url = "https://api.calorieninjas.com/v1/nutrition?query=";



    @GetMapping("/start")
    public String getnutritions(Model model)
    {

        model.addAttribute("input",new Item());
        return "start";
    }

    @PostMapping("/start")
    public String getCityWeatherByInput(@ModelAttribute Item item, Model model) throws HttpClientErrorException {
        String itemName = item.getName();


        model.addAttribute("input", item);
//        model.addAttribute("map", getCaloriesCalc(item.getName()).get("name"));
        model.addAttribute("result",getCaloriesCalc(item.getName()));
        model.addAttribute("name",getCaloriesCalc(item.getName()).get("name"));
        model.addAttribute("protein",getCaloriesCalc(item.getName()).get("protein"));
        model.addAttribute("serving",getCaloriesCalc(item.getName()).get("serving"));
        model.addAttribute("carbo",getCaloriesCalc(item.getName()).get("carbo"));
        model.addAttribute("fat",getCaloriesCalc(item.getName()).get("fat"));


//        Map<String, Object> result = new HashMap<>();
//        result.put( "serving", response.getBody().getItems().get(0).getServingSizeG());
//        result.put( "name", response.getBody().getItems().get(0).getName());
//        result.put(  "protein",response.getBody().getItems().get(0).getProteinG() );
//        result.put(  "carbo",response.getBody().getItems().get(0).getCarbohydratesTotalG() );
//        result.put( "fat", response.getBody().getItems().get(0).getFatTotalG()  );
//        System.out.println("mapr " + result.get("name"));

//        model.addAttribute("sugar",getCaloriesCalc(item.getAdditionalProperties());

        return "start";


    }

    public Map<String,Object> getCaloriesCalc(String input)
    {



        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();


        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));


        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");


        HttpEntity request = new HttpEntity(headers);


//        ResponseEntity<Item> response = restTemplate.exchange(
//                url+input,
//                HttpMethod.GET,
//                request,
//                Item.class
//
//
//        );

        ResponseEntity<Product> response = restTemplate.exchange(
                url+input,
                HttpMethod.GET,
                request,
                Product.class


        );
//        System.out.println("response"+response.getBody().getCalories());
//        System.out.println("response koks" + response.getBody().getAdditionalProperties().entrySet().stream().filter(x-> "name".equals(x.getValue())).map(Map.Entry::getKey).findFirst().get());
//
        if (response.getStatusCode() == HttpStatus.OK) {

//            System.out.println(response.getBody().getAdditionalProperties().keySet());
//            System.out.println(response.getBody().getCalories());
//            System.out.println("Items" + response.getBody().getAdditionalProperties());
//            System.out.println("values" + response.getBody().getAdditionalProperties().);

            for (Map.Entry<String, Object> e : response.getBody().getAdditionalProperties().entrySet()) {
                String key = e.getKey();
                Object value = e.getValue();
                System.out.println("key " + key);
            }



        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }

//        System.out.println(response.getBody().getItems().get(0).getCalories());
//        System.out.println(response.getBody().getItems().get(0).getName());
//        System.out.println(response.getBody().getItems().get(0).getFatTotalG());
//        System.out.println(response.getBody().getItems().get(0).getProteinG());

        String summary = "In " + response.getBody().getItems().get(0).getServingSizeG() + "g of "
                + response.getBody().getItems().get(0).getName()
                + "is "
                + response.getBody().getItems().get(0).getCalories() + " of calories"
                + response.getBody().getItems().get(0).getProteinG() + " of proteins"
                + response.getBody().getItems().get(0).getCarbohydratesTotalG() + " of carbohydrates"
                + response.getBody().getItems().get(0).getFatTotalG() + " of fat";

//        List<Object> result = new ArrayList<>();
//        result.add( response.getBody().getItems().get(0).getServingSizeG());
//        result.add( response.getBody().getItems().get(0).getName());
//        result.add( response.getBody().getItems().get(0).getProteinG() );
//        result.add( response.getBody().getItems().get(0).getCarbohydratesTotalG() );
//        result.add( response.getBody().getItems().get(0).getFatTotalG()  );

        Map<String, Object> result = new HashMap<>();
        result.put( "serving", response.getBody().getItems().get(0).getServingSizeG());
        result.put( "name", response.getBody().getItems().get(0).getName());
        result.put(  "protein",response.getBody().getItems().get(0).getProteinG() );
        result.put(  "carbo",response.getBody().getItems().get(0).getCarbohydratesTotalG() );
        result.put( "fat", response.getBody().getItems().get(0).getFatTotalG()  );
        System.out.println("mapr " + result.get("name"));

        return result;

    }


//    public Double getCaloriesCalc(String input)
//    {
//
//
//
//        RestTemplate restTemplate = new RestTemplate();
//
//
//        HttpHeaders headers = new HttpHeaders();
//
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//
//        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");
//
//
//        HttpEntity request = new HttpEntity(headers);
//
//
////        ResponseEntity<Item> response = restTemplate.exchange(
////                url+input,
////                HttpMethod.GET,
////                request,
////                Item.class
////
////
////        );
//
//        ResponseEntity<Product> response = restTemplate.exchange(
//                url+input,
//                HttpMethod.GET,
//                request,
//                Product.class
//
//
//        );
////        System.out.println("response"+response.getBody().getCalories());
////        System.out.println("response koks" + response.getBody().getAdditionalProperties().entrySet().stream().filter(x-> "name".equals(x.getValue())).map(Map.Entry::getKey).findFirst().get());
////
//        if (response.getStatusCode() == HttpStatus.OK) {
//
////            System.out.println(response.getBody().getAdditionalProperties().keySet());
////            System.out.println(response.getBody().getCalories());
////            System.out.println("Items" + response.getBody().getAdditionalProperties());
////            System.out.println("values" + response.getBody().getAdditionalProperties().);
//
//            for (Map.Entry<String, Object> e : response.getBody().getAdditionalProperties().entrySet()) {
//               String key = e.getKey();
//                Object value = e.getValue();
//                System.out.println("key " + key);
//            }
//
//
//
//        } else {
//            System.out.println("Request Failed");
//            System.out.println(response.getStatusCode());
//        }
//
//        System.out.println(response.getBody().getItems().get(0).getCalories());
//        System.out.println(response.getBody().getItems().get(0).getName());
//        System.out.println(response.getBody().getItems().get(0).getFatTotalG());
//        System.out.println(response.getBody().getItems().get(0).getProteinG());
//
//        String summary = "In " + response.getBody().getItems().get(0).getServingSizeG() + "g of "
//            + response.getBody().getItems().get(0).getName()
//            + "is "
//            + response.getBody().getItems().get(0).getCalories() + " of calories"
//            + response.getBody().getItems().get(0).getProteinG() + " of proteins"
//            + response.getBody().getItems().get(0).getCarbohydratesTotalG() + " of carbohydrates"
//            + response.getBody().getItems().get(0).getFatTotalG() + " of fat";
//
//        System.out.println(summary);
//
//        return response.getBody().getItems().get(0).getCalories();
//
//    }

//    public String getCaloriesCalc(String input)
//    {
//
//
//
//        RestTemplate restTemplate = new RestTemplate();
//
//
//        HttpHeaders headers = new HttpHeaders();
//
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//
//        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");
//
//
//        HttpEntity request = new HttpEntity(headers);
//
//
//        ResponseEntity<Item> response = restTemplate.exchange(
//                url+input,
//                HttpMethod.GET,
//                request,
//                Item.class
//        );
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            System.out.println("Request Successful.");
//            System.out.println(response.getBody().getAdditionalProperties());
//
//        } else {
//            System.out.println("Request Failed");
//            System.out.println(response.getStatusCode());
//        }
//
//        return response.getBody().getAdditionalProperties().toString();
//
//    }

//    public Item getCaloriesCalc(String input)
//    {
//
//
//
//        RestTemplate restTemplate = new RestTemplate();
//
//
//        HttpHeaders headers = new HttpHeaders();
//
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//
//        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");
//
//
//        HttpEntity request = new HttpEntity(headers);
//
//
//        ResponseEntity<Item> response = restTemplate.exchange(
//                url+input,
//                HttpMethod.GET,
//                request,
//                Item.class
//        );
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            System.out.println("Request Successful.");
//            System.out.println(response.getBody());
//            System.out.println(response.getBody().getAdditionalProperties().keySet());
//            System.out.println(response.getBody().getCalories());
//            System.out.println("Items" + response.getBody().getAdditionalProperties());
////            System.out.println("values" + response.getBody().getAdditionalProperties().);
//
//            for (Map.Entry<String, Object> e : response.getBody().getAdditionalProperties().entrySet()) {
//                String key = e.getKey();
//                Object value = e.getValue();
//                System.out.println("key " + key);
//            }
//
//
//
//        } else {
//            System.out.println("Request Failed");
//            System.out.println(response.getStatusCode());
//        }
//
//        return response.getBody();
//
//    }


}
