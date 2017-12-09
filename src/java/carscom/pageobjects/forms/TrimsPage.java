package carscom.pageobjects.forms;

import carscom.models.Car;
import framework.BaseForm;
import framework.elements.*;
import org.openqa.selenium.By;

public class TrimsPage extends BaseForm {

  private Label lblEngine = new Label(By.xpath("//span[contains(text(),'BASE TRIM')]/following::div[contains(text(),'hp')]"));
  private Label lblTransmission = new Label(By.xpath("//span[contains(text(),'BASE TRIM')]/following::div[contains(text(),'speed')]"));
  private Label lblCarName = new Label(By.xpath("//div[contains(@class,'trim-count')]//a"));
  private Button btnMainPage = new Button(By.xpath("//img[contains(@id,'cars')]"));

  public TrimsPage() {
     super("//div[contains(@class,'trim-count')]//a");
  }

  public void setTrims(Car car) {
    car.setEngine(lblEngine.getText());
    car.setTransmission(lblTransmission.getText());
  }

  public String getNameFromTrims() {
    return lblCarName.getText();
  }

  public void navigateMainPage() {
    btnMainPage.click();
  }
}
