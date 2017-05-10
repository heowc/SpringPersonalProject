package com.tistory.heowc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.codec.Base64;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

@Data
@Entity
@Table(name = "MEMBER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Member implements Serializable {

    @Id @NotEmpty @Length(min = 5)
    private String email;

    @NotEmpty @Length(min = 8)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String type;

    private String nickName;

    private String profile;

    public Member() {}

    public Member(String email) {
        this.email = email;
    }

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void toEncrypt() throws UnsupportedEncodingException {
        email = new String(Base64.encode(email.getBytes()));
        password = new String(Base64.encode(password.getBytes()));
    }

    public void toDecrypt() throws UnsupportedEncodingException {
        email = new String(Base64.decode(email.getBytes()));
        password = new String(Base64.decode(password.getBytes()));
    }
}
