import java.util.Scanner;
public class Main {

    static void Wait(int milliseconds)
    {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e){ 
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args)
    {
        //vars

        int numLmd = 340785;
        int numOrundum = 29310;
        final boolean isSixStar = true; //only used when six star op is mentioned (texas?)
        int numSixStarOperators = 0;

        //Amiya begin

        System.out.println("Please input your name:");
        Scanner scan = new Scanner(System.in); //scanner opens
        String name=scan.nextLine();
        System.out.println("Good morning Dr. "+name+". I hope you slept well, we've got a lot of work ahead of us!");

        Wait(3000);

        System.out.println("I'll start off with a recording of your current LMD and Orundum counts.");

        Wait(2000);

        System.out.println("You currently have "+numLmd+" LMD and "+numOrundum+" Orundum.");
        System.out.println("Do you want to hire operators?");
        scan = new Scanner(System.in); //scanner reuse
        String askHireOperator = scan.nextLine().toLowerCase();

        //ask to pull
        if (askHireOperator.equals("yes")){ //want to pull
            System.out.println("Alright! That'll be 6000 orundum spent, which means... ");
            numOrundum = numOrundum-6000; //substract

            Wait(3000);

            System.out.println("There's "+numOrundum+" orundum left.");
            Operator Texas = new Operator();
            Texas.setName("Texas");
            Texas.setRedeploymentTime(18.0);
            Texas.setAttack(219);

            System.out.println(Texas.getName()+" was hired! She would however like some compensation for her work and training. The total amount will be half our current LMD amount.");

            Wait(4500);
            
            System.out.println("You accept the charges? Alright, I'll send the LMD to her.");
            numLmd/=2;
            numSixStarOperators++;
            System.out.println("There is now "+numLmd+" LMD in our holdings, and the current number of Top Operators is "+numSixStarOperators+".");     

            Wait(4000);

            System.out.println("Doctor, do you want to learn more about miss Texas?");
            scan = new Scanner(System.in); //scanner reuse
            String askInfo = scan.nextLine().toLowerCase();

            if (askInfo.equals("yes")){ //want infodump
                System.out.println("After returning from her mission in Siracusa, it is "+isSixStar+" that she has gained more experience in battle. Her redeployment time has been reduced heavily to "+Texas.getRedeploymentTime()+" seconds. It increases by "+(Texas.getRedeploymentTime()/4)+" seconds on each new redeployment.");
                Texas.getAttack();

                Wait(8000);
            } else {
                System.out.println("Ok.. but remember, it's important to learn about your operators to learn how to most effectively command them in battle!");
                Wait(1500);
                System.out.println("Anyway, I'll go sort out Texas's files.");
            }
        } else {
            System.out.println("That's alright, we have other matters to handle anyway!");
        }

        Wait(3000);
        System.out.println(" ");
        System.out.println("A bit later...");
        System.out.println(" ");
        Wait(2000);

        //the silly 2

        System.out.println("Doctor, while I was working, I overheard some operators in the cafeteria arguing... could you please help settle it? I think it's over who has to cook..?");
        System.out.println(" ");
        System.out.println("Do you choose Gummy or Lava as today's cook?");
        scan = new Scanner(System.in); //scanner reuse
        String chooseCook = scan.nextLine().toLowerCase();

        Wait(4000);

        while(true){ //choose bwteen gum and lava
            if (chooseCook.equals("gummy")){ //YES GOOD

                Wait(3000);
                System.out.println("It seems the operators like her cooking! How will you divide the food among them though..?");
                scan = new Scanner(System.in); //scanner reuse

                System.out.println("(How many whole pounds of food will you allocate?)");

                int poundsFood = scan.nextInt();

                System.out.println("(Between how many operators?)");

                scan = new Scanner(System.in); //scanner reuse
                int numOperatorsFood = scan.nextInt();
                scan.close(); //scanner closes

                try { //division
                    System.out.println("Ok, so we need to give each operator "+((double)poundsFood/numOperatorsFood)+" pounds of food."); //add truncation thing with mod
                }
                catch (ArithmeticException error){
                System.out.print("Please don't use zero for this input, doctor!");
                }
            }
            else if (chooseCook.equals("lava")){

                Wait(3000);
                System.out.println("It seems the operators don't like her cooking... I think we should send them to the medical wing..");

            }
            else {
                System.out.println("Dr. "+name+", the only two cooks here are Gummy or Lava!");
                scan = new Scanner(System.in); //scanner reuse
                System.out.println("Do you choose Gummy or Lava as today's cook?");
            }
            break;
        }
        scan.close(); //scanner closes 
    }
}
