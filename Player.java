 /**
 * Representation of a Lion on the team.
 * Holding his first and last name and jersey number
 * @author Jevoun Tyrell
 */
package Calabar;

public class Player 
{
	private String firstName;
	private String lastName;
	private int number;
	
	/**
	 * Constructor for Player
	 * @param first
	 * @param last
	 * @param num
	 */
	public Player(String first, String last, int num)
	{
		firstName = first;
		lastName = last;
		number = num;
	}
	
	/**
	 * Returns player's first name
	 * @return firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Sets player's first name
	 * @param first
	 */
	public void setFirstName(String first)
	{
		firstName = first;
	}
	
	/**
	 * returns player's last name
	 * @returnlastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * sets player's last name
	 * @param last
	 */
	public void setLastName(String last)
	{
		lastName = last;
	}
	
	/**
	 * @return number
	 */
	public int getNumber()
	{
		return number;
	}
	
	/**
	 * Sets player's jersey number
	 * @param num
	 */
	public void setNumber(int num)
	{
		number = num;
	}
	
	
}
