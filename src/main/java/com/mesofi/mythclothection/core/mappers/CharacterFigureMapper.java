package com.mesofi.mythclothection.core.mappers;

import com.mesofi.mythclothection.core.entity.CharacterFigureEntity;
import com.mesofi.mythclothection.core.model.*;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.util.StringUtils;

@Mapper(componentModel = "spring")
public interface CharacterFigureMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "baseName", source = "baseName")
  @Mapping(target = "distributionJPY.basePrice", source = "basePriceJPY")
  @Mapping(target = "distributionJPY.firstAnnouncementDate", source = "announcementDateJPY")
  @Mapping(target = "distributionJPY.preorderDate", source = "preorderDateJPY")
  @Mapping(target = "distributionJPY.releaseDate", source = "releaseDateJPY")
  @Mapping(
      target = "distributionJPY.releaseDateDayConfirmed",
      source = "releaseDateDayConfirmedJPY")
  @Mapping(target = "distributionMXN.distributor", source = "distributorMXN")
  @Mapping(target = "distributionMXN.releasePrice", source = "finalPriceMXN")
  @Mapping(target = "distributionMXN.preorderDate", source = "preorderDateMXN")
  @Mapping(target = "distributionMXN.releaseDate", source = "releaseDateMXN")
  @Mapping(target = "lineUp", source = "lineUp", qualifiedByName = "customFieldLineUpMapping")
  @Mapping(
      target = "distributionMethod",
      source = "distributionMethod",
      qualifiedByName = "customFieldDistributionMethodMapping")
  @Mapping(target = "series", source = "series", qualifiedByName = "customFieldSeriesMapping")
  @Mapping(
      target = "boxLogoType",
      source = "ssBoxLogo",
      qualifiedByName = "customFieldBoxLogoTypeMapping")
  @Mapping(target = "bandaiBlueLogo", source = "bandaiBlueLogo")
  @Mapping(target = "category", source = "category", qualifiedByName = "customFieldCategoryMapping")
  @Mapping(target = "bodyType", source = "bodyType")
  @Mapping(target = "faces", source = "faces")
  @Mapping(
      target = "galleryImages",
      expression =
          "java(mapGalleryImages(characterFigureSheet.getOfficialImages(), characterFigureSheet.getOtherImages()))")
  @Mapping(target = "otherInformation", source = "otherInformation")
  CharacterFigureEntity toEntity(CharacterFigureSheet characterFigureSheet);

  @Named("customFieldLineUpMapping")
  default LineUp customLineUpMapping(String source) {
    for (LineUp lineUp : LineUp.values()) {
      if (lineUp.getDescription().equals(source)) {
        return lineUp;
      }
    }
    return null;
  }

  @Named("customFieldDistributionMethodMapping")
  default DistributionMethod customDistributionMethodMapping(String source) {
    for (DistributionMethod distributionMethod : DistributionMethod.values()) {
      if (distributionMethod.getDescription().equals(source)) {
        return distributionMethod;
      }
    }
    return null;
  }

  @Named("customFieldSeriesMapping")
  default Series customSeriesMapping(String source) {
    for (Series series : Series.values()) {
      if (series.getDescription().equals(source)) {
        return series;
      }
    }
    return null;
  }

  @Named("customFieldBoxLogoTypeMapping")
  default SaintSeiyaBoxLogoType customSSBoxLogoTypeMapping(String source) {
    for (SaintSeiyaBoxLogoType saintSeiyaBoxLogoType : SaintSeiyaBoxLogoType.values()) {
      if (saintSeiyaBoxLogoType.getDescription().equals(source)) {
        return saintSeiyaBoxLogoType;
      }
    }
    return null;
  }

  @Named("customFieldCategoryMapping")
  default Category customCategoryMapping(String source) {
    for (Category category : Category.values()) {
      if (category.getDescription().equals(source)) {
        return category;
      }
    }
    return null;
  }

  default List<GalleryImage> mapGalleryImages(String official, String other) {
    if (StringUtils.hasText(official) || StringUtils.hasText(other)) {
      List<GalleryImage> galleryImages = new ArrayList<>();

      String[] officialImages = official.split(",");
      int i;
      for (i = 0; i < officialImages.length; i++) {
        galleryImages.add(new GalleryImage(officialImages[i], true, i == 0, i + 1));
      }
      if (StringUtils.hasText(other)) {
        String[] otherImages = other.split(",");
        for (int j = 0; j < officialImages.length; j++) {
          galleryImages.add(new GalleryImage(otherImages[j], false, false, i + j + 1));
        }
      }

      return galleryImages;
    }
    return null;
  }

  @Mapping(target = "id", source = "id")
  @Mapping(target = "baseName", source = "baseName")
  @Mapping(target = "officialName", ignore = true)
  @Mapping(target = "distributionJPY.basePrice", source = "distributionJPY.basePrice")
  @Mapping(target = "distributionJPY.releasePrice", source = "distributionJPY.releasePrice")
  @Mapping(
      target = "distributionJPY.firstAnnouncementDate",
      source = "distributionJPY.firstAnnouncementDate")
  @Mapping(target = "distributionJPY.preorderDate", source = "distributionJPY.preorderDate")
  @Mapping(target = "distributionJPY.releaseDate", source = "distributionJPY.releaseDate")
  @Mapping(
      target = "distributionJPY.releaseDateDayConfirmed",
      source = "distributionJPY.releaseDateDayConfirmed")
  @Mapping(target = "distributionMXN.distributor", source = "distributionMXN.distributor")
  @Mapping(target = "distributionMXN.releasePrice", source = "distributionMXN.releasePrice")
  @Mapping(target = "distributionMXN.preorderDate", source = "distributionMXN.preorderDate")
  @Mapping(target = "distributionMXN.releaseDate", source = "distributionMXN.releaseDate")
  @Mapping(
      target = "distributionMXN.releaseDateDayConfirmed",
      source = "distributionMXN.releaseDateDayConfirmed")
  @Mapping(target = "lineUp", source = "lineUp")
  @Mapping(target = "distribution", source = "distributionMethod")
  @Mapping(target = "series", source = "series")
  @Mapping(target = "boxLogoType", source = "boxLogoType")
  @Mapping(target = "bandaiBlueLogo", source = "bandaiBlueLogo")
  @Mapping(target = "category", source = "category")
  @Mapping(target = "bodyType", source = "bodyType")
  @Mapping(target = "numberOfFaces", source = "faces")
  @Mapping(target = "galleryImages", source = "galleryImages")
  @Mapping(target = "otherInformation", source = "otherInformation")
  MythCharacterFigure toMythCharacterFigure(CharacterFigureEntity characterFigureEntity);
}
