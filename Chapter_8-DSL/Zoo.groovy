Animals animals(Closure cl)
{
	Animals als = new Animals()
	cl.delegate = als 
	cl()
	als
}

class Animals
{
	ArrayList<Animal> register = new ArrayList<Animal>()

	void addAnimal (String name, Integer age)
	{
    	Animal newAni = new Animal(name, age)
    	register << newAni 
	}

	void showRegister()
	{
    	println "Animals Details :"
		println "--------------------------"
    	        	
    	register.each { s ->
        	println "Animal Name    : $s.name"
        	println "Animal Age     : $s.age"
    		println "--------------------------"
    	}
	}
}

class Animal
{
    String name
    Integer age
    
    Animal(String name, Integer age)
    {
        this.name = name 
        this.age = age 
    }
}
// Source Code ends. Now start to use DSL Syntax.

def groupA = animals {
		addAnimal ("Richard Parker", 17)
		addAnimal ("Wolverine", 50)
	}

groupA.showRegister()
