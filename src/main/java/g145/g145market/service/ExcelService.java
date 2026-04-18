package g145.g145market.service;

import com.github.pjfanning.xlsx.StreamingReader;
import g145.g145market.dto.CategoryResponse;
import g145.g145market.dto.UserResponse;
import g145.g145market.entity.Category;
import g145.g145market.entity.Document;
import g145.g145market.entity.User;
import g145.g145market.repository.CategoryRepository;
import g145.g145market.repository.DocumentRepository;
import g145.g145market.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
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
public class ExcelService {

    private final UserRepository userRepository;
    private final DocumentRepository documentRepository;
    private final CategoryRepository categoryRepository;

    public ByteArrayInputStream exportUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new IllegalArgumentException("Users cannot be empty");
        }

        try (SXSSFWorkbook workbook = new SXSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Users");

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);

            CellStyle textStyle = workbook.createCellStyle();
            textStyle.setBorderBottom(BorderStyle.THIN);
            textStyle.setBorderTop(BorderStyle.THIN);
            textStyle.setBorderLeft(BorderStyle.THIN);
            textStyle.setBorderRight(BorderStyle.THIN);
            textStyle.setAlignment(HorizontalAlignment.LEFT);

            Row header = sheet.createRow(0);
            Cell headerCell = header.createCell(0);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue("Id");
            Cell nameCell = header.createCell(1);
            nameCell.setCellStyle(headerStyle);
            nameCell.setCellValue("Name");

            Cell headerBirthDateCell = header.createCell(2);
            headerBirthDateCell.setCellStyle(headerStyle);
            headerBirthDateCell.setCellValue("Birth Date");

            Cell headerPhoneCell = header.createCell(3);
            headerPhoneCell.setCellStyle(headerStyle);
            headerPhoneCell.setCellValue("Phone Number");

            Cell headerEmailCell = header.createCell(4);
            headerEmailCell.setCellStyle(headerStyle);
            headerEmailCell.setCellValue("Email");

            Cell headerAddressCell = header.createCell(5);
            headerAddressCell.setCellStyle(headerStyle);
            headerAddressCell.setCellValue("Address");

            Cell headerCityCell = header.createCell(6);
            headerCityCell.setCellStyle(headerStyle);
            headerCityCell.setCellValue("City");

            int rowNum = 1;
            for (User user : users) {
                Row row = sheet.createRow(rowNum);
                Cell idCell = row.createCell(0);
                idCell.setCellStyle(textStyle);
                idCell.setCellValue(user.getId());

                Cell fullNameCell = row.createCell(1);
                fullNameCell.setCellStyle(textStyle);
                fullNameCell.setCellValue(user.getFullName());

                Cell birthdateCell = row.createCell(2);
                birthdateCell.setCellStyle(textStyle);
                birthdateCell.setCellValue(user.getBirthdate());

                Cell emailCell = row.createCell(3);
                emailCell.setCellStyle(textStyle);
                emailCell.setCellValue(user.getEmail());

                Cell phoneCell = row.createCell(4);
                phoneCell.setCellStyle(textStyle);
                phoneCell.setCellValue(user.getPhoneNumber());

                Cell addressCell = row.createCell(5);
                addressCell.setCellStyle(textStyle);
                addressCell.setCellValue(user.getAddress());

                Cell creationDateCell = row.createCell(6);
                creationDateCell.setCellStyle(textStyle);
                creationDateCell.setCellValue(user.getCreatedAt());

                rowNum++;
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<UserResponse> importUsers(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return Collections.emptyList();
        }

        try (InputStream inputStream = file.getInputStream();
            Workbook workbook = openWorkbook(inputStream)) {

            Document document = Document.builder()
                    .fileName(file.getOriginalFilename())
                    .content(file.getBytes())
                    .type("xlsx")
                    .build();
            documentRepository.save(document);

            List<UserResponse> userResponses = new ArrayList<>();

            Sheet sheet = workbook.getSheet("Users");
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }

                UserResponse response = UserResponse.builder()
                        .fullName(row.getCell(0).getStringCellValue())
                        .dateOfBirth(row.getCell(1).getStringCellValue())
                        .number(row.getCell(2).getStringCellValue())
                        .email(row.getCell(3).getStringCellValue())
                        .address(row.getCell(4).getStringCellValue())
                        .build();

                userResponses.add(response);
            }

            return userResponses;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Workbook openWorkbook(InputStream inputStream) {
        return StreamingReader.builder()
                .rowCacheSize(100)
                .bufferSize(4096)
                .open(inputStream);
    }

}
