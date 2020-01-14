package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.CategoryRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 * @author Pedro Borda de Água
 */
public class RegistCategoryControllerTest {

    public RegistCategoryControllerTest() {
    }

    /**
     * Test of newCategory method, of class RegistCategoryController.
     */
    @Test
    public void testNewCategory() {
        System.out.println("newCategory");
        Company comp = new Company();
        Category cat;
        CategoryRecord crec = Company.getCategoryRecord();
        cat = crec.newCategory("limpeza", "limpar tudo");
        assertEquals(cat,crec.newCategory("limpeza", "limpar tudo"));
    }

    /**
     * Test of registCategory method, of class RegistCategoryController.
     */
    @Test
    public void testRegistCategory() {
        System.out.println("registCategory");
        Company comp = new Company();
        Category cat = new Category("limpeza", "limpar tudo");
        CategoryRecord crec = Company.getCategoryRecord();
        crec.registCategory(cat);
        assertEquals(true, crec.getListOfCategories().contains(cat));
    }
    
}
