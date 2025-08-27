package com.arka.arkadcastano.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.arka.arkadcastano.domain.model.Supplier;
import com.arka.arkadcastano.domain.port.out.SupplierRepositoryPort;
import com.arka.arkadcastano.infrastructure.adapter.out.persistence.entity.SupplierEntity;
import com.arka.arkadcastano.infrastructure.adapter.out.persistence.mapper.SupplierMapper;
import com.arka.arkadcastano.infrastructure.adapter.out.persistence.repository.SupplierJpaRepository;

@Component
public class SupplierPersistenceAdapter implements SupplierRepositoryPort {
    private final SupplierJpaRepository repository;
    private final SupplierMapper mapper;

    public SupplierPersistenceAdapter(SupplierJpaRepository repository, SupplierMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Supplier> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Supplier save(Supplier supplier) {
        SupplierEntity entity = mapper.toEntity(supplier);
        SupplierEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
