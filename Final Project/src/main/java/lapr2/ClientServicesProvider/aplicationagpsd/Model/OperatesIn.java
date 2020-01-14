package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Tiago
 */
public class OperatesIn implements Serializable{

    public static List<PostCode> OperatesIn(PostCode pc, double radius) {
        double latitude = pc.getLatitude();
        double longitude = pc.getLongitude();
        return obtainZonesOfOperation(latitude, longitude, radius);
    }

    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371e3;
        double x = lat2 - lat1;
        double y = lon2 - lon1;
        double theta1 = Math.toRadians(lat1);
        double theta2 = Math.toRadians(lat2);
        double deltaTheta = Math.toRadians(x);
        double deltaLambda = Math.toRadians(y);
        double a = Math.sin(deltaTheta / 2) * Math.sin(deltaTheta / 2)
                + Math.cos(theta1) * Math.cos(theta2)
                * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c; // distância em metros
        return d;
    }

    public static List<PostCode> obtainZonesOfOperation(double latitude, double longitude, double radius){
        int index = 0;
        double lat = 0.0;
        double longt = 0.0;
        String strPostalCode1 = null;
        String strPostalCode2 = null;
        List<PostCode> lstZonesOfOperation = new ArrayList<PostCode>();
        try {
            Scanner LongitudeFinder = new Scanner(new File("codigopostal_alt_long.csv"));
            LongitudeFinder.useDelimiter(";|\n");
            LongitudeFinder.nextLine();

            try {
                while (LongitudeFinder.hasNext()) {
                    String data = LongitudeFinder.next().trim();
                    switch (index) {
                        case 7:
                            strPostalCode1 = String.format("%4s",data).replaceAll(" ", "0");;
                            break;
                        case 8:
                            strPostalCode2 = String.format("%3s",data).replaceAll(" ", "0");;
                            break;
                        case 10:
                            lat = Double.parseDouble(data.replaceAll(",", ".").replaceAll(" ", "0"));
                            break;
                        case 11:
                            longt = Double.parseDouble(data.replaceAll(",",".").replaceAll(" ", "0"));
                            break;
                        case 14:
                            if (calculateDistance(latitude,longitude,lat,longt) < radius) {
                                lstZonesOfOperation.add(new PostCode(strPostalCode1, strPostalCode2, lat, longt));
                            }
                            break;
                    }
                    index++;
                    if (index == 15) {
                        index = 0;
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("Error reading csv file");
                e.printStackTrace();
                exit(0);
            }

            LongitudeFinder.close();

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            e.printStackTrace();
            exit(0);
        }
        return lstZonesOfOperation;
    }
}