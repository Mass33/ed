package tresenraya;


public class NoughtsAndCrossesBoardImplementation implements NoughtsAndCrossesBoard{
    private final int WIDTH = 3;
    private final int HEIGHT = 3;
    Color[][] piezas = new Color[HEIGHT][WIDTH]; 
    
    NoughtsAndCrossesBoardImplementation() {      
        piezas[0][0] = Color.RED;
        piezas[0][1] = Color.WHITE;
        piezas[0][2] = Color.RED;
        piezas[1][0] = Color.VOID;
        piezas[1][1] = Color.RED;
        piezas[1][2] = Color.VOID;
        piezas[2][0] = Color.WHITE;
        piezas[2][1] = Color.VOID;
        piezas[2][2] = Color.WHITE;   
    }
    
    private boolean isEmpty(int x, int y){
        return((x >= 0 && x < WIDTH) && (y >= 0 && y < HEIGHT) &&
            piezas[x][y] == Color.VOID);
    }
    
    @Override
    public boolean isGameOver(){
//        boolean linea = false;
//        Color teamFlag = null;
        if (piezas[0][0] != Color.VOID && piezas[0][0] == piezas[0][1] && 
            piezas[0][0] == piezas[0][2])
            return true;
        if (piezas[1][0] != Color.VOID && piezas[1][0] == piezas[1][1] &&
            piezas[1][0] == piezas[1][2])
            return true;
        if (piezas[2][0] != Color.VOID && piezas[2][0] == piezas[2][1] && 
            piezas[2][0] == piezas[2][2])
            return true;
        if (piezas[0][0] != Color.VOID && piezas[0][0] == piezas[1][0] && 
            piezas[0][0] == piezas[2][0])
            return true;
        if (piezas[0][1] != Color.VOID && piezas[0][1] == piezas[1][1] && 
            piezas[0][1] == piezas[2][1])
            return true;
        if (piezas[0][2] != Color.VOID && piezas[0][2] == piezas[1][2] && 
            piezas[0][2] == piezas[2][2])
            return true;
        if (piezas[0][0] != Color.VOID && piezas[0][0] == piezas[1][1] && 
            piezas[0][0] == piezas[2][2])
            return true;
        if (piezas[0][2] != Color.VOID && piezas[0][2] == piezas[1][1] && 
            piezas[0][2] == piezas[2][0])
            return true;
        return false;
//        //Horizantales
//        for(int i = 0; i < HEIGHT && !linea; i++){
//            teamFlag = piezas[i][0];
//            linea = true;
//            
//            for (int j = 0; j < WIDTH-1 && linea; j++)                    
//                if(piezas[0][j] != teamFlag)
//                    linea = false;
//        }
//        
//        //Verticales
//        for(int i = 0; i < WIDTH && !linea; i++){
//            teamFlag = piezas[0][i];
//            linea = true;
//            
//            for (int j = 0; j < HEIGHT-1 && linea; j++)                    
//                if(piezas[j][0] != teamFlag)
//                    linea = false;
//        }
//        
//        //Diagonales
//            
//        return linea;
    }
    
    @Override
    public boolean movePiece(int fromX, int fromY, int toX, int toY){
        boolean movimientoValido;
        boolean espacio;
        
        if ((fromX >= 0 && fromX < WIDTH) && (fromY >= 0 && fromY < HEIGHT) &&
           (toX >= 0 && toX < WIDTH) && (toY >= 0 && toY < HEIGHT)){
            movimientoValido = canMovePieceAt(fromX, fromY);
            if (movimientoValido){
                espacio = isEmpty(toX, toY);
                if (espacio){
                    piezas[toX][toY] = piezas[fromX][fromY];
                    piezas[fromX][fromY] = Color.VOID;
                    return true;
                }
            }
        }    
        return false;
    }
    
    @Override
    public boolean canMovePieceAt(int x, int y){
        return ((x >= 0 && x < WIDTH) && (y >= 0 && y < HEIGHT) && 
                piezas[x][y] == Color.RED || piezas[x][y] == Color.WHITE);
    }

    @Override
    public Color getPieceAt(int x, int y){
        if((x >= 0 && x < WIDTH) && (y >= 0 && y < HEIGHT))
            return piezas[x][y];
        return null;
    }  
}