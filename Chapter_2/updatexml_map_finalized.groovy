@Grab('com.xlson.groovycsv:groovycsv:1.1')
import static com.xlson.groovycsv.CsvParser.parseCsv 
import groovy.xml.StreamingMarkupBuilder
import com.sun.rowset.internal.Row 

def csv="srce.csv" 

df = new FileReader(csv) 

def data = parseCsv(df, readFirstLine: true) 

def csvMap1 = [:]
def csvMap2 = [:]
int i=0;


def input = "attr.xml" 
def root = new XmlSlurper().parse(input)


for (def row : data){
csvMap1[row.values[3]] = row.values[4]
csvMap2[row.values[5]] = row.values[6]

def title1= csvMap1.keySet().value[0]
def title2= csvMap1.values().value[0]

def title3= csvMap2.keySet().value[0]
def title4= csvMap2.values().value[0]

def cont1= csvMap1.keySet().value[i]
def cont2= csvMap1.values().value[i]


def cont3= csvMap2.keySet().value[i]
def cont4= csvMap2.values().value[i]

root.Book.Editions.Edition1.find { it.@"$title1"== "$cont1"}.@"$title2"= "$cont2"
root.Book.Editions.Edition2.find { it.@"$title3"== "$cont3"}.@"$title4"= "$cont4"
i++

}

def outputBuilder = new StreamingMarkupBuilder()
String result = outputBuilder.bind{ mkp.yield root }

def f = new File("result.xml") 

f.write (result) 
