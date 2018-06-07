##### Closure delegation strategies

Ref : [link](#https://stackoverflow.com/questions/47994435/groovy-closure-delegate-only-and-delegate-first-strategy-not-working)

```groovy
groovy -e 'def x=12; def y=10; def data = [ x: 10, y: 20 ]; def cl ={x,y=16-> y=x+y}; cl.delegate=new A(); cl.resolveStrategy = Closure.DELEGATE_ONLY; println cl.call(1); class A { def x = 1; def y = 2}'
```
