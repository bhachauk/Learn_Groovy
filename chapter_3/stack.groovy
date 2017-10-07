def method (String a, Closure c) {
    Format f = new Format()
    f.a = a
    c.delegate = f
    c.call()
    def str = f.str
}
class Format
{
    def str
    def a
    void transform (String str, Closure cls) {
        this.str = str
       	Pass p = new Pass()
        p.a=a
        cls.delegate=p
        cls.resolveStrategy = Closure.DELEGATE_FIRST
        cls.call()
        def val=p.a
        println val

    }

    class Pass
    {
    	String a
    } 
}

method("got") {
    transform ("got"){
    	a=a.reverse()
    }
}