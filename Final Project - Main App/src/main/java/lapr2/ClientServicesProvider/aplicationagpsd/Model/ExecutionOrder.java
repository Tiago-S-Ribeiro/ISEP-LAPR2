package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;

import java.io.Serializable;

/**
 * @author Tiago
 */
public class ExecutionOrder implements Serializable {

    private String sequencialIdentifier;
    private Date emissionDate;
    private ServiceProvider serviceProvider;
    private Client cli;
    private RequestedServiceDescription description;
    private Schedule schedule;
    private double distance;
    private PostalAddress postalAddress;

    private static int sequencialNumber = 1;

    private static final PostalAddress POSTAL_ADDRESS_BY_OMISSION = new PostalAddress();

    private static final String SEQUENTIAL_NUMBER_BY_OMISSION = "Without Sequential Number";

    private static final Date EMISSION_DATE_BY_OMISSION = new Date();

    private static final ServiceProvider SERVICE_PROVIDER_BY_OMISSION = new ServiceProvider();

    private static final Client CLIENT_BY_OMISSION = new Client();

    private static final RequestedServiceDescription DESCRIPTION_BY_OMISSION = new RequestedServiceDescription();

    private static Schedule SCHEDULE_BY_OMISSION = new Schedule();

    private static double DISTANCE_BY_OMISSION = 0;

    public ExecutionOrder(PostalAddress postalAddress, ServiceProvider serviceProvider, Client cli, RequestedServiceDescription description, Schedule schedule, double distance) {
        this.postalAddress = postalAddress;
        this.sequencialIdentifier = "AGSPD-" + sequencialNumber;
        this.emissionDate = Date.actualDate();
        this.serviceProvider = serviceProvider;
        this.cli = cli;
        this.description = description;
        this.schedule = schedule;
        this.distance = distance;
        sequencialNumber++;
    }

    public ExecutionOrder() {
        this.postalAddress = POSTAL_ADDRESS_BY_OMISSION;
        this.sequencialIdentifier = SEQUENTIAL_NUMBER_BY_OMISSION;
        this.emissionDate = EMISSION_DATE_BY_OMISSION;
        this.serviceProvider = SERVICE_PROVIDER_BY_OMISSION;
        this.cli = CLIENT_BY_OMISSION;
        this.description = DESCRIPTION_BY_OMISSION;
        this.schedule = SCHEDULE_BY_OMISSION;
        this.distance = DISTANCE_BY_OMISSION;
    }

    public String getSequencialIdentifier() {
        return sequencialIdentifier;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public Client getCli() {
        return cli;
    }

    public RequestedServiceDescription getDescription() {
        return description;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public double getDistance() {
        return distance;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        if (serviceProvider == null) {
            throw new IllegalArgumentException("Invalid Service Provider");
        }
        this.serviceProvider = serviceProvider;
    }

    public void setCli(Client cli) {
        if (cli == null) {
            throw new IllegalArgumentException("Invalid client");
        }
        this.cli = cli;
    }

    public void setDescription(RequestedServiceDescription description) {
        if (description == null) {
            throw new IllegalArgumentException("Invalid provision");
        }
        this.description = description;
    }

    public void setSchedule(Schedule schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("Invalid schedule");
        }
        this.schedule = schedule;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPostalAddress(PostalAddress pa) {
        if (pa == null) {
            throw new IllegalArgumentException("Invalid postal address");
        }
        this.postalAddress = pa;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != ExecutionOrder.class) {
            return false;
        }

        ExecutionOrder eo = (ExecutionOrder) obj;
        return eo.cli.equals(cli) && eo.distance == distance && eo.emissionDate.equals(emissionDate)
                && eo.description.equals(description) && eo.schedule.equals(schedule)
                && eo.sequencialIdentifier.equals(sequencialIdentifier)
                && eo.serviceProvider.equals(serviceProvider);
    }

    @Override
    public String toString() {
        return String.format("Execution Order Nº (%s), Client's Name: %s, Distance: %.2f, Category ID: %s, "
                + "ServiceType: %s\n %s, at %s, Address: %s, Locality: %s, %s", sequencialIdentifier, 
                cli.getName(),distance,description.getService().getCatID(),description.getService().getServiceType(),
                schedule.getDay().toYearMonthDayString(), schedule.getBeginingHour().toStringHHMM(),
                postalAddress.getAddress(),postalAddress.getLocality(),postalAddress.getPostCode().toString());
    }

    public int calculateFinalTime() {
        return this.schedule.getBeginingHour().toMinutes() + this.description.getDuration().toMinutes();
    }


}
