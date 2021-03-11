package reusableComponents;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {

	String filePath;
	Sheet sh;

	public ExcelOperations(String sheetName){
		try {
			filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//open file - workbook
		File testDataFile = new File(filePath);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sh = wb.getSheet(sheetName);
	}

	public HashMap<String, String> getTestDataInMap(int rowNum) throws Exception {

		File testDataFile = new File(filePath);
		Workbook wb = WorkbookFactory.create(testDataFile);

		Sheet sh = wb.getSheet("InsurancePremium");

		sh.getRow(0).getCell(1).toString();

		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}	
		return hm;
	}

	//get row count
	public int getRowCount() {		
		return sh.getLastRowNum();
	}

	//ger column count
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();

	}

	/*public static void main(String[] args) throws Exception {
		ExcelOperations e = new ExcelOperations();
		System.out.println(e.getTestDataInMap(2));

	}*/
}
