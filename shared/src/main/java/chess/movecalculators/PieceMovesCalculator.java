package chess.movecalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;

public abstract class PieceMovesCalculator {
    public abstract Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position);

    public boolean isLegalMove(ChessBoard board, ChessMove move) {
      if (move.isValid()) {
          if (board.getPiece(move.getEndPosition()) == null) {
              return true;
          } else return board.getPiece(move.getStartPosition()) != null &&
                  board.getPiece(move.getStartPosition()).getTeamColor() !=
                          board.getPiece(move.getEndPosition()).getTeamColor();
      }
      return false;
    }
}
