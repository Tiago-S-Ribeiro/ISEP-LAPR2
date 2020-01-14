package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 * @author Pedro Borda de Água
 */
public class CategoryTest {
    
    /**
     * Test of getCatCode method, of class Category.
     */
    @Test
    public void testGetCatCode() {
        System.out.println("getCatCode");
        Category cat1 = new Category();
        String expResult = "catXY";
        String result = cat1.getCatCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCatDescription method, of class Category.
     */
    @Test
    public void testGetCatDescription() {
        System.out.println("getCatDescription");
        Category cat1 = new Category();
        String expResult = "Unknown";
        String result = cat1.getCatDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCatCode method, of class Category.
     */
    @Test
    public void testSetCatCode() {
        System.out.println("setCatCode");
        String catCode = "cat123";
        Category cat1 = new Category();
        cat1.setCatCode(catCode);
        assertEquals(catCode,cat1.getCatCode());
    }

    /**
     * Test of setCatDescription method, of class Category.
     */
    @Test
    public void testSetCatDescription() {
        System.out.println("setCatDescription");
        String catDescription = "anything";
        Category cat1 = new Category();
        cat1.setCatDescription(catDescription);
        assertEquals(catDescription,cat1.getCatDescription());        
    }

    /**
     * Test of equals method, of class Category.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals for the same object");
        Category newCat = new Category();
        boolean expResult = true;
        boolean result = newCat.equals(newCat);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Category.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals for a null object");
        Object obj = null;
        Category newCat = new Category();
        boolean expResult = false;
        boolean result = newCat.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Category.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals for objects of different classes");
        Object obj = new Company();
        Category newCat = new Category();
        boolean expResult = false;
        boolean result = newCat.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Category.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals for two categories with every parameter equal");
        Category cat1 = new Category("cat1", "clean");
        Category cat2 = new Category("cat1", "clean");
        boolean expResult = true;
        boolean result = cat1.equals(cat2);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Category.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Category cat1 = new Category("cat1", "clean");
        String expResult = cat1.toString();
        String result = "Category with the ID code: cat1 and with the description: clean.";
        assertEquals(expResult, result);
    }
    
}
