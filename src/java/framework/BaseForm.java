package framework;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

public abstract class BaseForm extends BaseEntity {

  public BaseForm(String locator) {
    Assert.assertTrue((new Label(By.xpath(locator))).isEnabled());
  }

}
