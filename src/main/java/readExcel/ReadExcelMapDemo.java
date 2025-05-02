package readExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcelMapDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("resource/PassData.xlsx");
        readFile(file);
    }

    public static void readFile(FileInputStream file) throws IOException {
        Workbook wk = null;
        Map<String, String> map = null;
        try {
            wk = new XSSFWorkbook(file);
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
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            wk.close();
        }

//        return (HashMap<String, String>) map.entrySet();

    }

}