package com.sftrust.usermgmt.repo;

import com.sftrust.usermgmt.entity.VaultEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VaultRepo extends CrudRepository<VaultEntity, Long> {
    Optional<VaultEntity> findByAadharHash(String aadharHash);
}
