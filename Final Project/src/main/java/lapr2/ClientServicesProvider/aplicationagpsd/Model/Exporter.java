package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.util.List;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public interface Exporter {
    
    public void exportFile(List<ExecutionOrder> executionOrders, String fileName);
    
}
