package com.tigatok.Vehicle;

import com.tigatok.TrafficEntity;

import java.util.ArrayList;

/**
 * Created by tmarshall on 07/01/17.
 */
public class Vehicle extends TrafficEntity implements VehicleState{
  private State state;
  private static ArrayList<Vehicle> vehicleArrayList;

  public Vehicle(){
    this.entityID = this.generateRandomEntityId();
    setState(State.STOPPED);
    vehicleArrayList.add(this);
  }

  public static ArrayList<Vehicle> getVehicleArrayList(){
    if(vehicleArrayList == null){
      vehicleArrayList = new ArrayList<>();
    }
    return vehicleArrayList;
  }

  @Override
  public State getState() {
    return state;
  }

  @Override
  public void setState(State state) {
    this.state = state;
  }

  @Override
  protected String generateRandomEntityId() {
    return "VEH" + super.generateRandomEntityId();
  }
}
