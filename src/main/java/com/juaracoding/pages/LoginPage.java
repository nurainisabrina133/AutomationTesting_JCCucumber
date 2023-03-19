package com.juaracoding.pages;

import com.juaracoding.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement btnSearch;
    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[2]")
    WebElement imgDropdownProfile;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement btnOut;
    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    WebElement loginTitle;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement txtDashboard;
    @FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    WebElement warningMessage;

    public String getLoginTitle() {
        return loginTitle.getText();
    }

    public String getTxtDashboard() {
        return txtDashboard.getText();
    }
    public void enterSymbol(String btnSearch) {
        this.btnSearch.sendKeys(btnSearch);
    }
    public void getImgDropdownProfile(){
        imgDropdownProfile.click();
    }
   public void getBtnOut(){
        btnOut.click();
   }
    public String getWarningMessage() {
        return warningMessage.getText();
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }
    public void enterUsername(String username) {this.username.sendKeys(username);
    }

    public void buttonLogin() {
        btnLogin.click();
    }

}
