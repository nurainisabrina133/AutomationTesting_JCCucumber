package com.juaracoding.cucumber;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.strategies.DriverSingleton;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public  class TestLogin {
        public static WebDriver driver;
        public static LoginPage loginPage;

        @BeforeAll
        public static void setUp() {
            DriverSingleton.getInstance("chrome");
            driver = DriverSingleton.getDriver();
            loginPage = new LoginPage();
        }

        @Given("User open browser and url")
        public void user_open_browser_and_url() {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            System.out.println("User open browser and url");
        }


        @When("User enter valid username")
        public void user_enter_valid_username() {
            loginPage.enterUsername("Admin");
            System.out.println("User enter valid username");
        }

        @And("User enter valid password")
        public void user_enter_valid_password() {
            loginPage.enterPassword("admin123");
            System.out.println("User enter valid password");
        }

        @And("User click button login")
        public void user_click_button_login() {
            loginPage.buttonLogin();
            System.out.println("User click button login");
        }

        @Then("User go to page dashboard")
        public void user_go_to_page_Dashboard() {
            Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
            System.out.println("User go to page Dashboard");
        }
        @When("User click symbol")
        public void user_click_symbol(){
            loginPage.enterSymbol("*");
            System.out.println("Form Search disappears when the bin symbol (*) stars");
        }
        @When("User click button logout")
        public void user_click_button_logout() {
        loginPage.getImgDropdownProfile();
        loginPage.getBtnOut();
            Assert.assertEquals(loginPage.getLoginTitle(), "Login");
            System.out.println("User Logout ");
            System.out.println("User Try to Login");
        }

        @And("User enter invalid username")
        public void user_enter_invalid_username() {
            loginPage.enterUsername("Admin");
            System.out.println("User enter valid username");
        }
        @And("User enter invalid password")
        public void user_enter_invalid_password() {
            loginPage.enterPassword("Adminn345");
            System.out.println("User enter valid password");
        }
        @Then("User get message invalid credentials")
        public void user_get_message_invalid_credentials() {
            Assert.assertEquals(loginPage.getWarningMessage(), "Invalid credentials");
            System.out.println("User field login");
        }

        @AfterAll
        public static void quitBrowser() {
            delay(3);
            DriverSingleton.closeObjectInstance();
        }

        static void delay(long detik) {
            try {
                Thread.sleep(detik * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

