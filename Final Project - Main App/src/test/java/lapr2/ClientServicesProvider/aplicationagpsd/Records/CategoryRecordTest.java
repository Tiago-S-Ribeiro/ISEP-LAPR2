package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.CategoryRecord;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 * @author Pedro Borda de Água
 */
public class CategoryRecordTest {
    
    /**
     * Test of getListOfCategories method, of class CategoryRecord.
     */
    @Test
    public void testGetListOfCategories() {
        System.out.println("getListOfCategories");
        CategoryRecord instance = new CategoryRecord();
        List<Category> expResult = instance.getListOfCategories();
        List<Category> result = instance.getListOfCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListOfCategories method, of class CategoryRecord.
     */
    @Test
    public void testSetListOfCategories() {
        System.out.println("setListOfCategories");
        List<Category> list = new ArrayList<Category>();
        list.add(new Category("fed","dw"));
        CategoryRecord cRec = new CategoryRecord();
        cRec.setListOfCategories(list);
        assertEquals(list,cRec.getListOfCategories());
    }

    /**
     * Test of addCategory method, of class CategoryRecord.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category cat1 = new Category("limpar","limpar vidros");
        CategoryRecord cRec = new CategoryRecord();
        cRec.addCategory(cat1);
        assertEquals(cat1, cRec.getListOfCategories().get(0));
        
    }

    /**
     * Test of registCategory method, of class CategoryRecord.
     */
    @Test
    public void testRegistCategory() {
        System.out.println("registCategory");
        Company comp = new Company();
        Category cat1 = new Category("limpar","limpar vidros");
        CategoryRecord cRec = new CategoryRecord();
        cRec.registCategory(cat1);
        assertEquals(true,cRec.getListOfCategories().contains(cat1));
    }

    /**
     * Test of newCategory method, of class CategoryRecord.
     */
    @Test
    public void testNewCategory() {
        System.out.println("newCategory");
        String catCode = "cat1";
        String catDescription = "desc test";
        CategoryRecord cRec = new CategoryRecord();
        Category expResult = new Category(catCode, catDescription);
        Category result = cRec.newCategory(catCode, catDescription);
        assertEquals(expResult, result);
    }
    
}
