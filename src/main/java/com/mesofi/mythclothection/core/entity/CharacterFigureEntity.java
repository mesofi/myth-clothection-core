package com.mesofi.mythclothection.core.entity;

import com.mesofi.mythclothection.core.model.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("CharacterFigure")
public class CharacterFigureEntity {
  @Id private String id;
  private String baseName;
  private Distribution distributionJPY;
  private Distribution distributionMXN;
  private BoxStyle boxStyle;
  private String tamashiiUrl;
  private LineUp lineUp;
  private DistributionMethod distributionMethod;
  private Series series;
  private Category category;
  private BodyType bodyType;
  private int faces;
  private List<GalleryImage> galleryImages;
  private String otherInformation;
}
