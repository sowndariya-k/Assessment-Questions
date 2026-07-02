package com.Test.Utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;

public class DPExcel {

    public Object[][] getData(String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream("src/test/resources/TestData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }

        wb.close();
        return data;
    }

    @DataProvider(name = "registerData")
    public Object[][] registerData() throws Exception {
        return getData("Sheet1");
    }

    @DataProvider(name = "existingUserData")
    public Object[][] existingUserData() throws Exception {
        return getData("Sheet2");
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws Exception {
        return getData("Sheet3");
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() throws Exception {
        return getData("Sheet4");
    }
}