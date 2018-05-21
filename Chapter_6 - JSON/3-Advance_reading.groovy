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
	String rowpath
	List columnlist =[]
	List rowdata =[]

	ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<String>>()

	def jpath (def json, String rowpath)
	{
		rowpath.tokenize('.').inject(json){ j,str -> j."$str"}
	}

	void jsonfile (String filename)
	{
		json = new JsonSlurper().parse(new File (filename))
	}

	void row(String row)
	{
		rowpath=row
	}

	List column (String... columns)
	{
       for (String eachpath : columns){

            columnlist.add (eachpath)
        }
        return columnlist
	}

	List result (Closure closure)
	{

		jpath(json,rowpath).each{ row ->

			rowdata.clear()

			columnlist.each{ node ->

			if(node.contains(rowpath)){

				node=node.minus(rowpath+'.')

				jpath(row,node)!=null ? rowdata << jpath(row,node) : {}

				//jpath(row,node)!=null ? jpath(row,node).each{ rowdata << it} : {}

			}else{

				jpath(row,node)!=null ? rowdata << jpath(row,node) : {}
			}

		}

        def acc_row = new Access_row()
        closure.delegate = acc_row
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.call(rowdata)        

		}
		return data
	}

	class Access_row
    {
        void printraw(String sep='|')
        {
            print '\n'
            rowdata.each{
                print it+sep
            }
        }
        void collectdata()
        {
			!rowdata.isEmpty() ? data.add(new ArrayList<>(rowdata)) : {}
        }

    }
}

//--------------------Calling functions----------------

jsonstudy{	 
	jsonfile "file.json"
	row "Row_to_each"
	column "col_1","col_2",....,"col_n"
	def 2ddata=result(){
    collectdata()
  }
}
