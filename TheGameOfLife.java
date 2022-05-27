import java.util.Scanner;

/**
 * 
 * @author Teeron
 * 
 * Date Due: October 25th
 * Block: D
 * 
 * Description: 
 * This program asks the user for
 * the number of generations they
 * want to go through. It then asks
 * the user the coordinates of 
 * which cells should be "alive". 
 *
 */

public class TheGameOfLife 
{

	//Finals are declared
	public static final int MAX_COLS = 12;
	public static final int MAX_ROWS = 12;
	public static final Scanner CONSOLE = new Scanner(System.in);

	public static void main(String[] args)
	{

		//Creates the grid for the number of neighbors and the display grid
		char[][] grid = new char[MAX_ROWS][MAX_COLS];
		int[][] gridCount = new int[MAX_ROWS][MAX_COLS];

		int xCor = 0;
		int yCor = 0;

		int generations = getNumGen();

		fill(grid);
		countNbrs(gridCount);
		fillCells(grid, gridCount, xCor, yCor);
		makeGrid(grid);

		for (int i = 1; i < generations; i ++)
		{

			changeGen(gridCount, grid);
			update(gridCount, grid);
			makeGrid(grid);
			countNbrs(gridCount);

		}

	}

	/**
	 * Where the grid that is displayed
	 * is updated based on how many neighbors 
	 * each cell has
	 * 
	 * @param gridCount
	 * @param grid
	 */
	private static void update(int[][] gridCount, char[][] grid) 
	{

		for(int row = 1; row < MAX_ROWS - 1; row ++)
		{

			for(int col = 1; col < MAX_COLS - 1; col ++)
			{

				if(gridCount[row][col] == 3)
				{

					grid[row][col] = '#';

				}
				if(gridCount[row][col] <= 1)
				{

					grid[row][col] = '*';

				}
				if (gridCount[row][col] >= 4)
				{

					grid[row][col] = '*';

				}

			}

		}

	}

	/**
	 * Goes through all the cells in the
	 * grid and counts the amount of neighbors
	 * they have
	 * 
	 * @param gridCount
	 * @param grid
	 */
	private static void changeGen(int[][] gridCount, char[][] grid) 
	{

		for(int row = 1; row < MAX_ROWS - 1; row ++)
		{

			for(int col = 1; col < MAX_COLS - 1; col ++)
			{

				int numNbrs = 0;

				if(grid[row - 1][col - 1] == '#')
				{
					numNbrs ++;
				}

				if(grid[row][col - 1] == '#')
				{
					numNbrs ++;
				}

				if(grid[row - 1][col] == '#')
				{
					numNbrs ++;
				}

				if(grid[row + 1][col + 1] == '#')
				{
					numNbrs ++;
				}

				if(grid[row + 1][col] == '#')
				{
					numNbrs ++;
				}

				if(grid[row][col + 1] == '#')
				{
					numNbrs ++;
				}

				if(grid[row + 1][col - 1] == '#')
				{
					numNbrs ++;
				}

				if(grid[row - 1][col + 1] == '#')
				{
					numNbrs ++;
				}

				gridCount[row][col] = numNbrs;

			}

		}

	}

	/**
	 * Asks the user for the number
	 * of generations they want
	 * 
	 * @return
	 */
	private static int getNumGen() 
	{

		System.out.println("How many generations do you want to do:");
		int gens = CONSOLE.nextInt();

		return gens;

	}

	/**
	 * Fills the display grid
	 * 
	 * @return
	 */
	private static void fill(char[][] grid) 
	{

		for(int row = 0; row < grid.length; row ++)
		{

			for(int col = 0; col < grid[0].length; col ++)
			{

				grid[row][col] = '*';

			}

		}

	}

	/**
	 * Resets the number of neighbors
	 * each cell has
	 * 
	 * @param gridCount
	 */
	public static void countNbrs(int[][] gridCount)
	{

		for(int row = 0; row < gridCount.length; row ++)
		{

			for(int col = 0; col < gridCount[0].length; col ++)
			{

				gridCount[row][col] = 0;

			}

		}

	}

	/**
	 * Prints the display grid
	 * 
	 * @return
	 */
	private static void makeGrid(char[][] grid) 
	{

		for(int row = 1; row < MAX_ROWS - 1; row ++)
		{

			for(int col = 1; col < MAX_COLS - 1; col ++)
			{

				System.out.print(grid[row][col]);
				System.out.print(' ');

			}

			System.out.println();

		}

		System.out.println();

	}

	/**
	 * Asks the user for the cells that 
	 * they want "alive" and changes them
	 * on the display grid
	 * 
	 * @param grid 
	 */
	private static void fillCells(char[][] grid, int[][] gridCount, int xCor, int yCor)
	{

		System.out.println("Enter the coordinates of the living cells. Type in -1 -1 when you're done");

		while(xCor >= 0 && yCor >= 0)
		{

			xCor = CONSOLE.nextInt();
			yCor = CONSOLE.nextInt();

			if(xCor >= 0 && yCor >= 0)
			{

				grid[yCor][xCor] = '#';

			}

		}

	}

}