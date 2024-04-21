package escapeTheDark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

//import gameobjects.Room;
//import gameobjects.Actor;
//import escapeTheDark.GameBuild;
 

public class EscapeTheDark 
{
	
    static GameBuild game;
    
	public static void main(String[] args) throws IOException, InterruptedException
    {
    	//boolean gameOpen = true;
    	TextArt art = new TextArt();
    	
    	//game runs until player enters q and triggers System.exit(0);
    	while(true)
    	{
    		System.out.println("1325 Studios presents:");
    		System.out.println(art.IntroLogo);
    		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        	String playerInput="";
        	game = new GameBuild();
        	boolean newGame = true;
    		System.out.println("n: New Game.\nq: Quit.");
    		playerInput = in.readLine();
        	if("n".equals(playerInput.toLowerCase().trim()))
        	{
                //////////////////////////////////////////////////////////////////////////////////////////
            	//Main game loop. If player dies, they go bac to menu
                //////////////////////////////////////////////////////////////////////////////////////////
            	while(!"q".equals(playerInput))
            	{
            		//get alive status of player at start of main loop
            		boolean playerAlive = game.getPlayer().getAliveStatus();
           
            		//New Game intro. Show only if new game just started.
            		if(newGame)
            		{
            			System.out.printf("Starting New Game");
            			ellipsis();
            			System.out.printf("\n");
            			System.out.println(art.playerFace);
            			System.out.printf("\n");
            			wait(3);
            			game.showIntro();
            			newGame = false;
            		}
            		else
            		{
            			//if player is alive then look.
            			if(playerAlive)
            			{
            				System.out.println("--------------------------------------------");
            				game.look();
            			}
            			//if player died, game over
            			else
            			{
            				System.out.printf("oops");
            				ellipsis();
            				System.out.printf("\n");
            				System.out.println(art.playerDiedFace);
            				System.out.println(art.died);
            				System.out.println(art.gameOver+"\n\n");
            				System.out.println("--------------------------------------------");
                			break;
            			}
            			
            			//if player enters trap room
            			if(game.getPlayer().getLocation().equals(game.getMap().get(6)))
            			{
            				ellipsis();
            				System.out.println("\n"+art.trapFace);
            				System.out.println("The door slams shut\nYou are \n" + art.trapped);
            				System.out.println(art.gameOver+"\n\n");
            				System.out.println("--------------------------------------------");
            				break;
            			}
            			//if player in exit room then exit game.
            			if(game.getPlayer().getLocation().equals(game.getMap().get(11)))
            			{
            				System.out.println(game.getMap().get(4).getPrompt());
            				System.out.printf("As you exit you get a short and sharp headache so you close your eyes.\nYou see a figure");
            				ellipsis();
            				System.out.printf("\n");
            				wait(7);
            				System.out.println(art.exitFace);
            				wait(3);
            				System.out.printf("\nIt suddenly goes away and you open your eyes and feel as if you have been teleported to another dimension\n"
            									+ "You hear an alarm going off and you turn around and see the asylum's name");
            				ellipsis();
            				wait(7);
            				System.out.printf("\n");
            				System.out.println(art.OutroLogo);
            				System.out.printf("\n");
            				ellipsis();
            				wait(7);
            				System.out.printf("\n");
            				System.out.println("You hear a police siren in the distance as workers and visitors outside the asylum look at you with fear in their eyes\n"
            									+ "What just happened...?\n");
            				wait(7);
            				System.out.printf("Did you finally");
            				ellipsis();
            				System.out.println(art.IntroLogo);
            				wait(2);
            				System.out.println(art.q);
            				wait(2);
            				System.out.println(art.gameOver);
            				System.exit(0);
            			}
            		}
            		
            		//direction prompt
            		//if not in exit room, prompt user what to do
            		if(!game.getPlayer().getLocation().equals(game.getMap().get(4)))
            		{
            			System.out.println("What do you do?...");
            		}
            		
            		//get prompt for room
            		game.showPrompt();
            		
            		//set prompt for room items (if room has items)
            		if(!game.getPlayer().getLocation().getThings().isEmpty())
            		{
            			gameobjects.ThingList itemList = game.getPlayer().getLocation().getThings();
            			int items = itemList.size();
            			for (int i = 0; i < items; i++)
            			{
            				System.out.println(i + ": [interact] " + itemList.get(i).getName());
            			}
            		}
            		//get player input and run the command
            		System.out.printf("\n>>> ");
            		playerInput = in.readLine();
            		if(!playerInput.equals("q"))
            		{
            			ellipsis();
            		}
            		System.out.println();
            		game.runCommand(playerInput);	
            	}
            	
            	//exit game
            	if("q".equals(playerInput.toLowerCase().trim()))
            	{
            		System.out.printf("\nClosing Game");
            		ellipsis();
            		System.out.println("Bye");
            		System.exit(0);
            	}
        	}
        	//exit game
        	else if ("q".equals(playerInput.toLowerCase().trim()))
        	{
        		System.out.printf("\nClosing Game");
        		ellipsis();
        		System.out.println("Bye");
        		System.exit(0);
        	}
        	else
        	{
        		System.out.println("Enter valid input");
        	}
    	}
    }
	
	static void ellipsis() throws InterruptedException
	{
		for(int i = 0; i < 3; i++)
		{
			System.out.printf(".");
			TimeUnit.SECONDS.sleep(1);
		}
	}
	
	static void wait(int seconds) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(seconds);
	}
}
