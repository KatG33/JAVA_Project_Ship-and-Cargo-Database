import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;


public class questionTwoPartTwo {
	
	public static void main(String[] args)
	{
		String[] names = {"Nelra", "Natsirt", "Divad"};
		String filePathNelra = getUserInputPath(names[0]);
		int[] sizeColRowNelra = getRowCol(filePathNelra);
		Ship[] dataNelraCSV = readCSV(filePathNelra, sizeColRowNelra);
		
		String filePathNatsir = getUserInputPath(names[1]);
		int[] sizeColRowNatsir = getRowCol(filePathNatsir);
		Ship[] dataNatsirCSV = readCSV(filePathNatsir, sizeColRowNatsir); 
		
		String filePathDivad = getUserInputPath(names[2]);
		int[] sizeColRowDivad = getRowCol(filePathNatsir);
		Ship[] dataDivadCSV = readCSV(filePathDivad, sizeColRowDivad); 
		toPrintDataArr(dataNelraCSV);
		toPrintDataArr(dataNatsirCSV);
		toPrintDataArr(dataDivadCSV);
		arrayBubbleSort(dataNelraCSV);
		arrayBubbleSort(dataNatsirCSV);
		arrayBubbleSort(dataDivadCSV);
		System.out.println("\n");
		toPrintDataArr(dataNelraCSV);
		toPrintDataArr(dataNatsirCSV);
		toPrintDataArr(dataDivadCSV);
		totalCompanyCap(dataNelraCSV, dataNatsirCSV, dataDivadCSV);
		
	}
	
	//getUserInputPath prompts the user to enter the path to the .csv file and stores it.
	public static String getUserInputPath(String names)
	{
		System.out.println("Please, enter the path to the .csv file for " + names + " : ");
	    Scanner sc = new Scanner(System.in);
	    String filePath = sc.nextLine();
		return filePath;
	}

	//an array that reads through .csv file and stores info about amount of columns and rows in an array
	//Part of this method is taken from PDI lectures
	public static int[] getRowCol(String filePath)
	{
	    //creating variables necessary to read the CSV file
	    FileInputStream fileStream = null;
		InputStreamReader rdr;
		BufferedReader bufRdr;
		int rowNum = 0;
		String line;
		String[] splitLine = null;
	    int colNum = 0;
	    /*initializing the array where information about size of the CSV file will be stored */
	    int[] size = new int[2];
	    try
	    {
	        //providing the address of a file for stream Object, scanned and stored as inputFilePath
	        fileStream = new FileInputStream(filePath);
			//creating an Object that will read the stream
	        rdr = new InputStreamReader(fileStream);
	        //Initializing buffer reader to read line each
			bufRdr = new BufferedReader(rdr);
			line = bufRdr.readLine();
	        //creating while loop with purpose of going through each line
	        //as long as it is not empty
			do 
			{
				//using rowNum to count amount of rows
	            
				line = bufRdr.readLine();
	            //array splitLine is getting filled with values, separated by comma  
	            try
	            {
	                splitLine = line.split(",");
	            }
	            catch(NullPointerException nullPointer) 
	            {  }
	            rowNum++;
	            //storing the information about size of CSV file
	            //in the size array
	            colNum = splitLine.length;    
	            size[0] = rowNum;
	            size[1] = colNum;
			}
			while(line != null);
		}
	    catch(IOException ex1)
	    {
	        System.out.println("Error in reading a file, exception is thrown.\nPlease, check the file path entered.");
	    }        
	    //returning the size of the CSV file; 
	    return size;
	}

	//This is method that stores .csv file as an array of Objects made of Classes Ship and CargoCapacity
	public static Ship[] readCSV(String filePath, int[] sizeColRow)
	{
		//creating variables necessary to read the CSV file
		Ship[] shipObj = new Ship [sizeColRow[0]];
	    FileInputStream fileStream = null;
		InputStreamReader rdr;
		BufferedReader bufRdr;
		int rowNum = 0;
		String line;
		String[] splitLine = null;
	    /*initializing the array where information about size of the CSV file will be stored */
	    int[] size = new int[2];
	    try
	    {
	        //providing the address of a file for stream Object, scanned and stored as inputFilePath
	        fileStream = new FileInputStream(filePath);
			//creating an Object that will read the stream
	        rdr = new InputStreamReader(fileStream);
	        //Initializing buffer reader to read line each
			bufRdr = new BufferedReader(rdr);
	        //creating while loop with purpose of going through each line
	        //as long as it is not empty
			do
			{
				line = bufRdr.readLine();
	            //array splitLine is getting filled with values, separated by comma  
	            try
	            {
	                splitLine = line.split(",");
	                CargoCapacity cargo = new CargoCapacity();
	                int year = Integer.parseInt(splitLine[3]);
	                double widthCargo = Double.parseDouble(splitLine[5]);
	                double lengthCargo = Double.parseDouble(splitLine[6]);
	                double heightCargo = Double.parseDouble(splitLine[7]);
	                boolean enclosed = Boolean.parseBoolean(splitLine[8]);
	                cargo.setWidth(widthCargo);
	                cargo.setLength(lengthCargo);
	                cargo.setHeight(heightCargo);
	                cargo.setEnclosed(enclosed);
	                Ship nullPointerSolution = new Ship(splitLine[0], splitLine[1], splitLine[2], year, splitLine[4], cargo);
	                shipObj[rowNum] = nullPointerSolution;
	                rowNum++;  
	           }
	           catch(NullPointerException n) 
	           {
	                System.out.println(" ");
	           }  
	        }
			while(line != null);
			fileStream.close();
	    }
	    //an attempt to close fileStream or catch IOException
		catch(IOException e)
		{           
	    	if(fileStream != null)
			{
				try
				{
					fileStream.close();
				}
				catch(IOException ex2)
				{
	                System.out.println("File Stream is not closed, I/O Exception is thrown.");				
				}
			}           
		}
		return shipObj;		
	}

	//This method prints out information from .csv file, saved as an array of objects
	public static void toPrintDataArr(Ship[] dataCSV)
	{
		String[] arrHeading = {"Name", "Registration ID", "Country of Registration", "Year of Manufacture", "Shipping Company", "Width", "Length", "Height", "Enclosed", "Total Capacity"};
		System.out.println("       | " + arrHeading[0] + "   		 " + arrHeading[1] + "	  " + arrHeading[2] + "  	" + arrHeading[3] + "	      " + arrHeading[4] + "		         " + arrHeading[5] 
						   + "			       " + arrHeading[6] +  "			" + arrHeading[7] + "			" + arrHeading[8] + "		" + arrHeading[9]);
		for(int ii = 0; ii < dataCSV.length; ii++)
	    {
			String distanceName = determineDistance(dataCSV[ii].getName());
			String distanceCountry = determineDistance(dataCSV[ii].getCountryOfRegistr());
			int count = ii + 1;
			System.out.println("Ship " + count + " | " +  dataCSV[ii].getName() + distanceName + dataCSV[ii].getRegistrID() + "			" + dataCSV[ii].getCountryOfRegistr() + distanceCountry +
								dataCSV[ii].getYearOfManufacturing() + " 			     " + dataCSV[ii].getShippingCompany() + "			  " + dataCSV[ii].getCargoCap().getWidth() + "			     "
								+ dataCSV[ii].getCargoCap().getLength() + "			" + dataCSV[ii].getCargoCap().getHeight() + "			" + dataCSV[ii].getCargoCap().getEnclosed() + "			 "
								+ dataCSV[ii].getCargoCap().getCubicCapacity());
	    }	
	}

	//method determines how big the space is required based on a length of a String
	//the main purpose of this method is to make output look tidier
	public static String determineDistance(String string)
	{
		String space; 
		if(string.length() == 7)
		{
			space = "	 	   ";
		}
		else if(string.length() < 5)
		{
			space = "		  	   ";
			//return space;
		}
		
		else if(string.length() > 6)
		{
			space = "	 	    ";
			//return space;
		}	
		
		else { 
			space = "	  		   "; 
		}
		return space;
	}

		//I have chosen to use Bubble sort over Insertion or Selection sort because it is a stable algorithm and does not require a creation of a new array. 
		//Instead, bubble sort method sorts an existing array, which fits the description by the assessment requirements,
		//Even though it takes more time than Insertion or Selection sort methods.
		//This method is a based on pseudocode from Lecture 8.
		public static Ship[] arrayBubbleSort(Ship[] dataCSV)
		{
			int pass = 0;
			boolean sorted = false;
			Ship tempHolder = new Ship();
			do
			{
				for(int ll = 0; ll <= (dataCSV.length - 1 - pass) - 1 ; ll++)
				{
					if(dataCSV[ll].cargoCap.getCubicCapacity() < dataCSV[ll+1].cargoCap.getCubicCapacity())
					{
						tempHolder = dataCSV[ll];
						dataCSV[ll] = dataCSV[ll+1];
						dataCSV[ll+1] = tempHolder;
					}	
				}
				pass = pass + 1;
				if(pass > dataCSV.length - 1)
				{
					sorted = true; 
				}
			}
			while(sorted != true);
			return dataCSV;
		}
		
		
	//This method calculates and prints out the total cargo capacity for each company
		private static void totalCompanyCap(Ship[] dataNelraCSV, Ship[] dataNatsirCSV, Ship[] dataDivadCSV) {
			double totalCapNelra = 0, totalCapNatris = 0, totalCapDivad = 0;
			DecimalFormat newForm = new DecimalFormat("#.##");
			for(int xx = 0; xx < dataNelraCSV.length; xx++)
			{
				totalCapNelra = dataNelraCSV[xx].getCargoCap().getCubicCapacity() + totalCapNelra;
			}
			for(int zz = 0; zz < dataNatsirCSV.length; zz++)
			{
				totalCapNatris = dataNatsirCSV[zz].getCargoCap().getCubicCapacity() + totalCapNatris;
			}
			for(int cc = 0; cc < dataDivadCSV.length; cc++)
			{
				totalCapDivad = dataDivadCSV[cc].getCargoCap().getCubicCapacity() + totalCapDivad;
			}
		
			System.out.println("\nTotal capacity of Nelra company is: " + newForm.format(totalCapNelra) + " cubic metres.\n");
			System.out.println("Total capacity of Natris company is: " + newForm.format(totalCapNatris) + " cubic metres.\n");
			System.out.println("Total capacity of Divad company is: " + newForm.format(totalCapDivad) + " cubic metres.\n");
		}

	

}
