// write your code here
public class Pawn extends ChessPiece
{
    public Pawn(String color)
    {
        super(color);
    }
    
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn)
    {
        if ((toLine < 0) || (toLine >= 8) || (toColumn < 0) || (toColumn >= 8))
            return false;
            
        if (color == "White")
        {
            if (toColumn == column)
            {
                if ((line == 1) && (toLine == 3))
                    return ((chessBoard.board[2][toColumn] == null) && (chessBoard.board[3][toColumn] == null));
                
                if (toLine - line == 1)
                    return (chessBoard.board[toLine][toColumn] == null);
            }
            else if ((toColumn == column + 1) && (toLine == line + 1))
            {
                //Consider taking the 'En Passant pawn'
                if ((toLine == 5) &&
                    (chessBoard.board[4][toColumn] != null) &&
                    chessBoard.board[4][toColumn].getColor().equals("Black") &&
                    chessBoard.board[4][toColumn].getSymbol().equals("P") && 
                    (chessBoard.board[4][toColumn].check == false))
                    return true;
                    
                // Usual taking
                return ((chessBoard.board[toLine][toColumn] != null) && (chessBoard.board[toLine][toColumn].color != color));
            }
            
            return false;
        }
        else
        {
            if (toColumn == column)
            {
                if ((line == 6) && (toLine == 4))
                    return ((chessBoard.board[5][toColumn] == null) && (chessBoard.board[4][toColumn] == null));
                
                if (line - toLine == 1)
                    return (chessBoard.board[toLine][toColumn] == null);
            }
            else if ((toColumn == column - 1) && (toLine == line - 1))
            {
                //Consider taking the 'En Passant pawn'
                if ((toLine == 2) &&
                    (chessBoard.board[3][toColumn] != null) &&
                    chessBoard.board[3][toColumn].getColor().equals("White") &&
                    chessBoard.board[3][toColumn].getSymbol().equals("P") && 
                    (chessBoard.board[3][toColumn].check == false))
                    return true;
                    
                // Usual taking
                return ((chessBoard.board[toLine][toColumn] != null) && (chessBoard.board[toLine][toColumn].color != color));
            }
            
            return false;

        }
    }
    
    public String getSymbol()
    {
        return "P";
    }
}