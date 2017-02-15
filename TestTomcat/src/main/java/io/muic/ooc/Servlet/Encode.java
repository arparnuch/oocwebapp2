package io.muic.ooc.Servlet;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

/**
 * Created by arparnuch on 2/14/2017 AD.
 */
public class Encode {
    private String salt = "meandmycat";
    public Encode(){
        super();
    }

    public String hash(String password){

        String newPass = salt+password+salt;
        String returnPass = DigestUtils.sha256Hex(newPass);
        returnPass = DigestUtils.sha256Hex(salt+newPass+salt);

        return returnPass;
    }
}
