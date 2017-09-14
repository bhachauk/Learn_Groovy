import groovy.sql.Sql
def count=0
def i=1
boolean temp=0
boolean join=0
def joinstr=""
def map=[:]
def k=map.keySet()
def v=map.values()

def sql = Sql.newInstance("jdbc:mysql://localhost", "root","password", "com.mysql.jdbc.Driver")

sql.execute("use bc")

new File ('in1.txt').eachLine { String line ->

	if(line.startsWith("OSI Alarm :")){
		count++
		i=1
        temp=1
        if(count==2 ){
        println "Total no of fields:"+k.size()
		sql.execute('CREATE TABLE IF NOT EXISTS bc.alarm ('+k.value[0]+' varchar(255),'+k.value[1]+' varchar(255),'+k.value[2]+' varchar(255),'+k.value[3]+' varchar(255),'+k.value[4]+' varchar(255),'+k.value[5]+' varchar(255),'+k.value[6]+' varchar(255));') 
		println ("table created. loading........")
}

	}
	else if(line!=""&& temp ){
		if(line.endsWith("\"") && line.contains("=") && !join){
		//println line
		//println (line.substring(0, line.lastIndexOf(" =")))	
		//println (line.substring(line.lastIndexOf(" =") + 3).replace(/"/,""))
		map[line.substring(0, line.lastIndexOf(" ="))]= line.substring(line.lastIndexOf(" =") + 3).replace(/"/,"").replace(/'/,"")
		i++
		}
		else if(join){
			join=0
			//println ("join")
			//println line

			//println ("joined")
			line=joinstr+line
			//println line
			map[line.substring(0, line.lastIndexOf(" ="))]= line.substring(line.lastIndexOf(" =") + 3).replace(/"/,"").replace(/'/,"")

			i++
		}
		
		else{

			//println "Error hey :"
			joinstr =line
			//println line
			join=1
		}
		//println line
		//println line
		//println count

	}

	else{
		temp=0
	}
	if(count>1){
	sql.execute("INSERT INTO bc.alarm ("+k.value[0]+","+k.value[1]+", "+k.value[2]+","+k.value[3]+","+k.value[4]+","+k.value[5]+","+k.value[6]+") VALUES ('"+v.value[0]+"', '"+v.value[1]+"', '"+v.value[2]+"', '"+v.value[3]+"','"+v.value[4]+"','"+v.value[5]+"','"+v.value[6]+"');") //println i
}
}
println "line inserted: "+count
println ("line reached...!")
