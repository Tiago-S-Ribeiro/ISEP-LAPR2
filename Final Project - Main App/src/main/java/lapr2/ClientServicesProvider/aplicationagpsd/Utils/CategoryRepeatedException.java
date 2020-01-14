package lapr2.ClientServicesProvider.aplicationagpsd.Utils;

/**
 * @author Pedro Borda de Água
 */
public class CategoryRepeatedException extends IllegalArgumentException {
    
    public CategoryRepeatedException() {
        super("Category already exists");
    }    
}
