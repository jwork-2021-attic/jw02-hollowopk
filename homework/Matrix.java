package homework;

public class Matrix extends Line {

    public Matrix(int length) {
        super(length*length);
        this.positions = new Position[length][length];
    }

    private Position[][] positions;

    @Override
    public void put(Linable linable, int i) {
        if (this.positions[i/8][i%8] == null) {
            this.positions[i/8][i%8] = new Position(null);
        }
        this.positions[i/8][i%8].setLinable(linable);
    }

    @Override
    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i/8][i%8].getLinable();
        }
    }

    @Override
    public String toString() {
        String lineString = "";
        for (Position [] p : positions) {
            for (Position positon : p) {
                lineString += positon.getLinable().toString();
            }
            lineString += '\n';
        }
        return lineString;
    }

    @Override
    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length * this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i/8][i%8].getLinable();
        }

        return linables;

    }

    @Override
    public Linable getMonsterByRank(int rank) {
        return positions[rank/8][rank%8].getLinable();
    }

}