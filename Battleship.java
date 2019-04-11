import java.io.*;
import java.util.*;

public class Battleship {
	static void printer(String[][] f) {
		int rows = 5;
		int columns = 5;
		for(int i = 0; i<rows; i++)
			
		{
		    for(int j = 0; j<columns; j++)
		    {
		        System.out.print(" " +f[i][j] + " ");
		    }
		    System.out.println();
		
	}
	
	}

	public static void promptEnterKey(){
		   
	    try {
	        System.in.read();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public String highroll(String player1 , String player2){

		Scanner input = new Scanner(System.in);
		Random random = new Random();
		String player = "";
		System.out.println("We Are going to start with the high roll so " + player1 + " please press enter to continue");
		 promptEnterKey();
		 int player1_roll = random.nextInt(6);
		 player1_roll += 1;
		 System.out.println(player1+" your roll was " + player1_roll);
		 System.out.println(player2 + " please press enter to roll the dice");
		 promptEnterKey();
		 promptEnterKey();
		 int player2_roll = random.nextInt(6);
		 player2_roll += 1;
		 System.out.println(player2 + " you roll was " + player2_roll);
		 while(player1_roll == player2_roll){
			 System.out.println("The values were same so  " + player1 + " please press enter to continue");
			 promptEnterKey();
			 player1_roll = random.nextInt(6);
			 player1_roll += 1;
			 System.out.println(player1 + " your roll was " + player1_roll);
			 System.out.println("");
			 System.out.println(player2 + " please press enter to roll the dice");
			 promptEnterKey();
			 promptEnterKey();
			 player2_roll = random.nextInt(6);
			 player2_roll += 1;
			 System.out.println(player2 + " your roll was " + player2_roll);
		
	}
		 if(player1_roll>player2_roll){
			 player = player1;
		 }else{
			 player = player2;
					 }
		 
			 
		 
		 
		 return player;
	}
	
	
	public String[][] player1(String[][] player2_Battlefield , String player2 , int player2_row , int player2_col)throws InterruptedException{
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		  Thread.sleep(500);
		  printer(player2_Battlefield);
		  Thread.sleep(500);
			System.out.print("Enter the row you think "+player2+"'s battleship is located in : ");
			int vertical = input.nextInt();
			System.out.print("Enter the column you think "+player2+"'s battleship is located in : ");
			int horizontal = input.nextInt();
			vertical -= 1;
			horizontal -= 1;
					
		
				 if (vertical == player2_row && horizontal == player2_col){
			    	 System.out.println("Congratulation!! , you sunk "+player2+"'s battlehip.");
			    	 System.out.println("Thank you for Playing , See you next time! ");
			    	 
			    	 System.exit(1);
			    	 
			     }else if(vertical < 0 || vertical >5 ){
			    	System.out.println("Oops , thats not even in the ocean");
			     }else if(horizontal < 0 || horizontal >  5) {
			    		System.out.println("Oops , thats not even in the ocean");
			    	 
			     }else {
			    	 System.out.println("You missed!.");
			    	 player2_Battlefield[vertical][horizontal] = "x";
			    	 
			     }
			return player2_Battlefield;	 
	}
	public String[][] player2(String[][] player1_Battlefield , String player1 , int player1_row , int player1_col)throws InterruptedException{
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		  Thread.sleep(500);
		  printer(player1_Battlefield);
		  Thread.sleep(500);
			System.out.print("Enter the row you think "+player1+"'s battleship is located in : ");
			int vertical = input.nextInt();
			System.out.print("Enter the column you think "+player1+"'s battleship is located in : ");
			int horizontal = input.nextInt();
			vertical -= 1;
			horizontal -= 1;
					
		
				 if (vertical == player1_row && horizontal == player1_col){
			    	 System.out.println("Congratulation!! , you sunk "+player1+"'s battlehip.");
			    	 System.out.println("Thank you for Playing , See you next time! ");
			    	 
			    	 System.exit(1);
			    	 
			     }else if(vertical < 0 || vertical >5 ){
			    	System.out.println("Oops , thats not even in the ocean");
			     }else if(horizontal < 0 || horizontal >  5) {
			    		System.out.println("Oops , thats not even in the ocean");
			    	 
			     }else {
			    	 System.out.println("You missed!.");
			    	 player1_Battlefield[vertical][horizontal] = "x";
			    	 
			     }
			return player1_Battlefield;	 
	}
	public static void dual()throws IOException, InterruptedException{
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		String[][] player2_Battlefield = new String[5][5];
		String[][] player1_Battlefield = new String[5][5];
	
		for(int v = 0 ; v<=4;v++){
			for(int h = 0 ; h<=4 ;h++){
				
				player1_Battlefield[v][h] = "o";
				player2_Battlefield[v][h] = "o";
			}
		  }

		System.out.print("Please enter the name of the first player : "); 
		String player1 = input.nextLine();
		
		System.out.print("Please enter the name of the second player : "); 
		String player2 = input.nextLine();
		System.out.println("");
		Battleship caller = new Battleship();
		String winner = caller.highroll(player1 , player2);
		if(winner == player1){
			System.out.println(player1 + " has won the toss therefore " +  player1 + " starts");
			 printer(player1_Battlefield);
			 Thread.sleep(500);
			 System.out.println(player1 + " please set you location");
			 System.out.print(player1 + " please select your row : ");
			 int player1_row = input.nextInt();
			 
			 System.out.print(player1 + " please select your column : ");
			 int player1_col = input.nextInt();
			 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			 player1_col -= 1;
			 player1_row -= 1;
			 System.out.println("Thankyou " +player1 +" "+player2+" will set there location");
			 Thread.sleep(500);
			 printer(player2_Battlefield);
			 System.out.println(player2 + " please set you location");
			 System.out.print(player2 + " please select your row : ");
			 int player2_row = input.nextInt();
			 
			 System.out.print(player2 + " please select your column : ");
			 int player2_col = input.nextInt();
			 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			 player2_col-= 1;
			 player2_row-= 1;
			 for(int rag = 0 ; rag<4 ; rag++){
				    String val = "";
				    if (rag == 0){
				    	val = "first";
				    }else if(rag ==1){
				    	val = "second";
				    }else if (rag == 2){
				    	val = "third";
				    }else if (rag== 3){
				    	val = "fourth";
				    }
				    Thread.sleep(500);
				    //player1----------------------------------------------------------------------------------------
				    System.out.println(player1+ " This is your "+val+" turn");
				    player2_Battlefield = caller.player1(player2_Battlefield,player2,player2_row,player2_col);
				
						 //player2---------------------------------------------------------------------------------------------------
						 Thread.sleep(500);
						 System.out.println(player2+ " this is your "+val+" turn");
						 player1_Battlefield = caller.player2(player1_Battlefield,player1,player1_row,player1_col);
						 
			 
			 
			
			
		}
		System.out.println("Thank you for Playing , See you next time! ");
		
	}	else {
		 System.out.println(player2 + " has won the toss therefore " +  player2 + " starts");
		 Thread.sleep(500);
		 printer(player2_Battlefield);
		 System.out.println(player2 + " please set you location");
		 System.out.print(player2 + " please select your row : ");
		 int player2_row = input.nextInt();
		 
		 System.out.print(player2 + " please select your column : ");
		 int player2_col = input.nextInt();
		 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		 
		 
			    Thread.sleep(500);
			    System.out.println("Thankyou " +player2 +" "+player1+" will set there location");
				 printer(player1_Battlefield);
				 Thread.sleep(500);
				 System.out.println(player1 + " please set you location");
				 System.out.print(player1 + " please select your row : ");
				 
				 int player1_row = input.nextInt();
				
				 System.out.print(player1 + " please select your column : ");
				 int player1_col = input.nextInt();
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				 player1_col -= 1;
				 player1_row -= 1;
				 player2_col-= 1;
				 player2_row-= 1;
				 for(int rag = 0 ; rag<4 ; rag++){
					    String val = "";
					    if (rag == 0){
					    	val = "first";
					    }else if(rag ==1){
					    	val = "second";
					    }else if (rag == 2){
					    	val = "third";
					    }else if (rag== 3){
					    	val = "fourth";
					    }
					    //player2---------------------------------------------------------------------------------------------------
						 Thread.sleep(500);
						 System.out.println(player2+ " this is your "+val+" turn");
						 player1_Battlefield = caller.player2(player1_Battlefield,player1,player1_row,player1_col);
						 
					    Thread.sleep(500);
					    //player1----------------------------------------------------------------------------------------
					    System.out.println(player1+ " This is your "+val+" turn");
					    player2_Battlefield = caller.player1(player2_Battlefield,player2,player2_row,player2_col);
		
	}
		
					
							
				 
				 
				
				
			}
			System.out.println("Thank you for Playing , See you next time! ");
		
			
	}

	public static void comp()throws InterruptedException{
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		String[][] Battlefield = new String[5][5];
		String[][] com_Battlefield = new String[5][5];
		for(int v = 0 ; v<=4;v++){
			for(int h = 0 ; h<=4 ;h++){
				Battlefield[v][h] = "o";
				com_Battlefield[v][h] = "o";
			}
		}	
		int row = random.nextInt(5);
		int column = random.nextInt(5);
		row += 1;
		column += 1 ;
		System.out.println("row"+row);
		System.out.println("col"+column);
		 System.out.println("Please Select the coordinates of your battleship");
			
		 printer(Battlefield);
		 System.out.print("Enter the row you battleship is going to be located in : ");
		 int user_row = input.nextInt();
		 System.out.print("Enter the column you battleship is going to be located in : ");
		 int user_col = input.nextInt();
		 System.out.println("Location Set!!! ");
		user_row -= 1;
		user_col -= 1;
		
		for(int c = 0;c<4; c++){
			Thread.sleep(500);
			 System.out.println("The Computers turn ");
			 Thread.sleep(500);
			int compguess_row = random.nextInt(4);
			int compguess_col = random.nextInt(4);
			
			if(compguess_row == user_row && compguess_col == user_col){
				System.out.println("Sorry the computer sunk your battleship");
				System.out.println("The coordinates were : ");
				 Thread.sleep(500);
				System.out.println("Row : " + row);
				System.out.println("Column : " + column);
				 Thread.sleep(500);
				com_Battlefield[row-1][column-1] = "x";
				printer(com_Battlefield);
				 Thread.sleep(500);
				System.out.println("Thank you for Playing , See you next time! ");
				System.exit(1);
				
			}else{
				System.out.println("The Computer missed your battleship");
				com_Battlefield[compguess_row][compguess_col] = "x";
			}
			printer(com_Battlefield);
			//USER GUESS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		    String val = "";
		    if (c == 0){
		    	val = "first";
		    }else if(c ==1){
		    	val = "second";
		    }else if (c == 2){
		    	val = "third";
		    }else if (c== 3){
		    	val = "fourth";
		    }
		    Thread.sleep(500);
		    System.out.println("This is your "+val+" turn");

		    Thread.sleep(500);
		  printer(Battlefield);
		  Thread.sleep(500);
			System.out.print("Enter the row you think my battleship is located in : ");
			int vertical = input.nextInt();
			System.out.print("Enter the column you think my battleship is located in : ");
			int horizontal = input.nextInt();
			vertical -= 1;
			horizontal -= 1;
					
		
				 if (vertical == column && horizontal == row){
			    	 System.out.println("Congratulation!! , you sunk my battlehip.");
			    	 System.out.println("Thank you for Playing , See you next time! ");
			    	 
			    	 System.exit(1);
			    	 
			     }else if(vertical < 0 || vertical >5 ){
			    	System.out.println("Oops , thats not even in the ocean");
			     }else if(horizontal < 0 || horizontal >  5) {
			    		System.out.println("Oops , thats not even in the ocean");
			    	 
			     }else {
			    	 System.out.println("You missed!.");
			    	 Battlefield[vertical][horizontal] = "x";
			    	 
			     }
			    	 
			
		}
	    //Ending statement...........................................................................................
		System.out.println("The coordinates were : ");
		 Thread.sleep(500);
		System.out.println("Row : " + row);
		System.out.println("Column : " + column);
		 Thread.sleep(500);
		Battlefield[row-1][column-1] = "x";
		printer(Battlefield);
		 Thread.sleep(500);
		System.out.println("Thank you for Playing , See you next time! ");
		
	}
	public static void start()throws InterruptedException{
		System.out.println("Welcome to Raghav's Battleship game");
		Thread.sleep(1000);
		System.out.println("Description :");
		Thread.sleep(500);
		System.out.println("1. You get four turns");
		Thread.sleep(500);
		System.out.println("2. Choose between 1 and 5 for row and columns. ");
		Thread.sleep(500);
		System.out.println("Starting....");
		Thread.sleep(500);
		System.out.println("1....");
		Thread.sleep(500);
		System.out.println("2....");
		Thread.sleep(500);
		System.out.println("3....");
		
		Thread.sleep(500);
		System.out.println("Start");
	}
	

	
	public static void main(String[]args)throws IOException, InterruptedException {
	
		start();
	Scanner input = new Scanner(System.in);
	Random random = new Random();
	

	System.out.println("1 . Dual Player");
	System.out.println("2 . Against the computer");
	System.out.print("What mode do you want to play : ");
	int player_choice = input.nextInt();
	input.skip("((?<!\\R)\\s)*");
	if (player_choice == 2){
		comp();
	}else if (player_choice == 1){
		
		dual();
		 }
	}
	
}


	
	
	
	
	
