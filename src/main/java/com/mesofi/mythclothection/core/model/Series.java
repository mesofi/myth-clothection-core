package com.mesofi.mythclothection.core.model;

import lombok.Getter;

@Getter
public enum Series {
  SAINT_SEIYA("Saint Seiya");

  private final String description;

  Series(String description) {
    this.description = description;
  }
}
