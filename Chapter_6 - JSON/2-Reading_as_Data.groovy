import groovy.json.*

Json jsonstudy (Closure cl) {

        def json = new Json()
        cl.delegate = json
        cl.resolveStrategy = Closure.DELEGATE_FIRST
        cl()
        return json
    }

class Json {

	def json
	def row

	void jsonfile (String filename)
	{
		json = new JsonSlurper().parse(new File (filename))
	}

	ArrayList collectkeys (String rowpath)
	{
		def keys = jpath(json,rowpath)*.keySet().flatten().unique()
		return keys.collect { c -> encode( c ) }
	}

	def collectvalues(String rowpath)
	{
		return jpath(json,rowpath).collect { row ->
    	header(rowpath).collect { colName -> encode( row[ colName ] ) } }//.join( '\n' )
	}

	def datamap (def columns)
	{
		def datamap =[:]
		columns.each{

			datamap[it.tokenize('.').last()]=jpath(json,it)

		}
		return datamap
	}

	def dataheader (def columns)
	{
		return datamap(columns).keySet()
	}

	ArrayList data2d (def columns)
	{
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<String>>()

		datamap(columns).each{k,v ->

			data << v			
		}

		return data.transpose()
	}


	def jpath (def json, String rowpath)
	{
		rowpath.tokenize('.').inject(json){ j,str -> j."$str"}
	}

	def encode = { e -> e == null ? '' : e instanceof String ? /"$e"/ : "$e" }

}
