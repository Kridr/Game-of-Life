package life;

public class Universe {
    protected Cell[][] field;

    Cell getFieldValue(int i, int j) {
        return field[i][j];
    }

    void setFieldValue(int i, int j, Cell value) {
        field[i][j] = value;
    }

    int getSize() {
        return field.length;
    }

    Universe(int size, boolean isRandom) {
        field = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isRandom) {
                    field[i][j] = Generation.generateCellState();
                } else {
                    field[i][j] = Cell.DEAD;
                }
            }
        }
    }

    int countAlive() {
        int answer = 0;

        for (Cell[] cells : field) {
            for (int j = 0; j < field.length; j++) {
                if (cells[j] == Cell.ALIVE) {
                    answer++;
                }
            }
        }

        return answer;
    }

    @Override
    public String toString() {
        StringBuilder stringField = new StringBuilder();

        for (Cell[] cells : field) {
            for (int j = 0; j < field.length; j++) {
                stringField.append(cells[j].getSymbol());
            }
            stringField.append("\n");
        }

        return stringField.toString();
    }
}
