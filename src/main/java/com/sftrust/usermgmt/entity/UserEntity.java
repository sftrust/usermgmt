package com.sftrust.usermgmt.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    //    @Column(columnDefinition = "boolean default false") // define default value
    private Boolean isDonor;
    private Boolean isBeneficiary;
    private Boolean isVolunteer;
    private int vaultId;
    private String photoPath;

    @PrePersist
    public void prePersist() {
        if (isBeneficiary == null) {
            isBeneficiary = false;
        }
        if (isDonor == null) {
            isBeneficiary = false;
        }
        if (isVolunteer == null) {
            isBeneficiary = false;
        }
    }
}
