package g145.g145market.service;

import com.github.pjfanning.xlsx.StreamingReader;
import g145.g145market.dto.CategoryResponse;
import g145.g145market.entity.Category;
import g145.g145market.repository.CategoryRepository;
import g145.g145market.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Excel2Service {
    private final CategoryRepository categoryRepository;
    private final DocumentRepository documentRepository;

    public ByteArrayInputStream exportCategories(){
        List<Category> categoryResponses  = categoryRepository.findAll();
        if(categoryResponses.isEmpty()){
            throw new IllegalArgumentException("Category can not be null");
        }
        try(SXSSFWorkbook workbook = new SXSSFWorkbook();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){

            Sheet sheet = workbook.createSheet("Categories");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("NAME_KZ");
            header.createCell(2).setCellValue("NAME_RU");
            header.createCell(3).setCellValue("NAME_EU");
            header.createCell(4).setCellValue("CODE");
            header.createCell(5).setCellValue("CREATED_AT");

            int rowNum = 1;
            for(Category categoryResponse: categoryResponses){
                Row row = sheet.createRow(rowNum);
                row.createCell(0).setCellValue(categoryResponse.getId());
                row.createCell(1).setCellValue(categoryResponse.getNameKz());
                row.createCell(2).setCellValue(categoryResponse.getNameRu());
                row.createCell(3).setCellValue(categoryResponse.getNameEn());
                row.createCell(4).setCellValue(categoryResponse.getCode());
                row.createCell(5).setCellValue(categoryResponse.getCreatedAt());
                rowNum++;
            }
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    public List<CategoryResponse> importCategories(MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            return Collections.emptyList();
        }
        try (InputStream inputStream = multipartFile.getInputStream();
             Workbook workbook = openWorkbook(inputStream)) {
             List<CategoryResponse> categoryResponses = new ArrayList<>();
                Sheet sheet = workbook.getSheet("Categories");
                for (Row row: sheet){
                    if(row.getRowNum() == 0){
                        continue;
                    }
                    CategoryResponse response = CategoryResponse.builder()
                            .nameKz(row.getCell(0).getStringCellValue())
                            .nameRu(row.getCell(1).getStringCellValue())
                            .nameEn(row.getCell(2).getStringCellValue())
                            .code(row.getCell(3).getStringCellValue())
                            .build();
                    categoryResponses.add(response);
                }
                return categoryResponses;

        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
    private Workbook openWorkbook (InputStream inputStream){
        return StreamingReader.builder()
                .rowCacheSize(100)
                .bufferSize(4096)
                .open(inputStream);

    }
}
