package creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
   public static void main( String[] args )
   {	
	   
	   Scanner scan = new Scanner(System.in);
	   System.out.print("Mod name: ");
	   String mod = scan.nextLine();
	   System.out.print("Mod id: ");
	   String modId = scan.nextLine();
	   System.out.print("Item name: ");
	   String item = scan.nextLine();
	   scan.close();
	   

	  String dir = mod + "/src/main/resources/assets/" + modId + "/models/item/" + item + ".json";
	  

	  
	   
      try {

	     File modelItem = new File(dir);
	     /*If file gets created then the createNewFile() 
	      * method would return true or if the file is 
	      * already present it would return false
	      */


             boolean fvar = modelItem.createNewFile();
	     if (fvar){
	    	 
	    
	    	 
	    	 String json = "{\r\n" + 
		    	 		"   \"parent\": \"item/generated\",\r\n" + 
		    	 		"   \"textures\": {\r\n" + 
		    	 		"       \"layer0\": \"" + modId + ":items/" + item + "\"\r\n" + 
		    	 		"   }\r\n" + 
		    	 		"}";
	    	 
	    	 
	    	 
	    	 BufferedWriter jsonWrite = new BufferedWriter(new FileWriter(dir, true));
	    	 jsonWrite.append(json);
	    	 jsonWrite.close();
	    	 
	    
	    	 
	    	 
	    	 
	    	 
	          System.out.println("File has been created successfully");
	     }
	     else{
	          System.out.println("Files already present at the location");
	     }
    	} catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
	  }
    
   }
}