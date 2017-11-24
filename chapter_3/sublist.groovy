import java.util.*;

   // create two array list objects       
   List arrlistsrc = new ArrayList();
   List arrlisttarget = new ArrayList();
      
   // populate two lists
   arrlistsrc.add("A");
   arrlistsrc.add("B");
   arrlistsrc.add("C");
   arrlistsrc.add("D");
   arrlistsrc.add("E"); 
      
   arrlisttarget.add("C");
   arrlisttarget.add("D");
   arrlisttarget.add("E");
           
   // check target list in source list
   int index = Collections.indexOfSubList(arrlistsrc, arrlisttarget);
      
   System.out.println("Target list starts at index: "+index);    
