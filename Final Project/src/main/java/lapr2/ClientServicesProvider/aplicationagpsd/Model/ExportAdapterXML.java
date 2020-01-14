package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ExportAdapterXML implements Exporter{
    
    private static String[] columns = {"Order Number", "Client Name", "Distance", "Category ID", "Service Type", "Date", "Time", "Address", "Locality", "Postcode"};

    @Override
    public void exportFile(List<ExecutionOrder> executionOrders, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("ServiceExecutionOrders");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.ROYAL_BLUE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Creates a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create other rows and cells with executions orders information
        int rowNum = 1;

        for (ExecutionOrder order : executionOrders) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(order.getSequencialIdentifier());
            row.createCell(1).setCellValue(order.getCli().getName());
            row.createCell(2).setCellValue(order.getDistance());
            row.createCell(3).setCellValue(order.getDescription().getService().getCatID());
            row.createCell(4).setCellValue(order.getDescription().getService().getServiceType());
            row.createCell(5).setCellValue(order.getSchedule().getDay().toYearMonthDayString());
            row.createCell(6).setCellValue(order.getSchedule().getBeginingHour().toStringHHMM());
            row.createCell(7).setCellValue(order.getPostalAddress().getAddress());
            row.createCell(8).setCellValue(order.getPostalAddress().getLocality());
            row.createCell(9).setCellValue(order.getPostalAddress().getPostCode().toString());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream out;
        try {
            out = new FileOutputStream(fileName + "(XML).xml");
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("It was not possible to export your execution orders to a .XML file.");
        } catch (IOException io) {
            System.out.println("It was not possible to export your execution orders to a .XML file.");
        }
    }
}

