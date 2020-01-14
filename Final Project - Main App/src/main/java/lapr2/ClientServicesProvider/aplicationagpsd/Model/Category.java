package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
/**
 * 
 * @author Pedro Água
 */
public class Category implements Serializable{

    /**
     * Category's code
     */
    private String catCode;
    /**
     * Category's description
     */
    private String catDescription;

    /**
     * Category's code by omission
     */
    private String CATCODE_BY_OMISSION = "catXY";
    /**
     * Category's description by omission
     */
    private String CATDESCRIPTION_BY_OMISSION = "Unknown";

    /**
     * It builds an instance of a Category.
     * 
     * @param catCode
     * @param catDescription
     */ 
    public Category(String catCode, String catDescription) {
        this.catCode = catCode;
        this.catDescription = catDescription;
    }   
    
    /**
     * It builds an instance of an ExecutionOrder copying another instance.
     *
     * @param anotherCategory
     */
    public Category(Category anotherCategory) {
        this.catCode = anotherCategory.catCode;
        this.catDescription = anotherCategory.catDescription;
    }

    /**
     * It builds an instance of a Company with values by omission.
     */    
    public Category() {
        this.catCode = CATCODE_BY_OMISSION;
        this.catDescription = CATDESCRIPTION_BY_OMISSION;
    }

    /**
     * Returns the category's code.
     *
     * @return 
     */
    public String getCatCode() {
        return catCode;
    }

    /**
     * Returns the category's description.
     *
     * @return
     */
    public String getCatDescription() {
        return catDescription;
    }

    /**
     * It changes the category's code.
     *
     * @param catCode
     */
    public void setCatCode(String catCode) {
        if (catCode == null || catCode.isEmpty()) {
            throw new IllegalArgumentException("There is no argument.");
        }
        this.catCode = catCode;
    }

    /**
     * It changes the category's description.
     *
     * @param catDescription
     */
    public void setCatDescription(String catDescription) {
        if (catDescription == null || catDescription.isEmpty()) {
            throw new IllegalArgumentException("There is no argument.");
        }
        this.catDescription = catDescription;
    }
    
    /**
     * It compares two instances of category and if all the atributes are the
     * same, then it is the same object.
     *
     * @param anotherObject
     * @return true, if all the references refer to the same object false, if
     * any of the reference is different between both objects
     */
    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || this.getClass() != anotherObject.getClass()) {
            return false;
        }
        Category anotherCategory = (Category) anotherObject;
        return this.catCode.equalsIgnoreCase(anotherCategory.catCode)
                && this.catDescription.equalsIgnoreCase(anotherCategory.catDescription);
    }

    /**
     * It returns the characteristics of a record of categories.
     *
     * @return characteristics of a record of categories.
     */
    @Override
    public String toString() {
        return String.format("Category with the ID code: %s and with the description: %s.", catCode, catDescription);
    }    
}
