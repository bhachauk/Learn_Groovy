// Init_ Reading xml file
// XmlSlurper or XmlParser both works
def root

// Method_1 :       
root = new XmlSlurper().parse(new File(filename))

// Method_2 :
root = new XmlSlurper().parseText(new File(filename).getText())

//Method_3 :
def xmltext = '''
    <list>
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
'''
root = new XmlSlurper().parseText(xmltext)
