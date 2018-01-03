import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.util.Iterator

import org.apache.poi.hssf.usermodel.*

import org.apache.poi.xssf.usermodel.*


Excel excelstudy (Closure cl) {

        def excel = new Excel()
        cl.delegate = excel
        cl.resolveStrategy = Closure.DELEGATE_FIRST
        cl()
        return excel
    }

class Excel {


	def workbook
	def sheet
	def cell
	def row
	ArrayList<ArrayList<String>> sheetdata =new ArrayList<ArrayList<String>>()
	Map sheetdatamap =[:]

	void init_xls(FileInputStream file)
	{	
		HSSFWorkbook wb = new HSSFWorkbook (file)
		workbook =wb
		HSSFCell c = cell
		HSSFRow r = row
		HSSFSheet sh = sheet

	}

	void init_xlsx(FileInputStream file)
	{
		XSSFWorkbook wb = new XSSFWorkbook (file)
		workbook =wb
		XSSFCell c = cell
		XSSFRow r = row
		XSSFSheet sh = sheet
	}

	void excelfile(String filename)
	{
		FileInputStream file = new FileInputStream(new File(filename))		
		filename.contains('xlsx') ? init_xlsx(file):init_xls(file)
	}

	List sheetlist()
	{
		List<String> sheetNames = new ArrayList<String>()
		for (int i=0; i<workbook.getNumberOfSheets(); i++) {
    		sheetNames.add( workbook.getSheetName(i) )
		}

		return sheetNames
	}

	List getheader (String sheetname)
	{
		
		List<String> header =[]

		row = getsheet(sheetname).getRow(0)

		for(int i=0 ; i < row.getLastCellNum();i++){

			cell = row.getCell(i)
			header[i] = getvalue(cell)

		}
		return header
	}
  
	def getdata(String sheetname, List<String> columns)
	{

		getheader(sheetname).withIndex().each{ col_name, idx ->

			(columns.contains(col_name)) ? columns[columns.findIndexOf{ it == col_name}]=idx: {}

		}
		return getdata(sheetname,true,columns)
	}

	def getdata(String sheetname, boolean header=false,List<Integer> columns=[])
	{
		sheetdata.clear()
		
		int maxlength = 0

		header == true ? maxlength=getheader(sheetname).size() : {}

		for (int i=(header) ? 1 : 0; i< getsheet(sheetname).getPhysicalNumberOfRows(); i++)
		{
			List rowcontent=[]

			for (int j=0; j<getsheet(sheetname).getRow(i).getLastCellNum(); j++ )
			{
				if(!columns.contains(j) && !columns.isEmpty()) {continue}

				cell = getsheet(sheetname).getRow(i).getCell(j)

				rowcontent.add(getvalue(cell).toString())

			}
			maxlength < rowcontent.size() ? maxlength =rowcontent.size() : {}
			sheetdata.add(new ArrayList<>(rowcontent))

		}
		sheetdata.collect{row ->
				row.size()<maxlength ? 1.upto (maxlength-row.size()){ row.add('NULL')} : {}
				row
		}
		return sheetdata
	}

	def getdatamap (String sheetname)
	{
		getdata(sheetname,true).transpose().eachWithIndex { row,idx->

			sheetdatamap[getheader(sheetname)[idx]]=row
		}
		return sheetdatamap
	}


	Closure getsheet={

		sheet = workbook.getSheet(it)
		return sheet
	}

	Closure getvalue={
		if (it == null)
		{ 
			it="NULL" 
		}
		else{

			switch (it.getCellType()) 
			{
        case cell.CELL_TYPE_BOOLEAN:
		    it = it.getBooleanCellValue();
        break;
				case cell.CELL_TYPE_NUMERIC:
				it = it.getNumericCellValue();
 				break;
 				case cell.CELL_TYPE_STRING:
 				it = it.getStringCellValue();
     		break;
 				case cell.CELL_TYPE_BLANK:
  			it = " ";
    		break;
				default:
    		break;
        	}
        }
	}
}
