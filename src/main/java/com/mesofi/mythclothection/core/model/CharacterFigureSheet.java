/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesofi.mythclothection.core.model;

import com.mesofi.mythclothection.core.converters.ConvertJPYToBigDecimal;
import com.mesofi.mythclothection.core.converters.ConvertMXNToBigDecimal;
import com.mesofi.mythclothection.core.converters.ConvertToBoolean;
import com.mesofi.mythclothection.core.converters.ConvertToDate;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author armandorivasarzaluz
 */
@Getter
@Setter
public class CharacterFigureSheet {
  @CsvBindByName(column = "Base Name", required = true)
  private String baseName;

  @CsvCustomBindByName(
      column = "Base Price JPY",
      required = true,
      converter = ConvertJPYToBigDecimal.class)
  private BigDecimal basePriceJPY;

  @CsvCustomBindByName(column = "Announcement Date JPY", converter = ConvertToDate.class)
  private LocalDate announcementDateJPY;

  @CsvCustomBindByName(column = "Preorder Date JPY", converter = ConvertToDate.class)
  private LocalDate preorderDateJPY;

  @CsvCustomBindByName(
      column = "Release Date JPY",
      required = true,
      converter = ConvertToDate.class)
  private LocalDate releaseDateJPY;

  @CsvCustomBindByName(
      column = "Release Day Confirmed",
      required = true,
      converter = ConvertToBoolean.class)
  private boolean releaseDateDayConfirmedJPY;

  @CsvBindByName(column = "Distributor MXN", required = true)
  private String distributorMXN;

  @CsvCustomBindByName(column = "Final Price MXN", converter = ConvertMXNToBigDecimal.class)
  private BigDecimal finalPriceMXN;

  @CsvCustomBindByName(column = "Preorder Date MXN", converter = ConvertToDate.class)
  private LocalDate preorderDateMXN;

  @CsvCustomBindByName(column = "Release Date MXN", converter = ConvertToDate.class)
  private LocalDate releaseDateMXN;

  @CsvBindByName(column = "Tamashii URL")
  private String tamashiiUrl;

  @CsvBindByName(column = "LineUp", required = true)
  private String lineUp;

  @CsvBindByName(column = "Distribution Method", required = true)
  private String distributionMethod;

  @CsvBindByName(column = "Series", required = true)
  private String series;

  @CsvBindByName(column = "SS Box Logo Type", required = true)
  private String ssBoxLogo;

  @CsvCustomBindByName(
      column = "Bandai Blue Logo",
      required = true,
      converter = ConvertToBoolean.class)
  private boolean bandaiBlueLogo;

  @CsvBindByName(column = "Category", required = true)
  private String category;

  @CsvBindByName(column = "Body Type", required = true)
  private String bodyType;

  @CsvBindByName(column = "Faces", required = true)
  private int faces;

  @CsvBindByName(column = "Official Images")
  private String officialImages;

  @CsvBindByName(column = "Other Images")
  private String otherImages;

  @CsvBindByName(column = "Other Information")
  private String otherInformation;
}
