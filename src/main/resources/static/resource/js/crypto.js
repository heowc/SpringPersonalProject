'use strict';

const secretKey = CryptoJS.enc.Hex.parse('heowc1992@gmail.com');

const toEncrypt = (value) => {
    return CryptoJS.AES.encrypt(value, secretKey, {iv : secretKey}).toString();
};

const toDecrypt = (value) => {
    return CryptoJS.AES.decrypt(value, secretKey, {iv : secretKey}).toString();
};