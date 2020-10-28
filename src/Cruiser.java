import java.util.Arrays;

class Cruiser extends Ship{
    Cruiser()
    {
        this.setLength(6);
        this.setHit(new boolean[6]);
        Arrays.fill(this.getHit(),false);

    }

    @Override
    String getShipType() {

        return "cruiser";
    }

    @Override
    String Power() {
        return "I am a cruiser";
    }
}
