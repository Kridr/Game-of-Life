package life;

import java.util.Random;

enum Cell {
    ALIVE('O'), DEAD(' ');

    private final char state;

    Cell(char state) {
        this.state = state;
    }

    char getSymbol() {
        return state;
    }

}
