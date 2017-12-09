package carscom.pageobjects.forms;

import carscom.pageobjects.menus.GlobalMenu;
import framework.BaseForm;
import framework.elements.*;
import org.openqa.selenium.By;

public class CarPage extends BaseForm {

  public GlobalMenu globalMenu = new GlobalMenu();
  private Label lblTrimPage = new Label(By.xpath("//a[contains(@href,'/trims')]"));
  private Label lblName = new Label(By.xpath("//div[contains(@class, 'title')]//h1"));

  public CarPage() {
    super("//div[contains(@class, 'title')]//h1");
  }

  public boolean checkTrims() {
    return lblTrimPage.isEnabled();
  }

  public void navigateTrims() {
    lblTrimPage.click();
  }

  public String getNameFromCarPage() {
    return lblName.getText();
  }
}