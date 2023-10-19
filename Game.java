import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private int numLmd = 340785;
    private int numOrundum = 29310;
    private final boolean isSixStar = true; //only used when six star op is mentioned (texas?)
    private int numSixStarOperators = 0;

    static void Wait(int milliseconds)
    {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public int getNumLmd(){
        return numLmd;
    }
    public Game(){
        askName();
        printCurrency();
        askToHire();
        waitLater();
        askAboutCook();
        Operation op = new Operation();
        op.startOperation(numLmd);
        clearScreen();
    }

    public void askName(){
        System.out.println("Please input your name:");
        Scanner scan = new Scanner(System.in); //scanner opens
        String name=scan.nextLine();
        System.out.println("Good morning Dr. "+name+". I hope you slept well, we've got a lot of work ahead of us!\n");
        Wait(3000);
    }
    public void printCurrency(){
        System.out.println("I'll start off with a recording of your current LMD and Orundum counts.\n");

        Wait(2000);

        System.out.println("You currently have "+numLmd+" LMD and "+numOrundum+" Orundum.");

    }
    public void askToHire(){
        System.out.println("Do you want to hire operators?");
        Scanner scan = new Scanner(System.in); //scanner reuse
        String askHireOperator = scan.nextLine().toLowerCase();

        //ask to pull
        if (askHireOperator.equals("yes")){ //want to pull
            System.out.println("\nAlright! That'll be 6000 orundum spent, which means... ");
            numOrundum = numOrundum-6000; //substract

            Wait(3000);

            System.out.println("There's "+numOrundum+" orundum left.\n");
            Operator Texas = new Operator("Texas",219,18.0);

            System.out.println(Texas.getName()+" was hired! She would however like some compensation for her work and training. The total amount will be half our current LMD amount.");

            Wait(4500);

            System.out.println("You accept the charges? Alright, I'll send the LMD to her.\n");
            numLmd/=2;
            numSixStarOperators++;
            System.out.println("There is now "+numLmd+" LMD in our holdings, and the current number of Top Operators is "+numSixStarOperators+".");

            Wait(4000);

            System.out.println("Doctor, do you want to learn more about miss Texas?");
            Scanner s = new Scanner(System.in); //scanner reuse
            String askInfo = scan.nextLine().toLowerCase();

            if (askInfo.equals("yes")){ //want infodump
                System.out.println("\nAfter returning from her mission in Siracusa, it is "+isSixStar+" that she has gained more experience in battle. Her redeployment time has been reduced heavily to "+Texas.getRedeploymentTime()+" seconds. It increases by "+(Texas.getRedeploymentTime()/4)+" seconds on each new redeployment.");
                Texas.getAttack();

                Wait(8000);
            } else {
                System.out.println("\nOk.. but remember, it's important to learn about your operators to learn how to most effectively command them in battle!");
                Wait(1500);
                System.out.println("Anyway, I'll go sort out Texas's files.");
            }
        }else{ //don't want to pull
            System.out.println("\nThat's alright, we have other matters to handle anyway!");
        }
    }
    public void waitLater(){
        Wait(3000);
        System.out.println("\nA bit later...\n");
        Wait(2000);
    }
    public void askAboutCook(){
        System.out.println("Doctor, while I was working, I overheard some operators in the cafeteria arguing... could you please help settle it? I think it's over who has to cook..?\n");

        while(true){ //choose bwteen gum and lava
            System.out.println("Do you choose Gummy or Lava as today's cook?");
            Scanner sc = new Scanner(System.in); //scanner reuse
            String chooseCook = sc.nextLine().toLowerCase();

            Wait(4000);
            if (chooseCook.equals("gummy")){ //YES GOOD

                Wait(3000);
                System.out.println("\nIt seems the operators like her cooking! How will you divide the food among them though..?");
                sc = new Scanner(System.in); //scanner reuse

                System.out.println("(How many whole pounds of food will you allocate?)");

                int poundsFood = sc.nextInt();

                System.out.println("(Between how many operators?)");

                sc = new Scanner(System.in); //scanner reuse
                int numOperatorsFood = sc.nextInt();
                sc.close(); //scanner closes

                try { //division
                    System.out.println("Ok, so we need to give each operator "+((double)poundsFood/numOperatorsFood)+" pounds of food."); //add truncation thing with mod
                }
                catch (ArithmeticException error){
                    System.out.println("Please don't use zero for this input, doctor!");
                }
                break;
            }
            else if (chooseCook.equals("lava")){ //booo

                Wait(3000);
                System.out.println("\nIt seems the operators don't like her cooking... I think we should send them to the medical wing..");

                break;
            }
            else { //choose neither
                System.out.println("Doctor, the only two operators to cook here are Gummy and Lava!");
            }
        }
        Wait(2500);
    }

    public void clearScreen(){
        char c = '\n';
        int length = 40;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
    }

}

