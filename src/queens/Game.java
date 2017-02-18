package queens;


/**
 * solve the n queens problem
 * 
 * @author (Peter Cipolone) 
 * @version (April 23, 2015)
 */
public class Game
{
    public static final int  SIZE = 8;
   
    public static void main(String[] args)
    {
        Game game = new Game();
        System.out.println ("Solution is " + game.placeQueen (0, new Board()));
    }
    
    
    
    /**
  * @return the new board if queens can bbe placed on Board b in columns col .. SIZE-1, 
  * or null if not possible
  * Pre: queens have been successfully placed on Board b
  * in columns 0..col-1
  */
  private Board placeQueen(int col, Board b)
  {
     Position p; 
     Board result;
     
     for(int row = 0; row < Game.SIZE; row++)
     {
         p = new Position (row,col);
         result = new Board (b);    //Copy constructor 
         result.addQueen(p);
         if (! result.check())
         {
             if(col <SIZE - 1) //Recursive case
             {
                 result = placeQueen(col+1, result);
                 if (result != null)
                 {
                     return result;
                 }
                 
             }
             else
             {
                 return result; //Base case 
             }
         }
     }
     
     return null;
  }
}

 