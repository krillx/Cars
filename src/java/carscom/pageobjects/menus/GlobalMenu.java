package carscom.pageobjects.menus;

import framework.BaseForm;
import framework.elements.Button;
import org.openqa.selenium.By;

public class GlobalMenu extends BaseForm {

  String patternForGlobalMenu = "//li[contains(@class, 'global')]//a[contains(text(),'%s')]";

  public enum ElementOfMenu {
    RESEARCH("Research");

    private String name;

    ElementOfMenu(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  public GlobalMenu() {
    super("//li[contains(@class, 'global')]");
  }

  public void navigateGlobalMenu(ElementOfMenu elementOfMenu) {
    new Button(By.xpath(String.format(patternForGlobalMenu, elementOfMenu.getName()))).click();

  }
}
