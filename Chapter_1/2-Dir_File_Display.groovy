// This will display all files in the path mentioned.
new File("/home/bhanuchander/Desktop").eachFileRecurse() {file -> 
         println file.getAbsolutePath()
}
