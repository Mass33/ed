package Chess;

public class ChessPieceImplementation implements ChessPiece {
    
    Color pieceColor;
    Type pieceType;
    int movements = 0;

    ChessPieceImplementation(Color color, Type type) {
        pieceColor = color;
        pieceType = type;
    }

    @Override
    public Color getColor() {
        return pieceColor;
    }

    @Override
    public Type getType() {
        return pieceType;
    }

    @Override
    public void notifyMoved() {
        movements++;
    }

    @Override
    public boolean wasMoved() {
        if (movements > 0)
            return true;
        else
            return false;
    }

    @Override
    public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {
        
        PiecePosition aPositions[] = new PiecePosition[64];

        switch(pieceType){
            case KING:
                aPositions = ChessMovementManager.getAvailablePositionsOfKing(this, aBoard);
                break;
            case QUEEN:
                aPositions = ChessMovementManager.getAvailablePositionsOfQueen(this, aBoard);
                break;
            case BISHOP:
                aPositions = ChessMovementManager.getAvailablePositionsOfBishop(this, aBoard);
                break;
            case KNIGHT:
                aPositions = ChessMovementManager.getAvailablePositionsOfKnight(this, aBoard);
                break;
            case ROOK:
                aPositions = ChessMovementManager.getAvailablePositionsOfRook(this, aBoard);
                break;
            case PAWN:
                aPositions = ChessMovementManager.getAvailablePositionsOfPawn(this, aBoard);
                break;    
            default:
                break;
        }        
        return aPositions;
    }
}    
