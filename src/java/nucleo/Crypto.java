/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Sandro
 */
public class Crypto {
    
    public static String convertToMD5(String texto) throws NoSuchAlgorithmException{
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        
        BigInteger hash = new BigInteger(1,md.digest(texto.getBytes()));
        
        return String.format("%32x", hash);
    
    }
    
    public boolean senhaOK(String pass1, String pass2MD5)
    {
        
        boolean variguais = false;
        
        try{
            
            String pass1MD5 = convertToMD5(pass1);
            //String pass2MD5 = convertToMD5(pass2);
            
            if (pass1MD5.equals(pass2MD5))
            {
                variguais = true;
            }
            else
            {
                variguais = false;
            }
             
        }
        catch (NoSuchAlgorithmException ex) {
            
            ex.printStackTrace();
            
        }
        
        
        return variguais;
    
    }
    
}
