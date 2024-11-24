import java.util.Random;

public class RandomPlayer extends Player {
    public void buyProperty(Property property){
        int cost = property.getCost();
        boolean buy = new Random().nextBoolean();
        
        if (this.coin >= cost && buy) {
            this.coin -= cost;
            this.properties.add(property);
            property.setOwner(this);
        }
    }

}
