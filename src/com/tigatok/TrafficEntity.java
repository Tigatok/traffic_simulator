package com.tigatok;

import java.util.UUID;

/**
 * Created by tmarshall on 07/01/17.
 */
public abstract class TrafficEntity {
  protected String entityID;

  public String getEntityID() {
    return entityID;
  }

  public void setEntityID(String entityID) {
    this.entityID = entityID;
  }

  protected String generateRandomEntityId(){
    return UUID.randomUUID().toString().substring(0,8);
  }
}
