package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseElement extends BaseEntity {

  private WebElement element;
  private By locator;
  private static WebDriver driver = currentBrowser.returnDriver();
  private PropertiesReader properties = new PropertiesReader();
  private WebDriverWait wait = new WebDriverWait(driver, properties.getWaitsForElemetns());

  public BaseElement(By locator) {
    this.locator = locator;
  }

  public WebElement getElement() {
    element = driver.findElement(locator);
    return element;
  }

  public boolean isEnabled() {
    try {
      driver.findElement(locator).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
    return true;
  }

  public void click() {
    waitForClickable();
    element.click();
  }

  public String getText() {
    element = driver.findElement(locator);
    waitForEnabled();
    return getElement().getText();
  }

  public int getSizeOfList() {
    waitForEnabled();
    return  driver.findElements(locator).size();
  }

  public void waitForClickable() {
    element = driver.findElement(locator);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public void waitForEnabled() {
    element = driver.findElement(locator);
    wait.until(ExpectedConditions.visibilityOf(element));
  }
}






