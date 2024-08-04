package com.example.car_add_app.servises;

import java.util.List;
import java.util.Optional;

public interface ProtoService<T, E> {
    void create(E adDto);

    void deleteById(Long id);

    void deleteAll();

    Optional<T> findByIndex(Integer index);

    Optional<T> findById(Long id);

    List<T> findAll();
}
