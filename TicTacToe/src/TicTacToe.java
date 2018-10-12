import java.util.Scanner;

public class TicTacToe {
	
	public static char[][] board = new char[3][3];
	public static int gameCounter = 0;
	public static boolean isValidInput = false;
	public static boolean isGameOver = false;
	public static char winner = ' ';
	public static int xCoord = 0;
	public static int yCoord = 0;
	
	// Player X = turn 0
	// Player O = turn 1
	public static int turn = 0;

	public static void main(String[] args) {
		
		System.out.println("Welcome to TicTacToe!");
		
		resetBoard();
		System.out.println("Empty Board:");
		printBoard();
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		
		while(!isGameOver) 
		{
			/* 
			 * *********************************************************************
			 *
			 * PLAYER 0
			 * 
			 * *********************************************************************
			 */
			if(turn == 0)
			{
				
				// Do while loop for checking PLAYER X's --> X position
				do {
				    System.out.println("Player X --> Enter X Coordiante between 0 and 2:");
				    while (!sc.hasNextInt()) {
				    	System.out.println("That's not a valid input, try again\n"); 
				        System.out.println("Player X --> Enter X Coordiante between 0 and 2: ");
				        sc.next(); // this is important!
				    }
				    xCoord = sc.nextInt();
				    
				    if(xCoord < 0 || xCoord > 2) 
				    {
				    	System.out.println("Thats not a number between 0 and 2, try again \n");
				    	
				    }
				} while (xCoord < 0 || xCoord > 2);
				
				
				// Do while loop for checking PLAYER X's --> Y position
				do {
				    System.out.println("Player X--> Enter Y Coordiante between 0 and 2:");
				    while (!sc.hasNextInt()) {
				    	System.out.println("That's not a valid input, try again \n"); 
				        System.out.println("Player X --> Enter Y Coordiante between 0 and 2: ");
				        sc.next(); // this is important!
				    }
				    yCoord = sc.nextInt();
				    
				    if(yCoord < 0 || yCoord > 2) 
				    {
				    	System.out.println("Thats not a number between 0 and 2, try again \n");
				    	
				    }
				} while (yCoord < 0 || yCoord > 2);
				
				
				// Print out coordinates of player X's move
				System.out.println("Player X play coordinate (" + xCoord + ", " + yCoord + ")\n");
				
				
				// Conditional statement ot check if the input move is a free space
				if(board[xCoord][yCoord] == 'X' || board[xCoord][yCoord] == 'O') 
				{
					System.out.println("Space is already taken, try again\n");
					turn = 0;
				}
				else
				{
				board[xCoord][yCoord] = 'X';
				turn = 1;
				}
				
				printBoard();
				System.out.println();
				
				determineWinner();
		
			}
			
			
			/* 
			 * *********************************************************************
			 *
			 * PLAYER 0
			 * 
			 * *********************************************************************
			 */
			
			else 
			{
				
				// Do while loop for checking PLAYER O's --> X position
				do {
				    System.out.println("Player O --> Enter X Coordiante between 0 and 2:");
				    while (!sc.hasNextInt()) {
				        System.out.println("That's not a valid input, try again\n"); 
				        System.out.println("Player O --> Enter X Coordiante between 0 and 2: ");
				        
				        sc.next(); // this is important!
				    }
				    xCoord = sc.nextInt();
				    
				    if(xCoord < 0 || xCoord > 2) 
				    {
				    	System.out.println("Thats not a number between 0 and 2, try again \n");
				    	
				    }
				} while (xCoord < 0 || xCoord > 2);
				
				
				// Do while loop for checking PLAYER O's --> X position
				do {
				    System.out.println("Player O --> Enter Y Coordiante between 0 and 2:");
				    while (!sc.hasNextInt()) {
				    	System.out.println("That's not a valid input, try again \n"); 
				        System.out.println("Player O --> Enter Y Coordiante between 0 and 2: ");
				        sc.next(); // this is important!
				    }
				    yCoord = sc.nextInt();
				    
				    if(yCoord < 0 || yCoord > 2) 
				    {
				    	System.out.println("Thats not a number between 0 and 2, try again \n");
				    	
				    }
				} while (yCoord < 0 || yCoord > 2);
				
				
				// Prints out coordinates of player O's move
				System.out.println("Player O play coordinate (" + xCoord + ", " + yCoord + ")\n");
				
				
				// Conditional statement to check if current input move is a free space
				if(board[xCoord][yCoord] == 'X' || board[xCoord][yCoord] == 'O') 
				{
					System.out.println("Space is already taken, try again\n");
					turn = 1;
				}
				else
				{
				board[xCoord][yCoord] = 'O';
				turn = 0;
				}
				
				
				printBoard();
				System.out.println();
				determineWinner();
			
			}
		}
		
		System.out.println("Thanks for Playing!");
		
		
		
		
	}
	public static boolean isBoardFull() 
	{
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[0].length; j++) 
			{
				if(board[i][j] == '.')
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void determineWinner() 
	{
		
		// Check top horizontal row
		if(board[0][0] != '.'&& board[0][0] == board[0][1] && board[0][0] == board[0][2]) 
		{
			winner = board[0][0];
			System.out.println("The Winner is: " + winner);
			isGameOver = true;
		}
		
		// Check middle horizontal row 
		else if(board[1][0] != '.'&& board[1][0] == board[1][1] && board[1][0] == board[1][2]) 
		{
			winner = board[1][0];
			System.out.println("The Winner is: " + winner);
			isGameOver = true;
		}
		
		// Check bottom horizontal row 
		else if(board[2][0] != '.'&& board[2][0] == board[2][1] && board[2][0] == board[2][2]) 
		{
			winner = board[2][0];
			System.out.println("The Winner is: " + winner);
			isGameOver = true;
		}
		
		// Check left Vertical column
		else if(board[0][0] != '.' && board[0][0] == board[1][0] && board[0][0] == board[2][0]) 
		{
			winner = board[0][0];
			System.out.println("The Winner is: " + winner);
			isGameOver = true;
		}
		
		// Check middle vertical column
		else if(board[0][1] != '.' && board[0][1] == board[1][1] && board[0][1] == board[2][1]) 
		{
			winner = board[0][1];
			System.out.println("The Winner is: " + winner);
			isGameOver = true;
		}
		
		// Check right vertical column
		else if(board[0][2] != '.' && board[0][2] == board[1][2] && board[0][2] == board[2][2]) 
		{
			winner = board[0][2];
			System.out.println("The Winner is: " + winner);
			isGameOver = true;
		}
		
		//Check top left --> bottom right diagnol
		else if(board[0][0] != '.' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) 
		{
			winner = board[0][0];
			System.out.println("The Winner is: " + winner);
			isGameOver = true;
		}
		
		// Check bottom left --> top right diagnol
		else if(board[2][0] != '.'&& board[2][0] == board[1][1] && board[2][0] == board[0][2]) 
		{
			winner = board[2][0];
			System.out.println("The Winner is: " + winner);
			isGameOver = true;
		}
		
		// If no win condition is met, cats game
		else if(isBoardFull() == true)
		{
			System.out.println("The game resulted in a Cats Game..");
			isGameOver = true;
		}
		
	}
	
	public static void resetBoard()
	{
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[0].length; j++) 
			{
				board[i][j] = '.';
			}
		}
	}
	
	public static void printBoard() 
	{
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[0].length; j++) 
			{
				System.out.print(board[i][j]);
			}
			
			System.out.println("");
		}
	}
}
