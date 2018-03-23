package at.refugeescode.psetstest.pset2.controller.player;

import at.refugeescode.psetstest.pset2.model.move.Move;

public interface Player {

    Move getMove();

    boolean wantsToPlayAgain();

}
