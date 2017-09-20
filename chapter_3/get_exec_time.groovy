import groovy.time.*

def timeStart = new Date()
import groovy.sql.Sql
import groovy.sql.GroovyRowResult
def temp=""
def c=0

def sql = Sql.newInstance("jdbc:mysql://localhost", "root","password", "com.mysql.jdbc.Driver")

sql.execute("use tellabs")
//sql.execute("alter table alarm add var varchar(200);")
sql.rows("select MO_Position from alarm").each{ it.each {k,v->
	if (v.contains("Port")){
		//println temp=v
	}else if(v.contains("slot")|v.contains("Slot")|v.contains("In")|v.contains("rackR1")){
		//v=v.toLowerCase()
		//println v
	temp=v.replace("Rack ","1_/rack=").replace(" Subrack ","/subrack=").replace(" Slot ","/slot=").replace("rackR1 ","1_/rack=").replace(" subrack ","/subrack=").replace(" slot ","/slot=").replace("rack ","1_rack/").replace(" subrackR2 ","/subrack=")
	temp.tokenize(" ").value[0]
	//sql.execute("update alarm set inv='"+temp.tokenize(" ").value[0]+"' where MO_Position='"+v+"'")
	}
	else{
		if(v.matches(".*[a-zA-Z].*")){
			//println temp=v
		}else{
			if(v != null && v!= ""){
			 temp=v.tokenize('-')
		temp= '/rack='+temp.value[0]+'/shelf='+temp.value[1]+'/slot='+temp.value[2]+'/port='+temp.value[3]
		println c
		//sql.execute("update alarm set inv='"+temp+"' where MO_Position='"+v+"'")
		c++
		}
	}
		//println temp=v
	}
	//println it

}
}
// Some code you want to time
def timeStop = new Date()
TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
println duration
println "line inserted: "+c
println ("line reached...!")
