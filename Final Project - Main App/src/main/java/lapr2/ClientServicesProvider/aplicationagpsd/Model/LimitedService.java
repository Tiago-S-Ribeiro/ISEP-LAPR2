package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;

/**
 * @author Tiago
 */
public class LimitedService extends Service implements Serializable{

    public LimitedService(String catID, String servID, String serviceType, String briefDescription, String completeDescription, double hourCost) {
        super(catID, servID, serviceType, briefDescription, completeDescription, hourCost);
    }

    public LimitedService(LimitedService outroServico) {
        super(outroServico.getCatID(), outroServico.getServID(), outroServico.getServiceType(), outroServico.getBriefDescription(), outroServico.getCompleteDescription(), outroServico.getHourCost());
    }

    public LimitedService() {
        super();
    }

    public String toString() {
        return "Limited Service - " + super.toString();
    }

    public double calculateCost() {
        return this.getHourCost();
    }
}
