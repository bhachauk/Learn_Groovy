def xmlFile = "srce.xml"
def exampleXml = new XmlParser().parse(xmlFile)

def personBuilder = new NodeBuilder()

def personNode = personBuilder.person {
    name('Jane')
    lastname('Doe')
    age('42')
}

assert exampleXml.append(personNode)

def writer = new StringWriter()
new XmlNodePrinter(new PrintWriter(writer)).print(exampleXml)
println writer.toString()
