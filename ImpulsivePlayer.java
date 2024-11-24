public class ImpulsivePlayer extends Player{
    public void buyProperty(Property property){
        int cost = property.getCost();
        
        if (this.coin >= cost) {
            this.coin -= cost;
            this.properties.add(property);
            property.setOwner(this);
        }
    }
}
