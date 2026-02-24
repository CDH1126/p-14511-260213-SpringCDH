package com.back.domain.member.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Member extends BaseEntity {

    @Column(unique = true)
    private String username;
    @Column(length = 100)
    private String password;
    @Column(length = 30)
    private String nickname;


}
