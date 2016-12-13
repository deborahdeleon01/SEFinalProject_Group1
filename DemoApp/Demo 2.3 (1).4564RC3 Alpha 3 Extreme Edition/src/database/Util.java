/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Eli
 */
public class Util 
{
    /**
    *
    * @author Michelle
    */
    
    /**
     * 
     * @param pass
     * @param dbKey
     * @return
     * @throws Exception 
     */
    public String []  encrypt(String pass, String dbKey) throws Exception
    {   
        String passSalt[] = new String[2]; 
        String key=null;
        SecretKey sk;
        
        if(dbKey == null)
        {
           sk = generateKey();
          key = Base64.getEncoder().encodeToString(sk.getEncoded());
          System.out.println("this is key-->>>>"+key);
        }
        else
        {
            byte[] decodedKey = Base64.getDecoder().decode(dbKey);
            sk = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
            key=dbKey;
        }
        
            Cipher cipher = Cipher.getInstance("AES");
 
            // Encryption
            byte[] plainTextByte = pass.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, sk);
            byte[] encryptedByte = cipher.doFinal(plainTextByte);
            Base64.Encoder encoder = Base64.getEncoder();
            String passEncrypt = encoder.encodeToString(encryptedByte);
            System.out.println("this is encrypted passandsalt---->"+passEncrypt);
            // String array with encrypted password and salt
            passSalt[0]=passEncrypt;
            passSalt[1]=key;

        return passSalt;
    }
    
    /**
     * 
     * @return generateKey
     * @throws NoSuchAlgorithmException 
     */
    private static SecretKey generateKey() throws NoSuchAlgorithmException
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // 128 default; 192 and 256 also possible
        return keyGenerator.generateKey();
    }
    
    /*String genSalt()
    {
        SecureRandom random = new SecureRandom();
        String salt=null;
        byte[] saltByte = new byte[8];
        random.nextBytes(saltByte);
      
        try 
        {
           salt= new String(saltByte,"UTF-8");
           
           
        } 
        catch (UnsupportedEncodingException ex) 
        {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return salt;
    }*/
}