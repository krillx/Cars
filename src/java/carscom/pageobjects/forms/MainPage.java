package carscom.pageobjects.forms;

import carscom.pageobjects.menus.GlobalMenu;
import framework.BaseForm;

public class MainPage extends BaseForm {

  public GlobalMenu globalMenu = new GlobalMenu();

  public MainPage() {
    super((("//div[contains(@class, 'other-search')]")));
  }
}
