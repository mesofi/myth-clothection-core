package com.mesofi.mythclothection.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MythCharacterFigure {
  @Id private String id;
  private String baseName;
  private String officialName;
  private Distribution distributionJPY;
  private Distribution distributionMXN;
  private BoxStyle boxStyle;
  private String tamashiiUrl;
  private LineUp lineUp;
  private DistributionMethod distribution;
  private Series series;
  private Category category;
  private BodyType bodyType;
  private int numberOfFaces;
  private List<GalleryImage> galleryImages;
  private String otherInformation;
}
