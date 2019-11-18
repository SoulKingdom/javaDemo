package com.example.junittest.encryption;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/11/18 15:58
 **/
@Slf4j
public class HutoolEncryption {
    /**
     * AES加密解密
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/18 16:01
     **/
    private static void ascEncryption() {
        String content = "test中文";
        log.info("加密之前的文本--------->" + content);
        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        log.info("随机生成的密匙----->" + key);
        //构建
        AES aes = SecureUtil.aes(key);
        //加密
        byte[] encrypt = aes.encrypt(content);
        log.info("加密之后的文本--------->" + encrypt);
        //解密
        byte[] decrypt = aes.decrypt(encrypt);
        log.info("解密密之后的文本--------->" + new String(decrypt));
        //加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        log.info("16进制加密之后的文本--------->" + encryptHex);
        //解密为原字符串
        String decryptStr = aes.decryptStr(encryptHex);
        log.info("16进制解密之后的文本--------->" + decryptStr);
    }

    /**
     * DES加密解密
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/18 16:01
     **/
    private static void desEncryption() {
        String content = "test中文";
        log.info("des加密之前的文本--------->" + content);
        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();
        log.info("des随机生成的密匙----->" + key);
        //构建
        DES des = SecureUtil.des(key);
        //加密
        byte[] encrypt = des.encrypt(content);
        log.info("des加密之后的文本--------->" + encrypt);
        //解密
        byte[] decrypt = des.decrypt(encrypt);
        log.info("des解密密之后的文本--------->" + new String(decrypt));
        //加密为16进制表示
        String encryptHex = des.encryptHex(content);
        log.info("des16进制加密之后的文本--------->" + encryptHex);
        //解密为原字符串
        String decryptStr = des.decryptStr(encryptHex);
        log.info("des16进制解密之后的文本--------->" + decryptStr);
    }

    public static void main(String[] args) {
        //ASC加密
        ascEncryption();
        //DES加密
        desEncryption();
    }
}