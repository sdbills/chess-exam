package chess.movecalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;

public class QueenMovesCalculator extends PieceMovesCalculator{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        var moves = new BishopMovesCalculator().pieceMoves(board,position);
        moves.addAll(new RookMovesCalculator().pieceMoves(board,position));
        return moves;
    }
}
