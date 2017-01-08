package com.tigatok.Vehicle;

import com.tigatok.TrafficEntity;

import java.util.ArrayList;

/**
 * Created by tmarshall on 07/01/17.
 */
public class Vehicle extends TrafficEntity implements VehicleState{
  private State state;

  public Vehicle(){
    this.entityID = this.generateRandomEntityId();
    setState(State.STOPPED);
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

  public void moveVehicle(){
    System.out.println(this.getEntityID() + " has moved across the intersection");
  }
}
