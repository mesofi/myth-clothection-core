package com.mesofi.mythclothection.core.model;

import lombok.Getter;

@Getter
public enum LineUp {
  MYTH_CLOTH("Myth Cloth");

  private final String description;

  LineUp(String description) {
    this.description = description;
  }
}
