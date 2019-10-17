package bupt.fnl.dht.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;

public class Utils {

    public static boolean Decipher(){
      return true;
    }

    public static void encryption(){
        try {
            //初始化密钥
            KeyPairGenerator keyPairGenerator= KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);//密钥的长度
            KeyPair keyPair=keyPairGenerator.generateKeyPair();//生成密钥对
            //RSAPublicKey
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
