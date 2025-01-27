package chess.movecalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;

public class RookMovesCalculator extends PieceMovesCalculator{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        var moves = new ArrayList<ChessMove>();
        int[] directions = {-1,1};
        for (var n : directions) {
            for (var m : directions) {
                int i = 1;
                ChessPosition newPosition;
                do {
                    if (m == -1) {
                        newPosition = new ChessPosition(position.getRow()+i*n, position.getColumn());
                    } else {
                        newPosition = new ChessPosition(position.getRow(), position.getColumn()+i*n);
                    }
                    var newMove = new ChessMove(position,newPosition);
                    if (isLegalMove(board,newMove)) {
                        moves.add(newMove);
                    }
                    i++;
                } while (newPosition.isValid() && board.getPiece(newPosition) == null);
            }
        }
        return moves;
    }
}
