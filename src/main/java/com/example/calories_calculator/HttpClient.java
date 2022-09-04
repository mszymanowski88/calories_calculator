package com.example.calories_calculator;

import com.example.calories_calculator.api.Item;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Controller
public class HttpClient {

    Item item;



    String url = "https://api.calorieninjas.com/v1/nutrition?query=";



//    public String getCaloriesCalc(String input)
//    {
//
////   input = "carrot";
//
//        RestTemplate restTemplate = new RestTemplate();
//
//// create headers
//        HttpHeaders headers = new HttpHeaders();
//
//// set `Content-Type` and `Accept` headers
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//// example of custom header
//        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");
//
//// build the request
//        HttpEntity request = new HttpEntity(headers);
//
//// make an HTTP GET request with headers
//        ResponseEntity<Item> response = restTemplate.exchange(
//                url+input,
//                HttpMethod.GET,
//                request,
//                Item.class
////                ,
//////                100
//        );
////
////        Item item1 = restTemplate.getForObject("https://api.calorieninjas.com/v1/nutrition?query=apple", Item.class,1);
//// check response
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

    public Item getCaloriesCalc(String input)
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

        return response.getBody();

    }

    @EventListener(ApplicationReadyEvent.class)
            public void test()
    {
        getCaloriesCalc("apple");

    }
//
//    @GetMapping("/start")
//    public String getnutritions(Model model)
//    {
//
//        model.addAttribute("input",getCaloriesCalc())
//        return "start";
//    }

//    String query = "carrot";

//    @EventListener(ApplicationReadyEvent.class)
//    public void test()
//    {
//
//
//        String url = "https://api.calorieninjas.com/v1/nutrition?query=apple";
//
//// create an instance of RestTemplate
//        RestTemplate restTemplate = new RestTemplate();
//
//// create headers
//        HttpHeaders headers = new HttpHeaders();
//
//// set `Content-Type` and `Accept` headers
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//// example of custom header
//        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");
//
//// build the request
//        HttpEntity request = new HttpEntity(headers);
//
//// make an HTTP GET request with headers
//        ResponseEntity<Item> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                request,
//                Item.class
////                ,
//////                100
//        );
////
////        Item item1 = restTemplate.getForObject("https://api.calorieninjas.com/v1/nutrition?query=apple", Item.class,1);
//// check response
//        if (response.getStatusCode() == HttpStatus.OK) {
//            System.out.println("Request Successful.");
//            System.out.println(response.getBody().getAdditionalProperties());
//
//        } else {
//            System.out.println("Request Failed");
//            System.out.println(response.getStatusCode());
//        }
//    }


//    public String getMeal() throws URISyntaxException {
//
//        RestTemplate restTemplate = new RestTemplate();
//      String name = restTemplate.getForObject()
//
//
//        String query = "carrot";
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI("https://api.calorieninjas.com/v1/nutrition?query=" +query))
//                .headers("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI")
//                .GET()
//                .build();
//
//        System.out.println("Request" + request);
//
//       return getMeal().toString();
//
//
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public String request() throws URISyntaxException {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");
//
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//        RestTemplate restTemplate1 = new RestTemplate();
////        String name = restTemplate.getForObject("https://api.calorieninjas.com/v1/nutrition?query=" +query, entity,Item.class)
//
//        ResponseEntity<Item> respEntity = restTemplate.exchange("https://api.calorieninjas.com/v1/nutrition?query=apple", HttpMethod.GET, , Item.class);
//        ResponseEntity<Item> respEntity2 = restTemplate.getForObject("https://api.calorieninjas.com/v1/nutrition?query=apple",)
////       restTemplate1.getForEntity(respEntity.toString(),Item.class).toString();
//
//        System.out.println(respEntity.getBody().getCalories());
////        System.out.println( restTemplate1.getForEntity(respEntity.toString(),Item.class).toString());
//      return respEntity.getBody().getName();
//    }

//
//    @EventListener(ApplicationReadyEvent.class)
//    public String[] request() throws URISyntaxException {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("X-Api-Key", "b3c/4MGSrQl6WYwyI89VHA==fLjUcsy4X1RLE1OI");
//
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//        RestTemplate restTemplate1 = new RestTemplate();
////        String name = restTemplate.getForObject("https://api.calorieninjas.com/v1/nutrition?query=" +query, entity,Item.class)
//
//        ResponseEntity<Item[]> respEntity = restTemplate.exchange("https://api.calorieninjas.com/v1/nutrition?query=apple", HttpMethod.GET, entity, Item[].class);
//
//        Item item1 =  restTemplate1.getForEntity(respEntity.toString(),Item.class).getBody();
//
//        System.out.println(respEntity.getBody().length);
//        System.out.println(item1.getName());
//
//        return null;
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void check() throws URISyntaxException {
//
//
//        request();
//    }


}
