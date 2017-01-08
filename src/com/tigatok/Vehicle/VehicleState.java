package com.tigatok.Vehicle;

/**
 * Created by tmarshall on 07/01/17.
 */
public interface VehicleState {
  enum State {
    STOPPED,
    MOVING
  }

  State getState();
  void setState(State state);
}
