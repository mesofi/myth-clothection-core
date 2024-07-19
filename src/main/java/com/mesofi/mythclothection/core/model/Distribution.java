package com.mesofi.mythclothection.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Distribution {
  private Distributor distributor;
  private BigDecimal basePrice;
  private BigDecimal releasePrice;
  private LocalDate firstAnnouncementDate;
  private LocalDate preorderDate;
  private LocalDate releaseDate;
  private boolean releaseDateDayConfirmed;
}
