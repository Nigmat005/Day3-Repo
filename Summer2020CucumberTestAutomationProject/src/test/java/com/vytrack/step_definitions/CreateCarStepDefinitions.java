package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import com.vytrack.utlis.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class CreateCarStepDefinitions {
    CreateCarPage createCarPage=new CreateCarPage();


    @And("use clicks on Create Car button")
    public void use_clicks_on_create_car_button() {
      createCarPage.Click_CreatCar_Carbutton();
    }


    //    |License Plate | SDET|
    //    | Model Year   | 2021|
    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String,String> dataTable) {
       dataTable.forEach((k,v)-> System.out.println("Key: "+k+" , "+" Value: "+v));

        System.out.println("========================================");
        System.out.println("Lincense Plate: "+dataTable.get("License Plate"));
        System.out.println("Lincense Plate: "+dataTable.get("Model Year"));
        System.out.println("========================================");

    createCarPage.enterLicensePlate(dataTable.get("License Plate"));
    createCarPage.enterModelYear(dataTable.get("Model Year"));

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("oro_calendar_event_form_description-uid-5f95f9676f301_ifr")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));



    }
}
