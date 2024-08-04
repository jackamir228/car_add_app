package com.example.car_add_app.controllers;

import java.util.List;
import java.util.Optional;

public interface ProtoController<T, E, I> {

    public I create(E body);

    List<T> get();

    Optional<T> getByIndex(Integer index);

    Optional<T> getById(Long id);

    void deleteAll();

    void deleteById(Long id);

}
