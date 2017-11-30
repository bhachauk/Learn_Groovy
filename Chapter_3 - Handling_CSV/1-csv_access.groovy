@Grab('com.xlson.groovycsv:groovycsv:1.1')
import static com.xlson.groovycsv.CsvParser.parseCsv
def csv1="output.csv"
df = new FileReader(csv1)
def stringWriter = new StringWriter()
for (line in parseCsv (df))
{	
	println "$line.Title $line.Author $line.Genre"
}
