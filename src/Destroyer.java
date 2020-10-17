import java.util.Arrays;

class Destroyer extends Ship {
    Destroyer()
    {
        this.setLength(4);
        this.setHit(new boolean[4]);
        Arrays.fill(this.getHit(),false);

    }
    @Override
    String getShipType() {
        return "Destroyer";
    }


    @Override
    String Power() {
        return "I am a Destroyer";
    }
}
