package com.tigatok;

import com.tigatok.TrafficLight.TrafficLight;
import com.tigatok.TrafficLight.TrafficLightState;
import com.tigatok.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by tmarshall on 07/01/17.
 */
public class Intersection extends TrafficEntity {
  private String intersectionId;
  private String name;
  private TrafficLight lightX, lightY;
  private ArrayList<Vehicle> vehicles;
  private HashMap<TrafficLight, ArrayList<Vehicle>> trafficLightVehicleHashMap;

  /**
   * Create an intersection containing two lights.
   * @param lightX Light on X plane.
   * @param lightY Light on Y plane.
   * @param name Name of intersection.
   */
  public Intersection(TrafficLight lightX, TrafficLight lightY, String name){
    this.intersectionId = generateRandomEntityId();

    this.name = name;

    this.lightX = lightX;
    this.lightY = lightY;

    this.trafficLightVehicleHashMap = new HashMap<>();
  }

  /**
   * Generates a random entity string preceded with INT
   * @return modified String
   */
  @Override
  protected String generateRandomEntityId() {
    return "INT" + super.generateRandomEntityId();
  }

  /**
   * Processes an intersection.
   */
  public void processIntersection(){
    //Only process if there are vehicles waiting
    //at a light.
    System.out.println("\n\nProcessingIntersection");
    if(!this.trafficLightVehicleHashMap.isEmpty()){

      //Scenarios:
      //If there are vehicles at both
      //If there are vehicles at one

      //If there are vehicles at lightX.
      if(this.trafficLightVehicleHashMap.get(lightX) != null){
        System.out.println("lightX has a vehicle");

        lightX.setState(TrafficLightState.LightState.GREEN);
        lightY.setState(TrafficLightState.LightState.RED);
        return;
      }

      //If there are vehicles waiting at lightY.
      if(this.trafficLightVehicleHashMap.get(lightY) != null){
        System.out.println("lightY has a vehicle");

        lightY.setState(TrafficLightState.LightState.GREEN);
        lightX.setState(TrafficLightState.LightState.RED);


        return;
      }
    }
  }

  /**
   * @// TODO: 08/01/17 make random
   * Adds a vehicle to a random intersection.
   * @param vehicle
   */
  public void addVehicle(Vehicle vehicle){
    TrafficLight trafficLight;
    int random = new Random().nextInt(1 +1);
    if(random == 0){
      trafficLight = this.lightX;
    } else {
      trafficLight = this.lightY;
    }
    this.trafficLightVehicleHashMap.put(trafficLight, vehicles);
  }

  /**
   * Returns the intersectionId.
   * @return the intersectionId.
   */
  public String getIntersectionId() {
    return intersectionId;
  }

  /**
   * Sets the intersectionId.
   * @param intersectionId set the intersectionId.
   */
  public void setIntersectionId(String intersectionId) {
    this.intersectionId = intersectionId;
  }

  /**
   * Grabs the intersection name.
   * @return name of intersection to return.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the intersection name.
   * @param name name of intersection to set.
   */
  public void setName(String name) {
    this.name = name;
  }
}
