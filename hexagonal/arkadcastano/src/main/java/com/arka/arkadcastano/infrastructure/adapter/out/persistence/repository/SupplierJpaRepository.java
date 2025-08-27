package com.arka.arkadcastano.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arka.arkadcastano.infrastructure.adapter.out.persistence.entity.SupplierEntity;

public interface SupplierJpaRepository extends JpaRepository<SupplierEntity, Long> {

}
