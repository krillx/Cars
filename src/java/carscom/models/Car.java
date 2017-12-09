package carscom.models;

public class Car {

  private String engine;
  private String transmission;
  private String makeSelector;
  private String modelSelector;
  private String yearSelector;

  public void setMakeSelector(String randomMake) {
    this.makeSelector = randomMake;
  }

  public void setModelSelector(String randomModel) {
    this.modelSelector = randomModel;
  }

  public void setYearSelector(String randomYear) {
    this.yearSelector = randomYear;
  }

  public void setEngine(String engine) {
    this.engine = engine;
  }

  public void setTransmission(String transmission) {
    this.transmission = transmission;
  }

  public String getMakeSelector() {
    return makeSelector;
  }

  public String getModelSelector() {
    return modelSelector;
  }

  public String getYearSelector() {
    return yearSelector;
  }

  public String getEngine() {
    return engine;
  }

  public String getTransmission() {
    return transmission;
  }

  public String getName() {
    return getYearSelector() + " " + getMakeSelector() + " " + getModelSelector();
  }










}
