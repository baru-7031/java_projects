package TIK_TAC_Game;

import java.util.Random;
import java.util.Scanner;

public class TicTakGame
{
//    Print Array Always
    static void print(char[][] board)
    {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
//    This method for Move is valid or not
    static boolean isValidMove(char[][] board, String position)
    {
        switch(position)
        {
            case "1":
                return board[0][0] == ' ';
            case "2":
                return board[0][1] == ' ';
            case "3":
                return board[0][2] == ' ';
            case "4":
                return board[1][0] == ' ';
            case "5":
                return board[1][1] == ' ';
            case "6":
                return board[1][2] == ' ';
            case "7":
                return board[2][0] == ' ';
            case "8":
                return board[2][1] == ' ';
            case "9":
                return board[2][2] == ' ';
        }
        return false;
    }
//  This method for Input values
    static void inputValue(char[][] board, String position, char symbol)
    {
        switch(position)
        {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
        }
    }


//    This method for Player Moves
    static void playerMoves(char[][] board, Scanner sc, String name)
    {

        String playerMoves = "";
        while (true)
        {
            System.out.print("Which Position you want to play (1-9): ");
            playerMoves = sc.nextLine();
            if (isValidMove(board, playerMoves))
            {
                break;
            }
            else
            {
                System.out.println("Sorry Wrong Move :( " + playerMoves);
            }
        }
        System.out.println("Player Move is " + playerMoves);
        inputValue(board, playerMoves,'X');
    }

//    This method for Computer moves
    static void computerMove(char[][] board)
    {
        Random rand = new Random();
        int ComputerMove;
        while (true)
        {
            ComputerMove = rand.nextInt(8) +1;
            if (isValidMove(board, Integer.toString(ComputerMove)))
            {
                break;
            }
        }
        System.out.println("Computer Move is " + ComputerMove);
        inputValue(board, Integer.toString(ComputerMove),'O');
    }

//  This method for Finish the game
    static boolean isFinishgame(char[][] board, String name)
    {
//      Player checking
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X' ||
                board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
        {
            System.out.println(name + " Win! :)");
            return true;
        }

        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X' ||
                board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X' ||
                board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X' ||
                board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X' ||
                board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X' ||
                board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X'
                 )
        {
            System.out.println(name + " Win! :)");
            return true;
        }

//        Computer Checking
        if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O' ||
                board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
        {
            System.out.println("Computer Win! :)");
            return true;
        }

        if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O' ||
                board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O' ||
                board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O' ||
                board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O' ||
                board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O' ||
                board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'
                )
        {
            System.out.println("Computer Win! :)");
            return true;
        }


//      Finish game
        for (int i =0; i<board.length;i++)
        {
            for (int j =0; j<board[i].length; j++)
            {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        System.out.println("Match Tie!");
        return true;
    }


//  Main Method
    public static void main(String[] args)
    {
//      Classes......
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

//        Variables Declares
        char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
//        Enter User name section
        System.out.print("Enter Your name : ");
        String name = sc.nextLine();
        System.out.println("Welcome " + name);
        System.out.println();
        System.out.println(name + " chance :");
        int userChance = rand.nextInt(5) + 1;
        System.out.println("Computer chance");
        int computerChance = rand.nextInt(5) + 1;



        if (userChance<computerChance)
        {
            System.out.println(computerChance + " Computer Move");
            System.out.println(userChance + " User Move");
            while(true)
            {
                //  Computer Section
                computerMove(board);
                print(board);
                if (isFinishgame(board,name))
                {
                    break;
                }
                //      Player Section
                playerMoves(board, sc, name);
                print(board);
                if (isFinishgame(board,name))
                {
                    break;
                }
            }
        }
        else
        {
            System.out.println(userChance + " User Move");
            System.out.println(computerChance + " Computer Move");
            while(true)
            {
                //      Player Section
                playerMoves(board, sc, name);
                print(board);
                if (isFinishgame(board,name))
                {
                    break;
                }

//              Computer Section
                computerMove(board);
                print(board);
                if (isFinishgame(board,name))
                {
                    break;
                }
            }
        }


        sc.close();

    }
}
