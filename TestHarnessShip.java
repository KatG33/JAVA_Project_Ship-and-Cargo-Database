import java.util.*;
public class TestHarnessShip {
	
	public static void main(String[] args)
	{
		try
		{
			Ship[] testShip = new Ship[4];
			
			//Object creation
			CargoCapacity testCapacity1 = new CargoCapacity(5.0, 4.0, 1.0, true);
			CargoCapacity testCapacity2 = new CargoCapacity();
			testShip[0] = new Ship("Admiral", "19423117", "Russia", 1999, "RusShipping", testCapacity1);
			testShip[1] = new Ship("Britannica", "18071812", "Britain", 1812, "Anglo International", testCapacity2);
			testShip[2] = new Ship(testShip[0]);
			testShip[3] = new Ship(testShip[1]);
			
			//Print out created Objects
			System.out.println("\r\nTesting constructors: ");
			for(int ii = 0; ii < testShip.length; ii++)
	            {
	                System.out.println("Ship[" + ii + "]: " + testShip[ii].toString());
	                System.out.println("\r\n");
	            }
			
			//Testing method equals of CargoCapacity class
			//Because equals method is utilizes getName and getRegistrID accessors
			//if method equals works, it means that the accessors getName and getRegistrID accessors work well too
            System.out.println("Testing method equals of Ship class: \n");
            System.out.println("Equals (object) expected TRUE: " + testShip[1].equals(testShip[3]));
            System.out.println("Equals (object) expected FALSE: " + testShip[0].equals(testShip[3]));
			
            //testing mutators for class Ship
            System.out.println("\nTesting accessors and mutators for class Ship: \n");
            testShip[0].setName(testShip[1].getName());
            System.out.println(testShip[0].getName() + " = " + testShip[1].getName());

            testShip[0].setRegistrID(testShip[2].getRegistrID());
            System.out.println(testShip[0].getRegistrID() + " = " + testShip[2].getRegistrID());

            testShip[0].setCountryOfRegistr(testShip[1].getCountryOfRegistr());
            System.out.println(testShip[0].getCountryOfRegistr() + " = " + testShip[1].getCountryOfRegistr());

            testShip[0].setYearOfManufacturing(testShip[1].getYearOfManufacturing());
            System.out.println(testShip[0].getYearOfManufacturing() + " = " + testShip[1].getYearOfManufacturing());

            testShip[0].setShippingCompany(testShip[1].getShippingCompany());
            System.out.println(testShip[0].getShippingCompany() + " = " + testShip[1].getShippingCompany());
            
            testShip[0].setCargoCap(testShip[1].getCargoCap());
            System.out.println(testShip[0].getCargoCap() + " = " + testShip[1].getCargoCap());
        }
		
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        } 	
	}
}
