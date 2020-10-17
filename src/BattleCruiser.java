import java.util.Arrays;

class BattleCruiser extends Ship{

    BattleCruiser()
    {
        this.setLength(7);
        this.setHit(new boolean[7]);
        Arrays.fill(this.getHit(),false);

    }

    @Override
    String getShipType() {
        return "BattleCruiser";
    }

    @Override
    String Power() {
        return "batlecruiser";

    }
}
