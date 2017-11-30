// Init_ Reading xml file

def root

// Method_1 :       
root = new XmlSlurper().parse(new File(filename))

// Method_2 :
root = new XmlSlurper().parseText(versiontag.toString()+new File(filename).getText())
