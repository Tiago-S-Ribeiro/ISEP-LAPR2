/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Timer;

import java.util.Properties;

/**
 *
 * @author berna
 */
public class DoAffectations {
    
    
    public void start(Properties props){
        java.util.Timer myTimer = new java.util.Timer();
        AffectRequestToSPTask aTask = new AffectRequestToSPTask(props.getProperty("SchedulingAlgorithm"));
        
        int delay = Integer.parseInt(props.getProperty("Timer.Delay"));
        int period = Integer.parseInt(props.getProperty("Timer.Delay"));
        myTimer.scheduleAtFixedRate(aTask, delay, period);
    }
}
