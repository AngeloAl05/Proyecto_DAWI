package com.LootZone.domain.repository;

import com.LootZone.domain.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, String> {
}
