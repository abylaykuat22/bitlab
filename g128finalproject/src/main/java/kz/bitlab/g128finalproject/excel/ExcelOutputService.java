package kz.bitlab.g128finalproject.excel;

import jakarta.annotation.PostConstruct;
import kz.bitlab.g128finalproject.entity.WorkingFormat;
import kz.bitlab.g128finalproject.service.WorkingFormatService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.List;

@Service
public class ExcelOutputService {

    @Autowired
    private WorkingFormatService workingFormatService;

    @PostConstruct
    public void init() {

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOutputStream = new FileOutputStream("g128.xlsx")) {
            Sheet sheet = workbook.createSheet("Sheet1");

            Row row0 = sheet.createRow(0);
            Cell cell01 = row0.createCell(0);
            cell01.setCellValue("ID");

            Cell cell11 = row0.createCell(1);
            cell11.setCellValue("NAME");

            Cell cell22 = row0.createCell(2);
            cell22.setCellValue("DESCRIPTION");

            List<WorkingFormat> workingFormats = workingFormatService.getAllWorkingFormats();
            for (int i = 0; i < workingFormats.size(); i++) {
                Row row = sheet.createRow(i + 1);
                WorkingFormat wf = workingFormats.get(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(wf.getId());

                Cell cell1 = row.createCell(1);
                cell1.setCellValue(wf.getName());

                Cell cell2 = row.createCell(2);
                cell2.setCellValue(wf.getDescription());
            }
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
