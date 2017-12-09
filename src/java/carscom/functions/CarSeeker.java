package carscom.functions;

import carscom.models.Car;
import carscom.pageobjects.forms.CarPage;
import carscom.pageobjects.forms.SearchPage;
import carscom.pageobjects.menus.GlobalMenu;

public class CarSeeker {

  public static Car chooseAndSaveRandomCar(Car car) {
    int i = 5;
    SearchPage searchPage = new SearchPage();
    searchPage.chooseRandomCar(car);
    searchPage.searchRandomCar();
    CarPage carPage = new CarPage();
    while (!carPage.checkTrims() && i >= 0) {
      carPage.globalMenu.navigateGlobalMenu(GlobalMenu.ElementOfMenu.RESEARCH);
      searchPage = new SearchPage();
      searchPage.chooseRandomCar(car);
      searchPage.searchRandomCar();
      carPage = new CarPage();
      i--;
    }
    return car;
  }
}
