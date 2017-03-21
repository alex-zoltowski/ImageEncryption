package ImageEncryption;

public class RGB {
	
	private int red;
	private int green;
	private int blue;
	
	public RGB(int red, int green, int blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int getRed()
	{
		return red;
	}
	
	public int getGreen()
	{
		return green;
	}
	
	public int getBlue()
	{
		return blue;
	}
	
	public String toString()
	{
		return "" + red + green + blue;
	}

}
