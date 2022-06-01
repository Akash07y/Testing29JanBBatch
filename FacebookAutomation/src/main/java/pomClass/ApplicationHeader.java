package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeader {

	@FindBy (xpath = "//a[@class='content tasks']") 
	private WebElement tasks ;
	
	@FindBy (xpath = "//a[@class='content reports']") 
	private WebElement reports ;
	
	@FindBy (xpath = "//a[@class='content users']") 
	private WebElement users ;

	@FindBy (xpath = "//a[text()='Logout']") 
	private WebElement logout ;
	
	WebDriver driver;
	
	public ApplicationHeader(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver =  driver ;
	}
	
	public void openTaskPage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(tasks));
		tasks.click();
	}

	public void openReportsPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOf(reports));
		reports.click();
	}
	
	public void openUserList() {
		users.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
}
