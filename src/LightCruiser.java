import java.util.Arrays;

 class LightCruiser extends Ship {
     LightCruiser() {
        this.setLength(5);
        this.setHit(new boolean[5]);
        Arrays.fill(this.getHit(),false);
    }

    @Override
    String getShipType() {
        return null;
    }


    @Override
    String Power() {
        return "I am a Lightcruiser";
    }
}
