
public class CargoCapacity {
	//Class fields
	double width;
	double length;
	double height;
	//private int cubicCapacity;
	boolean enclosed;
		//enclosed (boolean), if true, overall capacity is reduced by 25%
	
	
	
	//Default Constructor
	public CargoCapacity()
	{
		width = 5.0;
		length = 6.0;
		height = 10.0;
		enclosed = false;
	}
	
	//Alternate Constructor
	public CargoCapacity(double pWidth, double pLength, double pHeight, boolean pEnclosed)
	{
		width = pWidth;
		length = pLength;
		height = pHeight;
		enclosed = pEnclosed;
	}
		
	//Copy constructor 
	public CargoCapacity(CargoCapacity pCargoCapacity)
	{		
		width = pCargoCapacity.getWidth();
		length = pCargoCapacity.getLength();
		height = pCargoCapacity.getHeight();
		enclosed = pCargoCapacity.getEnclosed();
	}
	
	//getters or accessors 
	public double getWidth()
	{
		return width;
	}
	public double getLength()
	{
		return length;
	}
	public double getHeight()
	{
		return height;
	}
	public boolean getEnclosed()
	{
		return enclosed;
	}
	public double getCubicCapacity()
	{
		double cubicCapacity = width * length * height;
		if(enclosed == true)
		{
			cubicCapacity *= 0.75;
		}
		return cubicCapacity;
	}
	//end getters
	
	//setters for class cargoCapacity
	public void setWidth(double pWidth)
	{
		width = pWidth;
	}	
	public void setLength(double pLength)
	{
		length = pLength;
	}
	public void setHeight(double pHeight)
	{
		height = pHeight;
	}
	public void setEnclosed(boolean pEnclosed)
	{
		enclosed = pEnclosed;
	}
	//end of setters for cargoCapacity
	
	public String toString()
	{
		String finalString, enclosedString;
		double cubicCapacity = getCubicCapacity();
		if(enclosed == true)
		{ 
			enclosedString = "\r\nThe cargo is enclosed.";
		}
		else
		{
			enclosedString = "\r\nThe cargo is not enclosed.";
		}
		finalString = "\r\nThe cargo capacity is: \r\n" + "Width: " + width +"\r\nLength: " + length + "\r\nHeight: " + height + "\r\nCubic capacity: " + cubicCapacity + enclosedString;
		return finalString;
	}
	
	public boolean equals(Object inObject)
	{
		boolean isEqual = false;
		CargoCapacity inCargo = null;
		if(inObject instanceof CargoCapacity)
		{
			inCargo = (CargoCapacity)inObject;
				if(Math.abs(getCubicCapacity() - inCargo.getCubicCapacity()) <= 0.025) //What minus what, again???
					isEqual = true;
		}
		return isEqual;
	}
		
}


