package carscom.steps;

import carscom.models.Car;
import carscom.functions.CarSeeker;
import carscom.pageobjects.forms.*;
import carscom.pageobjects.menus.GlobalMenu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;

public class Steps {

  private MainPage mainPage;
  private SearchPage searchPage;
  private CarPage carPage;
  private TrimsPage trimsPage;
  private AddComparePage addComparePage;
  private List<Car> cars = new ArrayList<>();

  @Given("^I should see a main page$")
  public void i_should_see_a_main_page() {
    mainPage = new MainPage();
  }

  @When("^I click button Research$")
  public void i_click_button() {
    mainPage.globalMenu.navigateGlobalMenu(GlobalMenu.ElementOfMenu.RESEARCH);
  }

  @Then("^I Should see a research page$")
  public void i_Should_see_a_research_page()  {
    searchPage = new SearchPage();
  }

  @When("^I choose and save random car number (\\d+) , I  should see trims button, or I return to Research and choose another car$")
  public void i_choose_and_save_random_car_number_I_should_see_trims_button_or_I_return_to_Research_and_choose_another_car(int carNumber) throws Throwable {
    int carIndex = carNumber - 1;
    cars.add(new Car());
    cars.set(carIndex,CarSeeker.chooseAndSaveRandomCar(cars.get(carIndex))) ;
    carPage = new CarPage();
  }

  @Then("^I should see car page for car number (\\d+)$")
  public void i_should_see_car_page_for_car_number(int carNumber) {
    int carIndex = carNumber - 1;
    String nameFromCarPage = carPage.getNameFromCarPage();
    String carName = cars.get(carIndex).getName();
    Assert.assertEquals(nameFromCarPage, carName);
  }

  @When("^I click trims button$")
  public void i_click_trims_button() {
    carPage.navigateTrims();
  }

  @Then("^I should see trims page for car number (\\d+)$")
  public void i_should_see_trims_page_for_car_number(int carNumber) {
    trimsPage = new TrimsPage();
    int carIndex = carNumber - 1;
    String nameFromCar = cars.get(carIndex).getName();
    Assert.assertEquals(trimsPage.getNameFromTrims(), nameFromCar);
  }

  @Then("^I collect and save Engine and transmission for car number (\\d+)$")
  public void i_collect_and_save_Engine_and_transmission_for_car_number(int carNumber) {
    int carIndex = carNumber - 1;
    trimsPage.setTrims(cars.get(carIndex));
  }

  @Then("^I return to mainPage$")
  public void i_return_to_mainPage() {
    trimsPage.navigateMainPage();
  }

  @When("^I click compare button$")
  public void i_click_compare_button() {
    searchPage.navigateComparisons();
    addComparePage = new AddComparePage();
  }

  @When("^I add  car number (\\d+) to compare$")
  public void i_add_car_number_to_compare(int carNumber) {
    addComparePage.addFirstCarToCompare(cars.get(--carNumber));
  }

  @Then("^I should see that car number (\\d+) added to compare$")
  public void i_should_see_that_car_number_added_to_compare(int carNumber)  {
    int carIndex = carNumber - 1;
    String nameFromTrans = addComparePage.getNameForCompare(carIndex);
    String nameFromCar = cars.get(carIndex).getName();
    Assert.assertEquals(nameFromTrans, nameFromCar);
  }

  @When("^I add another car number (\\d+) to compare$")
  public void i_add_another_car_number_to_compare(int carNumber) {
    addComparePage.addCarToCompare(cars.get(--carNumber));
  }

  @Then("^I check that engines and transmision of  car number (\\d+) are correct$")
  public void i_check_that_engines_and_transmision_of_car_number_are_correct(int carNumber) {
    int carIndex = carNumber - 1;
    String transfFromCopm = addComparePage.getTransmissionForCompare(carIndex);
    String transFromCar = cars.get(carIndex).getTransmission();
    String engFromCopm = addComparePage.getEngineForCompare(carIndex);
    String engFromCar = cars.get(carIndex).getEngine();
    Assert.assertTrue(transfFromCopm.contains(transFromCar));
    Assert.assertTrue(engFromCopm.contains(engFromCar));
  }
}

