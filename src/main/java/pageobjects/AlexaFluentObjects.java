package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlexaFluentObjects {
	public static WebDriver driver;
	public AlexaFluentObjects(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//header[@class='nav-opt-sprite nav-locale-in nav-lang-en nav-ssl nav-unrec']/div/div/div[2]//a[@data-nav-role='signin']")
	private WebElement ClickSigninbtnhome;

	@FindBy(xpath="//input[@type='email']")
    private WebElement email;

	@FindBy(id="continue")
	private WebElement clickcontinue;

	@FindBy(id="ap_password")
	private WebElement enterpassword;

	@FindBy(xpath="//input[@id='signInSubmit' and @type='submit']")
	public WebElement clicklogin;

	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement enterproduct;

	@FindBy(xpath="//div[@id='nav-search']/form[@role='search']//input[@value='Go']")
	private WebElement clickonsearch_product;

	@FindBy(xpath="//div[@class='sg-col-inner']//div[@class='s-include-content-margin s-border-bottom']//span[text()='Echo Dot (3rd Gen) � New and improved smart speaker with Alexa (Black)']")
	private WebElement clickonalexa;


	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addtocart;
	@FindBy(xpath="//input[@id='buy-now-button']")
    private WebElement buynow;

	@FindBy(id="hlb-view-cart-announce")
	WebElement viewcart;

	@FindBy(id="//select[@name='quantity']/option[@value='0']")
	WebElement clearcart;


	public static AlexaFluentObjects using(WebDriver driver)
	{
		return new AlexaFluentObjects(driver);

	}

	public WebElement ClickSigninbtnhome()
	{

		return ClickSigninbtnhome;
	}

	public WebElement email()
	{
		return email;
	}

	public WebElement clickcontinue()
	{
		return clickcontinue;
	}

	public WebElement enterpassword()
	{
		return enterpassword;
	}
	public WebElement clicklogin()
	{
		return clicklogin;
	}


	public WebElement enterproduct()
	{
		return enterproduct;
	}

	public WebElement clickonsearch_product()
	{
		return clickonsearch_product;
	}

	public WebElement clickonalexa()
	{
		return clickonalexa;
	}

	public WebElement addtocart()
	{
		return addtocart;
	}

	public WebElement buynow()
	{
		return buynow;
	}

	public WebElement viewcart()
	{
	return viewcart;
	}

	public WebElement clearcart()
	{
		return clearcart;
	}
}
