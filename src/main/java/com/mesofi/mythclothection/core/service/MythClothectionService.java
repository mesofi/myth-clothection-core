package com.mesofi.mythclothection.core.service;

import com.mesofi.mythclothection.core.entity.CharacterFigureEntity;
import com.mesofi.mythclothection.core.exception.CharacterFigureException;
import com.mesofi.mythclothection.core.mappers.CharacterFigureMapper;
import com.mesofi.mythclothection.core.model.*;
import com.mesofi.mythclothection.core.repository.CharacterFigureRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@AllArgsConstructor
public class MythClothectionService {

  private final CharacterFigureMapper characterFigureMapper;
  private final CharacterFigureRepository characterFigureRepository;

  public long loadAllCharacters(MultipartFile file) {
    log.debug("Loading all the records ...");
    if (Objects.isNull(file)) {
      throw new IllegalArgumentException("The uploaded file is missing...");
    }
    InputStream inputStream;
    try {
      inputStream = file.getInputStream();
    } catch (IOException e) {
      log.error("Can't read input file", e);
      throw new CharacterFigureException("Unable to read characters from initial input file");
    }
    // the records are read and processed now.
    try {
      List<CharacterFigureEntity> listEntities = convertStreamToEntityList(inputStream);
      log.info("{}", listEntities);
      characterFigureRepository.deleteAll();
      characterFigureRepository.saveAll(listEntities);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return 0;
  }

  public List<CharacterFigureEntity> convertStreamToEntityList(@NonNull InputStream inputStream)
      throws IOException {

    CsvToBean<CharacterFigureSheet> csvToBean;
    List<CharacterFigureEntity> list = new ArrayList<>();
    try (inputStream;
        InputStreamReader isr = new InputStreamReader(inputStream)) {
      csvToBean =
          new CsvToBeanBuilder<CharacterFigureSheet>(isr)
              .withType(CharacterFigureSheet.class)
              .withSkipLines(1)
              .withSeparator(',')
              .build();

      for (CharacterFigureSheet row : csvToBean) {
        list.add(characterFigureMapper.toEntity(row));
      }
    }
    return list;
  }

  public List<MythCharacterFigure> getAllCharacters() {
    return characterFigureRepository.findAll().stream()
        .map(characterFigureMapper::toMythCharacterFigure)
        .peek(this::calculateAdditionalInformation)
        .collect(Collectors.toList());
  }

  private void calculateAdditionalInformation(MythCharacterFigure mythCharacterFigure) {
    mythCharacterFigure.setOfficialName(calculateOfficialName(mythCharacterFigure));
    mythCharacterFigure
        .getDistributionJPY()
        .setReleasePrice(calculateReleasePrice(mythCharacterFigure));

    for (GalleryImage galleryImage : mythCharacterFigure.getGalleryImages()) {
      galleryImage.setUrl(calculateImageUrl(galleryImage.getUrl()));
    }

    mythCharacterFigure.setBoxStyle(calculateBoxStyle(mythCharacterFigure.getBoxStyle()));
  }

  private BigDecimal calculateReleasePrice(MythCharacterFigure mythCharacterFigure) {
    BigDecimal basePrice = mythCharacterFigure.getDistributionJPY().getBasePrice();
    LocalDate releaseDate = mythCharacterFigure.getDistributionJPY().getReleaseDate();

    BigDecimal releasePrice;
    if (Objects.nonNull(basePrice) && Objects.nonNull(releaseDate)) {
      LocalDate october2019 = LocalDate.of(2019, 10, 1);
      if (releaseDate.isBefore(october2019)) {
        releasePrice = basePrice.add(basePrice.multiply(new BigDecimal(".08")));
      } else {
        releasePrice = basePrice.add(basePrice.multiply(new BigDecimal(".10")));
      }
      return releasePrice;
    }
    return null;
  }

  private String calculateOfficialName(MythCharacterFigure mythCharacterFigure) {
    if (mythCharacterFigure.getLineUp() == LineUp.MYTH_CLOTH
        && mythCharacterFigure.getCategory() == Category.BRONZE_V3) {

      return mythCharacterFigure.getBaseName() + " (Final Bronze Cloth)";
    }
    return mythCharacterFigure.getBaseName();
  }

  private String calculateImageUrl(String url) {
    return "https://imagizer.imageshack.com/v2/640x480q70/" + url + ".jpg";
  }

  private BoxStyle calculateBoxStyle(BoxStyle boxStyle) {
    if (StringUtils.hasText(boxStyle.getBorderColor())) {
      boxStyle.setBorderColor("#" + boxStyle.getBorderColor());
    } else {
      boxStyle.setBorderColor(null);
    }
    return boxStyle;
  }
}
