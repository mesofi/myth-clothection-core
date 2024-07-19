package com.mesofi.mythclothection.core.converters;

import java.math.BigDecimal;
import org.springframework.util.StringUtils;

public interface ConvertToBigDecimal {
  default BigDecimal convertToNumber(String string, String charactersToRemove) {
    if (StringUtils.hasText(string)) {
      return new BigDecimal(string.replaceAll(charactersToRemove, ""));
    }
    return null;
  }
}
