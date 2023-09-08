// write your code here
public class Horse extends ChessPiece
{
    public Horse(String color)
    {
        super(color);
    }
    
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn)
    {
        if ((toLine < 0) || (toLine >= 8) || (toColumn < 0) || (toColumn >= 8))
            return false;
            
        if ( ((Math.abs(toLine - line) == 2) && (Math.abs(toColumn - column) == 1)) ||
             ((Math.abs(toLine - line) == 1) && (Math.abs(toColumn - column) == 2)) )
        {
            if ((chessBoard.board[toLine][toColumn] == null) || (chessBoard.board[toLine][toColumn].color != color))
             return true;
        }

        return false;
    }
    
    public String getSymbol()
    {
        return "H";
    }
}