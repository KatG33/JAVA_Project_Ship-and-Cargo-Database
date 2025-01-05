import java.util.*;
public class TestHarnessCargoCapacity {
	
	public static void main(String[] args)
	{
		try
		{
			CargoCapacity[] testCapacity = new CargoCapacity[4];
			
			//Object creation
			testCapacity[0] = new CargoCapacity(5.0, 4.0, 1.0, true);
			testCapacity[1] = new CargoCapacity(3.0, 2.0, 5.0, false);
			testCapacity[2] = new CargoCapacity(testCapacity[0]);
			testCapacity[3] = new CargoCapacity(testCapacity[1]);
			
			//Print out created Objects
			System.out.println("\r\nTesting constructors: ");
			for(int ii = 0; ii < testCapacity.length; ii++)
	            {
	                System.out.println("Cargo capacity[" + ii + "]: " + testCapacity[ii].toString());
	                System.out.println("\r\n");
	            }
			
			//Testing method equals of CargoCapacity class
			//Because equals method is utilizes getCubicCapacity accessor
			//if method equals works, it means that the accessor getCubicCapacity works well too
            System.out.println("Testing method equals of CargoCapacity class: \n");
            System.out.println("Equals (object) expected TRUE: " + testCapacity[1].equals(testCapacity[3]));
            System.out.println("Equals (object) expected FALSE: " + testCapacity[0].equals(testCapacity[3]));
			
            //testing mutators for class CargoCapacity
            System.out.println("\nTesting accessors and mutators for class CargoCapacity: \n");
            testCapacity[0].setWidth(testCapacity[1].getWidth());
            System.out.println(testCapacity[0].getWidth() + " = " + testCapacity[1].getWidth());

            testCapacity[0].setLength(testCapacity[2].getLength());
            System.out.println(testCapacity[0].getLength() + " = " + testCapacity[2].getLength());

          // testCapacity[0].setWidth(testCapacity[1].getWidth());
          //  System.out.println(testCapacity[0].getWidth() + " = " + testCapacity[1].getWidth());

            testCapacity[0].setHeight(testCapacity[1].getHeight());
            System.out.println(testCapacity[0].getHeight() + " = " + testCapacity[1].getHeight());

            testCapacity[0].setEnclosed(testCapacity[1].getEnclosed());
            System.out.println(testCapacity[0].getEnclosed() + " = " + testCapacity[1].getEnclosed());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        } 	
	}
}
