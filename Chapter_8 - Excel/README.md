#### INFO 
:books: Reading Excel file :eyes: sheet by sheet
1. JXL
<pre> It only reads the 'xls' files. Consumes lower memory lib space </pre>
   - [jxl.jar](https://mvnrepository.com/artifact/net.sourceforge.jexcelapi/jxl)
2. APACHE-POI 
<pre> Reads both 'xlsx' and 'xls' files. Consumes more memory for lib space</pre>
   - [poi.jar](https://mvnrepository.com/artifact/org.apache.poi/poi)
   - [poi-excelant.jar](https://mvnrepository.com/artifact/org.apache.poi/poi-excelant)
   - [poi-examples.jar](https://mvnrepository.com/artifact/org.apache.poi/poi-examples)
   - [poi-ooxml.jar](https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-schemas)
   - [poi-ooxml-schemas.jar](https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-schemas)
   - [poi-scratchpad-.jar](https://mvnrepository.com/artifact/org.apache.poi/poi-scratchpad)
   - [xmlbeans-2.3.0.jar](https://mvnrepository.com/artifact/org.apache.xmlbeans/xmlbeans)
   - [commons-collections.jar](https://mvnrepository.com/artifact/org.apache.commons/commons-collections4)
#### Program examples:
1. 1-read-excel.groovy
<pre>
Initiated with the code.
It just read and prints the data of each sheets in excel file.
</pre>
2. 2-excel_study.groovy
<pre>
Helps better than previous. Evolved very much. Some are,
- Closure introduced.
- Access each sheet dynamically
- Access each columns of the sheet dynamically
- Can get Data map of each sheet
- Header enable, disable features.

Example codes shown below ...
</pre>
```groovy
excelstudy{ 
   excelfile "/home/bhanuchander/dude/apps/testdsl/bin/new-poi.xlsx" 
   sheetlist() // returns sheetname list 
   getheader('sheetname') // returns header list 
   getdata('sheetname') // return 2D data with header 
   getdata('sheetname',header=true) // return 2D data with header selection 
   getdata('sheetname',hader=true,[0,1,2,..]) // column filter 
   getdata('sheetname',hader=true,[0,1,2,..]) // column filter 
   getdata('sheetname',["col_1","col_2"]) // column selection 
   getdata ('sheetname', ["col_1",1,2,..]) // support for both string and integer 
   getdatamap('sheetname') // return map 
}
```
