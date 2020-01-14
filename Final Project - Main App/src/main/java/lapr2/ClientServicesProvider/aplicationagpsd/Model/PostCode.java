package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import static java.lang.System.exit;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Tiago
 */
public class PostCode implements Serializable {

    private String postalCode1;
    private String postalCode2;
    private double longitude;
    private double latitude;

    private static final String POSTAL_CODE1_BY_OMISSION = "0000";
    private static final String POSTAL_CODE2_BY_OMISSION = "000";
    private static final double LONGITUDE_BY_OMISSION = 0;
    private static final double LATITUDE_BY_OMISSION = 0;

    public PostCode(String postalCode1, String postalCode2) {
        setPostalCode1(postalCode1);
        setPostalCode2(postalCode2);
        setLongitude(obtainLongitude(postalCode1, postalCode2));
        setLatitude(obtainLatitude(postalCode1, postalCode2));
    }
    
    public PostCode(String postalCode1, String postalCode2, double latitude, double longitude){
        setPostalCode1(postalCode1);
        setPostalCode2(postalCode2);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public PostCode(PostCode outroCodPostal) {
        this.postalCode1 = outroCodPostal.postalCode1;
        this.postalCode2 = outroCodPostal.postalCode2;
        this.latitude = outroCodPostal.latitude;
        this.longitude = outroCodPostal.longitude;
    }

    public PostCode() {
        this.postalCode1 = POSTAL_CODE1_BY_OMISSION;
        this.postalCode2 = POSTAL_CODE2_BY_OMISSION;
        this.latitude = LATITUDE_BY_OMISSION;
        this.longitude = LONGITUDE_BY_OMISSION;
    }

    public String getPostalCode1() {
        return postalCode1;
    }

    public String getPostalCode2() {
        return postalCode2;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setPostalCode1(String postalCode1) {
        if (postalCode1 == null || postalCode1.isEmpty() || postalCode1.length() != 4) {
            throw new IllegalArgumentException("Invalid Postal Code.");
        }
        this.postalCode1 = postalCode1;
    }

    public void setPostalCode2(String postalCode2) {
        if (postalCode2 == null || postalCode2.isEmpty() || postalCode2.length() != 3) {
            throw new IllegalArgumentException("Invalid Postal Code.");
        }
        this.postalCode2 = postalCode2;
    }

    public void setLongitude(double longitude) {
        if (longitude == 0) {
            throw new IllegalArgumentException("Invalid Longitude.");
        }
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        if (latitude == 0) {
            throw new IllegalArgumentException("Invalid latitude.");
        }
        this.latitude = latitude;
    }

    public String toString() {
        return postalCode1 + "-" + postalCode2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != PostCode.class) {
            return false;
        }
        PostCode codP = (PostCode) obj;
        return codP.latitude == this.latitude && codP.longitude == this.longitude
                && this.postalCode1.equalsIgnoreCase(codP.postalCode1) && this.postalCode2.equalsIgnoreCase(codP.postalCode2);
    }

     public double obtainLatitude(String postalCode1, String postalCode2){
        int index = 0;
        double latitude;
        boolean verifyPc1 = false;
        boolean verifyPc2 = false;
        try {
            Scanner latitudeFinder = new Scanner(new File("codigopostal_alt_long.csv"));
            latitudeFinder.useDelimiter(";|\n");

            try {
                while (latitudeFinder.hasNext()) {
                    String data = latitudeFinder.next().trim();
                    switch (index) {
                        case 7:
                            String strPc1 = String.format("%4s",data).replaceAll(" ", "0");;
                            if (strPc1.equalsIgnoreCase(postalCode1)) {
                                verifyPc1 = true;
                            }
                            break;
                        case 8:
                            String strPc2 = String.format("%3s",data).replaceAll(" ", "0");;
                            if (strPc2.equalsIgnoreCase(postalCode2)) {
                                verifyPc2 = true;
                            }
                            break;
                        case 10:
                            if (verifyPc1 && verifyPc2) {
                                latitude = Double.parseDouble(data.replaceAll(",", "."));
                                return latitude;
                            }
                    }
                    index++;
                    if (index == 15) {
                        index = 0;
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("Erro na leitura do ficheiro Administradores.");
                e.printStackTrace();
                exit(0);
            }

            latitudeFinder.close();

        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro de Administradores não existe.");
            e.printStackTrace();
            exit(0);
        }
        return LATITUDE_BY_OMISSION;
    }

    public double obtainLongitude(String postalCode1, String postalCode2){
        int index = 0;
        double longitude;
        boolean verifyPc1 = false;
        boolean verifyPc2 = false;
        try {
            Scanner LongitudeFinder = new Scanner(new File("codigopostal_alt_long.csv"));
            LongitudeFinder.useDelimiter(";|\n");
            LongitudeFinder.nextLine();

            try {
                while (LongitudeFinder.hasNext()) {
                    String data = LongitudeFinder.next().trim();
                    switch (index) {
                        case 7:
                            String strPc1 = String.format("%4s",data).replaceAll(" ", "0");
                            if (strPc1.equalsIgnoreCase(postalCode1)) {
                                verifyPc1 = true;
                            } else{
                                verifyPc1 = false;
                            }
                            break;
                        case 8:
                            String strPc2 = String.format("%3s", data).replaceAll(" ", "0");
                            if (strPc2.equalsIgnoreCase(postalCode2)) {
                                verifyPc2 = true;
                            } else{
                                verifyPc1 = false;
                            }
                            break;
                        case 11:
                            if (verifyPc1 && verifyPc2) {
                                longitude = Double.parseDouble(data.replaceAll(",", "."));
                                return longitude;
                            }
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
        return LONGITUDE_BY_OMISSION;
    }
}
