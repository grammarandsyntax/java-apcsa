import java.util.Scanner;
import java.util.Date;
public class Main
{
    static void Wait()
    {
        try {
            Thread.sleep(4000);
        } catch(InterruptedException e){ 
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args)
    {
        //Lancet section
        int numLmd = 340785;
        int numOrundum = 29310;
        final boolean isSixStar = true; //only used when six star op is mentioned (texas?)
        double redeploymentTime = 18.5;
        int numSixStarOperators = 0;

        System.out.println("What is your name?");
        Scanner scan = new Scanner(System.in); //scanner opens
        String name=scan.nextLine();
        System.out.println("Hello Dr. "+name+". I am Lancet-2, model Exister-S62, and I will be subbing in for miss Amiya for the next few days.");
        scan.close(); //scanner closes
        Wait();
        System.out.println("I'll start off with a recording of your current LMD and Orundum counts.");
        System.out.println("Calibrating...");
        Wait();
        System.out.println("You currently have "+numLmd+" LMD and "+numOrundum+" Orundum.");
        System.out.println("You wish to search for new operators? I suppose I can't stop you...");
        System.out.println("Recalibrating orundum amount...");
        Wait();
        numOrundum=numOrundum-6000; //10 pull lol
        System.out.println("You now have "+numOrundum+" Orundum. And it looks like you've hired miss Texas! However, she'd like some compensation in LMD for her work; about half of our current amount.");
        Wait();
        System.out.println("You accept the charges? Alright, I'll send the requested LMD over to her.");
        numLmd/=2;
        numSixStarOperators++;
        System.out.println("There is now "+numLmd+" LMD in our holdings, and your current number of Top Operators is "+numSixStarOperators+".");
        Wait();
        System.out.println("Doctor, you wish to learn more about Texas? Well, after returning from her mission in Siracusa, it is "+isSixStar+" that she has gained more experience in battle. Her redeployment time has been reduced heavily to "+redeploymentTime+" seconds. It increases by "+(redeploymentTime%2.0)+" seconds on each new redeployment.");
        Wait();
        Wait();
        System.out.println("Wait, you want to hire more operators already?! Doctor, please let me recompensate the missing amount with some mining operations..");
        numOrundum=(numOrundum-6000)*2;


    }
}
