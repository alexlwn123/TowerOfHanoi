/**
 *Tower of Hanoi in command line.
 *Play the game as prompted.
 *@author Alex Lewin
 */

import java.util.*;
import java.util.regex.*;
public class TowerOfHanoi{

  public static void main(String[] args){
     Scanner input = new Scanner(System.in);
  //intro section\\
     System.out.println("Welcome to Tower Of Hanoi! By Alex Lewin \n");
     System.out.print("Please input the number of rings you would like to play with: ");
    
     String devexit = "";
     boolean cheat = false;
     int height = 0;
    
     try {   
        devexit = input.next();
        height = Integer.parseInt(devexit);
      
     }
        catch(NumberFormatException notNumber){
           if(devexit.equals("nickelbackistheonlygod"))
              cheat = true;
        
           System.out.println("Invalid Input");
           System.out.print("Please input a valid number of rings you would like to play with: ");
        
        }
  
     while(height <= 0){
     
        try {   
           height = Integer.parseInt(input.next());	  
        }
           catch(NumberFormatException notNumber){
              System.out.println("Invalid Input");
              System.out.print("Please input a valid number of rings you would like to play with: ");
           }
     }
  
  
     
     int[] a = new int[height], b = new int[height] ,c = new int[height];
    
     a = startfill(a);
     int moves = 0;
  //cheat section\\
     if(cheat){
        TowerSolver.a=a;
        TowerSolver.b=b;
        TowerSolver.c=c;
        TowerSolver.sort(height,a,c,b);
      
        displayboard(a,b,c);
        System.out.println("You Win!");
        System.out.println("Moves: " + TowerSolver.count);
        System.out.println("Best Possible: " + (int) (Math.pow(2, height) -1));
        return;
     }
  
  
  
  //game section\\
     while(!finished(c) && !finished(b)){    
        displayboard(a,b,c);
        System.out.println("Move " + (moves + 1) + ":");
     //pick move section\\
        System.out.print("From: ");
        String from = input.next().substring(0,1);
      
        while(Pattern.matches("[^abc]", from)){
           System.out.println("Invalid Input.");
           System.out.print("Move: ");
           from = input.next().substring(0,1);
        
        }
      
        System.out.print("Move: " + from + " -> ");
        String to = input.next().substring(0,1);
     
     
        
     
        while(Pattern.matches("[^abc]", to)) {
           System.out.println("Invalid Input.");
           System.out.print("Move: " + from + " -> ");
           to = input.next().substring(0,1);
        }   
     
        boolean okay = false;
     
     
        if(from.equals("a")){
           if(to.equals("b")){
              if(legalmove(a, b)){
                 move(a,b);
                 okay = true;
              }
           }
           
           else if(to.equals("c")){
              if(legalmove(a, c)){
                 move(a,c);
                 okay = true;
              }
           }
        }
           
        
        else if(from.equals("b")){
           if(to.equals("a")){
              if(legalmove(b, a)){
                 move(b,a);
                 okay = true;
              }
           }
           
           else if(to.equals("c")){
              if(legalmove(b, c)){
                 move(b,c);
                 okay = true;
              }
           }
        }
        
        else if(from.equals("c")){
           if(to.equals("a")){
              if(legalmove(c, a)){
                 move(c,a);
                 okay = true;
              }
           }
           
           else if(to.equals("b")){
              if(legalmove(c, b)){
                 move(c,b);
                 okay = true;
              }
           }
        }
     
        if(!okay)
           System.out.println("Move Impossible.");
        else
           moves++;
        
     }  
     
     
  
  
     displayboard(a,b,c);
     System.out.println("You Win!");
     System.out.println("Moves: " + moves);
     System.out.println("Best Possible: " + (int) (Math.pow(2, height) -1));
  
  
  }
  public static int[] startfill(int[] a){
     for(int i = 0; i < a.length; i++)
        a[i] = i+1;
     return a;
  }


  public static void displayboard(int[] a, int[] b, int[] c){
     System.out.println("\n-------------");
     for(int i = 0; i < a.length; i++)
        System.out.println("  " + (a[i] == 0 ? "|" : a[i])
                  + (a[i] <= 9 ? "   ": "  ") + (b[i] == 0 ? "|" : b[i])
                  + (b[i] <= 9 ? "   ": "  ") + (c[i] == 0 ? "|" : c[i]));
     System.out.println("-------------");
     System.out.println(" [a] [b] [c] ");
  } 


  private static boolean legalmove(int[] from, int[] to){
     if(from[from.length-1] == 0|| to[0] != 0)
        return false;
     
     int fromtop = findtop(from);        
     int totop = findtop(to);
  
     return (totop == to.length || to[totop] > from[fromtop]);
  }

  private static int findtop(int[] nums){
     for(int i = 0; i < nums.length; i++)
        if(nums[i] != 0)
           return i;
          
     return nums.length;
  }

  public static void move(int[] from, int[] to){
     to[findtop(to)-1] = from[findtop(from)];
     from[findtop(from)] = 0;
  }

  private static boolean finished(int[] nums){
     for(int i = 0; i < nums.length; i++)
        if(nums[i] != i+1)
           return false;
     return true; 
  
  }

  

}
