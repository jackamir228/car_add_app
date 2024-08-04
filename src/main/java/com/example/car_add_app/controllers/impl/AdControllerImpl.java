package com.example.car_add_app.controllers.impl;

import com.example.car_add_app.controllers.AdController;
import com.example.car_add_app.entity.Ad;
import com.example.car_add_app.enums.Color;
import com.example.car_add_app.servises.impl.AdServiceImpl;
import com.example.car_add_app.dto.AdDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("carAdd")
@AllArgsConstructor
public class AdControllerImpl implements AdController {
    private final AdServiceImpl adService;

    @PostMapping("create")
    @Override
    public ResponseEntity create(@RequestBody AdDto body) {
        adService.create(body);
        return ResponseEntity.status(201).body(body);
    }

    @GetMapping("getAll")
    @Override
    public List<Ad> get() {
        return adService.findAll();
    }

    @GetMapping("/index/{index}")
    @Override
    public Optional<Ad> getByIndex(@PathVariable Integer index) {
        return adService.findByIndex(index);
    }

    @GetMapping("/id/{id}")
    @Override
    public Optional<Ad> getById(@PathVariable Long id) {
        return adService.findById(id);
    }

    @GetMapping("getByDate")
    @Override
    public List<Ad> findByDate(LocalDate date) {
        return adService.findByDate(date);
    }

    @GetMapping("getByParam")
    @Override
    public Set<Ad> findByParam(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Color color,
            @RequestParam(required = false) BigDecimal price,
            @RequestParam(required = false) String model
    ) {

        Set<Ad> ads = new HashSet<>();
        if (name != null) {
            ads.addAll(adService.findByName(name));
        }

        if (color != null) {
            ads.addAll(adService.findByColor(color));
        }

        if (price != null) {
            ads.addAll(adService.findByPrice(price));
        }

        if (model != null) {
            ads.addAll(adService.findByModel(model));
        }
        return Optional.of(ads).orElseThrow(() -> new RuntimeException("объявления по этим параметрам не найдены"));
    }

    @DeleteMapping("deleteAll")
    @Override
    public void deleteAll() {
        adService.deleteAll();
    }

    @DeleteMapping("/deleteById/{id}")
    @Override
    public void deleteById(@PathVariable Long id) {
        if (id == null) {
            adService.deleteAll();
        }
        adService.deleteById(id);
    }
}
