new File("/home/bhanuchander/Desktop").eachFileRecurse() {
         file -> 
         t= file.getAbsolutePath()
         if (t == '/home/bhanuchander/Desktop/con.py'){
         	println('Gotcha..!')
         }
         
     
     }
