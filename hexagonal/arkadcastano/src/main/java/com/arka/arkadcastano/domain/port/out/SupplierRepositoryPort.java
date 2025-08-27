package com.arka.arkadcastano.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.arka.arkadcastano.domain.model.Supplier;

public interface SupplierRepositoryPort {
    List<Supplier> findAll();
    Optional<Supplier> findById(Long id);
    Supplier save(Supplier supplier);
    void deleteById(Long id);
    boolean existsById(Long id);
}