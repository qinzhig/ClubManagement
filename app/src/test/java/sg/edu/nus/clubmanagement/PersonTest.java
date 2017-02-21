package sg.edu.nus.clubmanagement;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sg.edu.nus.clubmanagement.ClubFolder.Person;

/**
 * Created by swarna on 4/8/2016.
 */


public class PersonTest extends TestCase {
    // Test Fixtures
    private Person p1 = null;
    private Person p2 = null;

    @Before
    public void setUp() throws Exception {
        p1 = new Person ("Tan", "Lee", "Ling");
        p2 = new Person ("Bharadwaj", "Ashok", null);
    }

    @After
    public void tearDown() throws Exception {
        p1 = null;
        p2 = null;
    }

    @Test
    public void testPerson() {

        assertEquals("Tan", p1.getSurname());
        assertEquals("Lee", p1.getFirstName());
        assertEquals("Ling", p1.getSecondName());


        assertEquals("Bharadwaj", p2.getSurname());
        assertEquals("Ashok", p2.getFirstName());
        assertNull(p2.getSecondName());
    }

    @Test
    public void testGetSurname() {
        assertEquals ("Tan", p1.getSurname());
        assertEquals ("Bharadwaj", p2.getSurname());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Lee", p1.getFirstName());
        assertEquals("Ashok", p2.getFirstName());
    }

    @Test
    public void testGetSecondName() {
        assertEquals("Ling", p1.getSecondName());
        assertNull(p2.getSecondName());

    }

    @Test
    public void testShow() {
        assertEquals ("Lee Ling Tan", p1.toString());
        assertEquals ("Ashok Bharadwaj", p2.toString());
    }

    @Test
    public void testEquals() {
        assertSame(p1,p1);
        assertSame(p2,p2);

        assertEquals(p1, new Person("Tan", "Lee", "Ling"));
        assertEquals(p2,new Person ("Bharadwaj", "Ashok", null));

        assertFalse(p1.equals(p2));
        assertFalse(p2.equals(p1));

        Person p3 = new Person("Tan", "Lee", null);
        assertFalse(p1.equals(p3));
        assertFalse(p3.equals(p1));
        Person p4 = new Person ("Bharadwaj", "Ashok", "Kumar");
        assertFalse(p2.equals(p4));
        assertFalse(p4.equals(p2));
    }

}
