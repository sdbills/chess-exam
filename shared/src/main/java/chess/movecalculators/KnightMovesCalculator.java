package chess.movecalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMovesCalculator extends PieceMovesCalculator{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        var moves = new ArrayList<ChessMove>();
        int[] directions = {-1,1};
        for (var m : directions) {
            for (var n : directions) {
                for (var p : directions) {
                    ChessPosition newPosition;
                    if (p == -1) {
                        newPosition = new ChessPosition(position.getRow()+2*m, position.getColumn()+n);
                    } else {
                        newPosition = new ChessPosition(position.getRow()+m, position.getColumn()+2*n);
                    }
                    var newMove = new ChessMove(position,newPosition);
                    if (isLegalMove(board,newMove)) {
                        moves.add(newMove);
                    }
                }
            }
        }
        return moves;
    }
}
