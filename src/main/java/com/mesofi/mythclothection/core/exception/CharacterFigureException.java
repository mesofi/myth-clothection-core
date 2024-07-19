package com.mesofi.mythclothection.core.exception;

import java.io.Serial;

public class CharacterFigureException extends RuntimeException {

  @Serial private static final long serialVersionUID = 1L;

  public CharacterFigureException(String message) {
    super(message);
  }
}
