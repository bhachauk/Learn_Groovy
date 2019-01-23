void rectangle(int length, int width, Closure cl)
{
    Rectangle r = new Rectangle(length,width)
    cl.delegate = r
    cl()
}
class Rectangle{
    int l
    int w
    Rectangle(int len, int wid)
    {
        l=len
        w=wid
    }
    int area()
    {
        return l*w
    }
    int perimeter()
    {
        return (2*(l+w))
    }
    int diagonal()
    {
        return Math.sqrt((l*l)+(w*w))
    }
}

rectangle(4,3){
    println area()
    println perimeter()
    println diagonal()
}