package com.tigatok;

import com.tigatok.TrafficLight.TrafficLight;
import com.tigatok.Vehicle.Vehicle;
import com.tigatok.tests.VehicleTest;

import java.util.Timer;

public class Main {

  static boolean debug = true;
  public static void main(String[] args) {
    //Generate some vechile testing
    if(debug) {
      new VehicleTest();
    }

    TrafficLight lightX = new TrafficLight();
    TrafficLight lightY = new TrafficLight();

    Intersection intersection = new Intersection(lightX, lightY, "Pandosy");

    intersection.addVehicle(new Vehicle());
    intersection.addVehicle(new Vehicle());
    intersection.addVehicle(new Vehicle());
    intersection.addVehicle(new Vehicle());
    intersection.addVehicle(new Vehicle());
    intersection.addVehicle(new Vehicle());
    intersection.addVehicle(new Vehicle());
    intersection.addVehicle(new Vehicle());
    intersection.processIntersection();
  }
}
