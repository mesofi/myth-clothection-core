package com.mesofi.mythclothection.core.model;

import lombok.Getter;

@Getter
public enum SaintSeiyaBoxLogoType {
  CLASSIC("Classic"),
  HADES_SANCTUARY("Hades Chapter-Sanctuary");

  private final String description;

  SaintSeiyaBoxLogoType(String description) {
    this.description = description;
  }
}
