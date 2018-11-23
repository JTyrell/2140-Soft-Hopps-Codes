package Calabar;

import java.text.DecimalFormat;

public class BasketballPlayer extends Player
{
	private int shotsTaken;
	private int madeShots;
	private int threesTaken;
	private int made3s;
	private int freesTaken;
	private int madeFrees;
	private int points;
	private int fouls;
	private int assists;
	private int blocks;
	private int steals;
	private int rebounds;
	private PlayerAlert alert = null;
	private DecimalFormat df = new DecimalFormat("###.##");

	public BasketballPlayer(String first, String last, int num) 
	{
		super(first, last, num);
		shotsTaken = 0;
		madeShots = 0;
		threesTaken = 0;
		made3s = 0;
		freesTaken = 0;
		madeFrees = 0;
		points = 0;
		fouls = 0;
		assists = 0;
		blocks = 0;
		steals = 0;
		rebounds = 0;
	}
	
	
	/**
	 * Sets alert for player's foul trouble
	 */
	public void setAlert(PlayerAlert p)
	{
		alert = p;
	}
	
	public String toString()
	{
		String str = (getNumber() + " " + getLastName() + ", " + getFirstName());
		
		return str;
	}
	

	/***********************************\
	* Getters for Statistical data
	* Used for each player Accordingly
	************************************/


	/**
	*returns # of 2 point shots taken ie. layups, Jumps 
	*/

	public int getShotsTaken()
	{
		return shotsTaken;
	}
	
	/**
	 * returns # of 2 point shots made, as in scored
	 */
	 public int getMadeShots()
	 {
		 return madeShots;
	 }
	
	 /**
	  * Returns number of 3 point shots taken
	  * @return threesTaken
	  */
	 public int getThreesTaken()
	 {
		 return threesTaken;
	 }/*End getThreesTaken*/
	 
	 /**
	  * Return number of 3 point shots made, as in scored
	  * @return getThreesMade
	  */
	 public int getThreesMade()
	 {
		 return made3s;
	 }/*End getThreesMade*/
	 
	 /**
	  * Returns number of free throws taken
	  */

	 public int getFreesTaken()
	 {
		 return freesTaken;
	 }
	 
	 /**
	  * Returns number of free throws made, as in scored
	  */
	 public int getMadeFrees()
	 {
		 return madeFrees;
	 }
	 
	 /**
	  * Return total points scored, for selected player
	  */
	 public int getPoints()
	 {
		 return points;
	 }
	 
	 /**
	  * Returns number of fouls player has
	  */
	 public int getFouls()
	 {
		 return fouls;
	 }
	 
	 /**
	  * Returns number of blocks player has, Gavin, Recho and Ravine Fav thing to do!!! :) 
	  */

	 public int getBlocks()
	 {
		 return blocks;
	 }
	 
	 /**
	  * Returns number of assists player has
	  */
	 public int getAssists()
	 {
		 return assists;
	 }
	 
	 /**
	  * Returns number of steals player has, Recho's thing and CJ and JT lol go Calabar
	  */
	 public int getSteals()
	 {
		 return steals;
	 }
	 
	 /**
	  * Returns number of rebounds player has
	  */
	 public int getRebounds()
	 {
		 return rebounds;
	 }



	/**************************************\
	* Getters for Statistical data, but 
	* tallied Percentages are created here
	* Used for each player Accordingly
	***************************************/


	/**
	 * Returns player's fieldgoal percentage
	 */
	public String getFieldgoalPerc()
	{
		double fgPerc;
		if(shotsTaken == 0)
		{
			return "0";
		}
		
		fgPerc = (madeShots/(double)shotsTaken)*100;
		
		return df.format(fgPerc);
	}
	
	/**
	 * Return 3 point shot percentage
	 */
	public String getThreePointPerc()
	{
		double threePerc;
		
		if(threesTaken == 0)
		{
			return "0";
		}
		threePerc = (made3s/(double)threesTaken)*100;
		
		return df.format(threePerc);
	}
	
	/**
	 * Returns players free throw percentage
	 */
	public String getFreePerc()
	{
		double freePerc;
		
		if(freesTaken == 0)
		{
			return "0";
		}
		freePerc = (madeFrees/(double)freesTaken)*100;
		
		return df.format(freePerc);
	}

	 

	/***********************************\
	* Setters for Statistical data
	* Used for each player Accordingly
	************************************/


	/**
	 * Used to represent player making 2 point shot
	 */
	public void made2()
	{
		shotsTaken ++;
		madeShots++;
		points += 2;
	}
	
	/**
	 * Used to represent player missing 2 point shot
	 */
	public void missed2()
	{
		shotsTaken ++;
	}
	
	/**
	 * Used to represent player making 3pointer
	 */
	public void made3()
	{
		threesTaken ++;
		made3s ++;
		shotsTaken ++;
		madeShots ++;
		points += 3;
	}
	
	/**
	 * Used to represent player missing 3point shot
	 */
	public void missed3()
	{
		threesTaken ++;
		shotsTaken ++;
	}
	
	/**
	 * Used to represent player making Free Throw
	 */
	public void freeMade()
	{
		freesTaken ++;
		madeFrees ++;
		points += 1;
	}
	
	/**
	 * Used to represent payer missing Free Throw
	 */
	public void missedFree()
	{
		freesTaken ++;
	}
	
	/**
	 * Used to add foul to stats
	 * Also send warnings for foul trouble
	 */

	public void commitFoul()
	{
		fouls ++;

		/*Call warnings if player has one foul remaining or has fouled out*/
		if (fouls == 4)
		{
			String title = "4 Fouls";
			String msg = "Player #" + getNumber() + " has 4 fouls.\n One more till they foul out, ";
			String warn = "Coach Luds, better you bench him r***";
			alert.alert(title, msg, warn);
		}
		
		if(fouls ==5)
		{
			String title = "Fouled Out";
			String msg = "Player #" + getNumber() + " has fouled out.\n They are no longer available";
			String warn = "If yuh just did bench him r***";
			alert.alert(title, msg, warn);			
		}/*End if player has fouled out*/
	}
	
	/**
	 * Used to add an assist to stats
	 */
	public void assist()
	{
		assists ++;
	}
	
	/**
	 * Used to add a block to stats
	 */
	public void block()
	{
		blocks ++;
	}
	
	/**
	 * Used to add a steal to stats
	 */
	public void steal()
	{
		steals ++;
	}
	
	/**
	 * Used to add rebound to stats
	 */
	public void rebound()
	{
		rebounds ++;
	}
	
}

