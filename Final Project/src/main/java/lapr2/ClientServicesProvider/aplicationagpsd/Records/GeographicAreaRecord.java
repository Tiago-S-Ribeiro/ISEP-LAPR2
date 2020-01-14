package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.GeographicArea;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.GeographicAreaRepetedException;

/**
 *
 * @author Tiago
 */
public class GeographicAreaRecord implements Serializable{

    private List<GeographicArea> lstGeographicAreas;

    public GeographicAreaRecord() {
        this.lstGeographicAreas = new ArrayList<GeographicArea>();
    }

    public List<GeographicArea> getLstGeographicAreas() {
        return lstGeographicAreas;
    }

    public void setLstGeographicAreas(List<GeographicArea> lstGeographicAreas) {
        this.lstGeographicAreas = lstGeographicAreas;
    }

    private void validateGeographicArea(GeographicArea ga) {
        for (GeographicArea gaE : Company.getGeographicAreasRecord().getLstGeographicAreas()) {
            if (ga.getPostalCode().equals(gaE.getPostalCode())) {
                throw new GeographicAreaRepetedException();
            }
        }
    }

    public void registGeographicArea(GeographicArea ga) {
        validateGeographicArea(ga);
        lstGeographicAreas.add(ga);
        System.out.println("Geographic area added with success.");
    }

    public GeographicArea newGeographicArea(String designation, float cost, double radius, String postalCode1, String postalCode2) {
        return new GeographicArea(designation, cost, radius, postalCode1, postalCode2);
    }
    
    public GeographicArea getNearestGeographicArea(double latitude, double longitude){
        double distance = distance(latitude, longitude, lstGeographicAreas.get(0).getPostalCode().getLatitude(), lstGeographicAreas.get(0).getPostalCode().getLongitude());
        double minorDistance = distance;
        GeographicArea nearestGa = lstGeographicAreas.get(0);
        for(int ga = 1; ga < lstGeographicAreas.size(); ga++){
            distance = distance(latitude, longitude, lstGeographicAreas.get(ga).getPostalCode().getLatitude(), lstGeographicAreas.get(ga).getPostalCode().getLongitude());
            if(distance < minorDistance){
                minorDistance = distance;
                nearestGa = lstGeographicAreas.get(ga);
            }
        }
        return nearestGa;
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371e3;
        double theta1 = Math.toRadians(lat1);
        double theta2 = Math.toRadians(lat2);
        double deltaTheta = Math.toRadians(lat2 - lat1);
        double deltaLambda = Math.toRadians(lon2 - lon1);
        double a = Math.sin(deltaTheta / 2) * Math.sin(deltaTheta / 2) + Math.cos(theta1) * Math.cos(theta2) * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c; 
        return d;
    }
    
    public GeographicArea getGeographicAreaByPostCode(String postCode1, String postCode2){
        for (GeographicArea ga : lstGeographicAreas) {
            if(ga.getPostalCode().getPostalCode1().equals(postCode1) && ga.getPostalCode().getPostalCode2().equals(postCode2)){
                return ga;
            }
        }
        throw new IllegalArgumentException("Geographic area not Found");
    }
}
