@Grab('com.xlson.groovycsv:groovycsv:1.1')
import static com.xlson.groovycsv.CsvParser.parseCsv
import groovy.xml.MarkupBuilder
def csv="srce.csv"
int i=1;
value=[]
df = new FileReader(csv)
def writer = new StringWriter()
def data = parseCsv(df, readFirstLine: true)
new MarkupBuilder(writer).root {
    data.each { row ->
        Row {
            row.values.eachWithIndex { k, idx -> 
 //           	if (i==1){
            		//def value="$value" (k)
 //           		value[idx] =(k)
 //                   return(null)

 //           	}else{
 //                   def j=value[idx]
 //           		"$j" (k)
 //           	}
                	//"$value$idx"(k)                 
             	//}
                while (i==1){
                    //def value="$value" (k)
                    value[idx] =(k)
                    return(null)

                }
                def j=value[idx]
                "$j" (k)
                




            }
        	i=2;
        } 


    }
}

println writer.toString()
