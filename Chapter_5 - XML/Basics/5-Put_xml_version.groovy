//--------------------------------------------------------------//
//----------------------Put Xml file version--------------------//
//--------------------------------------------------------------//

void putversion(def filename)
{
	filename=filename.toString()
	def lines= new File (filename).readLines()
	if(!(lines.get(0)).contains('xml version'))
	{
		def cmd = ['sed', '-i', '1 i <?xml version="1.1"?>', filename]
		cmd.execute()
	}

}

//Note : <?xml version="1.1"?> denotes the version tag. will place the tag in first line of xml file.
