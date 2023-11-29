import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

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
    public void clearScreen(){
        char c = '\n';
        int length = 40;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
    }

    public int getNumLmd(){
        return numLmd;
    }
    public Game(){
        Operator o = new Operator("Angelina");
        askName();
        printCurrency();
        askToHire(o);
        waitLater();
        askAboutCook();
        clearScreen();
        Operation op = new Operation();
        op.startOperation(numLmd);
        clearScreen();
        waitLater();
        ptilopsisEncounter();
        waitLater();
        endDay();
        checkOperator(o);
        breakfastMontage();
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
    public void askToHire(Operator o){
        System.out.println("Do you want to hire operators?");
        Scanner scan = new Scanner(System.in); //scanner reuse
        String askHireOperator = scan.nextLine().toLowerCase();

        //ask to pull
        if (askHireOperator.equals("yes")){ //want to pull
            System.out.println("\nAlright! That'll be 6000 orundum spent, which means... ");
            numOrundum = numOrundum-6000; //substract

            Wait(3000);

            System.out.println("There's "+numOrundum+" orundum left.\n");
            o.setName("Texas");
            o.setAttack(219);
            o.setRedeploymentTime(18.0);

            System.out.println(o.getName()+" was hired! She would however like some compensation for her work and training. The total amount will be half our current LMD amount.");

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
                System.out.println("\nAfter returning from her mission in Siracusa, it is "+isSixStar+" that she has gained more experience in battle. Her redeployment time has been reduced heavily to "+o.getRedeploymentTime()+" seconds. It increases by "+(o.getRedeploymentTime()/4)+" seconds on each new redeployment.");
                o.getAttack();

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

            Wait(2000);
            if (chooseCook.equals("gummy")){ //YES GOOD
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

                System.out.println("\nIt seems the operators don't like her cooking... I think we should send them to the medical wing..");

                break;
            }
            else { //choose neither
                System.out.println("Doctor, the only two operators to cook here are Gummy and Lava!");
            }
        }
        Wait(2500);
    }

    public void ptilopsisEncounter(){
        System.out.println("..but I don't think Blaze should- is that Ptilopsis? Hey! How are you after that operation?");
        Wait(2000);
        System.out.println("Ptilopsis: Rhine Lab.. so much work...\nshutting.. down...zzz");
        Wait(2000);
        System.out.println("Uhh Doctor.. I think she needs some help staying awake.. what should we do?\n");
        Scanner s = new Scanner(System.in); //scanner reuse
        String askForPtilopsis = s.nextLine().toLowerCase();
        Wait(1800);
        Random rand = new Random();
        int chanceAwoken = rand.nextInt(100);
        if (askForPtilopsis.length()%2==0){
            System.out.println("Let's try it out!\n");
        }else{
            System.out.println("That doesn't sound like a good idea..\n");
        }
        Wait(2000);
        if (chanceAwoken>=70){
            System.out.println("Ptilopsis: !!");
            Wait(1000);
            System.out.println("Woah! It woke her up.. and she's gone...");
        }else{
            System.out.println("Ptilopsis: zzz");
            Wait(1000);
            System.out.println("Still asleep..");
        }
    }
    public void endDay(){
        Integer time = 18;
        System.out.println("\nIt's been a pretty long "+time.toString()+" hours, I think I'll go to sleep. Goodnight, Doctor.");
        Wait(2000);
    }
    public void checkOperator(Operator o){
        System.out.println("Good morning, Doctor, let me do a file check real quick.\n");
        System.out.println("It is "+o.equals("Texas")+" that the most recently hired operator is Texas.");
    }
    public void breakfastMontage(){
        System.out.println("You must be hungry, let's go to the cafeteria.\n\n\nOne trip to the cafe later..\n");
        String[] foods = {"Yogurt","Rice","Orange Juice","Oatmeal","Omelette","Toast","Mango Juice"};
        for (int i=0; i<foods.length; i++){
            if ((foods[i].toLowerCase()).indexOf("juice") >= 0){
                System.out.print("\n*Doctor drinks ");
            }else {
                System.out.print("\n*Doctor eats ");
            }
            System.out.println(foods[i]+"*");
        }
        if (foods.length>=5){ //so it's adjustable
            System.out.println("\n\nWoah, Doctor, slow down! The food won't run away!\n");
        }else{
            System.out.println("\n\nYou didn't finish everything? I can give the rest to Ceobe.\n");
        }
    }

}

