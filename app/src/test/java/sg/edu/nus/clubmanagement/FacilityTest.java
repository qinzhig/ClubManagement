package sg.edu.nus.clubmanagement;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sg.edu.nus.clubmanagement.ClubFolder.Facility;

/**
 * Created by swarna on 4/8/2016.
 */
public class FacilityTest extends TestCase {

  private Facility fac1, fac2, fac3;

  @Before public void setUp() throws Exception {
    fac1 = new Facility("Main Hall", null);
    fac2 = new Facility("Room1", "Conference Room on Level 2");
    fac3 = new Facility("Room2", "Meeting Room on Level 3");
  }

  @After public void tearDown() throws Exception {
    fac1 = null;
    fac2 = null;
    fac3 = null;
  }

  @Test public void testFacilityString() {
    assertEquals("Main Hall", fac1.getName());
    assertNull(fac1.getDescription());
  }

  @Test public void testFacilityStringString() {
    assertEquals("Room1", fac2.getName());
    assertEquals("Conference Room on Level 2", fac2.getDescription());
  }

  @Test public void testGetName() {
    assertEquals("Main Hall", fac1.getName());
    assertEquals("Room1", fac2.getName());
    assertEquals("Room2", fac3.getName());
  }

  @Test public void testGetDescription() {
    assertTrue(fac1.getDescription() == null);
    assertEquals("Conference Room on Level 2", fac2.getDescription());
    assertEquals("Meeting Room on Level 3", fac3.getDescription());
  }

  @Test public void testShow() {
    fac1.show();
    fac2.show();
    fac3.show();
    assertTrue(true);
  }

  @Test public void testEquals() {
    assertEquals(fac1, new Facility("Main Hall"));
    assertFalse(fac2.equals(new Facility("Main Hall")));
    assertFalse(new Facility("Main Hall").equals(fac2));
    assertTrue(fac2.equals(new Facility("Room1", "Conference Room on Level 2")));
  }

  public static junit.framework.Test suite() {
    TestSuite suite = new TestSuite("Test for default package");
    System.out.println("Test for default package");
    suite.addTestSuite(PersonTest.class);
    suite.addTestSuite(FacilityTest.class);
    suite.addTestSuite(ClubTest.class);
    return suite;
  }
}
