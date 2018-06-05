package day3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Locations {

    private final Set<Location> locations = new HashSet<>();

    private Location position;

    Locations() {
        moveTo(0, 0);
    }

    int count() {
        return locations.size();
    }

    public void moveTo(char c) {
        switch (c) {
            case '^':
                moveTo(position.x + 1, position.y);
                break;
            case 'v':
                moveTo(position.x - 1, position.y);
                break;
            case '<':
                moveTo(position.x, position.y - 1);
                break;
            case '>':
                moveTo(position.x, position.y + 1);
                break;
        }
    }

    private void moveTo(int x, int y) {
        position = new Location(x, y);
        locations.add(position);
    }

    static class Location {
        private final int x;
        private final int y;

        private Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Location location = (Location) o;
            return x == location.x && y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

}
