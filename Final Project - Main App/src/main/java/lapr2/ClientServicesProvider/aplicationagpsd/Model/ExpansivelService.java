package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;

/**
 * @author Tiago
 */
public class ExpansivelService extends Service implements Serializable{

    public ExpansivelService() {
        super();
    }

    public ExpansivelService(String catID, String servID, String serviceType, String briefDescription, String completeDescription, double hourCost) {
        super(catID, servID, serviceType, briefDescription, completeDescription, hourCost);
    }

    public ExpansivelService(ExpansivelService outroServico) {
        super(outroServico.getCatID(), outroServico.getServID(), outroServico.getServiceType(), outroServico.getBriefDescription(), outroServico.getCompleteDescription(), outroServico.getHourCost());
    }

    public String toString() {
        return "Expansivel Service- " + super.toString();
    }

    public double calculaCusto() {
        return this.getHourCost();
    }
}
