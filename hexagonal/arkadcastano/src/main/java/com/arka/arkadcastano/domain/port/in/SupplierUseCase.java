package com.arka.arkadcastano.domain.port.in;

import java.util.List;

import com.arka.arkadcastano.domain.model.Supplier;

public interface SupplierUseCase {

    Supplier createSupplier(Supplier supplier);
    Supplier getSupplierById(Long id);
    List<Supplier> getAllSuppliers();
    Supplier updateSupplier(Long id, Supplier supplier);
    void deleteSupplier(Long id);
}
