package com.juaracoding.pageobject.hooks;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/2.PlaceOrder.feature",
glue = "com.juaracoding.pageobject.step_definitions",
plugin = {"pretty", "html:target/cucumber-reports.html"})


public class TestHooksRunner extends AbstractTestNGCucumberTests{

}
