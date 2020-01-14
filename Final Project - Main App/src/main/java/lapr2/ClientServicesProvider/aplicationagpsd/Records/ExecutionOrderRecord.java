package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.CompleteWork;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExecutionOrder;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.RequestedServiceDescription;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Schedule;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.RepeatedExecutionOrderException;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

/**
 * @author Tiago
 */
public class ExecutionOrderRecord implements Serializable {

    private List<ExecutionOrder> executionOrdersList;

    public ExecutionOrderRecord() {
        this.executionOrdersList = new ArrayList<ExecutionOrder>();
    }

    public List<ExecutionOrder> getExecutionOrdersList() {
        return executionOrdersList;
    }

    public void setExecutionOrdersList(List<ExecutionOrder> executionOrdersList) {
        this.executionOrdersList = executionOrdersList;
    }

    public void registExecutionOrder(ExecutionOrder eo) {
        validateExecutionOrder(eo);
        this.executionOrdersList.add(eo);
    }

    public ExecutionOrder newExecutionOrder(PostalAddress postalAddress, double distance, RequestedServiceDescription description, Schedule schedule, ServiceProvider sp, Client cli) {
        return new ExecutionOrder(postalAddress, sp, cli, description, schedule, distance);
    }

    private void validateExecutionOrder(ExecutionOrder eo) {
        for (ExecutionOrder executionOrder : this.executionOrdersList) {
            if (eo.getSequencialIdentifier().equals(executionOrder.getSequencialIdentifier())) {
                throw new RepeatedExecutionOrderException();
            }
        }
    }

    public ArrayList<ExecutionOrder> getExecutionOrdersByServiceProvider(ServiceProvider sp, Date period1, Date period2) {
        ArrayList<ExecutionOrder> executionOrdersBySP = new ArrayList<ExecutionOrder>();
        for (ExecutionOrder order : executionOrdersList) {
            if ((order.getServiceProvider()).equals(sp) && order.getSchedule().getDay().isGreater(period1) == true && order.getSchedule().getDay().isGreater(period2) == false) {
                executionOrdersBySP.add(order);
            }
        }
        return executionOrdersBySP;
    }

    public boolean exportExecutionOrders(String format, ArrayList<ExecutionOrder> executionOrderList) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("executionOrders" + format));
            try {
                out.writeObject(executionOrderList);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to export the file in " + format + " format.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    }

    public List<ExecutionOrder> getExecutionOrdersListByCompleteWorks(List<CompleteWork> lstCompleteWorks) {
        List<ExecutionOrder> lstExecOrders = new ArrayList<ExecutionOrder>(executionOrdersList);
        for (CompleteWork e : lstCompleteWorks) {
            if (this.executionOrdersList.contains(e.getExecutionOrder())) {
                lstExecOrders.remove(e.getExecutionOrder());
            }
        }
        return lstExecOrders;
    }

    public ExecutionOrder getExecutionOrderBySequenciaIdentifier(String sequenciaIdentifier) {
        for (ExecutionOrder eo : this.executionOrdersList) {
            if (eo.getSequencialIdentifier().equalsIgnoreCase(sequenciaIdentifier)) {
                return eo;
            }
        }
        throw new IllegalArgumentException();
    }

    public ArrayList<ExecutionOrder> getExecutionOrdersByServiceProviderWhenServiceExecuted(ServiceProvider sp, List<ExecutionOrder> lstExecutionOrders) {
        ArrayList<ExecutionOrder> executionOrdersBySP = new ArrayList<ExecutionOrder>();
        ArrayList<ExecutionOrder> lstExecOrderBySp = getExecutionOrderByServiceProvider(sp, lstExecutionOrders);
        for (ExecutionOrder order : lstExecOrderBySp) {
            if (Date.actualDate().equals(order.getSchedule().getDay())) {
                if (order.calculateFinalTime() < Time.actualTime().toMinutes()) {
                    executionOrdersBySP.add(order);
                }
            } else if (Date.actualDate().isGreater(order.getSchedule().getDay())) {
                executionOrdersBySP.add(order);
            }
        }
        return executionOrdersBySP;
    }

    private ArrayList<ExecutionOrder> getExecutionOrderByServiceProvider(ServiceProvider sp, List<ExecutionOrder> executionOrders) {
        ArrayList<ExecutionOrder> lstexecutionOrdersBySP = new ArrayList<ExecutionOrder>();
        for (ExecutionOrder e : executionOrders) {
            if (e.getServiceProvider().equals(sp)) {
                lstexecutionOrdersBySP.add(e);
            }
        }
        return lstexecutionOrdersBySP;
    }
}
