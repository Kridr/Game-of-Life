package life;

public enum Direction {
    N, NE, E, SE, S, SW, W, NW;

    static boolean consistN(Direction direction) {
        return direction == NW || direction == N || direction == NE;
    }

    static boolean consistE(Direction direction) {
        return direction == NE || direction == E || direction == SE;
    }

    static boolean consistS(Direction direction) {
        return direction == SE || direction == S || direction == SW;
    }

    static boolean consistW(Direction direction) {
        return direction == SW || direction == W || direction == NW;
    }
}
