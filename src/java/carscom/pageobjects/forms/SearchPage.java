package carscom.pageobjects.forms;

import carscom.models.Car;
import framework.BaseForm;
import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;

public class SearchPage extends BaseForm {

  private Button btnSubmit = new Button(By.xpath("//div[contains(@class, 'submit')]"));
  private Label lblCompare = new Label(By.xpath("//h4[contains(text(),'Compar')]"));

  public SearchPage() {
    super("//select[contains(@ng-model, '')]");
  }

  public void chooseRandomCar(Car car) {
    car.setMakeSelector(getRandomElement("make"));
    car.setModelSelector(getRandomElement("model"));
    car.setYearSelector(getRandomElement("year"));
  }

  public void searchRandomCar() {
    btnSubmit.click();
  }

  private String getRandomElement(String pattern) {
    String patternForSelect = "//select[contains(@ng-model, '%s')]";
    ComboBox comboBox = new ComboBox(By.xpath(String.format(patternForSelect,pattern)));
    int rand = (int) (Math.random() *  (comboBox.getSizeOfList() - 1) + 1);
    comboBox.selectByIndex(rand);
    return  comboBox.getTextOfChoosenOption();
  }

  public void navigateComparisons() {
    lblCompare.click();
  }
}
