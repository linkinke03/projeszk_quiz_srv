/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionHandler;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Linkinke
 */
public class ClientConnectionTest {
    
    public ClientConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class ClientConnection.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ClientConnection instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewQuestion method, of class ClientConnection.
     */
    @Test
    public void testGetNewQuestion() {
        System.out.println("getNewQuestion");
        ClientConnection instance = null;
        QuizQuestion expResult = null;
        QuizQuestion result = instance.getNewQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCorrect method, of class ClientConnection.
     */
    @Test
    public void testIsCorrect() {
        System.out.println("isCorrect");
        String answer = "";
        ClientConnection instance = null;
        Boolean expResult = null;
        Boolean result = instance.isCorrect(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCorrectAnswer method, of class ClientConnection.
     */
    @Test
    public void testGetCorrectAnswer() {
        System.out.println("getCorrectAnswer");
        ClientConnection instance = null;
        String expResult = "";
        String result = instance.getCorrectAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
