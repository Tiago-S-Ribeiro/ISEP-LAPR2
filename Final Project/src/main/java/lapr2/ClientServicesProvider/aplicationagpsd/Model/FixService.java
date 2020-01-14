package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

/**
 * The type Fix service.
 *
 * @author Tiago
 */
public class FixService extends Service implements Serializable{

    private Time estimatedDuration;

    private static final Time ESTIMATED_DURATION_BY_OMISSION = new Time(0, 30);

    /**
     * Instantiates a new Fix service.
     */
    public FixService() {
        super();
        this.estimatedDuration = ESTIMATED_DURATION_BY_OMISSION;
    }

    /**
     * Instantiates a new Fix service.
     *
     * @param catID               the cat id
     * @param servID              the serv id
     * @param serviceType         the service type
     * @param briefDescription    the brief description
     * @param completeDescription the complete description
     * @param hourCost            the hour cost
     * @param estimatedDuration   the estimated duration
     */
    public FixService(String catID, String servID, String serviceType, String briefDescription, String completeDescription, double hourCost, Time estimatedDuration) {
        super(catID, servID, serviceType, briefDescription, completeDescription, hourCost);
        this.estimatedDuration = new Time(estimatedDuration);
    }

    /**
     * Instantiates a new Fix service.
     *
     * @param outroServico the outro servico
     */
    public FixService(FixService outroServico) {
        super(outroServico.getCatID(), outroServico.getServID(), outroServico.getServiceType(), outroServico.getBriefDescription(), outroServico.getCompleteDescription(), outroServico.getHourCost());
        this.estimatedDuration = new Time(outroServico.estimatedDuration);
    }

    /**
     * Gets estimated duration.
     *
     * @return the estimated duration
     */
    public Time getEstimatedDuration() {
        return estimatedDuration;
    }

    /**
     * Sets estimated duration.
     *
     * @param estimatedDuration the estimated duration
     */
    public void setEstimatedDuration(Time estimatedDuration) {
        this.estimatedDuration = new Time(estimatedDuration);
    }

    public String toString() {
        return "Fix Service - " + super.toString() + " ,duration " + estimatedDuration;
    }

    /**
     * Calcula custo double.
     *
     * @return the double
     */
    public double calculateCost() {
        return this.getHourCost() * ((estimatedDuration.getHours() * 60) + estimatedDuration.getMinutes()) / 60;
    }
}
