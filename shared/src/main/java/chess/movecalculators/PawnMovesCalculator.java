package chess.movecalculators;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;

import static chess.ChessPiece.PieceType.*;

public class PawnMovesCalculator extends PieceMovesCalculator{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        var moves = new ArrayList<ChessMove>();
        int d = 1;
        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.BLACK) {
            d = -1;
        }
        for (int i = -1; i < 2; i++) {
            var newPosition =  new ChessPosition(position.getRow()+d, position.getColumn()+i);
            var newMove = new ChessMove(position,newPosition);
            if (isLegalMove(board, newMove)) {
                if (newPosition.getRow() == 1 || newPosition.getRow() == 8) {
                    moves.addAll(createPromotionMoves(newMove));
                } else if ((position.getRow() == 2 || position.getRow() == 7) && i == 0) {
                    moves.add(newMove);
                    newPosition = new ChessPosition(position.getRow()+2*d, position.getColumn());
                    newMove = new ChessMove(position,newPosition);
                    if (isLegalMove(board, newMove)) {
                        moves.add(newMove);
                    }
                } else {
                    moves.add(newMove);
                }
            }
        }
        return moves;
    }

    @Override
    public boolean isLegalMove(ChessBoard board, ChessMove move) {
        if (move.isValid()) {
            if (board.getPiece(move.getEndPosition()) == null) {
                    return move.getEndPosition().getColumn() == move.getStartPosition().getColumn();
            } else return board.getPiece(move.getStartPosition()) != null &&
                    move.getEndPosition().getColumn() != move.getStartPosition().getColumn()
                    && board.getPiece(move.getStartPosition()).getTeamColor() !=
                    board.getPiece(move.getEndPosition()).getTeamColor();
        }
        return false;
    }

    private Collection<ChessMove> createPromotionMoves(ChessMove move) {
        var moves = new ArrayList<ChessMove>();
        ChessPiece.PieceType[] promos = {ROOK,BISHOP,QUEEN,KNIGHT};
        for (var p : promos) {
            moves.add(new ChessMove(move.getStartPosition(),move.getEndPosition(),p));
        }
        return moves;
    }
}
