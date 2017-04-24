package com.tistory.heowc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "MEMBER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Member implements Serializable {

    @Id
    private String email;

    private String password;

    private String type;

    private String nickName;

    private String profile;

    public Member() {}

    public Member(String email) {
        this.email = email;
    }
}
