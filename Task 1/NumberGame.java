import java.util.Scanner;

class game{
    Scanner in = new Scanner(System.in);
    int num = (int) (Math.random() * 100) + 1;
    void mygame(int n){
        if (n == 0){
            System.out.println("Game Over!");
            System.out.println("The answer is: "+ num);
            return;
        }
        System.out.println("Make a guess: ");
        int i = in.nextInt();
        if(i>num){
            System.out.println("Too High!");
        }
        else if(i<num){
            System.out.println("Too Low!");
        }
        else{
            System.out.println("Congrats, you have guessed it!");
            return;
        }
        System.out.println("You have "+(n-1)+" attempt(s) to guess!");
        mygame(n-1);
    }
    public void game(){
        // Scanner in = new Scanner(System.in);
        System.out.println("Welcome to NUMBER GAME!");
        System.out.println("I'm Thinking of a number from 1 to 100");
        boolean game_not_end = true;
        while(game_not_end){
            System.out.println("Choose a difficulty. Type 'easy' or 'hard': ");
            String choice = in.nextLine();
            if(choice.equals( "easy")){
                System.out.println("You have 10 attempts to guess!");
                mygame(10);
            }
            else if(choice.equals("hard")){
                System.out.println("You have 5 attempts to guess!");
                mygame(5);
            }
            else{
                System.out.println("Give valid choice dude, starting from again.");
            }
            System.out.println("Type 'y' to play again: " );
            String c = in.next();
            if (c.equals("y")){  
                game();
            }
            else{
                return;
            }
        }
     }
}
public class NumberGame {
    public static void main(String[] args) {
        new game().game();
    }
}
