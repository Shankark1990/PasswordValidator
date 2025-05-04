package testcases;

import Utils.Actions;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PassValidatorDemo extends BaseClass {

    @Test(dataProvider = "excel_data")
    public void test(String password, String expectedMsg) {
        Actions.enterText(driver, password);
        Actions.eleClcik(driver);
        String actualErrorMsg = driver.findElement(By.xpath(ObjectRepository.errorMessage_xpath)).getText();
        Assert.assertEquals(expectedMsg, actualErrorMsg);
    }

    @DataProvider(name = "excel_data")
    public static Object[][] getExcelData() throws IOException {
        Workbook wk = null;
        Object[][] excelData = null;
        try {
            wk = new XSSFWorkbook(new FileInputStream(ObjectRepository.excelPath));
            Sheet sheet = wk.getSheet("Sheet2");
            int totalRows = sheet.getLastRowNum();
            int column = 2;
            excelData = new Object[totalRows][column];
            for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                String column1Value = row.getCell(0).getStringCellValue();
                System.out.println(column1Value);
                String column2Value = row.getCell(1).getStringCellValue();
                System.out.println(column2Value);

                excelData[rowIndex - 1][0] = column1Value;
                excelData[rowIndex - 1][1] = column2Value;


//                String column3Value = row.getCell(2).getStringCellValue();
//                System.out.println(column3Value);

/*
                if(column1Value.equals("YES")) {
                    String column2Value = row.getCell(1).getStringCellValue();
                    String column3Value = row.getCell(2).getStringCellValue();
                    excelData[rowIndex - 1][0] = column1Value;
                    excelData[rowIndex - 1][1] = column2Value;
                    excelData[rowIndex - 1][2] = column3Value;
                }
*/
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (wk != null) {
                wk.close();
            }
        }

        return excelData;
    }

}
