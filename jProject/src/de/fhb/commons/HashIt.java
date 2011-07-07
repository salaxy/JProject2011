/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.commons;

/**
 *
 * @author MacYser
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class HashIt {

    private String calculateHash(MessageDigest algorithm, String pw) throws UnsupportedEncodingException{

        // get the hash value as byte array
        byte[] hash = algorithm.digest(pw.getBytes("UTF-8"));

        return byteArray2Hex(hash);
    }

    private String byteArray2Hex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public String calcSHA1(String pw) 
			throws UnsupportedEncodingException, NoSuchAlgorithmException{

        MessageDigest sha1 = MessageDigest.getInstance("SHA1");      

        return calculateHash(sha1, pw);
    }
	public String calcMD5(String pw) 
			throws UnsupportedEncodingException, NoSuchAlgorithmException{

        MessageDigest md5  = MessageDigest.getInstance("MD5");        

        return calculateHash(md5, pw);
    }
}
