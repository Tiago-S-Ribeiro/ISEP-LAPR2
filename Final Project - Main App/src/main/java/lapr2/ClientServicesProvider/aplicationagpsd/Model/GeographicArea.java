package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class GeographicArea implements Serializable{

    /**
     * Designação da Área Geográfica
     */
    private String designation;

    /**
     * Custo da deslocação da Área Geográfica
     */
    private float costOfTravel;

    /**
     * Raio da atuação da Área Geográfica
     */
    private double radius;

    /**
     * Código postal da Área Geográfica
     */
    private PostCode postalCode;
    
    private List<PostCode> zonesOfOperation;

    private static final String DESIGNATION_BY_OMISSION = "No Designation";
    private static final float COST_OF_TRAVEL_BY_OMISSION = 0;
    private static final float RADIUS_BY_OMISSION = 0;
    private static final PostCode POST_CODE_BY_OMISSION = new PostCode();
    private static final List<PostCode> ZONES_OF_OPERATION_BY_OMISSION = new ArrayList<PostCode>();

    /**
     * Constrói uma instância de uma Área Geográfica recebendo como parâmetro
     * uma designação, um custo de deslocação,um raio de atuação um código
     * postal e uma latitude e longitude do código postal
     *
     * @param designacao designação da Área Geográfica
     * @param custoDeslocacao custo da deslocação da Área Geográfica
     * @param raioAtuacao raio da atuação da Área Geográfica
     * @param designacaoCod código postal da Área Geográfica
     * @param latitude latitude do código postal da Área Geográfica
     * @param longitude longitude do código postal da Área Geográfica
     */
    public GeographicArea(String designation, float costOfTravel, double radius, String postalCode1, String postalCode2) {
        this.setDesignation(designation);
        this.setCostOfTravel(costOfTravel);
        this.setRadius(radius);
        this.postalCode = new PostCode(postalCode1, postalCode2);
        this.zonesOfOperation = OperatesIn.OperatesIn(postalCode, radius);
    }

    /**
     * Constrói uma instância de uma Área Geográfica recebendo como parâmetro
     * uma outra Área Geográfica.
     *
     * @param outraArea outra instancia de area geografica.
     */
    public GeographicArea(GeographicArea otherArea) {
        this.postalCode = otherArea.getPostalCode();
        this.costOfTravel = otherArea.getCostOfTravel();
        this.designation = otherArea.getDesignation();
        this.radius = otherArea.getRadius();
        this.zonesOfOperation = otherArea.getZonesOfOperation();
    }

    public GeographicArea() {
        this.postalCode = POST_CODE_BY_OMISSION;
        this.costOfTravel = COST_OF_TRAVEL_BY_OMISSION;
        this.designation = DESIGNATION_BY_OMISSION;
        this.radius = RADIUS_BY_OMISSION;
        this.zonesOfOperation = ZONES_OF_OPERATION_BY_OMISSION;
    }

    /**
     * Devolve a designação da Área Geográfica
     *
     * @return a designação da Área Geográfica
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Devolve o custo da deslocação da Área Geográfica
     *
     * @return o custo da deslocação da Área Geográfica
     */
    public float getCostOfTravel() {
        return costOfTravel;
    }

    /**
     * Devolve o raio da atuação da Área Geográfica
     *
     * @return o raio da atuação da Área Geográfica
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Devolve o Código Postal da Área Geográfica composto por uma designação,
     * latitude e longitude
     *
     * @return o Código Postal da Área Geográfica
     */
    public PostCode getPostalCode() {
        return new PostCode(postalCode);
    }

    public List<PostCode> getZonesOfOperation() {
        return zonesOfOperation;
    }

    /**
     * Modifica a designação da Área Geográfica validando-a
     *
     * @param designacao a designação da Área Geográfica
     */
    public void setDesignation(String designation) {

        if (designation == null || designation.isEmpty()) {
            throw new IllegalArgumentException("Designação inválida.");
        }

        this.designation = designation;
    }

    /**
     * Modifica o custo da deslocação da Área Geográfica validando-o
     *
     * @param custoDeslocacao o custo da deslocação da Área Geográfica
     */
    public void setCostOfTravel(float costOfTravel) {
        if (costOfTravel < 0) {
            throw new IllegalArgumentException("Custo de deslocação inválido.");
        }
        this.costOfTravel = costOfTravel;
    }

    /**
     * Modifica o raio de atuação da Área Geográfica validando-o
     *
     * @param raioAtuacao o raio de atuação da Área Geográfica
     */
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Raio de deslocação inválido.");
        }
        this.radius = radius;
    }

    public void setPostalCode(PostCode postalCode) {
        this.postalCode = postalCode;
    }

    public void setZonesOfOperation(List<PostCode> zonesOfOperation) {
        this.zonesOfOperation = zonesOfOperation;
    }

    /**
     * Modifica o Código Postal da Área Geográfica composto por uma designação,
     * latitude e longitude
     *
     * @param designacaoCod designação do Código Postal da Área Geográfica
     * @param latitude latitude do Código Postal da Área Geográfica
     * @param longitude longitude do Código Postal da Área Geográfica
     */
//    public void setCodPostal(String codeDesignation, double latitude,
//            double longitude) {
//        this.postalCode = new PostCode(codeDesignation, longitude, latitude);
//    }

    public String toString() {
        return "Area Geográfica: " + this.designation 
                + "\ncódigo postal: " + this.postalCode
                + "\ncusto de deslocacao: " + this.costOfTravel 
                + "\nraio de atuacao: " + this.radius;
    }

    /**
     * Compara duas instâncias de Área Geográfica
     *
     * @param obj Instância a ser comparada com a instância que invoca o método
     * @return true se forem iguais e false se forem diferentes
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != GeographicArea.class) {
            return false;
        }
        GeographicArea ag1 = (GeographicArea) obj;
        return this.costOfTravel == ag1.costOfTravel
                && this.designation.equalsIgnoreCase(this.designation)
                && this.radius == ag1.radius && this.postalCode.equals(ag1.postalCode);
    }
}
