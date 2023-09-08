// write your code here
public class Bishop extends ChessPiece
{
    public Bishop(String color)
    {
        super(color);
    }
    
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn)
    {
        if ((toLine < 0) || (toLine >= 8) || (toColumn < 0) || (toColumn >= 8))
            return false;

        if ((line == toLine) && (column == toColumn))
            return false;
            
        if (Math.abs(line - toLine) == Math.abs(column - toColumn))
            return isFigureInPath(chessBoard, line, column, toLine, toColumn);

        return false;
    }
    
    public String getSymbol()
    {
        return "B";
    }
}