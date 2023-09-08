// write your code here
public abstract class ChessPiece
{
    String color;
    boolean check = true;
    
    ChessPiece(String color)
    {
        this.color = color;
    }
    
    public String getColor()
    {
        return color;
    }
    
    protected boolean isFigureInPath(ChessBoard chessBoard, int line, int column, int toLine, int toColumn)
    {
        int lineIncrement = 0;
        int columnIncrement = 0;
        
        if (toLine > line)
            lineIncrement = 1;
        else if (toLine < line)
            lineIncrement = -1;
            
        if (toColumn > column)
            columnIncrement = 1;
        else if (toColumn < column)
            columnIncrement = -1;
            
        line += lineIncrement;
        column += columnIncrement;
        
        while ((line != toLine) && (column != toColumn))
        {
            if (chessBoard.board[line][column] != null)
                return false;
            line += lineIncrement;
            column += columnIncrement;
        }
            
        return ((chessBoard.board[toLine][toColumn] == null) || (chessBoard.board[toLine][toColumn].color != color));
    }
    
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    
    public abstract String getSymbol();
}