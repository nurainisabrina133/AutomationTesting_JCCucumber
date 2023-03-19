package stepdefinitions;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TestLogin {
        public static WebDriver driver;
        public LoginPage loginPage;

        @BeforeClass
        public void setUp() {
            DriverSingleton.getInstance("chrome");
            driver = DriverSingleton.getDriver();
            loginPage = new LoginPage();
        }

        @Test(priority = 1)
        public void tesUrl() {
            delay(4);
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            //step verify
            delay(6);
            Assert.assertEquals(loginPage.getLoginTitle(), "Login");
            System.out.println("Url valid!!!");
        }

        @Test(priority = 2)
        public void tesValidLogin() {
            delay(10);
            loginPage.enterPassword("admin123");
            loginPage.enterUsername("Admin");
            loginPage.buttonLogin();
            Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
            System.out.println("Login test Valid Clear");
        }

        @Test(priority = 3)
        public void testLogOut(){
            delay(10);
            loginPage.getImgDropdownProfile();
            loginPage.getBtnOut();
            Assert.assertEquals(loginPage.getLoginTitle(), "Login");
            System.out.println("Logout BERHASIL!!!");
        }


        @Test(priority = 4)
        public void tesInvalidLogin() {
            delay(3);
            loginPage.enterPassword("admin123");
            loginPage.enterUsername("Admi");
            loginPage.buttonLogin();
            Assert.assertEquals(loginPage.getWarningMessage(), "Invalid credentials");
            System.out.println("Login test Invalid Clear");
        }
        @AfterClass
        public void quitBrowser() {
            delay(3);
            DriverSingleton.closeObjectInstance();
        }

        static void delay(long detik) {
            try {
                Thread.sleep(detik + 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }


