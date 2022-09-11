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

import java.text.DecimalFormat;

@Controller
public class CaloriesCalcController {

    private Nutritions  nutritions;
    private static final DecimalFormat df = new DecimalFormat("0.00");

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
//        model.addAttribute("portion", Math.round((double)nutritions.getNutritions(item.getName()).get("Calories:")*(item.getPortion()/100)));
        model.addAttribute("portion", nutritions.getcaloriesPerServing(item.getName(), item.getPortion()));

        System.out.println(Math.round((double)nutritions.getNutritions(item.getName()).get("Calories:")*(item.getPortion()/100)));

        return "start";
    }


}
