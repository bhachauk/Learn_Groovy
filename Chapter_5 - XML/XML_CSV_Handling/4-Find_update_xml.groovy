@Grab('com.xlson.groovycsv:groovycsv:1.1')
import static com.xlson.groovycsv.CsvParser.parseCsv 
import groovy.xml.StreamingMarkupBuilder
import com.sun.rowset.internal.Row 

def csv="child.csv" 
df = new FileReader(csv) 

def data = parseCsv(df, readFirstLine: true) 

def input = "attr.xml"
def Model = new XmlSlurper().parse(input)


for (def row : data){

def cont1= row.values[0]
def cont2= row.values[1]
def cont3= row.values[2]

if(row.values[2].size() != 0 ) {

Model.TYPE.find { it.@name== "$cont1"}.SUBTYPE.find {it.@name== "$cont2"}.@displayLabel= "$cont3"

}

}

def outputBuilder = new StreamingMarkupBuilder()
String result = outputBuilder.bind { mkp.yield Model }

def f = new File("final_result.xml") 
f.write (result) 
