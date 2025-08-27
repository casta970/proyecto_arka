package com.arka.arkadcastano.infrastructure.adapter.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.arka.arkadcastano.domain.model.Supplier;
import com.arka.arkadcastano.infrastructure.adapter.out.persistence.entity.SupplierEntity;

@Component
public class SupplierMapper {

    public Supplier toDomain(SupplierEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Supplier supplier = new Supplier();
        supplier.setId(entity.getProveedorId());
        supplier.setNombre(entity.getNombre());
        supplier.setEmail(entity.getEmail());
        
        return supplier;
    }

    public SupplierEntity toEntity(Supplier supplier) {
        if (supplier == null) {
            return null;
        }

        SupplierEntity entity = new SupplierEntity();
        entity.setProveedorId(supplier.getId());
        entity.setNombre(supplier.getNombre());
        entity.setEmail(supplier.getEmail());

        return entity;
    }

}
