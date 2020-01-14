package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.CompleteWork;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExecutionOrder;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Invoice;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.RepeatedExecutionOrderException;

/**
 *
 * @author Tiago
 */
public class CompleteWorkRecord implements Serializable{
    
    private List<CompleteWork> lstCompletedWorks;

    public CompleteWorkRecord() {
        this.lstCompletedWorks = new ArrayList<CompleteWork>();
    }

    public List<CompleteWork> getLstCompleteWorks() {
        return lstCompletedWorks;
    }
    
    public void setCompleteWorksList(List<CompleteWork> completeWorks){
        lstCompletedWorks = completeWorks;
    }
    
    public CompleteWork newCompleteWork(String description, ExecutionOrder e){
        return new CompleteWork(description, e);
    }
    
    public void registCompleteWork(CompleteWork e){
        validateCompleteWork(e);
        this.lstCompletedWorks.add(e);
    }
    
    private void validateCompleteWork(CompleteWork cw){
        for(CompleteWork completeWork : lstCompletedWorks){
            if(cw.getExecutionOrder().getSequencialIdentifier().equals(completeWork.getExecutionOrder().getSequencialIdentifier())){
                throw new RepeatedExecutionOrderException();
            }
        }
    }
    
    public List<CompleteWork> getCompleteWorkByClient(Client client) {
        List<CompleteWork> workByClient = new ArrayList<CompleteWork>();
        for (CompleteWork cw : lstCompletedWorks) {
            if (cw.getExecutionOrder().getCli().equals(client)) {
                workByClient.add(cw);
            }
        }
        return workByClient;
    }
    
    public CompleteWork getCompleteWorkByExecutionOrder(ExecutionOrder eo) {
        for (CompleteWork cw : lstCompletedWorks) {
            if (cw.getExecutionOrder().equals(eo)) {
                return cw;
            }
        }
        return new CompleteWork();
    }
}
