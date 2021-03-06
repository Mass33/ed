package Chess;

import static Chess.ChessPiece.Color;
import static Chess.ChessPiece.Type;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChessBoardImplementation implements ChessBoard {

	ChessPiece	pieces[] = new ChessPiece[8 * 8];
	
	public ChessBoardImplementation() {
		for (int i = 0; i < 8; i++) {
			pieces[getPieceIndex(i, 1)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.PAWN);
			pieces[getPieceIndex(i, 6)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.PAWN);
		}
		pieces[getPieceIndex(0, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.ROOK);
		pieces[getPieceIndex(7, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.ROOK);
		pieces[getPieceIndex(0, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.ROOK);
		pieces[getPieceIndex(7, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.ROOK);

		pieces[getPieceIndex(1, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.KNIGHT);
		pieces[getPieceIndex(6, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.KNIGHT);
		pieces[getPieceIndex(1, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.KNIGHT);
		pieces[getPieceIndex(6, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.KNIGHT);

		pieces[getPieceIndex(2, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.BISHOP);
		pieces[getPieceIndex(5, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.BISHOP);
		pieces[getPieceIndex(2, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.BISHOP);
		pieces[getPieceIndex(5, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.BISHOP);

		pieces[getPieceIndex(4, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.KING);
		pieces[getPieceIndex(3, 0)] = new ChessPieceImplementation(ChessPiece.Color.WHITE, ChessPiece.Type.QUEEN);
		pieces[getPieceIndex(3, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.QUEEN);
		pieces[getPieceIndex(4, 7)] = new ChessPieceImplementation(ChessPiece.Color.BLACK, ChessPiece.Type.KING);
	}
	
	@Override
	public ChessPiece[] getPieces(ChessPiece.Color PieceColor) {
		int count = 0;
		for (ChessPiece piece : pieces)
			if (piece != null && piece.getColor() == PieceColor)
				count++;

		if (count == 0)
			return null;
		
		ChessPiece[] result = new ChessPiece[count];
		count = 0;
		for (ChessPiece piece : pieces)
			if (piece != null && piece.getColor() == PieceColor)
				result[count++] = piece;

		return result;
	}
	
	private	int getPieceIndex(int column, int row) {
		return row * 8 + column;
	}

	private	int getPieceIndex(PiecePosition position) {
		return position.getRow() * 8 + position.getColumn();
	}

	private	ChessPiece getPiece(int column, int row) {
		int index = getPieceIndex(column, row);
		return pieces[index];
	}

	@Override
	public ChessPiece getPieceAt(PiecePosition position) {
		if (!PiecePosition.isAvailable(position))
			return null;
		return getPiece(position.getColumn(), position.getRow());
	}

	@Override
	public PiecePosition getPiecePosition(ChessPiece APiece) {
		for (int row = 0; row < 8; row++)
			for (int column = 0; column < 8; column++)
				if (getPiece(column, row) == APiece)
					return new PiecePosition(column, row);
		return null;
	}

	@Override
	public void removePieceAt(PiecePosition Position) {
		pieces[getPieceIndex(Position.getColumn(), Position.getRow())] = null;
	}

	@Override
	public boolean movePieceTo(ChessPiece Piece, PiecePosition Position) {
		PiecePosition oldPosition = getPiecePosition(Piece);
		if (oldPosition != null) {
			int oldIndex = getPieceIndex(oldPosition);
			int newIndex = getPieceIndex(Position);
			pieces[oldIndex] = null;
                        if(Piece.getType() == ChessPiece.Type.PAWN && (Position.getRow() == 0 || Position.getRow() == 7))
                            Piece = new ChessPieceImplementation(Piece.getColor(),ChessPiece.Type.QUEEN);
			pieces[newIndex] = Piece;
			Piece.notifyMoved();
			return true;
		}
		return false;
	}

	@Override
	public boolean containsKing(ChessPiece.Color PieceColor) {
		for (ChessPiece piece : pieces) 
			if (piece != null && piece.getType() == ChessPiece.Type.KING && piece.getColor() == PieceColor)
				return true;
		return false;
	}

	@Override
	public boolean saveToFile(File location) {
            String s = "";
            
            Charset charset = Charset.forName("US-ASCII");
            try (BufferedWriter writer = Files.newBufferedWriter(location.toPath(), charset)) {
                for (ChessPiece p : getPieces()) {     
                    if(p.getColor() == Color.WHITE)
                        s = s + "W,";
                    else
                        s = s + "B,";
                    switch(p.getType()) {
                        case KING: s = s + "K,"; 
                                    break;
                        case QUEEN:s = s + "Q,"; 
                                    break;            
                        case BISHOP:s = s + "B,"; 
                                    break;
                        case KNIGHT:s = s + "N,"; 
                                    break;
                        case ROOK:s = s + "R,"; 
                                    break;
                        case PAWN:s = s + "P,"; 
                                    break; 
                        default:
                            break;
                    }
                    PiecePosition pos = getPiecePosition(p);
                    int c = pos.getColumn();
                    s = s + c + ",";
                    int r = pos.getRow();
                    s = s + r + "\n";  
                }
                writer.write(s); 
                return true;
            }    
            catch (IOException x) {
                System.err.format("IOException: %s%n", x);
                return false;
            }
	}

	@Override
	public boolean loadFromFile(File location) {
		try {
                Scanner sc = new Scanner(location);
                for (int i = 0; i < 8 * 8; i++) {
                    pieces[i] = null;
                }
                while(sc.hasNext()) {
                    String s = sc.nextLine();
                    String[] fields = s.split(",");
                    Color color;
                    Type type = null;
                    if(fields[0].equalsIgnoreCase("W"))
                        color = Color.WHITE;
                    else
                        color = Color.BLACK;
                    switch(fields[1]) {
                        case "K": type = Type.KING; 
                                    break;
                        case "Q": type = Type.QUEEN; 
                                    break;            
                        case "B": type = Type.BISHOP; 
                                    break;
                        case "N": type = Type.KNIGHT; 
                                    break;
                        case "R": type = Type.ROOK; 
                                    break;
                        case "P": type = Type.PAWN; 
                                    break; 
                        default:
                            break;
                    }
                    int c = Integer.parseInt(fields[2]);
                    int r = Integer.parseInt(fields[3]);
                    
                    pieces[getPieceIndex(c, r)] = new ChessPieceImplementation(color, type);
                }
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChessBoardImplementation.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
}
