package com.tigatok.TrafficLight;

/**
 * Created by tmarshall on 07/01/17.
 */
public interface TrafficLightState {
  enum LightState{
    RED,
    YELLOW,
    GREEN,
  }

  LightState getState();

  void setState(LightState lightState);

}
