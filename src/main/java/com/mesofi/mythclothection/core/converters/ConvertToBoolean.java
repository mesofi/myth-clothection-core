/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesofi.mythclothection.core.converters;

import com.opencsv.bean.AbstractBeanField;
import org.springframework.util.StringUtils;

/**
 * @author armandorivasarzaluz
 */
public class ConvertToBoolean extends AbstractBeanField<String, Boolean> {

  @Override
  protected Object convert(String booleanString) {
    if (StringUtils.hasText(booleanString)) {
      return booleanString.equals("TRUE");
    }
    return null;
  }
}
