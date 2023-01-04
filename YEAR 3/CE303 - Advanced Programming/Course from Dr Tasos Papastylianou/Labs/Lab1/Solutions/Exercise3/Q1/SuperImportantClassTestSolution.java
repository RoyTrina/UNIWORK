package Lab1.Exercise3.Q1;

import Lab1.Exercise3.Q1.SuperImportantClass;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;

public class SuperImportantClassTestSolution
{
    @BeforeAll
    static void doBeforeAll() { System.out.println( "This is called before all tests in class" ); }

    @AfterAll
    static void doAfterAll() { System.out.println( "This is called after all tests in class" ); }

    @BeforeEach
    void setUp() { System.out.println( "This is called before each test in this class" ); }

    @AfterEach
    void tearDown() { System.out.println( "This is called after each test in this class" ); }

    @Test
    void succeedingTest() { return; } // A test that returns without explicit 'failure' is deemed to be successful.

    @Test
    void failingTest() { fail("We have caused this test to fail"); }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() { } // will not included in the test suite.

    @Test
    void demonstrateAssertEquals() { assertEquals( 1 + 1, 2 ); } // succeeds when the two arguments are equal

    @Test
    void demonstrateAssertTrue() { assertTrue( 5 > 0 ); } // succeeds when the input argument evaluates to 'true'

    @Test
    void demonstrateAssertInstanceOf() { assertInstanceOf( new String().getClass(), "Hello" ); }

    @Test
    void testSuperImportantStaticMethod() { assertEquals( 2, SuperImportantClass.superImportantStaticMethod(1) ); }

    @Test
    void testSuperImportantInstanceMethod()
    {
        SuperImportantClass s = new SuperImportantClass();
        assertEquals( 3, s.superImportantInstanceMethod(1) );
    }
}
