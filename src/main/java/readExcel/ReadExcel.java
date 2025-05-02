package readExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    public static void main(String... arg) throws IOException {
        XSSFWorkbook wk = null;
        try {
            wk = new XSSFWorkbook(new FileInputStream("resource/PassData.xlsx"));
            XSSFSheet sheet = wk.getSheet("Sheet1");
//            XSSFRow totalRow=sheet.getRow(1);

            int totalRow = sheet.getLastRowNum();
            System.out.println("Total Rows: " + totalRow);

            for (int i = 0; i < totalRow; i++) {
                XSSFRow row = sheet.getRow(i);
                int totalColumn = row.getLastCellNum();
                System.out.println(totalColumn);
                for (int j = 0; j < totalColumn; j++) {
                    Cell cell = row.getCell(j);
                    if (cell.getCellType() == CellType.NUMERIC) {
                        double value = cell.getNumericCellValue();
                        System.out.println(value);
                    }
                    if (cell.getCellType() == CellType.STRING) {
                        String value = cell.getStringCellValue();
                        System.out.println(value);
                    }

                }


            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            wk.close();
        }
    }
}
