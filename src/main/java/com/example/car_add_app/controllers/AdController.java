package com.example.car_add_app.controllers;

import com.example.car_add_app.entity.Ad;
import com.example.car_add_app.dto.AdDto;
import com.example.car_add_app.enums.Color;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AdController extends ProtoController<Ad, AdDto, ResponseEntity> {
    @Override
    ResponseEntity create(AdDto body);

    @Override
    List<Ad> get();

    @Override
    Optional<Ad> getByIndex(Integer index);

    @Override
    Optional<Ad> getById(Long id);

    @Override
    void deleteAll();

    @Override
    void deleteById(Long id);

    List<Ad> findByDate(LocalDate date);

    Set<Ad> findByParam(
            String name,
            Color color,
            BigDecimal price,
            String model);
}
