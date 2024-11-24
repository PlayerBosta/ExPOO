import java.util.ArrayList;

public abstract class Player {
    private int position;
    private boolean isPlaying;

    protected int coin;
    protected ArrayList<Property> properties;

    Player() {
        this.coin = 300;
        this.position = 0;
        this.isPlaying = true;
        properties = new ArrayList<Property>();
    }

    public int getPosition() {
        return this.position;
    }

    public boolean getIsPlaying() {
        return this.isPlaying;
    }

    public int getCoins() {
        return this.coin;
    }

    public int move(int steps) {
        this.position += steps;

        if (this.position > 20) {
            this.position -= 20;
            this.receive(100);
        }

        return this.position;
    }

    public void receive(int coin) {
        this.coin += coin;
    }

    public void payRent(Property property) {
        Player owner = property.getOwner();
        int rent = property.getRent();

        if(this.coin >= rent){
            owner.receive(rent);
        } else {
            owner.receive(this.coin);
        }
        
        this.coin -= rent;

        if (this.coin <= 0) {
            this.lose();
        }
    }

    private void lose() {
        this.isPlaying = false;

        for (Property property : properties) {
            property.setOwner(null);
        }

        properties.clear();
    }

    public abstract void buyProperty(Property property);
}
