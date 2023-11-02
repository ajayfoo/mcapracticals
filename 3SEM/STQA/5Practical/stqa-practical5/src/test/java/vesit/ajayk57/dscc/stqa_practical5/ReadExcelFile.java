package vesit.ajayk57.dscc.stqa_practical5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	final XSSFWorkbook workBook;
	final XSSFSheet sheet;

	public ReadExcelFile(final String excelfilePathStr, final int sheetNum) throws IOException {
		final File excelFile = new File(excelfilePathStr);
		final FileInputStream stream = new FileInputStream(excelFile);
		workBook = new XSSFWorkbook(stream);
		sheet = workBook.getSheetAt(sheetNum);
	}

	public String getData(int row, int column) {
		return sheet.getRow(row).getCell(column).getStringCellValue();
	}

	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows() - 1;
	}
}