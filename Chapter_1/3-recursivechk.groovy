// As same as Previous code
new File("/home/bhanuchander/Desktop").eachFileRecurse() {
         file -> 
         t= file.getAbsolutePath()
         //Using if loop to check a file
         if (t == '/home/mydir_path/file.filetype'){
                  //If yor file exists `Gotcha..!' will print
         	println('Gotcha..!')
         }
         
     
     }
