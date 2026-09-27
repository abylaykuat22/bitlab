package kz.bitlab.g128finalproject.excel;

import jakarta.annotation.PostConstruct;
import kz.bitlab.g128finalproject.entity.Developer;
import kz.bitlab.g128finalproject.entity.ProgrammingLanguage;
import kz.bitlab.g128finalproject.entity.WorkingFormat;
import kz.bitlab.g128finalproject.service.DeveloperService;
import kz.bitlab.g128finalproject.service.ProgrammingLanguageService;
import kz.bitlab.g128finalproject.service.WorkingFormatService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class ExcelInputService {

    @Autowired
    private DeveloperService developerService;
    @Autowired
    private ProgrammingLanguageService programmingLanguageService;
    @Autowired
    private WorkingFormatService workingFormatService;

    @PostConstruct
    public void init() {

        try (FileInputStream fileInputStream = new FileInputStream("developers.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheet("Sheet1");
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                Long programmingLanguageId = (long) row.getCell(3).getNumericCellValue();
                ProgrammingLanguage programmingLanguage = programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);

                Long workingFormatId = (long) row.getCell(4).getNumericCellValue();
                WorkingFormat workingFormat = workingFormatService.getWorkingFormatById(workingFormatId);

                Developer developer = Developer.builder()
                        .name(row.getCell(0).getStringCellValue())
                        .age((int) row.getCell(1).getNumericCellValue())
                        .salary(row.getCell(2).getNumericCellValue())
                        .programmingLanguage(programmingLanguage)
                        .workingFormat(workingFormat)
                        .build();
                developerService.addDeveloperFromExcel(developer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
