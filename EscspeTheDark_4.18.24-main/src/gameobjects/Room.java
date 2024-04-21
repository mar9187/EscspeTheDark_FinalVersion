package gameobjects;

public class Room extends ThingHolder
{
	private int north, south, east, west;
	private String prompt;
	private boolean unlocked;
	
	public Room (String roomName, String roomDescription, int roomToNorth, int roomToSouth, int roomToEast, int roomToWest, ThingList thinglist, String roomPrompt, boolean roomUnlocked)
	{
		super(roomName, roomDescription, thinglist);
		
		this.north = roomToNorth;
		this.south = roomToSouth;
		this.east = roomToEast;
		this.west = roomToWest;
		this.prompt = roomPrompt;
		this.unlocked = roomUnlocked;
	}
	
    //////////////////////////////////////////////////////////////////////////////////////////
	// Getters
	// Return new room in the given direction of the current room.
    //////////////////////////////////////////////////////////////////////////////////////////
	public int getNorth()
	{
		return north;
	}
	
	public int getSouth()
	{
		return south;
	}
	public int getEast()
	{
		return east;
	}
	public int getWest()
	{
		return west;
	}
	public String getPrompt() 
	{
		return prompt;
	}
	public boolean isUnlocked()
	{
		return unlocked;
	}
	
	public String describe() {
        String roomdesc;
        String thingsdesc;
        
        roomdesc = String.format("%s. %s.", getName(), getDescription());
        thingsdesc = getThings().describeThings();
        if (!thingsdesc.isEmpty()) 
        {
            roomdesc += "\n\nThings here:\n" + thingsdesc;
        }
        return roomdesc;
    }
	
    //////////////////////////////////////////////////////////////////////////////////////////
	// Setters
	// Set new room in the given direction of the current room.
    //////////////////////////////////////////////////////////////////////////////////////////
	
	public void setNorth(int roomNorth)
	{
		this.north = roomNorth;
	}
	public void setSouth(int roomSouth)
	{
		this.south = roomSouth;
	}
	public void setEast(int roomEast)
	{
		this.east = roomEast;
	}
	public void setWest(int roomWest)
	{
		this.west = roomWest;
	}
	public void setUnlocked(boolean roomUnlocked)
	{
		this.unlocked = roomUnlocked;
	}
	
}
