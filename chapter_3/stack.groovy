def method (int a, Closure c) {
    Query q = new Query()
    q.a = a
    c.delegate = q
    c.call()
    def str = q.str
    println str
}
class Query
{
    def str
    def a
    void key (String str) {
        this.str = str
        println a
    }
}
method(5) {
    key "got"
}