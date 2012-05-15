/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.yahoomailjava;

/**
 *
 * @author intesar
 */
public class Main {
    public static void main(String[] args) {
        YahooMailService emailService = YahooMailService.getInstance();
        
        emailService.sendEmail("mdshannan@gmail.com", "test subject from YahooMailService ", "test body");
        
        emailService.shutdown();
    }
}
