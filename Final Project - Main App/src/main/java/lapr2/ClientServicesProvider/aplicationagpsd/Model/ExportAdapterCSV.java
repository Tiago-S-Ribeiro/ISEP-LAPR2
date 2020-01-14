package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ExportAdapterCSV implements Exporter {

    @Override
    public void exportFile(List<ExecutionOrder> executionOrders, String fileName) {
        try {
            Formatter out = new Formatter(new File(fileName + "(CSV).csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("Order Number").append(";");
            sb.append("Client Name").append(";");
            sb.append("Distance").append(";");
            sb.append("Category ID").append(";");
            sb.append("Service Type").append(";");
            sb.append("Date").append(";");
            sb.append("Time").append(";");
            sb.append("Address").append(";");
            sb.append("Locality").append(";");
            sb.append("Postcode").append(";").append("\n");
            
            for (ExecutionOrder order : executionOrders) {
                if (order != null && order.toString() != null && !order.toString().isEmpty()) {
                    sb.append(order.getSequencialIdentifier()).append(";");
                    sb.append(order.getCli().getName()).append(";");
                    sb.append(order.getDistance()).append(";");
                    sb.append(order.getDescription().getService().getCatID()).append(";");
                    sb.append(order.getDescription().getService().getServiceType()).append(";");
                    sb.append(order.getSchedule().getDay().toYearMonthDayString()).append(";");
                    sb.append(order.getSchedule().getBeginingHour().toStringHHMM()).append(";");
                    sb.append(order.getPostalAddress().getAddress()).append(";");
                    sb.append(order.getPostalAddress().getLocality()).append(";");
                    sb.append(order.getPostalAddress().getPostCode().toString()).append(";").append("\n");
                }
            }

            out.format("%s", sb.toString());
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("It was not possible to export your execution orders to a .CSV file.");
        }
    }
}
