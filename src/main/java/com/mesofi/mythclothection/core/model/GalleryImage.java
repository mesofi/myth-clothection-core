package com.mesofi.mythclothection.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GalleryImage {
  private String url;
  private boolean official;
  private boolean coverPhoto;
  private int order;
}
