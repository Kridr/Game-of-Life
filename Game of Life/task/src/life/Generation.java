package life;

import java.util.Random;

public class Generation extends Universe{
    private int generation;

    int getGeneration() {
        return generation;
    }

    Generation(int size, boolean isRandom) {
        super(size, isRandom);
        generation = 0;
    }

    static Cell generateCellState() {
        Random random = new Random();
        boolean alive = random.nextBoolean();

        if (alive) {
            return Cell.ALIVE;
        } else {
            return Cell.DEAD;
        }
    }

    void nextGeneration() {
        Generation newGeneration = new Generation(getSize(), false);

        for (int i = 0; i < newGeneration.getSize(); i++) {
            for (int j = 0; j < newGeneration.getSize(); j++) {
                newGeneration.setFieldValue(i, j, evolutionSingle(i, j));
            }
        }

        this.field = newGeneration.field;
        generation++;
    }

    private Cell evolutionSingle(int i, int j) {
        int aliveNeighbors = aliveNeighbors(i, j);

        if (getFieldValue(i, j) == Cell.ALIVE) {
            if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                return Cell.ALIVE;
            } else {
                return Cell.DEAD;
            }
        } else {
            if (aliveNeighbors == 3) {
                return Cell.ALIVE;
            } else {
                return Cell.DEAD;
            }
        }
    }

    private int aliveNeighbors(int i, int j) {
        int answer = 0;

        for (Direction dir : Direction.values()) {
            answer += getNeighborState(i, j, dir);
        }

        return answer;
    }

    private int getNeighborState(int i, int j, Direction direction) {
        int first = i;
        int second = j;

        if (Direction.consistN(direction)) {
            second = (second == 0) ? getSize() - 1 : second - 1;
        }

        if (Direction.consistE(direction)) {
            first = (first == getSize() - 1) ? 0 : first + 1;
        }

        if (Direction.consistS(direction)) {
            second = (second == getSize() - 1) ? 0 : second + 1;
        }

        if (Direction.consistW(direction)) {
            first = (first == 0) ? getSize() - 1 : first - 1;
        }

        return getFieldValue(first, second) == Cell.ALIVE ? 1 : 0;
    }

    @Override
    public String toString() {
        return "Generation #" + generation +
                "\nAlive: " + countAlive() + "\n" +
                super.toString();
    }
}
