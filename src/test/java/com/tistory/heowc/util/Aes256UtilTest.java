package com.tistory.heowc.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Aes256UtilTest {

    @Test
    public void test_encrypt() throws Exception {
        String email = new AES256Util(AES256Util.SECRET_KEY).toEncrypt("heowc1992@gmail.com");
        System.out.println(email);
        assertThat(email).isNotEmpty();
    }

    @Test
    public void test_decrypt() throws Exception {
        assertThat(new AES256Util(AES256Util.SECRET_KEY)
                    .toDecrypt("8ynUUd6atJNY+eBG3SeHpWbg+FMqyJChztiKXxzkcik="))
                .isEqualTo("heowc1992@gmail.com");
    }
}
