package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

/**
 * The type Service provision request.
 *
 * @author berna
 */
public class ServiceProvisionRequest implements Serializable {

    private int requestNumber;

    private Client client;

    private PostalAddress pAdd;

    private List<RequestedServiceDescription> requestedServicesDecriptionList = new ArrayList<RequestedServiceDescription>();

    private List<Schedule> schedulesList = new ArrayList<Schedule>();

    private Double totalCost;

    private static final Client CLIENT_BY_OMISSION = new Client();

    private static final PostalAddress POSTAL_ADDRESS_BY_OMISSION = new PostalAddress();

    private static final Double TOTAL_COST_BY_OMISSION = 0.0;

    private static int sequencialNumber = 0;

    /**
     * Instantiates a new Service provision request.
     *
     * @param client             the client
     * @param pAdd               the p add
     * @param reqServDescription the req serv description
     * @param schedule           the schedule
     * @param totalCost          the total cost
     */
    public ServiceProvisionRequest(Client client, PostalAddress pAdd, RequestedServiceDescription reqServDescription, Schedule schedule, Double totalCost) {
        sequencialNumber++;
        this.requestNumber = sequencialNumber;
        this.client = new Client(client);
        this.pAdd = new PostalAddress(pAdd);
        this.requestedServicesDecriptionList.add(reqServDescription);
        this.schedulesList.add(schedule);
        this.totalCost = totalCost;
    }

    /**
     * Instantiates a new Service provision request.
     *
     * @param cli  the cli
     * @param pAdd the p add
     */
    public ServiceProvisionRequest(Client cli, PostalAddress pAdd) {
        sequencialNumber++;
        this.requestNumber = sequencialNumber;
        this.client = new Client(cli);
        this.pAdd = new PostalAddress(pAdd);
        this.requestedServicesDecriptionList = new ArrayList<RequestedServiceDescription>();
        this.schedulesList = new ArrayList<Schedule>();
        this.totalCost = TOTAL_COST_BY_OMISSION;
    }

    /**
     * Instantiates a new Service provision request.
     *
     * @param spreq the spreq
     */
    public ServiceProvisionRequest(ServiceProvisionRequest spreq) {
        this.requestNumber = spreq.requestNumber;
        this.client = new Client(spreq.client);
        this.pAdd = new PostalAddress(spreq.pAdd);
        this.requestedServicesDecriptionList = spreq.requestedServicesDecriptionList;
        this.schedulesList = spreq.getSchedulesList();
        this.totalCost = spreq.totalCost;
    }

    /**
     * Instantiates a new Service provision request.
     */
    public ServiceProvisionRequest() {
        sequencialNumber++;
        this.requestNumber = sequencialNumber;
        client = CLIENT_BY_OMISSION;
        pAdd = POSTAL_ADDRESS_BY_OMISSION;
        requestedServicesDecriptionList = new ArrayList<RequestedServiceDescription>();
        schedulesList = new ArrayList<Schedule>();
        totalCost = TOTAL_COST_BY_OMISSION;
    }

    /**
     * Gets request number.
     *
     * @return the requestNumber
     */
    public int getRequestNumber() {
        return requestNumber;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Gets add.
     *
     * @return the pAdd
     */
    public PostalAddress getpAdd() {
        return pAdd;
    }

    /**
     * Gets requested services decription list.
     *
     * @return the requestedServicesDecriptionList
     */
    public List<RequestedServiceDescription> getRequestedServicesDecriptionList() {
        return requestedServicesDecriptionList;
    }

    /**
     * Gets schedules list.
     *
     * @return the schedulesList
     */
    public List<Schedule> getSchedulesList() {
        return schedulesList;
    }

    /**
     * Gets total cost.
     *
     * @return the totalCost
     */
    public Double getTotalCost() {
        return totalCost;
    }

    /**
     * Gets sequencial number.
     *
     * @return the sequencialNumber
     */
    public static int getSequencialNumber() {
        return sequencialNumber;
    }

    /**
     * Sets request number.
     *
     * @param requestNumber the requestNumber to set
     */
    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    /**
     * Sets client.
     *
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Sets add.
     *
     * @param pAdd the pAdd to set
     */
    public void setpAdd(PostalAddress pAdd) {
        this.pAdd = pAdd;
    }

    /**
     * Sets requested services decription list.
     *
     * @param requestedServicesDecriptionList the requestedServicesDecriptionList to set
     */
    public void setRequestedServicesDecriptionList(List<RequestedServiceDescription> requestedServicesDecriptionList) {
        this.requestedServicesDecriptionList = requestedServicesDecriptionList;
    }

    /**
     * Sets schedules list.
     *
     * @param schedulesList the schedulesList to set
     */
    public void setSchedulesList(List<Schedule> schedulesList) {
        this.schedulesList = schedulesList;
    }

    /**
     * Sets total cost.
     *
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Add requested service description requested service description.
     *
     * @param s           the s
     * @param description the description
     * @param duration    the duration
     * @return the requested service description
     */
    public RequestedServiceDescription addRequestedServiceDescription(Service s, String description, Time duration) {
        return new RequestedServiceDescription(s, description, duration);
    }

    @Override
    public String toString() {
        return "Request number=" + requestNumber + ", client=" + client.toString() + ", postal address=" + pAdd.toString() + ", total cost=" + totalCost + ".";
    }

    /**
     * Validate requested service description boolean.
     *
     * @param description the description
     * @return the boolean
     */
    public boolean validateRequestedServiceDescription(RequestedServiceDescription description) {
        for (RequestedServiceDescription servDesc : this.requestedServicesDecriptionList) {
            if (description.equals(servDesc)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add requested service description boolean.
     *
     * @param description the description
     * @return the boolean
     */
    public boolean addRequestedServiceDescription(RequestedServiceDescription description) {
        return requestedServicesDecriptionList.add(new RequestedServiceDescription(description));
    }

    /**
     * Count schedules int.
     *
     * @return the int
     */
    public int countSchedules() {
        return this.schedulesList.size() + 1;
    }

    /**
     * Add schedule schedule.
     *
     * @param day          the day
     * @param beginingHour the begining hour
     * @return the schedule
     */
    public Schedule addSchedule(Date day, Time beginingHour) {
        int order = this.countSchedules();
        return new Schedule(order, day, beginingHour);
    }

    /**
     * Validate schedule boolean.
     *
     * @param schedule the schedule
     * @return the boolean
     */
    public boolean validateSchedule(Schedule schedule) {
        for (Schedule sc : schedulesList) {
            if (schedule.equals(sc)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add schedule boolean.
     *
     * @param schedule the schedule
     * @return the boolean
     */
    public boolean addSchedule(Schedule schedule) {
        return schedulesList.add(new Schedule(schedule));
    }

    /**
     * Calculate cost double.
     *
     * @return the double
     */
    public double calculateCost() {
        double cost = 0;
        for (RequestedServiceDescription rsd : this.requestedServicesDecriptionList) {
            cost = cost + rsd.getCost();
        }
        GeographicAreaRecord gar = Company.getGeographicAreasRecord();
        GeographicArea ga = gar.getNearestGeographicArea(this.pAdd.getPostCode().getLatitude(), this.pAdd.getPostCode().getLongitude());
        cost = cost + ga.getCostOfTravel();
        return cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServiceProvisionRequest other = (ServiceProvisionRequest) obj;
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.pAdd, other.pAdd)) {
            return false;
        }
        if (!Objects.equals(this.requestedServicesDecriptionList, other.requestedServicesDecriptionList)) {
            return false;
        }
        if (!Objects.equals(this.schedulesList, other.schedulesList)) {
            return false;
        }
        if (!Objects.equals(this.totalCost, other.totalCost)) {
            return false;
        }
        return true;
    }

}