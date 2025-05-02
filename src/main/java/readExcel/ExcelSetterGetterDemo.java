package readExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelSetterGetterDemo {
    private String validPass;
    private String invalidPass;

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

    public static void main(String[] args) throws IOException {
        ExcelSetterGetterDemo data=new ExcelSetterGetterDemo();
        Workbook wk = null;
        Map<String, String> map = null;
        try {
            wk = new XSSFWorkbook(new FileInputStream("resource/PassData.xlsx"));
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
                System.out.println(entry.getKey() + " - " + entry.getValue());
                if (entry.getKey().equals("validPass")) {
                    System.out.println("***** " + entry.getValue());
                    data.setValidPass(entry.getValue());
                }
                if (entry.getKey().equals("invalidPass")) {
                    System.out.println("**** " + entry.getValue());
                    data.setInvalidPass(entry.getValue());
                }
            }

            System.out.println(data.getInvalidPass());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            wk.close();
        }
    }
}
