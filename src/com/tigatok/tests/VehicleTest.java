package com.tigatok.tests;

import com.tigatok.Vehicle.Vehicle;
import com.tigatok.Vehicle.VehicleState;

import static com.tigatok.Vehicle.VehicleState.State.STOPPED;

/**
 * Created by tmarshall on 07/01/17.
 */
public class VehicleTest {
  public VehicleTest(){
    System.out.println("Creating a Vehicle");
    Vehicle testVehicle = new Vehicle();

    System.out.println("Test Vehicle ID: " + testVehicle.getEntityID());
    System.out.println("Vehicle State == STOPPED: " + (testVehicle.getState() == STOPPED));
    System.out.println("Setting state to MOVING");

    testVehicle.setState(VehicleState.State.MOVING);
    System.out.println("Vehicle State: " + testVehicle.getState());
  }
}
