import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Palindrome<String> palindrome = new Palindrome<String>();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nEnter a word or phrase. (Enter \"0\" to exit)");
        String word = keyboard.nextLine();

        while(word != "0")
        {
            System.out.println(palindrome.isPalindrome(word));
            System.out.println("\nEnter another word or phrase. (Enter \"0\" to exit)");
            word = keyboard.nextLine();
        }
    }
}

