package com.mesofi.mythclothection.core.model;

import lombok.Getter;

@Getter
public enum Distributor {
  TAMASHII("Bandai Tamashii Nations"),
  DTM("DTM"),
  DAM("Animexico"),
  BLUEFIN("BlueFin"),
  UNKNOWN("N/A");

  private final String description;

  Distributor(String description) {
    this.description = description;
  }
}
