import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("hello world");
        System.out.println("drjava sucks");

        //variables
        int inty=46;
        double floaty=-99.9;
        final boolean period3= true; //cannot be changed

        System.out.println(inty);
        System.out.println(floaty);
        System.out.println(period3);
        //test
        System.out.print("I have ");
        System.out.print(inty);
        System.out.println(" horses");
        System.out.println("");
        //1.3
        int day=1;
        double cash=99.99;
        System.out.println("On day "+day+" I have $"+cash);
        day=day+1;
        cash=cash/2;
        System.out.println("enter your address");
        Scanner scan=new Scanner(System.in);
        String question=scan.nextLine();
        System.out.println("I will find you at "+question);
        System.out.println("How much cash do you have?");
        String cashAmount=scan.nextDouble();
        System.out.println("Give me $"+cashAmount);
        scan.close();
        
    }
}
