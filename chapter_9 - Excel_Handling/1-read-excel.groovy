// For file operations 
import java.io.File
import java.io.IOException

// For excel operations 
import jxl.*
import jxl.Workbook
import jxl.Sheet
import jxl.read.biff.BiffException
import jxl.WorkbookSettings

WorkbookSettings wbSettings = new WorkbookSettings()
wbSettings.setSuppressWarnings(true);

// Reading file
Workbook wb = Workbook.getWorkbook(new File("test.xls"));
// Total number of Sheets in file
println "Excel file contains "+wb.getNumberOfSheets()+" Number of Sheets"

String [] sheetNames = wb.getSheetNames();
    
for (int sno = 0 ; sno < sheetNames.length ; sno ++ ) {
	
        Sheet sh = wb.getSheet(sno);
		int totalNoOfRows = sh.getRows();
		int totalNoOfCols = sh.getColumns();

		println "sheetname : "sheetNames[sno];
		println "rows      : " + totalNoOfRows
		println "columns   : "+ totalNoOfCols

		for(int i=0;i<totalNoOfRows;i++){
		def column_fields =[]

			for(int j=0;j<totalNoOfCols;j++){

				Cell curr_cell= sh.getCell(j, i);
				column_fields=column_fields.add(curr_cell.getContents())
			}
			println column_fields
		}
}
wb.close(); 
