// write your code here
public class King extends ChessPiece
{
    public King(String color)
    {
        super(color);
    }
    
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn)
    {
        if ((toLine < 0) || (toLine >= 8) || (toColumn < 0) || (toColumn >= 8))
            return false;

        if ((line == toLine) && (column == toColumn))
            return false;
            
        if ((Math.abs(line - toLine) <= 1) && (Math.abs(column - toColumn) <= 1))
            return isFigureInPath(chessBoard, line, column, toLine, toColumn);
            
        return false;
    }
    
    boolean isUnderAttack(ChessBoard board, int line, int column)
    {
        for (int iLine = 0; iLine < 7; ++iLine)
        {
            for (int iColumn = 0; iColumn < 7; ++iColumn)
            {
                if (board.board[iLine][iColumn] == null)
                    continue;
                    
                if (board.board[iLine][iColumn].getColor() == color)
                    continue;
                    
                if (board.board[iLine][iColumn].canMoveToPosition(board, iLine, iColumn, line, column))
                    return true;
            }
        }
        
        return false;
    }
    
    public String getSymbol()
    {
        return "K";
    }
}