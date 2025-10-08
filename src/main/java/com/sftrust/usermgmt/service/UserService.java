package com.sftrust.usermgmt.service;

import com.sftrust.usermgmt.dto.UserDto;
import com.sftrust.usermgmt.dto.UserResponseDto;
import com.sftrust.usermgmt.entity.UserEntity;
import com.sftrust.usermgmt.entity.VaultEntity;
import com.sftrust.usermgmt.repo.UserRepo;
import com.sftrust.usermgmt.repo.VaultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private VaultRepo vaultRepo;
    @Autowired
    private UserRepo userRepo;
    @Transactional
    public UserResponseDto createUser(UserDto userDto) {
        Optional<UserEntity> userEntity = userRepo.findByEmailAndPhone(userDto.getEmail(),
                userDto.getPhone());
        if (userEntity.isPresent()) {

            return new UserResponseDto(userEntity.get(), 200);
        }
        UserEntity user = new UserEntity();

        Optional<VaultEntity> vault = vaultRepo.findByAadharHash(userDto.getAadharNumber());
        if (vault.isPresent()) {
            user.setVaultId(vault.get().getId());
        } else {
            VaultEntity vaultEntity = new VaultEntity();
            vaultEntity.setAadharHash(userDto.getAadharNumber());
            vaultEntity.setPanHash(userDto.getPanNumber());
            vaultEntity = vaultRepo.save(vaultEntity);
            user.setVaultId(vaultEntity.getId());
        }
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());
        user.setIsBeneficiary(userDto.getIsBeneficiary());
        user.setIsDonor(userDto.getIsDonor());
        user.setIsVolunteer(userDto.getIsVolunteer());
        user.setPhotoPath(userDto.getPhotoPath());
        return new UserResponseDto(userRepo.save(user), 201);
    }

}
