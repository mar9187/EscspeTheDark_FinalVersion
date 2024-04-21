package escapeTheDark;

import java.util.ArrayList;
//import java.util.List;

import gameobjects.Actor;
import gameobjects.Room;
import gameobjects.Thing;
import gameobjects.ThingList;
import globals.Directions;

//Game
public class GameBuild
{
	//////////////////////////////////////////////////////////////////////////////////////
	// Player and Map declarations
	//////////////////////////////////////////////////////////////////////////////////////
	private ArrayList<Room> map;
	private Actor player;
	ThingList playerlist = new ThingList();
	Room pad;
	Room common;
	Room cafe;
	Room secret;
	Room rec;
	Room courtyard;
	Room trap;
	Room security;
	Room lobby;
	Room library;
	Room pharm;
	Room exit;
	
    //////////////////////////////////////////////////////////////////////////////////////////
	// Enemies and NPCs declarations
    //////////////////////////////////////////////////////////////////////////////////////////
	// Enemies:
	Thing viktor;
	Thing brittany;
	Thing seb;
	Thing henry;
	ThingList enemyList = new ThingList();
	//NPCs:
	Thing drConnors;
	Thing nurseTiffany;
	Thing alexander;
	Thing pastorChristian;
	ThingList npcList = new ThingList();;
	
    //////////////////////////////////////////////////////////////////////////////////////////
	// Items declarations
    //////////////////////////////////////////////////////////////////////////////////////////
	Thing waterBottle;
	Thing taser;
	Thing notes;
	Thing stethoscope;
	Thing axe;
	Thing libraryKey;
	Thing securityKey;
	Thing gun;
	Thing exitKey;
	ThingList itemList = new ThingList();;
	
    //////////////////////////////////////////////////////////////////////////////////////////
	// Constructor for GameBuild. It builds the game.
    //////////////////////////////////////////////////////////////////////////////////////////
	public GameBuild()
	{
		//////////////////////////////////////////////////////////////////////////////////////
		// Map initialization
		//////////////////////////////////////////////////////////////////////////////////////
		this.map = new ArrayList<Room>();
		
		//////////////////////////////////////////////////////////////////////////////////////
		// Intro and Outro Prompts
		//////////////////////////////////////////////////////////////////////////////////////
		//TextArt txt = new TextArt();
		String roomPrompt="q: quit\ni: list inventory";
		String exitPrompt="You escaped the dark asylum.\n";
		
		//////////////////////////////////////////////////////////////////////////////////////
		// Initialization of Enemies, NPCs, and items
		//////////////////////////////////////////////////////////////////////////////////////
		//ENEMIES:
		//Viktor
		final String vikDesc = "\n    He has electric blue eyes and his gaze looks dizzy and lost. "
				+ "\n    He's 5'11'' and has a toned body but looks somewhat skinny. He has broad shoulders like an Olympic swimmer. "
				+ "\n    His blonde hair looks spikey and frizzy like he got struck by lightning. "
				+ "\n    He loves playing with electricity and watching lightning strike from the clouds on a rainy day. "
				+ "\n    When it is thundering, he is always found near an open window admiring the lightning. "
				+ "\n    He has a hospital patient gown on which has burn marks from all the times he tried to play with electricity. "
				+ "\n    He constantly smells like burnt wood or paper."
				+ "\n    He is currently messing with a car battery and trying to wire it to his heart.";
		viktor = new Thing("Viktor", vikDesc, false, false);
		//Brittany
		final String britDesc ="\n    She has been a nurse for as long as she can remember. "
				+ "\n    But ever since she lost her husband, she's been on the edge and is always looking for conflict. "
				+ "\n    She's 5'1'' with shoulder-length dark brown hair.\n    She wears a tight nurse uniform with unknown blood stains and little tears on her skirt. "
				+ "\n    She roams around the hallways with a smile on her face looking to pick on anyone that gets in her way.\n    She looks small but fierce and has an axe.";
		brittany = new Thing("Brittany", britDesc, false, false);
		//Seb
		final String sebDesc = "\n    He's a daily visitor in the asylum. Always searching for his mama who went crazy. "
				+ "\n    He always roams the hallways calling out his mama's name (Bethany) but doesn't understand that she's not a patient anymore. "
				+ "\n    He's 5'9'' and is skinny for his height.\n    He looks younger than his age and always gets mistaken for a child. He has a small build overall. "
				+ "\n    His brown eyes look empty and has no facial hair.\n    He always wears the same dirty hoodie and shorts which smell like pizza and sweat.";
		seb = new Thing("Seb", sebDesc, false, false);
		//Henry
		final String henDesc = "\n    He was a lumberjack before a terrible accident that made him lose his arm. He's 6' and super buff. "
				+ "\n    His one arm is so buff that his blood vessels are always popping.\n    Even with 1 arm, he is stronger than most men. "
				+ "\n    He has a dirty blonde mullet and a trimmed yet messy beard.\n    Ever since the accident, he always looks angry with his bushy eyebrows furrowed and his footsteps are heavy. "
				+ "\n    He has green eyes with eye bags.\n    He looks like he can pick you up with one arm and toss you.";
		henry = new Thing("Henry",henDesc, false, false);
		//enemyList
		enemyList.add(viktor);
		enemyList.add(brittany);
		enemyList.add(seb);
		enemyList.add(henry);
		
		//NPCs:
		// Dr. Connors
		final String drConDesc = "\n    He's 6'2'' and lanky with dark circles under his eyes."
				+ "\n    Dr. Connors has pale skin, messy black hair, and a sharp face.\n    His face is skinny and his cheeks are hollow. "
				+ "\n    He looks like he hasn't slept in days but still looks sharp. "
				+ "\n    He looks like a depressed highschooler who has barely any food to eat but he has studied hard throughout his whole life to become a doctor. ";
		drConnors = new Thing ("Dr. Connors", drConDesc, false, false);
		//Nurse Tiffany
		final String nurseDesc = "\n    She's average height but wears heels to appear taller.\n    She dresses in a clean nurse uniform with barely any imperfections in sight. "
				+ "\n    She naturally radiates light as she is very pretty and an optimistic person.\n    With long, wavy blonde hair, she always has it in a clean bun so it doesn't interfere with her work. "
				+ "\n    She smells like fresh roses and lemons when she walks by.\n    When patients see her, they can't take their eyes off her. "
				+ "\n    Her gentle blue eyes look calm yet fierce and she walks with confidence like nothing can harm her.";
		nurseTiffany = new Thing ("Nurse Tiffany", nurseDesc, false, false);
		//Alexander
		final String alexDesc = "\n    He's 6'3'' and buff. Has muscles in all the right places and everyone finds him attractive.\n    He's big build makes him noticeable from across the hallways. "
				+ "\n    With short brown hair that is always styled up, he loves to be by Nurse Mercy's side and protects her.\n    Although he's buff, his face looks soft with soft features and big brown eyes. "
				+ "\n    He has a tattoo sleeve on his right arm with random doodles of things he loves like dogs, gym, quotes, and symbols.\n    He likes to wear oversized t-shirts to cover his muscles and wears baggy jeans.";
		alexander = new Thing ("Alexander", alexDesc, false, false);
		//Pastor Christian
		final String pastorDesc = "\n    Religious guy who always carries around a bible. He will stop and pray for anyone who looks like they are in trouble.\n    He's average height and average build. "
				+ "\n    Nothing about him really stands out. He has black hair and brown eyes.\n    Always wears a well-fitted suit and has a cross necklace on at all times. "
				+ "\n    He looks clean and looks too rich to be an ordinary pastor.";
		pastorChristian = new Thing("Pastor Christian", pastorDesc, false, false);
		//npcList
		npcList.add(drConnors);
		npcList.add(nurseTiffany);
		npcList.add(alexander);
		npcList.add(pastorChristian);
		
		// Items:
		waterBottle = new Thing("Water Bottle", "\n    Just a regular plastic water bottle.\n    It would be SHOCKING if this had any use beside drinking.");
		taser = new Thing("Taser","\n    Has very little charge left.");
		notes = new Thing("Notes","\n    Research notes of Dr. Connors.");
		stethoscope = new Thing("Stethoscope","\n    Belongs to Nurse Tiffany.");
		axe = new Thing("Axe", "\n    An old lumberjack axe.");
		libraryKey = new Thing("Library Key","\n    Opens the library.");
		securityKey = new Thing("Security Key", "\n    Opens the security room.");
		gun = new Thing("S&W Model 13", "\n    A bloody revolver with one bullet left.");
		exitKey = new Thing("Exit Key","\n    Opens the exit to the asylum." );
		// Only items found in rooms and not items received from NPCs/Enemies.
		itemList.add(waterBottle);
		itemList.add(stethoscope);
		itemList.add(libraryKey);
		itemList.add(gun);
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		// Rooms and Room Lists
		//////////////////////////////////////////////////////////////////////////////////////
		// RoomList Initialization first  because we need them to initialize Rooms
		ThingList padList = new ThingList();
		padList.add(waterBottle);
		padList.add(pastorChristian);
		
		ThingList commonList = new ThingList();
		commonList.add(viktor);
		
		ThingList cafeList = new ThingList();
		cafeList.add(alexander);
		
		ThingList secretList = new ThingList();
		secretList.add(libraryKey);
		
		ThingList recList = new ThingList();
		recList.add(brittany);
		recList.add(stethoscope);
		
		ThingList courtyardList = new ThingList();
		courtyardList.add(nurseTiffany);
		
		ThingList trapList = new ThingList(); //empty but needed to initialize room
		
		ThingList securityList = new ThingList();
		securityList.add(gun);
		
		ThingList lobbyList = new ThingList();
		lobbyList.add(seb);
		
		ThingList libraryList = new ThingList();
		libraryList.add(henry);
		
		ThingList pharmList = new ThingList();
		pharmList.add(drConnors);
		
		ThingList exitList = new ThingList(); //empty but needed to initialize room
		
		//Room Initialization (name, desc, n, s, e, w, roomList, prompt, unlocked) 
		pad = new Room("Padded Room","A dark room with padded walls and floor so patients don't hurt themselves.\nThere is a dark figure in the corner",
				-1, -1, 1, -1, padList, roomPrompt, true);
		common = new Room("Common Room", "A common area for patients to socialize.\n    The walls are covered in blood. There is someone staring out of a window", 
				-1, -1, 2, 0, commonList, roomPrompt, true);
		cafe = new Room("Cafeteria", "A caferteria with empty tables.\n    It smells like rotten food. There is a large man in the corner holding a woman in his arms", 
				-1, 5, -1, 1, cafeList, roomPrompt, true);
		secret = new Room("Secret Room", "A small cramped room with a whole in the wall to enter and exit", 
				-1, -1, 4, -1, secretList, roomPrompt, true);
		rec = new Room("Recreation Room", "A big room with basketball hoops, many tables, and a shelf with cards and board games.\n    A few dead bodies are scattered throughout. There is a woman roaming the room", 
				-1, 7, 5, -1, recList, roomPrompt, true); // east room will change when secret room discovered
		courtyard = new Room("Courtyard", "A courtyard with a tables, a track, and football field.\n    There is a full moon obscured by clouds. There is a nurse sitting at a table", 
				2, 8, -1, 4, courtyardList, roomPrompt, true);
		trap = new Room("Cell", "An old rusty cell that looks like something striaght out of Alcatraz.", 
				-1, -1, -1, -1, trapList, roomPrompt, true);
		security = new Room("Security Room", "A room used for surveillance and weapon storage.\n    On the wall there is a message in blood that says 'I tried my best'", 
				4, 10, 8, 6, securityList, roomPrompt, false);
		lobby = new Room("Lobby", "A lobby with chairs and a recption desk. A boy is wandering around.", 
				5, -1, -1, 7, lobbyList, roomPrompt, true);
		library = new Room("Library", "An old library full of dust that hasn't been used in years.\n    There is a large man sitting at a table while he reads an old book about trees", 
				-1, -1, 10, -1, libraryList, roomPrompt, false);
		pharm = new Room("Pharmacy", "A pharmacy with empty shelves.\n    There are shelves labeled: "
				+ "\n        'antipsychotics'\n        'antidepreseants'\n        'amphetamines'\n        'barbiturates'\n    All are empty.\n    There is a doctor sitting in a desk", 
				7, -1, 11, 9, pharmList, roomPrompt, true);
		exit = new Room("Exit", "The Outisde parking lot of the asylum", 
				-1, -1, -1, -1, exitList, exitPrompt, false);
		
		//////////////////////////////////////////////////////////////////////////////////////
		// Map build. index = room number
		//////////////////////////////////////////////////////////////////////////////////////
		map.add(pad);
		map.add(common);
		map.add(cafe);
		map.add(secret);
		map.add(rec);
		map.add(courtyard);
		map.add(trap);
		map.add(security);
		map.add(lobby);
		map.add(library);
		map.add(pharm);
		map.add(exit);
		
		//////////////////////////////////////////////////////////////////////////////////////
		// Player initialization 
		//////////////////////////////////////////////////////////////////////////////////////
		player = new Actor("John Verrückt", "Someone who doesnt know how they got where they are right now. All you knoe is your name.", playerlist,map.get(0));
		
	}//end of constructor GameBuild()
	
    //////////////////////////////////////////////////////////////////////////////////////////
    // Player and Map getters
    //////////////////////////////////////////////////////////////////////////////////////////
    public Actor getPlayer() 
    {
        return player;
    }
    
    public ArrayList<Room> getMap() 
	{
        return map;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // methods to take objects
    //////////////////////////////////////////////////////////////////////////////////////////
    private void transferObject(Thing t, ThingList fromlist, ThingList tolist) 
    {
        fromlist.remove(t);
        tolist.add(t);
    }
    
    String takeObject(String obname) 
    {
        String retStr = "";
        Thing t = player.getLocation().getThings().thisObject(obname);
        if(t.isTakable())
        {
        	transferObject(t, player.getLocation().getThings(), player.getThings());
            retStr = obname + " taken!";
        }
        return retStr;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    // Methods to move player location
    //////////////////////////////////////////////////////////////////////////////////////////
    private void moveActorTo(Actor p, Room aRoom) 
    {
        p.setLocation(aRoom);
    }

    private int moveTo(Actor anActor, Directions dir) 
    {
        
    	//get room and declare exit
    	Room r = anActor.getLocation();
    	int exit;
    	
    	//////////////////////////////////////////////////////////////////////////////////////
    	// Get room number for each direction and unlocked status.
    	// Try/catch deals with room number = -1
    	// Although there is no room, treat it as unlocked to return NO EXIT to user
    	//////////////////////////////////////////////////////////////////////////////////////
    	//North
    	int roomNorth = r.getNorth();
        boolean northUnlocked;
		try 
		{
			northUnlocked = map.get(roomNorth).isUnlocked();
		} 
		catch (Exception e) 
		{
			northUnlocked = true; 
		}
        
		//South
        int roomSouth = r.getSouth();
        boolean southUnlocked;
		try 
		{
			southUnlocked = map.get(roomSouth).isUnlocked();
		} 
		catch (Exception e) 
		{
			southUnlocked = true; 
		}
        
        //East
		int roomEast = r.getEast ();
        boolean eastUnlocked;
		try 
		{
			eastUnlocked = map.get(roomEast).isUnlocked();
		} 
		catch (Exception e) 
		{
			eastUnlocked = true; 
		}
        
        //West
        int roomWest = r.getWest();
        boolean westUnlocked;
		try 
		{
			westUnlocked = map.get(roomWest).isUnlocked();
		} 
		catch (Exception e) 
		{
			westUnlocked = true;
		}
        
    	//////////////////////////////////////////////////////////////////////////////////////
		// Switch returns constant representing the room number moved to or NOEXIT
        // Try to move player in direction indicated by dir.
        // If room is locked, then stay in same room. Else got to new room.
    	//////////////////////////////////////////////////////////////////////////////////////
        switch (dir) 
        {
            case NORTH:
                if(northUnlocked)
                {
                	exit = roomNorth;
                    break;
                }
                else
                {
                	System.out.println("That room is locked.");
                	exit = Directions.NOEXIT; //stay in same room
                    break;
                }
                
            case SOUTH:
            	if(southUnlocked)
                {
                	exit = roomSouth;
                    break;
                }
                else
                {
                	System.out.println("That room is locked.");
                	exit = Directions.NOEXIT; //stay in same room
                    break;
                }
            	
            case EAST:
            	if(eastUnlocked)
                {
                	exit = roomEast;
                    break;
                }
                else
                {
                	System.out.println("That room is locked.");
                	exit = Directions.NOEXIT; //stay in same room
                    break;
                }
            	
            case WEST:
            	if(westUnlocked)
                {
                	exit = roomWest;
                    break;
                    
                }
                else
                {
                	System.out.println("That room is locked.");
                	exit = Directions.NOEXIT; //stay in same room
                    break;
                }
            	
            default:
                exit = Directions.NOEXIT; //stay in same room
                break;
        }
        // If exit room value != -1, then move player and return room number.
        if (exit != Directions.NOEXIT) 
        {
            moveActorTo(anActor, map.get(exit));
        }
        return exit;
    }

   void movePlayerTo(Directions dir) 
   {
        // if roomNumber = NOEXIT, display a special message, otherwise
        // display text (e.g. name and description of room)                
        if (moveTo(player, dir) == Directions.NOEXIT) 
        {
            showStr("No Exit!");
        } 
    }

    void goNorth() 
    {
        movePlayerTo(Directions.NORTH);
    }

    void goSouth() 
    {
        movePlayerTo(Directions.SOUTH);
    }

    void goWest() 
    {
        movePlayerTo(Directions.WEST);
    }

    void goEast() 
    {
        movePlayerTo(Directions.EAST);
    }

    void look() 
    {
        showStr("You are in: " + getPlayer().getLocation().describe());
    }

    void showStr(String s) 
    {
        System.out.println(s);
    } // end of methods to move player
    
    //////////////////////////////////////////////////////////////////////////////////////////
    // Misc game methods (self explanatory) 
    //////////////////////////////////////////////////////////////////////////////////////////
    void showInventory() 
    {
        showStr("You have\n" + getPlayer().getThings().describeThings());
    }
    
    public void showPrompt()
    {
    	Room room = getPlayer().getLocation();
		int roomN = room.getNorth();
		int roomS = room.getSouth();
		int roomE = room.getEast();
		int roomW = room.getWest();
		System.out.println(room.getPrompt());
		// north
		if(room.getNorth() != -1)
		{
			System.out.println("w: go north ("+ getMap().get(roomN).getName() + ")");
		}
		else
		{
			System.out.println("w: go north (no exit)");
		}
		//south
		if(room.getSouth() != -1)
		{
			System.out.println("s: go south ("+ getMap().get(roomS).getName() + ")");
		}
		else
		{
			System.out.println("s: go south (no exit)");
		}
		//east
		if(room.getEast() != -1)
		{
			System.out.println("d: go east ("+ getMap().get(roomE).getName() + ")");
		}
		else
		{
			System.out.println("d: go east (no exit)");
		}
		//east
		if(room.getWest() != -1)
		{
			System.out.println("a: go west ("+ getMap().get(roomW).getName() + ")");
		}
		else
		{
			System.out.println("a: go west (no exit)");
		}		
    }

    public void showIntro() 
    {
        String s;
        
        s = "You awaken in a dark insane asylum lobby.\n"
                + "You dont know how you got there.\n"
        		+ "You only know your name: " + player.getName()+ "\n";
        showStr(s);
        look();
    }
    
    // Method for unlocking doors and telling user what door is unlocked (only tells them once)
    boolean secKeyPrompt = true;
    boolean libKeyPrompt = true;
    boolean exitKeyPrompt = true;
    public void checkKeys(ThingList inventory)
    {
    	
    	if(inventory.contains(securityKey) && secKeyPrompt)
    	{
    		System.out.println("Security Key can open the Security Room.");
    		map.get(7).setUnlocked(true);
    		secKeyPrompt = false;
    	}
    	if(inventory.contains(libraryKey) && libKeyPrompt)
    	{
    		System.out.println("Library Key can open the Library.");
    		map.get(9).setUnlocked(true);
    		libKeyPrompt = false;
    	}
    	if(inventory.contains(exitKey) && exitKeyPrompt)
    	{
    		System.out.println("Exit Key can open the door to escape the asylum.");
    		map.get(11).setUnlocked(true);
    		exitKeyPrompt = false;
    	}
    	//etc
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    // Methods to runs player command. Giant switch cases... could be coded better but oh well.
    //////////////////////////////////////////////////////////////////////////////////////////
    
    String itemType(Thing t)
    {
    	if(enemyList.contains(t))
    	{
    		return "enemy";
    	}
    	else if(npcList.contains(t))
    	{
    		return "npc";
    	}
    	else //itemList.contains(t)
    	{
    		return "item";
    	}
    }
    
    // Method for item interaction
    void itemInteract(Thing item)
    {
    	takeObject(item.getName());
    	System.out.println("You picked up : " +item.getName());
    }
    
    // Method for enemy interaction
	boolean vikAlive = true;
	boolean britAlive = true;
	boolean sebAlive = true;
	boolean henAlive = true;
    void enemyInteract(Thing enemy)
    {
    	switch(enemy.getName())
    	{
    		case "Viktor":
    		{
    			if(playerlist.contains(waterBottle))
    			{
    				System.out.println("He is angered by your presence and takes out a taser.");
    				System.out.println("You electrocute Viktor by throwing water at the cables connected to his heart.");
    				vikAlive = false;
    				playerlist.remove(waterBottle);
    				playerlist.add(taser);
    				System.out.println("You picked up: " + taser.getName()+".");
    				viktor.setDescription("He is laying lifeless on the gorund.");
    				common.setDescription("A common area for patients to socialize.\n    The walls are covered in blood.");
    				break;
    			}
    			else
    			{
    				if(vikAlive)
    				{
	    				System.out.println("Viktor is angered by your presence. He electrocutes you.");
	    				player.setIsAlive(false);
	    				break;
    				}
    				else
    				{
    					System.out.println("He was smart, but clearly insane.");
    					break;
    				}
    			}
    		}
    		
    		case "Brittany":
    		{
    			if(playerlist.contains(gun))
    			{
    				System.out.println("She starts to charge at you.");
    				System.out.println("You shoot Brittany with the gun.The gun is useless now so you drop it.");
    				britAlive = false;
    				playerlist.remove(gun);
    				playerlist.add(axe);
    				System.out.println("You picked up : " + axe.getName()+".");
    				brittany.setDescription("She is laying in a pool of blood.");
    				rec.setDescription("A big room with basketball hoops, many tables, and a shelf with cards and board games. "
    						+ "A few dead bodies are scattered throughout.");
    				break;
    			}
    			else
    			{
    				if(britAlive)
    				{
	    				System.out.println("Brittany attacks you with the axe.");
	    				player.setIsAlive(false);
	    				break;
    				}
    				else
    				{
    					System.out.println("She was crazy. Good thing she's dead now");
    					break;
    				}
    			}
    		}
    		
    		case "Seb":
    		{
    			if(playerlist.contains(taser))
    			{
    				System.out.println("Seb thinks you took his mother so he tries to choke you.");
    				System.out.println("You tase Seb with the taser. The taser lost all charge so you drop it.");
    				sebAlive = false;
    				playerlist.remove(taser);
    				playerlist.add(securityKey);
    				System.out.println("You picked up : " + securityKey.getName()+".");
    				seb.setDescription("He is laying on the ground. Maybe he will wake up later. Maybe he is dead...");
    				lobby.setDescription("A lobby with chairs and a recption desk.");
    				break;
    			}
    			else
    			{
    				if(sebAlive)
    				{
	    				System.out.println("Seb thinks you took his mother away. He grabs you and chokes you.");
	    				player.setIsAlive(false);
	    				break;
    				}
    				else
    				{
    					System.out.println("Poor kid... You did what you had to do.");
    					break;
    				}
    			}
    		}
    		
    		case "Henry":
    		{
    			if(playerlist.contains(axe))
    			{
    				System.out.println("Henry shouts at you 'LET ME READ IN PEACE!!' and charges at you.");
    				System.out.println("But he is hit with flashbacks as he sees your axe. You take the oportunity to decapitate him.");
    				henAlive = false;
    				playerlist.remove(axe);
    				playerlist.add(exitKey);
    				System.out.println("You picked up : " + exitKey.getName()+".");
    				henry.setDescription("His head is about 4 feet from his body and he is drenched in blood. Better him than you.");
    				library.setDescription("An old library full of dust that hasn't been used in years.");
    				break;
    			}
    			else
    			{
    				if(henAlive)
    				{
	    				System.out.println("Henry shouts at you 'LET ME READ IN PEACE!!'\nHe puches you with the strength of a grizzly bear.");
	    				player.setIsAlive(false);
	    				break;
    				}
    				else
    				{
    					System.out.println("You wonder what made him freeze up like that... At least you have the exit to escape now.");
    					break;
    				}
    			}
    		}
    	}
    }
    
    // Method for npc interaction
    boolean tiffItem = false;
    boolean drItem = false;
    void npcInteract(Thing npc)
    {
    	switch(npc.getName())
    	{
	    	case "Pastor Christian":
			{
				System.out.println("Pastro Christian says:");
				System.out.println("    'About time you wake up...\n    Be careful out there. There is some crazy guy tring to wire his heart to a car battery."
						+ "\n    He has anger problems and tried attacking me but I escaped into here."
						+ "\n    There is also a boy looking for his mother who tried attacking me.\n    I'm praying for them.'");
				break;
			}
    		case "Alexander":
    		{
    			System.out.println("Alexander says:");
    			System.out.println("    'Brittany hurt Nurse Mercy... \n    She is on PCP and the only thing that can stop her is a gun."
    					+ "\n    If you get to close she will try to kill you. She is in the recreation room.'");
    			break;
    		}
    		
    		case "Nurse Tiffany":
    		{
    			if(!playerlist.contains(stethoscope) && !tiffItem)
    			{
    				System.out.println("Nurse Tiffany says:");
    				System.out.println("    'Don't go into the cell. Something will push you down and lock you up."
        					+ "\n    My stethoscope is in the recreation room. Do you think you can get it for me?"
        					+ "\n    I need it to do my job but Brittany scares me to death.'");
    				break;
    			}
    			else
    			{
    				if (playerlist.contains(stethoscope))
    				{
    					System.out.println("Nurse Tiffany says:");
    					System.out.println("    'Thank you so much!\n    By the way if you see Dr. Connors can you give him his notes.'");
    					playerlist.remove(stethoscope);
    					tiffItem = true;
    					playerlist.add(notes);
    					System.out.println("Nurse Tiffany Gave you: " + notes.getName());
    					break;
    				}
    				else if (tiffItem)
    				{
    					System.out.println("Nurse Tiffany says:");
    					System.out.println("    'Thanks again!'");
    					break;
    				}
    				break;
    			}
    			
    		}
    		
    		case "Dr. Connors":
    		{
    			if(!playerlist.contains(notes) && !drItem)
    			{
    				System.out.println("Dr. Connors says:");
    				System.out.println("    Have you seen my research notes?");
    				break;
    			}
    			else
    			{
    				if (playerlist.contains(notes))
    				{
    					System.out.println("Dr. Connors says:");
    					System.out.println("    'Thanks. Now I can focus on my research.'");
    					playerlist.remove(notes);
    					drItem = true;
    					System.out.println("    Did you know there's a hidden passage in the recreation room?"
    							+ "\n    It's behind a bookshelf on the west wall"
    							+ "\n    Some wierdo goes in there to read library books and keeps a library key in there.'");
    					rec.setWest(3); //sets new room to west of recreation room
    					break;
    				}
    				else if (drItem)
    				{
    					System.out.println("Dr. Connors says:");
    					System.out.println("    'Thanks again for the notes. Don't forget to check out the hidden passage in the recreation room.'");
    					break;
    				}
    				break;
    			}
    			
    		}
    	}
    }
    
    public void runCommand(String inputString) 
    {
    	
        String lowString = inputString.trim().toLowerCase();
        Room room = player.getLocation();
        ThingList roomList = room.getThings();
        
        if (!lowString.equals("q")) 
        {
            switch(lowString)
            {
            	case "cheat":
            		player.setLocation(exit);
            		break;
	            //cases for directions
	            case "q":
	            	System.exit(0);
	            	break;
	            case "i" :
	            	showInventory();
	            	break;
	            case "w" :
	            	goNorth();
	            	break;
	            case "s" :
	            	goSouth();
	            	break;
	            case "d" :
	            	goEast();
	            	break;
	            case "a" :
	            	goWest();
	            	break;
	            //cases for interactions
	            case "0":
					try 
					{
						Thing thing = roomList.get(0);
						//System.out.println("thing = "+thing.getName());
						String thingType =itemType(thing);
						//System.out.println(thingType);
						switch (thingType)
						{
							case "item":
								itemInteract(thing);
								break;
							case "enemy":
								enemyInteract(thing);
								break;
							case "npc":
								//System.out.println("case: npc");
								npcInteract(thing);
								//System.out.println("interacted");
								break;
						}
						break;
					} 
					catch (Exception e) 
					{
						System.out.println("Invalid Command!");
						break;
					}
					
	            case "1":
	            	try 
					{
						Thing thing = roomList.get(1);
						String thingType =itemType(thing);
						switch (thingType)
						{
							case "item":
								itemInteract(thing);
								break;
							case "enemy":
								enemyInteract(thing);
								break;
							case "npc":
								npcInteract(thing);
								break;
						}
					} 
					catch (Exception e) 
					{
						System.out.println("Invalid Command!");
						break;
					}
	            	break;
	            	
	            default:
	            	System.out.println("Invalid Command!");
	            	break;
            }
        }
        checkKeys(player.getThings()); // check if new doors were unlocked
    }  
}
