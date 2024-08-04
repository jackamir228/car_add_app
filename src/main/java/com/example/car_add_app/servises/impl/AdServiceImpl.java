package com.example.car_add_app.servises.impl;

import com.example.car_add_app.entity.Ad;
import com.example.car_add_app.enums.Color;
import com.example.car_add_app.repositories.impl.AdRepositoryImpl;
import com.example.car_add_app.servises.AdService;
import com.example.car_add_app.dto.AdDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdServiceImpl implements AdService {
    private final AdRepositoryImpl adRepository;

    @Override
    public void create(AdDto body) {

        Long id = body.id() == null ? Long.valueOf(228) : body.id();
        Color color = body.color() == null ? Color.BLACK : body.color();
        String name = body.name() == null ? "Нет имени" : body.name();
        BigDecimal price = body.price() == null ? BigDecimal.ZERO : body.price();
        String model = body.model() == null ? "Нет модели" : body.model();
        LocalDate date = body.date() == null ? LocalDate.now() : body.date();

        Ad ad = Ad.builder()
                .id(id)
                .name(name)
                .color(color)
                .price(price)
                .model(model)
                .date(date)
                .build();
        adRepository.add(ad);
    }

    @Override
    public void deleteById(Long id) {
        adRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        adRepository.deleteAll();
    }

    @Override
    public Optional<Ad> findByIndex(Integer index) {
        return adRepository.findByIndex(index);
    }

    @Override
    public Optional<Ad> findById(Long id) {
        return adRepository.findById(id);
    }

    @Override
    public List<Ad> findAll() {
        return adRepository.findAll();
    }

    @Override
    public List<Ad> findByDate(LocalDate date) {
        return adRepository.findByDate(date);
    }

    @Override
    public List<Ad> findByName(String name) {
        return adRepository.findByName(name);
    }

    @Override
    public List<Ad> findByColor(Color color) {
        return adRepository.findByColor(color);
    }

    @Override
    public List<Ad> findByPrice(BigDecimal price) {
        return adRepository.findByPrice(price);
    }

    @Override
    public List<Ad> findByModel(String model) {
        return adRepository.findByModel(model);
    }
}
