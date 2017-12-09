package carscom.pageobjects.forms;

import carscom.models.Car;
import framework.BaseForm;
import framework.elements.*;
import org.openqa.selenium.By;

public class AddComparePage extends BaseForm {

  private Button btnSubmit = new Button(By.xpath("//button[contains(@class, 'done')]"));
  private Button lblAddAnotherCar = new Button(By.xpath("//div[contains(@id , 'icon')]"));
  private Button btnAnotherCarAdded = new Button(By.xpath("//button[contains(text(),'Done')]"));

  public AddComparePage() {
    super("//button[contains(@class, 'done')]");
  }

  public void addFirstCarToCompare(Car car) {
    selectCarToCompare(car);
    btnSubmit.click();
  }

  public void addCarToCompare(Car car) {
    lblAddAnotherCar.click();
    selectCarToCompare(car);
    btnAnotherCarAdded.click();
  }

  private void selectCarToCompare(Car car) {
    String patternForSelect = "//select[contains(@id ,'%s')]";
    new ComboBox(By.xpath(String.format(patternForSelect,"make"))).selectByText(car.getMakeSelector());
    new ComboBox(By.xpath(String.format(patternForSelect,"model"))).selectByText(car.getModelSelector());
    new ComboBox(By.xpath(String.format(patternForSelect, "year"))).selectByText(car.getYearSelector());
  }

  public String getTransmissionForCompare(int index) {
    String patternForTransmision = "//p[contains(text(), 'Trans')]/parent::div/following-sibling::div//span[%s]";
    Label label = new Label(By.xpath(String.format(patternForTransmision,String.valueOf(index + 1))));
    return label.getText();
  }

  public String getEngineForCompare(int index) {
    String patternForEngine = "//p[contains(text(), 'Engine')]/parent::div/following-sibling::div//span[%s]";
    Label label = new Label(By.xpath(String.format(patternForEngine,String.valueOf(index + 1))));
    String beforeReplace = label.getText();
    return beforeReplace.replace("liter ","L ");
  }

  public String getNameForCompare(int index) {
    String patternForName = "//div[@id= 'sticky-header']//span[%s]//h4";
    Label label = new Label(By.xpath(String.format(patternForName,String.valueOf(index + 1))));
    return label.getText();
  }
}


