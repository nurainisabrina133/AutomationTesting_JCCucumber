package com.juaracoding.cucumber;


import  io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "/Users/sabrinalin13/IdeaProjects/juaracoding/sqabatch8/TestCucumber/src/main/resources/feature/Login.feature",
        glue = {"com.juaracoding.cucumber"}

)

public class RunnerTest extends AbstractTestNGCucumberTests{

}
