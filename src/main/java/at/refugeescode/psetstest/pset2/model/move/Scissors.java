package at.refugeescode.psetstest.pset2.model.move;

public class Scissors implements Move {

    Scissors() {
    }

    @Override
    public boolean defeats(Move move) {
        return move.getClass() == Paper.class || move.getClass() == Lizard.class;
    }
}
