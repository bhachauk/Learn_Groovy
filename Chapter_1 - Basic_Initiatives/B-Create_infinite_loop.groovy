method()
void method()
{
	println "This is going to print Infinite times"
	method()
}
/*
//-----------After Printing N times---------------//
Error:
Caught: java.lang.StackOverflowError
*/
