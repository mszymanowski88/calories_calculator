package com.example.calories_calculator.api;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sugar_g",
        "fiber_g",
        "serving_size_g",
        "sodium_mg",
        "name",
        "potassium_mg",
        "fat_saturated_g",
        "fat_total_g",
        "calories",
        "cholesterol_mg",
        "protein_g",
        "carbohydrates_total_g"
})
@Generated("jsonschema2pojo")
public class Item {

    @JsonProperty("sugar_g")
    private Double sugarG;
    @JsonProperty("fiber_g")
    private Double fiberG;
    @JsonProperty("serving_size_g")
    private Integer servingSizeG;
    @JsonProperty("sodium_mg")
    private Integer sodiumMg;
    @JsonProperty("name")
    private String name;
    @JsonProperty("potassium_mg")
    private Integer potassiumMg;
    @JsonProperty("fat_saturated_g")
    private Integer fatSaturatedG;
    @JsonProperty("fat_total_g")
    private Double fatTotalG;
    @JsonProperty("calories")
    private Double calories;
    @JsonProperty("cholesterol_mg")
    private Integer cholesterolMg;
    @JsonProperty("protein_g")
    private Double proteinG;
    @JsonProperty("carbohydrates_total_g")
    private Double carbohydratesTotalG;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sugar_g")
    public Double getSugarG() {
        return sugarG;
    }

    @JsonProperty("sugar_g")
    public void setSugarG(Double sugarG) {
        this.sugarG = sugarG;
    }

    @JsonProperty("fiber_g")
    public Double getFiberG() {
        return fiberG;
    }

    @JsonProperty("fiber_g")
    public void setFiberG(Double fiberG) {
        this.fiberG = fiberG;
    }

    @JsonProperty("serving_size_g")
    public Integer getServingSizeG() {
        return servingSizeG;
    }

    @JsonProperty("serving_size_g")
    public void setServingSizeG(Integer servingSizeG) {
        this.servingSizeG = servingSizeG;
    }

    @JsonProperty("sodium_mg")
    public Integer getSodiumMg() {
        return sodiumMg;
    }

    @JsonProperty("sodium_mg")
    public void setSodiumMg(Integer sodiumMg) {
        this.sodiumMg = sodiumMg;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("potassium_mg")
    public Integer getPotassiumMg() {
        return potassiumMg;
    }

    @JsonProperty("potassium_mg")
    public void setPotassiumMg(Integer potassiumMg) {
        this.potassiumMg = potassiumMg;
    }

    @JsonProperty("fat_saturated_g")
    public Integer getFatSaturatedG() {
        return fatSaturatedG;
    }

    @JsonProperty("fat_saturated_g")
    public void setFatSaturatedG(Integer fatSaturatedG) {
        this.fatSaturatedG = fatSaturatedG;
    }

    @JsonProperty("fat_total_g")
    public Double getFatTotalG() {
        return fatTotalG;
    }

    @JsonProperty("fat_total_g")
    public void setFatTotalG(Double fatTotalG) {
        this.fatTotalG = fatTotalG;
    }

    @JsonProperty("calories")
    public Double getCalories() {
        return calories;
    }

    @JsonProperty("calories")
    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @JsonProperty("cholesterol_mg")
    public Integer getCholesterolMg() {
        return cholesterolMg;
    }

    @JsonProperty("cholesterol_mg")
    public void setCholesterolMg(Integer cholesterolMg) {
        this.cholesterolMg = cholesterolMg;
    }

    @JsonProperty("protein_g")
    public Double getProteinG() {
        return proteinG;
    }

    @JsonProperty("protein_g")
    public void setProteinG(Double proteinG) {
        this.proteinG = proteinG;
    }

    @JsonProperty("carbohydrates_total_g")
    public Double getCarbohydratesTotalG() {
        return carbohydratesTotalG;
    }

    @JsonProperty("carbohydrates_total_g")
    public void setCarbohydratesTotalG(Double carbohydratesTotalG) {
        this.carbohydratesTotalG = carbohydratesTotalG;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return "Item{" +
                "sugarG=" + sugarG +
                ", fiberG=" + fiberG +
                ", servingSizeG=" + servingSizeG +
                ", sodiumMg=" + sodiumMg +
                ", name='" + name + '\'' +
                ", potassiumMg=" + potassiumMg +
                ", fatSaturatedG=" + fatSaturatedG +
                ", fatTotalG=" + fatTotalG +
                ", calories=" + calories +
                ", cholesterolMg=" + cholesterolMg +
                ", proteinG=" + proteinG +
                ", carbohydratesTotalG=" + carbohydratesTotalG +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
