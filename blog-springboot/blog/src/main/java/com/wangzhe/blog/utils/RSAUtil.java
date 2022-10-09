package com.wangzhe.blog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA加解密
 */
public class RSAUtil {

    private static final Logger log = LoggerFactory.getLogger(RSAUtil.class);

    private static Base64.Encoder encoder = Base64.getEncoder();
    private static Base64.Decoder decoder = Base64.getDecoder();

    private static final String DEF_CHARSET = "UTF-8";

    private static final String algorithm = "RSA";
    private static final String pubKeyName = "publicKey";
    private static final String priKeyName = "privateKey";

    public static final String signWithSha1 = "Sha1WithRSA";
    public static final String signWithMd5 = "MD5WithRSA";
    public static final String signWithSha256 = "SHA256withRSA";

    /**
     * 生成密钥对
     * @param keySize
     * @return
     */
    public static Map<String, String> genKeyPair(int keySize){
        Map<String, String> rst = new HashMap();
        try{
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
            keyGen.initialize(keySize);
            KeyPair keyPair = keyGen.generateKeyPair();
            rst.put(pubKeyName, key2Str(keyPair.getPublic()));
            rst.put(priKeyName, key2Str(keyPair.getPrivate()));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return rst;
    }

    public static String encrypt(String text, String pubKeyStr){
        try {
            PublicKey publicKey = getPublicKey(pubKeyStr);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            int keySize = keySizeByPubKey(publicKey);
            int maxEncryptBlock = keySize / 8 - 11;
            return encoder.encodeToString(doFinal(text.getBytes(DEF_CHARSET), cipher, maxEncryptBlock));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String text, String priKeyStr){
        try{
            PrivateKey privateKey = getPrivateKey(priKeyStr);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            int keySize = keySizeByPriKey(privateKey);
            int maxDecryptBlock = keySize / 8;
            return new String(doFinal(decoder.decode(text), cipher, maxDecryptBlock), DEF_CHARSET);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String sign(String data, String privateKey, String signatureAlgorithm){
        try{
            PrivateKey privateK = getPrivateKey(privateKey);
            Signature signature = Signature.getInstance(signatureAlgorithm);
            signature.initSign(privateK);
            signature.update(data.getBytes());
            return encoder.encodeToString(signature.sign());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String signWithSha256(String data, String privateKey){
        return sign(data, privateKey, signWithSha256);
    }

    public static boolean verify(String data, String sign, String publicKey, String signatureAlgorithm){
        try {
            PublicKey pubKey = getPublicKey(publicKey);
            Signature signature = Signature.getInstance(signatureAlgorithm);
            signature.initVerify(pubKey);
            signature.update(data.getBytes(DEF_CHARSET));
            return signature.verify(decoder.decode(sign));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyWithSha256(String data, String sign, String publicKey){
        return verify(data, sign, publicKey, signWithSha256);
    }

    private static String key2Str(Key key){
        return encoder.encodeToString(key.getEncoded());
    }

    private static PublicKey getPublicKey(String keyStr){
        try {
            byte[] encodedBytes = decoder.decode(keyStr);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedBytes);
            KeyFactory factory = KeyFactory.getInstance(algorithm);
            return factory.generatePublic(spec);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private static PrivateKey getPrivateKey(String keyStr){
        try{
            byte[] encodedBytes = decoder.decode(keyStr);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(encodedBytes);
            KeyFactory factory = KeyFactory.getInstance(algorithm);
            return factory.generatePrivate(spec);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private static int keySizeByPubKey(PublicKey publicKey){
        try {
            int bitLength = KeyFactory.getInstance(algorithm).getKeySpec(publicKey, RSAPublicKeySpec.class).getModulus().bitLength();
            return keySizeByBitLen(bitLength);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int keySizeByPriKey(PrivateKey privateKey){
        try {
            int bitLength = KeyFactory.getInstance(algorithm).getKeySpec(privateKey, RSAPrivateKeySpec.class).getModulus().bitLength();
            return keySizeByBitLen(bitLength);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int keySizeByBitLen(int bitLength){
        int keySize;
        if(bitLength <= 512){
            throw new IllegalArgumentException("不支持判断的密钥位数！");
        }else if(bitLength <= 1024){
            keySize = 1024;
        }else if(bitLength <= 2048){
            keySize = 2048;
        }else if(bitLength <= 4096){
            keySize = 4096;
        }else{
            throw new IllegalArgumentException("不支持判断的密钥位数！");
        }
        return keySize;
    }

    private static byte[] doFinal(byte[] bytes, Cipher cipher, int maxDoFinalBlock){
        int offset = 0, totalLen = bytes.length;
        ByteArrayOutputStream bos = null;
        byte[] tmpBytes = null;
        try {
            bos = new ByteArrayOutputStream();
            int doFinalLen = 0;
            while (offset < totalLen) {
                doFinalLen = (totalLen - offset > maxDoFinalBlock) ? maxDoFinalBlock : (totalLen - offset);
                tmpBytes = cipher.doFinal(bytes, offset, doFinalLen);
                bos.write(tmpBytes, 0, tmpBytes.length);
                offset += doFinalLen;
            }
            return bos.toByteArray();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try{
                if(bos!=null){
                    bos.close();
                }
            }catch (Exception e){}
        }
    }

   /* public static void main(String[] args){
        Map<String, String> keyMap = genKeyPair(2048);
        log.info("公钥："+keyMap.get(pubKeyName));
        log.info("私钥："+keyMap.get(priKeyName));
        String str = "我是java工程师！";
        log.info("原文："+str);
        String pass = encrypt(str, keyMap.get(pubKeyName));
        log.info("加密："+pass);
        log.info("解密："+decrypt(pass, keyMap.get(priKeyName)));
        String sign = signWithSha256(str, keyMap.get(priKeyName));
        log.info("签名："+sign);
        log.info("验签："+verifyWithSha256(str, sign, keyMap.get(pubKeyName))+"");
    }*/


    public static void main(String[] args){
//        String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlzLU+rdsEf0K3rX9Od8W/12QIWU1AbhG+FO9Lhg67M9eDTP3QwE1kSJlZ58+7wKV9N93tN41PCA6IVPWBT3VbISdQPEOdrgTUIcbYXq/3m4D8kgvQyF96hdyuR2NGB9Jnw/grPPEg8MYphxBmWCBV9HAzhqSX0ie9MWZS5foXfzODzjcSYcaVNtpRlFcyPBpvvxbVcdIWBb58h17SOYv+ahpRGV4ZzEhWMlifby4OdWUYfl0U84XU15rWBkeu9RMu8aRlLFg8Ujpi1Pl8DgbjbgfECJbDytl8ZhJt5VvDpMD5lWnE8LkVBvrUqVxo2Z7TVNX20u/JQItGY7SQa5pRwIDAQAB";
//        String priKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCXMtT6t2wR/Qretf053xb/XZAhZTUBuEb4U70uGDrsz14NM/dDATWRImVnnz7vApX033e03jU8IDohU9YFPdVshJ1A8Q52uBNQhxther/ebgPySC9DIX3qF3K5HY0YH0mfD+Cs88SDwximHEGZYIFX0cDOGpJfSJ70xZlLl+hd/M4PONxJhxpU22lGUVzI8Gm+/FtVx0hYFvnyHXtI5i/5qGlEZXhnMSFYyWJ9vLg51ZRh+XRTzhdTXmtYGR671Ey7xpGUsWDxSOmLU+XwOBuNuB8QIlsPK2XxmEm3lW8OkwPmVacTwuRUG+tSpXGjZntNU1fbS78lAi0ZjtJBrmlHAgMBAAECggEBAJHn+MUU+hIF2VZ/0qTlFuFJXcwMSXGmbb43uOjhcwORPRaKnkKnyRSMV8T+VJH7MdCDUZZVlJO4GcCNkYuvVuSIuOOxe56vFdxw9MhF1yADlIVaiVlD2alsBUaEMOMlVjtL7Cmad3obbA7oV5l2Gnsvq9p4o+WVQ+e7Q6pCJneDAVLZqeSSXnuXC0j8/woYsBUa4MrfhQK7KfpPeqNRKkwzcEqLKawzFqaQxFd2sgc/9vv+G4tYFjGKQel0/9ultJdZhFuK/JciJT8UJ1Jgnx22S9Fti0tJHahL2EuWa8n9v2DBtNqC5fv56e/+KteOTDGODFSWiVJXjnP69M6ewvECgYEAye5f/R9Zsqrxly5rEzBCqU8FViUyX5dgUze32SC3S+ID8GC+CMOQiScJfiPH5/fvoi9KDI8Kp4Z/zBEwgQVCZykpH2mqZEK2AIbTBL/xeIl7AGyE+wanlCzCU4I5gkOQDBgg3qUJaDjxoYLgmWDxs/qFKRt92E12n7Ghf4beMRkCgYEAv67tgTuXHGwC1UEux+TWLFBtlUNMPPOilUSHbet/h8RQW/7ewfBtvuOwR5q9CCBfrEZtIqY1HXvvO5ty71Lps8/Z1FEWjfz3VijeMqRTJZNTVyP5vqtX3iZRnjW4ciDjo9SIXXhxy3tCGSohGcN0Ejz3U2JOk3jsIrW1nPH82V8CgYEAwhPFVfanszzw7ajDaLHdn/Q+4MjnXVCUV+cZYCo9gUU9G+8fNjUf2XIXgZDKNXzqaCqjNObWCqUOdweeYqK3a4b36yUXiz1Cx8bNUadZYcxg18t1E/8VWSibrL9gnn5pF/aowNRF8lGoit7LFx9BrwV8rkGp9hadiGalHXh2XSECgYBBC3we0XjatTBU61STkmy3BufYsciKGma+Xk3SmApjqNNYFGnEx/CFyT/FXJXuzwWIMTHRgzMc+TRaNsrOuYUCdnLFoGqV7hSEUUPtTWPFqXOra1LRR9V+VeR2WmZnnA+DRZislzWORhpM7cXjtzaJBdUrn31of60prh2dz2Ps4wKBgEXIBo+ntIZkRI6MsgLX/oAuyaDuavu/qJysoAbPNXPb2PBBhT/VvdUyW3dKNBNTSlTp2ar+DtGQ6khrZaZS+jrHVS1cPIHZtTZiMl9CZWc7ESKXpFyOHCbJ7uytq7PmPFM25aGRWgQgfPMteru+PJQG0WLsWAPVdzo+6FDVrZb7";

        String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqpp+26R3WwZj/OVp95P+RfTJDj8g2z5DCNwrQWQUwz5yk2En6cMlux0jRay3dsQ+E0xs/4nuO0GyUZ9Y5aCQJ8GMQNX0sCLA5GEduNPC3h/H+RvCjZUJnDrm7IvsFGTsbU5TRbOtm8EADhht51oC0FjFlCyL4uKYkvDGAiK/AnbhuOZiKxPB/qoKh+g8UovwuyondzohpOFJsOwLkxz3TzoiE6mJIRqy/NIVEZiPP/umAt6IKiEDMCvHtQouE0vqWz9IyPYN3HJiw1CXLnwxDt8WSlY6JPnmJlJ3vA3AZSG+AduqfahNRmcgFi+qF0OCwpM0S69Y3rgwgBSFw2EncQIDAQAB";
        String priKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCqmn7bpHdbBmP85Wn3k/5F9MkOPyDbPkMI3CtBZBTDPnKTYSfpwyW7HSNFrLd2xD4TTGz/ie47QbJRn1jloJAnwYxA1fSwIsDkYR2408LeH8f5G8KNlQmcOubsi+wUZOxtTlNFs62bwQAOGG3nWgLQWMWULIvi4piS8MYCIr8CduG45mIrE8H+qgqH6DxSi/C7Kid3OiGk4Umw7AuTHPdPOiITqYkhGrL80hURmI8/+6YC3ogqIQMwK8e1Ci4TS+pbP0jI9g3ccmLDUJcufDEO3xZKVjok+eYmUne8DcBlIb4B26p9qE1GZyAWL6oXQ4LCkzRLr1jeuDCAFIXDYSdxAgMBAAECggEAMIyKsUKaXKLy7VLz1uqcn5fLZ2x7kyiitvDAtnkel3k77cjmLNXF9PuTwA4on3m1GJTVJ9s+mkpVzniEOcR5gXbIzOKWIVGihttENAa/G6r7o15M/TF+bKEuef5PjnYx+eEiPWGmc/52X4yAKigpSNUaVNJgdI57UMWH86+jn7VvrQDPcVC/9nacHE1syEiI2HnYBClSbFOEfYaLca+6gKrgJwX1MZ017u30fAx5yAJ6cgaX1cDmkMhBk+rGZMCYZV5SnKDUU+MnofEq2V51BGKIk1IREmOK3QTrZhLK8L2H2dBR9QCckodjeoyQ1ulpjlxYN7nw/HA6U2c3+Hf2KQKBgQD/THLaHA2mF+eZiie0JxY54sq+OLA0cREvjLNOrfXPZE0Oo8BjZI73iACRoGa6J7H1MrYl8va4hwth1gG62/5LbB5Pk1vue9u877AV7g+z0WbBqvA/parALhOizcHit25JJ6VI8VGJ+/TlzKCBgDuCexif+DjkA6PKZoBCg2bYvwKBgQCrEnsaN5jM/A4mK0aSB4h6BdNWtqCtWfIwCORAXWGg3tryFUJW6S3SS5zk2HzIGlfgrzMlrTsWqzqqZEkSAtqvvGK5UCEfq2C1g8hNDlTYyNsC3o8gEwaZnzDMKODsGQk9Pc9TSCpEahmi8HktUa5qTl70IuVidP4RqMfbCtRbzwKBgQD1eWWJsKWzCZMoP/3zLA4j9JxrEQjkM7+Jj+ktAvmyw0eQhwVKzHrnKX8ahzefUOG82Vjo3lg6j6bzGJorOLKnhLsUWqVvhup/HZybSX8RsIv0Nc+x8zJefS9mQB9oRmWls5gqrdZwLbKJbxr5yfnueTvxPPQ+0f0gdTRoP/6Y8wKBgQCF62nDFFLh5U+OQcJ0/sCwBW90KnOOQSN+xvcoC/IpZUwwxsOwFcpxHhAsdez5GOZCVeTMUdg33sOGMAujtehMOkVunHPRvu9uKUPcTqPNMS+CB4gzq7E3AY/JwxaQvOimsIRkxdGQzR5Ul7vE5nSLc96Rb9/yO3PJjz8lEk07sQKBgDlv02SUMUGXKu9z6iDMlOKLIhsOWDPQzX6ecmfjut+zgf7fAYC45VW5NUdXn0Zf2J2FyzGwIcDeDZUEhjDGojZEfHR4JsAuC4BT+sN/iMMpA88OolortfWUapqAd6vvbDRmQu9uYQAuFeyBdnd45oImUeERTy+CpzRuuAzEc0ei";
        String str = "我是java工程师！";
        log.info("原文："+str);
        String pass = encrypt(str, pubKey);
        log.info("加密："+pass);
        log.info("解密："+decrypt(pass, priKey));
        String sign = signWithSha256(str, priKey);
        log.info("签名："+sign);
        log.info("验签："+verifyWithSha256(str, sign, pubKey)+"");
    }
}
