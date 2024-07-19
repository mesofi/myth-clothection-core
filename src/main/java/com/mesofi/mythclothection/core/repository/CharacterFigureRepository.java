package com.mesofi.mythclothection.core.repository;

import com.mesofi.mythclothection.core.entity.CharacterFigureEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Primary // we make it primary because the Integration Tests uses a custom
// implementation.
@Repository
public interface CharacterFigureRepository extends MongoRepository<CharacterFigureEntity, String> {}
