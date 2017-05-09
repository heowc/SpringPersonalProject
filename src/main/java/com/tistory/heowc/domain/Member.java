package com.tistory.heowc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tistory.heowc.util.AES256Util;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

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
        AES256Util aes256 = new AES256Util(AES256Util.SECRET_KEY);
        email = aes256.toEncrypt(email);
        password = aes256.toEncrypt(password);
    }

    public void toDecrypt() throws UnsupportedEncodingException {
        AES256Util aes256 = new AES256Util(AES256Util.SECRET_KEY);
        email = aes256.toDecrypt(email);
        password = aes256.toDecrypt(password);
    }
}
