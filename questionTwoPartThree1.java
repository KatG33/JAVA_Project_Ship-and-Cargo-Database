import java.util.*;

public class questionTwoPartThree1 {
	
	public static double getCargoSize()
	{
		System.out.println("Please, enter the size of cargo to ship in cubic metres: ");
	    Scanner sc = new Scanner(System.in);
	    double userInput = sc.nextDouble();
		return userInput;
	}
	
	//I will start loading Ships with:
	//1.Check if there is a ship available with approximate capacity equal or less than 100 cubic meters
	//2.Then I will start loading all the Ships available starting with the smallest one
	public static int loadShips(Ship[] dataCSV, double cargoSize, double totalCompanyCap)
	{
		double tolerance = 10000;
		int shipsReq = 0;
		double capacityUsed = 0;
		boolean allCargoShipped = false;
		double cargoSizeUsed = cargoSize;
		//First we will loop through the list to find out if there is a ship that had capacity 
		//approximately the same to the size of cargo
		for(int tt = 0; tt < dataCSV.length; tt++)
		{
			if(shipsReq == 0)
			{
				double differenceShipAndCargo = cargoSize - dataCSV[tt].getCargoCap().getCubicCapacity();
				if(differenceShipAndCargo <= tolerance)
				{
					System.out.println("In " + dataCSV[tt].getShippingCompany() + " you will need only 1 ship: " + dataCSV[tt].getName() + ".");
					shipsReq = 1;
					allCargoShipped = true;
				}				
			}
		}
		if(shipsReq == 0)
		{
			System.out.println("\n" + dataCSV[0].getShippingCompany() + " does not have one ship that would be as big as yout cargo.");
		}
		//I check if we fount one ships which cargo capacity is close to the size of cargo 
		//a client need to transport. If not: shipsReq will stay zero.
		if(shipsReq == 0)
		{
			//Because a company doesn't have a ship that could fit in all client's cargo at once, 
			//the program has to "divide the cargo" and use multiple ships, starting with a ship with smallest capacity
			for(int bb = 0; bb < dataCSV.length; bb++)
			{
				if (allCargoShipped == false)
				{
					capacityUsed = dataCSV[bb].getCargoCap().getCubicCapacity() + capacityUsed;
					cargoSizeUsed = cargoSizeUsed - dataCSV[bb].getCargoCap().getCubicCapacity();
					shipsReq++;
					if (cargoSizeUsed <= 0)
					{
						System.out.println("The company " + dataCSV[bb].getShippingCompany() + " will need " + shipsReq + " ships to deliver your cargo.");
						allCargoShipped = true;
					}
				}
			}
		}
		//last of all we need to check if the total cargo capacity of a company is enough 
		//If it isnt enough, advice the client to apply to more shipping firms
		if(allCargoShipped == false)
		{
			if((totalCompanyCap - cargoSize) < tolerance)
			{
				System.out.println("Company " + dataCSV[0].getShippingCompany() + " is too small for your cargo.\n To ship your order you need to apply to more than one company.");
				allCargoShipped = true;
			}
		}
		return shipsReq;
	}
	
	
	public static void choiceCompany(int[] options)
	{
		if(options[1] < options[2] && options[1] < options[3])
		{
			System.out.println("Company Nelra is the best option available");
		}
		else if(options[2] < options[1] && options[2] < options[3])
		{
			System.out.println("Company Natsir is the best option available");
		}
		else if(options[3] < options[1] && options[3] < options[2])
		{
			System.out.println("Company Divad is the best option available");
		}
		else if(options[1] == options[2] && options[1] < options[3])
		{
			System.out.println("Companies Nelra and Natsir are the best options available");
		}
		else if(options[1] == options[3] && options[1] < options[2])
		{
			System.out.println("Company Nelra and Divad are the best options available");
		}
		else if(options[2] == options[3] && options[2] < options[1])
		{
			System.out.println("Companies Divad and Natsir are the best options available");
		}
		else
		{
			System.out.println("All 3 companies have the same results. There are no recommendations availabe.");
		}
	}
	
}
