package testcases;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelData {

    private String validPass;
    private String invalidPass;
    private String shortPass;
    private String consecutivePass;

    public String getShortPass() {
        return shortPass;
    }

    public void setShortPass(String shortPass) {
        this.shortPass = shortPass;
    }

    public String getConsecutivePass() {
        return consecutivePass;
    }

    public void setConsecutivePass(String consecutivePass) {
        this.consecutivePass = consecutivePass;
    }

    public String getValidPass() {
        return validPass;
    }

    public void setValidPass(String validPass) {
        this.validPass = validPass;
    }

    public String getInvalidPass() {
        return invalidPass;
    }

    public void setInvalidPass(String invalidPass) {
        this.invalidPass = invalidPass;
    }

    @DataProvider(name = "excel_data")
    public static Object[][] getExcelData() throws IOException {

        ExcelData data = new ExcelData();

        Workbook wk = null;
        Map<String, String> map;
        try {
            wk = new XSSFWorkbook(new FileInputStream(ObjectRepository.excelPath));
            Sheet sheet = wk.getSheet("Sheet1");
            map = new HashMap<>();
            for (Row row : sheet) {
                Cell keyCell = row.getCell(0);
                Cell valueCell = row.getCell(1);
                if (keyCell != null && valueCell != null) {
                    String key = keyCell.getStringCellValue();
                    String value = valueCell.getStringCellValue();
                    map.put(key, value);
                }
            }

            for (Map.Entry<String, String> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + " - " + entry.getValue());
                if (entry.getKey().equals("validPass")) {
                    System.out.println("valid_pass : " + entry.getValue());
                    data.setValidPass(entry.getValue());
                }
                if (entry.getKey().equals("invalidPass")) {
                    System.out.println("Invalid_Pass : " + entry.getValue());
                    data.setInvalidPass(entry.getValue());
                }
                if(entry.getKey().equals("shortPass")){
                    data.setShortPass(entry.getValue());
                }
                if(entry.getKey().equals("consecutivePass")){
                    data.setConsecutivePass(entry.getValue());
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(wk!=null){
                wk.close();
            }
        }

//     Object[][] testData={{data}};
        return new Object[][]{{data}};
//return testData;

    }
}
