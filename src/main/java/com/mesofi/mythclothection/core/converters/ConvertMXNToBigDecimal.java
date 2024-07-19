/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesofi.mythclothection.core.converters;

import com.opencsv.bean.AbstractBeanField;
import java.math.BigDecimal;

/**
 * @author armandorivasarzaluz
 */
public class ConvertMXNToBigDecimal extends AbstractBeanField<String, BigDecimal>
    implements ConvertToBigDecimal {

  @Override
  protected Object convert(String mxnNumberString) {
    return convertToNumber(mxnNumberString, "[$,]");
  }
}
