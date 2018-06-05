package day3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationsTest {


    @Test
    void containsOrigin() {
        Locations locations = new Locations();
        assertThat(locations.count()).isEqualTo(1);
    }

    @Test
    void oneMovement() {
        Locations locations = new Locations();
        locations.moveTo('^');
        assertThat(locations.count()).isEqualTo(2);
    }

    @Test
    void twoMovementsSameDirection() {
        Locations locations = new Locations();
        locations.moveTo('v');
        locations.moveTo('v');
        assertThat(locations.count()).isEqualTo(3);
    }

    @Test
    void twoMovementsGoingBack() {
        Locations locations = new Locations();
        locations.moveTo('<');
        locations.moveTo('>');
        assertThat(locations.count()).isEqualTo(2);
    }

}