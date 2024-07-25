package com.mesofi.mythclothection.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoxStyle {
  private SaintSeiyaBoxLogoType boxLogoType;
  private boolean bandaiBlueLogo;
  private String borderColor;
}
