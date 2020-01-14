package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.CategoryRepeatedException;

/**
 * @author Pedro Borda de Água
 */
public class CategoryRecord implements Serializable{

    /**
     * Container which will store categories of services.
     */
    private List<Category> listOfCategories;

    /**
     * Create a new list for the record of categories.
     */
    public CategoryRecord() {
        this.listOfCategories = new ArrayList<Category>();
    }

    /**
     * Returns the list containning all the categories.
     *
     * @return
     */
    public List<Category> getListOfCategories() {
        return listOfCategories;

    }

    /**
     * It changes the list containning the categories.
     *
     * @param listOfCategories
     */
    public void setListOfCategories(List<Category> listOfCategories) {
        if (listOfCategories == null || listOfCategories.isEmpty()) {
            throw new IllegalArgumentException("There is no argument.");
        }
        this.listOfCategories = listOfCategories;
    }

    /**
     * It adds a category to the record of categories.
     *
     * @param category
     */
    public void addCategory(Category category) {
        if (category instanceof Category) {
            Category newCategory = (Category) category;
            listOfCategories.add(newCategory);
        }
    }

    /**
     * It validates an instance of a Category passed by parameter.
     *
     * @param cat
     */
    private void validateCategory(Category cat) {
        for (Category cat1 : Company.getCategoryRecord().getListOfCategories()) {
            if (cat.getCatCode().equals(cat1.getCatCode())) {
                throw new CategoryRepeatedException();
            }
        }
    }

    /**
     * It builds an instance of a Category with values passed by parameter.
     *
     * @param cat
     */
    public void registCategory(Category cat) {
        validateCategory(cat);
        listOfCategories.add(cat);
        System.out.println("Category added with success.");
    }

    /**
     * It builds an instance of a Category with values passed by parameter.
     *
     * @param catCode
     * @param catDescription
     * @return
     */
    public Category newCategory(String catCode, String catDescription) {
        return new Category(catCode, catDescription);
    }
    
    public Category getCategoryById(String idCat){
        for (Category category : listOfCategories) {
            if(category.getCatCode().equalsIgnoreCase(idCat)){
                return category;
            }
        }
        return null;
    }

}
