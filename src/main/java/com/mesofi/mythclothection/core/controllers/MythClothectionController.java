/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesofi.mythclothection.core.controllers;

import com.mesofi.mythclothection.core.model.MythCharacterFigure;
import com.mesofi.mythclothection.core.service.MythClothectionService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author armandorivasarzaluz
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/characters")
@CrossOrigin(origins = {"http://localhost:5173"})
public class MythClothectionController {

  private final MythClothectionService mythClothectionService;

  /**
   * Handle all the incoming records.
   *
   * @param file The records to be uploaded.
   * @return d
   */
  @PostMapping("/loader")
  public ResponseEntity<?> loadAllCharacters(@RequestParam("file") MultipartFile file) {
    log.debug("Loading all the character records from the original source ...");
    // calls the actual service ...
    long total = mythClothectionService.loadAllCharacters(file);
    log.debug("Total records loaded: {}", total);
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }

  @GetMapping
  public List<MythCharacterFigure> getAllCharacters() {
    return mythClothectionService.getAllCharacters();
  }
}
