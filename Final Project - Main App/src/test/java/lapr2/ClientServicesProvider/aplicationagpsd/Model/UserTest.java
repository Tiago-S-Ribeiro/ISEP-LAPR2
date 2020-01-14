package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User test.
 */
class UserTest {

    /**
     * Gets email.
     */
    @Test
    void getEmail() {
        User instance = new User();
        String actual = instance.getEmail();
        String expected = "NO EMAIL";
        assertEquals(expected, actual);
    }

    /**
     * Gets password.
     */
    @Test
    void getPassword() {
        User instance = new User();
        String actual = instance.getPassword();
        String expected = "NO PASSWORD";
        assertEquals(expected, actual);
    }

    /**
     * Sets email.
     */
    @Test
    void setEmail() {
        User instance = new User();
        instance.setEmail("email@test.com");
        String actual = instance.getEmail();
        String expected = "email@test.com";
        assertEquals(expected, actual);
    }

    /**
     * Sets password.
     */
    @Test
    void setPassword() {
        User instance = new User();
        instance.setPassword("testpasssword");
        String actual = instance.getPassword();
        String expected = "testpasssword";
        assertEquals(expected, actual);
    }

    /**
     * To string test.
     */
    @Test
    void toStringTest() {
        User instance = new User();
        String actual = instance.toString();
        String expected = String.format("%s - %s", "USER", "NO EMAIL");
        assertEquals(expected, actual);
    }

    /**
     * Equals test null.
     */
    @Test
    void equalsTestNull() {
        User instance = new User();
        User instance2 = null;
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Equals test same object.
     */
    @Test
    void equalsTestSameObject() {
        User instance = new User();
        boolean expected = true;
        boolean actual = instance.equals(instance);
        assertEquals(expected, actual);
    }

    /**
     * Equals test different class.
     */
    @Test
    void equalsTestDifferentClass() {
        User instance = new User();
        Appliance instance2 = new Appliance();
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Equals test parameters.
     */
    @Test
    void equalsTestParameters() {
        User instance = new User("email@test.com", "passwordtest","client");
        User instance2 = new User("email@test.com", "passwordtest2","client");
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }
}