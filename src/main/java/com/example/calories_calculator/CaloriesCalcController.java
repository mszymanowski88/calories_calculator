package com.example.calories_calculator;

import com.example.calories_calculator.api.Item;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Controller
public class CaloriesCalcController {





    String url = "https://api.calorieninjas.com/v1/nutrition?query=";



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
        model.addAttribute("result",getCaloriesCalc(item.getName()));

        return "start";


    }

    public String getCaloriesCalc(String input)
    {

//   input = "carrot";

        RestTemplate restTemplate = new RestTemplate();

// create headers
        HttpHeaders headers = new HttpHeaders();

// set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

// example of custom header
        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");

// build the request
        HttpEntity request = new HttpEntity(headers);

// make an HTTP GET request with headers
        ResponseEntity<Item> response = restTemplate.exchange(
                url+input,
                HttpMethod.GET,
                request,
                Item.class
//                ,
////                100
        );
//
//        Item item1 = restTemplate.getForObject("https://api.calorieninjas.com/v1/nutrition?query=apple", Item.class,1);
// check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody().getAdditionalProperties());

        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }

        return response.getBody().getAdditionalProperties().toString();

    }

    @EventListener(ApplicationReadyEvent.class)
    public void test()
    {
        getCaloriesCalc("apple");

    }



}
