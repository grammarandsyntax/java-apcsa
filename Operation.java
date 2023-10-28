import java.util.Random;
public class Operation {

    static void Wait(int milliseconds)
    {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public Operation(){
        introOperation();
    }

    public void introOperation(int t){
        System.out.println("");
        System.out.println("Doctor, I believe we need to run an operation. Get all the operators prepared; operation commencing!");
        System.out.println("");
        Wait(t);
    }
    public void introOperation(){
        System.out.println("");
        System.out.println("Doctor, I believe we need to run an operation. Get all the operators prepared; operation commencing!");
        System.out.println("");
        Wait(3000);
    }
    public int randomNummy(int min, int max){
        return (int)(Math.random()*(max-min+1))+min;
    }

    public void startOperation(int l){
        int chanceWon = randomNummy(1,100);

        Wait(3000);
        if (chanceWon > 15){ //operation won
            System.out.println("Doctor, we won! I know we can handle anything with you around! Now let's see what we've obtained!\n");
            Wait(2000);
            int obtainedLmd = randomNummy(1,450);
            if (obtainedLmd >= 200){
                System.out.println("Nice, we picked up "+obtainedLmd+" Lmd!");
            } else {
                System.out.println("Ah, we picked up "+obtainedLmd+" Lmd.");
            }
            l+= obtainedLmd;
            System.out.println("\nDid we get any extra materials?\n");
                int obtainedMaterials = randomNummy(1,100);
                if (obtainedMaterials>65){
                    System.out.println("Closure will find this oriron particularly useful!");
                } else {
                    System.out.println("Oh well, maybe next time.");
                }
            } else {
                System.out.println("We lost! I'm fine... Get it together, everyone!");
            }
            Wait(3000);
        }
    }
