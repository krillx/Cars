package framework.elements;

import framework.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBox extends BaseElement {

  private Select select;

  public ComboBox(By locator) {
        super(locator);
  }

  private Select getSelect() {
    this.select = new Select(getElement());
    return select;
  }

  public void selectByValue(String valueOfSelect) {
    this.select = new Select(getElement());
    getSelect().selectByValue(valueOfSelect);
  }

  public void selectByText(String valueOfText) {
    this.select = new Select(getElement());
    getSelect().selectByVisibleText(valueOfText);
  }

  public void selectByIndex(int index) {
    this.select = new Select(getElement());
    getSelect().selectByIndex(index);
  }

  public String getTextOfChoosenOption() {
    this.select = new Select((getElement()));
    return select.getFirstSelectedOption().getText();
  }

  public int getSizeOfList() {
    this.select = new Select((getElement()));
    return select.getOptions().size();
  }
}
