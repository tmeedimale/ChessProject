package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        //check if pawn already exists
        if (isLegalBoardPosition(xCoordinate, yCoordinate)) {
            Pawn tmpPawn = pieces[xCoordinate][yCoordinate];
            if (tmpPawn == null) {
                if (pieceColor == PieceColor.BLACK) {
                    if ((xCoordinate == 5 || xCoordinate == 6) && (yCoordinate >= 0 && yCoordinate <= 6)) {
                        pawn.setXCoordinate(xCoordinate);
                        pawn.setYCoordinate(yCoordinate);
                    }
                } else if (pieceColor == PieceColor.WHITE) {
                    if ((xCoordinate == 0 || xCoordinate == 1) && (yCoordinate >= 0 && yCoordinate <= 6)) {
                        pawn.setXCoordinate(xCoordinate);
                        pawn.setYCoordinate(yCoordinate);
                    }
                }
                pieces[xCoordinate][yCoordinate] = pawn;
                return;
            }
        }

        pawn.setYCoordinate(-1);
        pawn.setXCoordinate(-1);
    }


    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >=0 && xCoordinate <=6 && yCoordinate >=0 && yCoordinate <= 6);
    }
}
