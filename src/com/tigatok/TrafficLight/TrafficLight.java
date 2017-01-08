package com.tigatok.TrafficLight;

import com.tigatok.TrafficEntity;

/**
 * Created by tmarshall on 07/01/17.
 */
public class TrafficLight extends TrafficEntity implements TrafficLightState{
  private LightState lightState;
  private String trafficLightId;

  public TrafficLight(){
    setState(LightState.GREEN);
    this.trafficLightId = generateRandomEntityId();
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
}
