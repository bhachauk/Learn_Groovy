// This program is combines a csv file and xml file without any logical matching and also too many iteration is going on.
// Need to be solved more:P

@Grab('com.xlson.groovycsv:groovycsv:1.1')
import static com.xlson.groovycsv.CsvParser.parseCsv
import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder
def csv="srce.csv"
def read =0
int i=1;
value=[]
out=[]
cont=[]
def map = [:]
def master = [:]
boolean isFirst = true
def input = "attr.xml"
def root = new XmlSlurper().parse(input)
df = new FileReader(csv)
def writer = new StringWriter()
def data = parseCsv(df, readFirstLine: true)
new MarkupBuilder(writer).root {
    data.eachWithIndex { row,id->
        row.values.eachWithIndex{k,idx ->
            if(i<=2){

                value[idx]=(k)

            }else{
                cont[idx]=(k)
                //"Row"(k)
            }
        i=i+1;
        }
    j=value    
    def mp=[value,cont].transpose().collectEntries{ it }
    //print mp
    root.children().each { map=it.attributes()
        //map=it.attributes()
        //mp.putAll(map)
        if(!isFirst){
//            if(read==1){
//                print(mp)
                mp.putAll(map)
                "Row"(mp)
                out[id]=mp
//                read=false
//            }
            //mp.putAll(map)
            //"Row"(mp)
            //out[id]=mp
        }//else{
         //   isFirst=false
        //}
        read++;
    }
    isFirst=false
    //root.children().each { println map = it.attributes()}
    //println (map)
//    mp.putAll(map)
    //if(!isFirst) {
//       "Row"(mp)
//        out[id]=mp;
    //} else {
//        isFirst = false;
    //}
    }
}
def f = new File("result.xml")
println writer.toString()
f.write (writer.toString())
//println (out)

//def input = "attr.xml"

//def root = new XmlSlurper().parse(input)
//def add = new XmlSlurper().parse(f)
//def map = [:]
//root.children().each { map = it.attributes()}
//println (map)
//root.Row.@value = '15' 
//def outputBuilder = new StreamingMarkupBuilder()
//String result = outputBuilder.bind{ mkp.yield root }
//def f = new File("got.xml")
//f.write (result)
//l=m1.intersect(m2).size()
