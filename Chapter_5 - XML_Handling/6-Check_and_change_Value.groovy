// Imported for pretty printing the xmlfile
import groovy.xml.XmlUtil


String xmlfile ='''<?xml version="1.0" encoding="UTF-8"?>
<breakfast_menu>
<food>
<name>Belgian Waffles</name>
<price name="dollars" mode="online">5.95</price>
<description>
Two of our famous Belgian Waffles with plenty of real maple syrup
</description>
<calories>650</calories>
</food>
</breakfast_menu>'''

// parsing xmlfile
def root = new XmlSlurper().parseText(xmlfile)

// Find and change/add values in one line
root.food.price.find{ it["@name"] =="dollars"}.@ "mode"='offline'

// Pretty printing the xml file
println (XmlUtil.serialize(root))
