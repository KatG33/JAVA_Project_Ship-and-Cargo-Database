
public class Ship {
	//Class fields
	String name;
	String registrID;
	String countryOfRegistr;
	Integer yearOfManufacture;
	String shippingCompany;
	CargoCapacity cargoCap = new CargoCapacity();
	//CargoCapacity[] cargoCap;
	
	
	//Default Constructor
	public Ship()
	{
		name = "Britannic";
		registrID = "862876";
		countryOfRegistr = "Australia";
		yearOfManufacture = 2008;
		shippingCompany = "Asmo Shipping";
		cargoCap = new CargoCapacity(15.0, 10.0, 10.0, true);
	}
	
	//Alternate Constructor
	public Ship(String pName, String pRegistrID, String pCountryOfRegistr, Integer pYearOfManufacture, String pShippingCompany, CargoCapacity pCargoCap)
	{
		name = pName;
		registrID = pRegistrID;
		countryOfRegistr = pCountryOfRegistr;
		yearOfManufacture = pYearOfManufacture;
		shippingCompany = pShippingCompany;
		cargoCap = pCargoCap;
	}
		
	//Copy constructor 
	public Ship(Ship pShip)
	{		
		name = pShip.getName();
		registrID = pShip.getRegistrID();
		countryOfRegistr = pShip.getCountryOfRegistr();
		yearOfManufacture = pShip.getYearOfManufacturing();
		shippingCompany = pShip.getShippingCompany();
		cargoCap = pShip.getCargoCap();
	}
	
	//getters or accessors for Class Ship
	public String getName()
	{
		return name;
	}
	public String getRegistrID()
	{
		return registrID;
	}
	public String getCountryOfRegistr()
	{
		return countryOfRegistr;
	}
	public Integer getYearOfManufacturing()
	{
		return yearOfManufacture;
	}
	public String getShippingCompany()
	{
		return shippingCompany;
	}
	public CargoCapacity getCargoCap()
	{
		return cargoCap;
	}
	//end of getters for Class Ship
	

	//setters for class Ship 
	public void setName(String pName)
	{
		name = pName;
	}
	public void setRegistrID(String pRegistrID)
	{
		registrID = pRegistrID;
	}
	public void setCountryOfRegistr(String pCountryOfRegistr)
	{
		countryOfRegistr = pCountryOfRegistr;
	}
	public void setYearOfManufacturing(Integer pYearOfManufacture)
	{
		yearOfManufacture = pYearOfManufacture;
	}
	public void setShippingCompany(String pShippingCompany)
	{
		shippingCompany = pShippingCompany;
	}
	public void setCargoCap(CargoCapacity pCargoCapacity)
	{
		 cargoCap = pCargoCapacity;
	}
	//end of setters for cargoCapacity
	
	public String toString()
	{
		String finalString;
		finalString = "\nThe Ship's characteristics: \r\n" + "Name: " + name +"\r\nRegistration Identification: " + registrID + "\r\nCountry of registration: " + 
					   countryOfRegistr + "\r\nYear of manufacturing: " + yearOfManufacture + "\r\nShiping company: " + shippingCompany + "\r\n" + cargoCap.toString();
		return finalString;
	}
	
	//Equals method, where two ships are considered equal if they have the same name and registration number.
	public boolean equals(Object inObject)
	{
		boolean isEqual = false;
		Ship inShip = null;
		if(inObject instanceof Ship)
		{
			inShip = (Ship)inObject;
			if(name.equals(inShip.getName()))
				if(registrID.equals(inShip.getRegistrID()))
					isEqual = true;
		}
		return isEqual;
	}

}

