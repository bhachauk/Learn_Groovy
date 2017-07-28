@Grab('com.xlson.groovycsv:groovycsv:1.1')
import static com.xlson.groovycsv.CsvParser.parseCsv
import groovy.xml.MarkupBuilder
def csv="srce1.csv"
int i=1;
value=[]
out=[]
cont=[]
att=("att")
id="id"
boolean isFirst = true
df = new FileReader(csv)
def writer = new StringWriter()
def data = parseCsv(df, readFirstLine: true)
new MarkupBuilder(writer).root {
    data.eachWithIndex { row,id->
        row.values.eachWithIndex{k,idx ->
            if(i<=5){

                value[idx]=(k)

            }else{
                cont[idx]=(k)
                //"Row"(k)
            }
        i=i+1;
        }
    j=value  
    //println(cont)  
    def mp=[value,cont].transpose().collectEntries{it}
    println(mp.take(3))
    //def mp1=[value,cont].transpose().collectEntries { if{it >3 }}    
    if(!isFirst) {
        "Row"(mp.take(3)){
            "child"(mp.drop(3))

        }
        
    } else {
        isFirst = false;
    }
    }
}
def f = new File("attr.xml")
println writer.toString()
f.write (writer.toString())
