package com.cg.service;

import com.cg.model.Province;

import java.util.Optional;

public interface IProvinceService{
    Iterable<Province> findAll();

    void save(Province province);

    Optional<Province> findById(long id);

    void remove(Long id);
}
