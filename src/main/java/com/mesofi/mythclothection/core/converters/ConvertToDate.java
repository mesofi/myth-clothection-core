/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesofi.mythclothection.core.converters;

import com.opencsv.bean.AbstractBeanField;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

/**
 * @author armandorivasarzaluz
 */
public class ConvertToDate extends AbstractBeanField<String, LocalDate> {

  @Override
  protected Object convert(String dateString) {
    if (StringUtils.hasText(dateString)) {
      if (dateString.length() == 6 || dateString.length() == 7) {
        // date with no day
        YearMonth yearMonth = YearMonth.parse(dateString, DateTimeFormatter.ofPattern("M/yyyy"));
        return yearMonth.atDay(1);
      } else {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("M/d/yyyy"));
      }
    }
    return null;
  }
}
