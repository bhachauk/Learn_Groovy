def file1 = new File('file1.txt').readLines() // Source duplicates...

	new File('file2.txt').eachLine{l2 -> // search file ... primary key 

		for (eachline in file1){

			println eachline

			if (eachline.contains(l2)){

				break
			}

	}

	println '----------------'

}
