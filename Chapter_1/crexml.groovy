import groovy.xml.MarkupBuilder
File df = new File("output.csv")
File out = new File("out.xml")

def stringWriter = new StringWriter()
        def my = new MarkupBuilder(stringWriter)
        my.people {

            person {
                firstName('John')
                lastName('Doe')
                age(25)
            }
            person {
                firstName('Jane')
                lastName('Smith')
                age(31)
            }
        }
        def xml = stringWriter.toString()
        
        println xml
