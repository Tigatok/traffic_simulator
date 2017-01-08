package com.tigatok;

import com.tigatok.TrafficLight.TrafficLight;
import com.tigatok.TrafficLight.TrafficLightState;
import com.tigatok.Vehicle.Vehicle;

import java.util.*;

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
    this.lightY.setState(TrafficLightState.LightState.RED);

    this.vehicles = new ArrayList<>();
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
      //If there are vehicles at one
      //If there are vehicles at both

      //If there are vehicles at lightX.
      if(this.trafficLightVehicleHashMap.get(lightX) != null){
        System.out.println("lightX has " + this.trafficLightVehicleHashMap.get(lightX).size() + " vehicles");
        System.out.println("LightX State: " + lightX.getState()+"\n" +
          "LightY State: " + lightY.getState());

        lightX.setState(TrafficLightState.LightState.GREEN);
        lightY.setState(TrafficLightState.LightState.RED);

        Iterator i = trafficLightVehicleHashMap.get(lightX).iterator();
        while(i.hasNext()){
          Vehicle v = (Vehicle)i.next();
          v.moveVehicle();
          i.remove();
        }
      }

      //If there are vehicles waiting at lightY.
      if(this.trafficLightVehicleHashMap.get(lightY) != null){
        System.out.println("lightY has " + this.trafficLightVehicleHashMap.get(lightY).size() + " vehicles");

        lightY.setState(TrafficLightState.LightState.GREEN);
        lightX.setState(TrafficLightState.LightState.RED);

        Iterator i = trafficLightVehicleHashMap.get(lightY).iterator();
        while(i.hasNext()){
          Vehicle v = (Vehicle)i.next();
          v.moveVehicle();
          i.remove();
        }
      }

      System.out.println("LightX State: " + lightX.getState()+"\n" +
        "LightY State: " + lightY.getState());
      System.out.println("Vehicles Waiting: " + vehicles.size());
    }
  }

  /**
   * @TODO: 08/01/17 make random
   * Adds a vehicle to a random intersection.
   * @param vehicle
   */
  public void addVehicle(Vehicle vehicle){
    TrafficLight trafficLight;

    //Add a vehicle to a random light.
    int random = new Random().nextInt(1 +1);
    if(random == 0){
      trafficLight = this.lightX;
    } else {
      trafficLight = this.lightY;
    }

    trafficLight.getVehicles().add(vehicle);
    this.trafficLightVehicleHashMap.put(trafficLight, trafficLight.getVehicles());
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
