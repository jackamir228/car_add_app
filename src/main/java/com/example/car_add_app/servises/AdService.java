package com.example.car_add_app.servises;

import com.example.car_add_app.entity.Ad;
import com.example.car_add_app.dto.AdDto;
import com.example.car_add_app.enums.Color;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AdService extends ProtoService<Ad, AdDto> {
    @Override
    void create(AdDto adDto);

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();

    @Override
    Optional<Ad> findByIndex(Integer index);

    @Override
    Optional<Ad> findById(Long id);

    @Override
    List<Ad> findAll();

    List<Ad> findByDate(LocalDate date);

    List<Ad> findByName(String name);

    List<Ad> findByColor(Color color);

    List<Ad> findByPrice(BigDecimal price);

    List<Ad> findByModel(String model);
}
