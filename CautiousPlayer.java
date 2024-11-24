public class CautiousPlayer extends Player{
    public void buyProperty(Property property){
        int cost = property.getCost();
        int reserve = coin - cost;

        if (this.coin >= cost && reserve >= 80) {
            this.coin -= cost;
            this.properties.add(property);
            property.setOwner(this);
        }
    }

}
