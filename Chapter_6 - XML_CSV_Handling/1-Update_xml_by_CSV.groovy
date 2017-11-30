@Grab('com.xlson.groovycsv:groovycsv:1.1')
import static com.xlson.groovycsv.CsvParser.parseCsv
import groovy.xml.MarkupBuilder
def csv="srce.csv"
int i=1;
value=[]
out=[]
cont=[]
att=("att")
id="id"
df = new FileReader(csv)
def writer = new StringWriter()
def data = parseCsv(df, readFirstLine: true)
new MarkupBuilder(writer).root {
    data.eachWithIndex { row,id->
        row.values.eachWithIndex{k,idx ->
            if(i<=3){                 // Indicate No of Columns
                value[idx]=(k)
            }else{
                cont[idx]=(k)
            }
        i=i+1;
        }
    j=value    
    def mp=[value,cont].transpose().collectEntries { it }
    "Row"(mp)
    }
}
def f = new File("attr.xml") // Updated new file created in current directory.
println writer.toString()
f.write (writer.toString())
