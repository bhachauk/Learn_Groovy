import java.io.File
import java.io.IOException

import jxl.*
import jxl.Workbook
import jxl.Sheet
import jxl.read.biff.BiffException
import jxl.WorkbookSettings

WorkbookSettings wbSettings = new WorkbookSettings()
wbSettings.setSuppressWarnings(true);

Workbook wb = Workbook.getWorkbook(new File("test.xls"));
println wb.getNumberOfSheets()

String [] sheetNames = wb.getSheetNames();
    
for (int sno = 0 ; sno < sheetNames.length ; sno ++ ) {
	
        Sheet sh = wb.getSheet(sno);
		int totalNoOfRows = sh.getRows();
		int totalNoOfCols = sh.getColumns();

		println sheetNames[sno];
		println "rows: " + totalNoOfRows
		println "columns :"+ totalNoOfCols

		for(int i=0;i<totalNoOfRows;i++){
		def column_fields =[]

			for(int j=0;j<totalNoOfCols;j++){

				Cell curr_cell= sh.getCell(j, i);
				column_fields=column_fields.add(curr_cell.getContents())
			}
			println column_fields
		}
}
    
    //Close and free allocated memory 
wb.close(); 
