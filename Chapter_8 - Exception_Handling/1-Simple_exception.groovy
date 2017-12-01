//Simple check and throw exception
[1,2,3,4,0,2].each{
	if(it==0) { throw new Exception("Not allowed to pass " + it) }
}
/*
Output:
Caught: java.lang.Exception: Not allowed to pass 0
*/
