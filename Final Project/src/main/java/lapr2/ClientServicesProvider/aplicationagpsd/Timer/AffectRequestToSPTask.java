/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Timer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TimerTask;

/**
 *
 * @author berna
 */
public class AffectRequestToSPTask extends TimerTask {
        
    private String schedulingAlgorithm;
    
    public AffectRequestToSPTask(String schedulingAlgorithm){
        this.schedulingAlgorithm = schedulingAlgorithm;
    }
    
    @Override
    public void run() {
        TaskAlgorithm task = new TaskAlgorithm();
        task.fcfs();
//        try {
//            Method sumInstanceMethod = TaskAlgorithm.class.getMethod(schedulingAlgorithm);
//            TaskAlgorithm operationsInstance = new TaskAlgorithm();
//            sumInstanceMethod.setAccessible(true);
//            Void result = (Void) sumInstanceMethod.invoke(operationsInstance);
//        } catch (NoSuchMethodException ex) {
//            //Logger.getLogger(AffectRequestToSPTask.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SecurityException ex) {
//            //Logger.getLogger(AffectRequestToSPTask.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            //Logger.getLogger(AffectRequestToSPTask.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalArgumentException ex) {
//            //Logger.getLogger(AffectRequestToSPTask.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvocationTargetException ex) {
//            //Logger.getLogger(AffectRequestToSPTask.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * @return the schedulingAlgorithm
     */
    public String getSchedulingAlgorithm() {
        return schedulingAlgorithm;
    }

    /**
     * @param schedulingAlgorithm the schedulingAlgorithm to set
     */
    public void setSchedulingAlgorithm(String schedulingAlgorithm) {
        this.schedulingAlgorithm = schedulingAlgorithm;
    }
    
}
