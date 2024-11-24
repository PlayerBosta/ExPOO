public class DemandingPlayer extends Player {
    public void buyProperty(Property property){
        int cost = property.getCost();
        int rent = property.getRent();

        if (this.coin >= cost && rent > 50) {
            this.coin -= cost;
            this.properties.add(property);
            property.setOwner(this);
        }
    }
}
