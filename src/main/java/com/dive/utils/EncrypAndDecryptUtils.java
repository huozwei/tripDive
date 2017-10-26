package com.dive.utils;

import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @desc
 * @author HZW
 * @date   2017年7月3日 下午2:45:25
 */
public class EncrypAndDecryptUtils {
	  
	   public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
	    
	    private static byte[] IV = { 0x12, 0x34, 0x56, 0x78, (byte) 0x90,
			(byte) 0xAB, (byte) 0xCD, (byte) 0xEF };
	    /**
	     * DES算法，加密
	     *
	     * @param data 待加密字符串
	     * @param key  加密私钥，长度不能够小于8位
	     * @return 加密后的字节数组，一般结合Base64编码使用
	     * @throws CryptException 异常
	     */
	    public static String encode(String key,String data) throws Exception
	    {
	        try
	        {
	      DESKeySpec dks = new DESKeySpec(key.getBytes());

	      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	            //key的长度不能够小于8位字节
	            Key secretKey = keyFactory.generateSecret(dks);
	            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
	            IvParameterSpec iv = new IvParameterSpec(IV);
	            AlgorithmParameterSpec paramSpec = iv;
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey,paramSpec);

	            return new String(new Base64().encode(cipher.doFinal(data.getBytes("UTF-8"))));
	        } catch (Exception e)
	        {
	            throw new Exception(e);
	        }
	    }
	    /**
	     * DES算法，解密
	     *
	     * @param data 待解密字符串
	     * @param key  解密私钥，长度不能够小于8位
	     * @return 解密后的字节数组
	     * @throws Exception 异常
	     */
	    public static String decode(String key,String data) throws Exception
	    {
	        try
	        {
	         SecureRandom sr = new SecureRandom();
	      DESKeySpec dks = new DESKeySpec(key.getBytes());
	      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	            //key的长度不能够小于8位字节
	            Key secretKey = keyFactory.generateSecret(dks);
	            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
	            IvParameterSpec iv = new IvParameterSpec(IV);
	            AlgorithmParameterSpec paramSpec = iv;
	            cipher.init(Cipher.DECRYPT_MODE, secretKey,paramSpec);
	            return new String(cipher.doFinal(new Base64().decode(data.getBytes("UTF-8"))));
	        } catch (Exception e)
	        {
	            throw new Exception(e);
	        }
	    }
	      //测试
	     public static void main(String[] args) throws Exception {
			  System.out.println(encode("123456789","admin"));
			  System.out.println(decode("123456789", "gTxAAmqkV7E="));
		}
}


