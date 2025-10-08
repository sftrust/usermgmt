package com.sftrust.usermgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vault")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VaultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vault_id")
    private int id;
    private String aadharHash;
    private String panHash;
}
