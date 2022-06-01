package pomClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath = "//input[@name='username']") 
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@name='pwd']") 
	private WebElement password ;
	
	@FindBy (xpath = "//input[@name='remember']") 
	private WebElement keepMeLoginCheckbox ;
	
	@FindBy (xpath = "//a[text()='Login']") 
	private WebElement login ;
	
	@FindBy (xpath = "//a[text()='Login']") 
	private List<WebElement> login123 ;
	

	
	//driver1 = driver = new ChromeDriver();
	public LoginPage(WebDriver driver1){   
		PageFactory.initElements(driver1, this);
	}
	
	public void sendUserName(String user) {
		userName.sendKeys(user);
	}
	
	public void sendPasswordName(String pass) {
		password.sendKeys(pass);
	}
	
	public void selectKeepMeLogin() {
		keepMeLoginCheckbox.click();
	}
	
	public void clickOnLoginButton() {
		login.click();
	}
	
	//Or
	
	public void loginToApplication() {
		userName.sendKeys("Admin");
		password.sendKeys("manager");
		keepMeLoginCheckbox.click();
		login.click();
	}

}
