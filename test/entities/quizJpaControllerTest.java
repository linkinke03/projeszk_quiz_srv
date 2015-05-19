/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.EntityManager;
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
public class quizJpaControllerTest {
    
    public quizJpaControllerTest() {
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
     * Test of getEntityManager method, of class quizJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        quizJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class quizJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        quiz quiz = null;
        quizJpaController instance = null;
        instance.create(quiz);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class quizJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        quiz quiz = null;
        quizJpaController instance = null;
        instance.edit(quiz);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class quizJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = null;
        quizJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findquizEntities method, of class quizJpaController.
     */
    @Test
    public void testFindquizEntities_0args() {
        System.out.println("findquizEntities");
        quizJpaController instance = null;
        List<quiz> expResult = null;
        List<quiz> result = instance.findquizEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findquizEntities method, of class quizJpaController.
     */
    @Test
    public void testFindquizEntities_int_int() {
        System.out.println("findquizEntities");
        int maxResults = 0;
        int firstResult = 0;
        quizJpaController instance = null;
        List<quiz> expResult = null;
        List<quiz> result = instance.findquizEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findquiz method, of class quizJpaController.
     */
    @Test
    public void testFindquiz() {
        System.out.println("findquiz");
        Long id = null;
        quizJpaController instance = null;
        quiz expResult = null;
        quiz result = instance.findquiz(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getquizCount method, of class quizJpaController.
     */
    @Test
    public void testGetquizCount() {
        System.out.println("getquizCount");
        quizJpaController instance = null;
        int expResult = 0;
        int result = instance.getquizCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomQuiz method, of class quizJpaController.
     */
    @Test
    public void testGetRandomQuiz() {
        System.out.println("getRandomQuiz");
        quizJpaController instance = null;
        quiz expResult = null;
        quiz result = instance.getRandomQuiz();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
