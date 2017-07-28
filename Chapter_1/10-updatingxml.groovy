import groovy.xml.StreamingMarkupBuilder

def input = "srce.xml"

def root = new XmlSlurper().parse(input)

root.Row.@value = '15' 

def outputBuilder = new StreamingMarkupBuilder()
String result = outputBuilder.bind{ mkp.yield root }

println result

def f = new File("got.xml")
f.write (result)
