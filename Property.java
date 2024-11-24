public class Property {
    private int cost, rent;
    private Player owner;

    Property(int cost, int rent){
        this.cost = cost;
        this.rent = rent;
    }

    public void setOwner(Player owner){
        this.owner = owner;
    }

    public Player getOwner(){
        return this.owner;
    }

    public int getCost(){
        return this.cost;
    }

    public int getRent(){
        return this.rent;
    }

}
