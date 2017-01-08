package com.tigatok.TrafficLight;

import com.tigatok.TrafficEntity;
import com.tigatok.Vehicle.Vehicle;

import java.util.ArrayList;

/**
 * Created by tmarshall on 07/01/17.
 */
public class TrafficLight extends TrafficEntity implements TrafficLightState{
  private LightState lightState;
  private String trafficLightId;
  private ArrayList<Vehicle> vehicles;

  public TrafficLight(){
    setState(LightState.GREEN);
    this.trafficLightId = generateRandomEntityId();
    this.vehicles = new ArrayList<>();
  }

  @Override
  public LightState getState() {
    return this.lightState;
  }

  @Override
  public void setState(LightState lightState) {
    this.lightState = lightState;
  }

  @Override
  protected String generateRandomEntityId() {
    return "LIG" + super.generateRandomEntityId();
  }

  public ArrayList<Vehicle> getVehicles() {
    return vehicles;
  }

  public void setVehicles(ArrayList<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }
}
