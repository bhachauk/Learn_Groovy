// Date format settings
String startDate='1_2_2017'
String endDate='4_2_2017'

Date sdate = Date.parse( 'dd_mm_yyyy', startDate )
Date edate = Date.parse( 'dd_mm_yyyy', endDate )


 (sdate..edate).each{ it ->
 
String curr_date=it.format('dd_mm_yyyy')
print curr_date
}

//------------------------------------------------
// Go to the nth of the date.

Date future_of(Date current,int a)
{
  1.upto(a)
	 {
		  current=current.next()	
	 }
	 return current
}

println future_of(sdate,10)
