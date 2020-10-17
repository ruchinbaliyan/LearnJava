import java.util.Arrays;

class BattleShip extends Ship {
    BattleShip() {
        this.setLength(8);
        this.setHit(new boolean[8]);
        Arrays.fill(this.getHit(),false);

    }

    @Override
    String getShipType() {
        return "BattleShip";
    }

    @Override
    String Power() {
        return "I am the biggest ship carrying all the ammo and resources";

    }
}
