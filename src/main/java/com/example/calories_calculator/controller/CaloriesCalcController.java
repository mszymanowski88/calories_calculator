package com.example.calories_calculator.controller;

import com.example.calories_calculator.api.Item;
import com.example.calories_calculator.service.Nutritions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class CaloriesCalcController {


private Nutritions nutritions;

@Autowired
    public CaloriesCalcController(Nutritions nutritions) {
        this.nutritions = nutritions;
    }

    @GetMapping("/start")
    public String getnutritions(Model model) {

        model.addAttribute("input", new Item());
        return "start";
    }

    @PostMapping("/start")
    public String getCityWeatherByInput(@ModelAttribute Item item, Model model) throws HttpClientErrorException {


        model.addAttribute("input", item);
        model.addAttribute("result", nutritions.getNutritions(item.getName()));
//        model.addAttribute("result", new Nutritions().getNutritions("name"));
        model.addAttribute("name", nutritions.getNutritions(item.getName()).get("name"));
        model.addAttribute("protein", nutritions.getNutritions(item.getName()).get("protein"));
        model.addAttribute("serving", nutritions.getNutritions(item.getName()).get("serving"));
        model.addAttribute("carbo", nutritions.getNutritions(item.getName()).get("carbo"));
        model.addAttribute("fat", nutritions.getNutritions(item.getName()).get("fat"));

        return "start";


    }




}
