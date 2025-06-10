package com.utility;



import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static String[] readCities(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1); // Assuming data is in the second row
            Cell fromCityCell = row.getCell(0);
            Cell toCityCell = row.getCell(1);
            String fromCity = fromCityCell.getStringCellValue();
            String toCity = toCityCell.getStringCellValue();
            return new String[]{fromCity, toCity};
        }
    }
}

