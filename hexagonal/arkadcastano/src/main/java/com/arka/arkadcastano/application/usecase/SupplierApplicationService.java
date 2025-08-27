package com.arka.arkadcastano.application.usecase;

import java.util.List;

import com.arka.arkadcastano.domain.model.Supplier;
import com.arka.arkadcastano.domain.port.in.SupplierUseCase;
import com.arka.arkadcastano.domain.port.out.SupplierRepositoryPort;

public class SupplierApplicationService  implements SupplierUseCase {
    private final SupplierRepositoryPort supplierRepository;

    public SupplierApplicationService(SupplierRepositoryPort supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new RuntimeException("Supplier not found with id: " + id);
        }
        supplierRepository.deleteById(id);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
    }
    
    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        if (!supplierRepository.existsById(id)) {
            return null;
        }
        supplier.setId(id);
        return supplierRepository.save(supplier);
    }

}
