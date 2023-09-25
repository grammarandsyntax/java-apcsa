public class Operator {
    //instance variables
    private String name;
    private int level;
    private int potential;
    private int attack;
    private int defense;
    private double redeploymentTime;

    Operator() {
        level = 1;
    }

    //methods
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRedeploymentTime(double redeploymentTime){
        this.redeploymentTime = redeploymentTime;
    }

    public double getRedeploymentTime(){
        return redeploymentTime;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }
    
    public void getAttack(){
        System.out.println(name+" has "+attack+" attack.");
    }
}
