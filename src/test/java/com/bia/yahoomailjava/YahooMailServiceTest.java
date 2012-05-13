/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.yahoomailjava;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author intesar
 */
public class YahooMailServiceTest {
    
    public YahooMailServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    YahooMailService instance = YahooMailService.getInstance();
    
    /**
     * Test of sendEmail method, of class YahooMailService.
     */
    @Test
    public void testSendEmail_3args_1() {
        System.out.println("sendEmail");
        
        String toAddress = "mdshannan@gmail.com";
        String subject = "testing yahoo send";
        String body = "testing body";
        
        check(toAddress, subject, body, true); // all valid
        check(toAddress, subject, "", true); // optional body missing
        check(toAddress, subject, null, true); // optional body missing
        check(toAddress, subject, " ", true); // optional body missing
        
        check(toAddress, "", body, false); // subject missing
        check(toAddress, null, body, false); // subject missing
        check(toAddress, "  ", body, false); // subject missing
        
        String toAddress0 = null;
        check(toAddress0, subject, body, false); // subject missing
        String toAddress1 = "mdshannan@gmail";
        check(toAddress1, subject, body, false); // subject missing
        String toAddress2 = "mdshannan";
        check(toAddress2, subject, body, false); // subject missing
        String toAddress3 = "";
        check(toAddress3, subject, body, false); // subject missing
    }

    /**
     * Test of sendEmail method, of class YahooMailService.
     */
    @Test
    public void testSendEmail_3args_2() {
        System.out.println("sendEmail");
        String[] toAddress = {"mdshannan@gmail.com"};
        String subject = "testing yahoo send";
        String body = "testing body";
        
        check(toAddress, subject, body, true); // all valid
        check(toAddress, subject, "", true); // optional body missing
        check(toAddress, subject, null, true); // optional body missing
        check(toAddress, subject, " ", true); // optional body missing
        
        check(toAddress, "", body, false); // subject missing
        check(toAddress, null, body, false); // subject missing
        check(toAddress, "  ", body, false); // subject missing
        
        String[] toAddress0 = null;
        check(toAddress0, subject, body, false); // subject missing
        String[] toAddress1 = {"mdshannan@gmail"};
        check(toAddress1, subject, body, false); // subject missing
        String[] toAddress2 = {"mdshannan"};
        check(toAddress2, subject, body, false); // subject missing
        String[] toAddress3 = {""};
        check(toAddress3, subject, body, false); // subject missing
    }
    
    private void check(String to, String subject, String body, boolean expResult) {
        boolean result = instance.sendEmail(to, subject, body);
        assertEquals(expResult, result);
    }
    
    private void check(String[] to, String subject, String body, boolean expResult) {
        boolean result = instance.sendEmail(to, subject, body);
        assertEquals(expResult, result);
    }
}
