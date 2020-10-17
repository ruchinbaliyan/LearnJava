import java.util.Arrays;

 class Submarine extends Ship {

     Submarine()
    {
        this.setLength(3);
        this.setHit(new boolean[3] );
        Arrays.fill(this.getHit(), false);
    }

    @Override
    String getShipType() {
        return "submarine";

    }

    @Override
    String Power() {
        return "I can destroy enemies without letting them know";
    }
}
