package com.mesofi.mythclothection.core.model;

import lombok.Getter;

@Getter
public enum DistributionMethod {
  RETAIL("Retail"),
  OTHER_LIMITED_EDITION("Other Limited Edition");

  private final String description;

  DistributionMethod(String description) {
    this.description = description;
  }
}
