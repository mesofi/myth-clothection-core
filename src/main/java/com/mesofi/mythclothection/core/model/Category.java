package com.mesofi.mythclothection.core.model;

import lombok.Getter;

@Getter
public enum Category {
  BRONZE_V2("New Bronze Cloth"),
  GOLDEN("Golden Saint"),
  JUDGE("Underworld Judge"),
  BRONZE_V3("Final Bronze Cloth"),
  OTHER("Other");

  private final String description;

  Category(String description) {
    this.description = description;
  }
}
