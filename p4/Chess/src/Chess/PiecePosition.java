package Chess;

public class PiecePosition {

	/**
	 * Esta función comprueba que unas coordenadas pertenecen a una 
         * casilla dentro del tablero.
         * @param column es la coordenada correspondiente a la columna.
         * @param row es la coordenada correspondiente a la fila.
         * @return verdadero si las coordenadas están dentro del trablero,
         * o falso de lo contrario.
	 */
	public static boolean isAvailable(int column, int row) {
		return column >= 0 && column < 8 && row >= 0 && row < 8;
	}

	/**
	 * Esta función comprueba que con un incremento en las coordenadas, 
         * estas siguen perteneciendo a una casilla dentro del tablero.
         * @param position con la posición de la pieza.
         * @param columnIncrement con el número a sumar a la columna.
         * @param rowIncrement con el número a sumar a la fila.
         * @return verdadero si las nuevas coordenadas aumentadas están 
         * dentro del tablero o falso de lo contrario.
	 */
	static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
		if (position == null)
			return false;
		
		int newColumn = position.getColumn() + columnIncrement;
		int newRow = position.getRow() + rowIncrement;
		return isAvailable(newColumn, newRow);
	}

	/**
	 * Esta función Comprueba que una posición corresponde a una casilla 
         * dentro del tablero.
         * @param position con la posición de la pieza.
         * @return verdadero si la posición esta dentro del tablero o
         * falso de lo contrario.
	 */
	static boolean isAvailable(PiecePosition position) {
		if (position == null)
			return false;
		return isAvailable(position.getColumn(), position.getRow());
	}

	private int column, row;

	/**
	 * Constructor que establece la posición de la pieza mediante
         * unas coordenadas de columna y fila.
         * @param column con una coordenada correspondiente a columna.
         * @param row con una coordenada correspondiente a fila.
	 */
	public PiecePosition(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	/**
	 *  Esta función Devuelve la columna de la posición de la pieza.
         *  @return la coordenada correspondiente a la columna.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 *  Esta función Devuelve la fila de la posición de la pieza.
         *  @return la coordenada correspondiente a la fila.
	 */
	public int getRow() {
		return row;
	}
	
	/*
        * Esta función establece los valores de las coordenadas 
        * correspondientes a la columna y la fila de la posición de la pieza
        * comprobando primero que pertenecen a una casilla dentro del tablero.
        * @param column es el valor que asignaremos a la coordenada de columna.
        * @param row es el valor que asignaremos a la coordenada de fila.
        * @return verdadero si se han podido establecer los valores deseados
        * como coordenadas de columna y fila o falso de lo contrario.
        */
        public boolean setValues(int column, int row) {
		if (isAvailable(column, row)) {
			this.column = column;
			this.row = row;			
			return true;
		}
		return false;
	}
	
	/**
	 * Esta función comprueba que sumando las cantidades suministradas
         * a las coordenadas de la posición de la pieza, la pieza sigue estando 
         * dentro del tablero. En caso afirmativo suma las cantidades a 
         * las coordenadas, devolviendo la nueva posición de la pieza.
         * @param columnCount con la cantidad que se desea sumar a la columna.
         * @param rowCount con la cantidad que se desea sumar a la fila.
         * @return la nueva posición de la pieza.
	 */
	public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
		if (!isAvailable(this, columnCount, rowCount))
			return null;
		int newColumn = getColumn() + columnCount;
		int newRow = getRow() + rowCount;
		return new PiecePosition(newColumn, newRow);
	}
	
	/**
	 * Esta función clona la posición de la pieza.
         * @return la posición clonada.
	 */
	public PiecePosition clone() {
		return new PiecePosition(column, row);
	}
	
	/**
	 * Esta función comprueba si la posición suministrada es igual
         * a la posición de la pieza.
         * @param aPosition con la posición a comparar.
         * @return verdadero si la posición suministrada es la misma que
         * la posición de la pieza o falso de lo contrario.
	 */
	public boolean equals(PiecePosition aPosition) {
		return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
	}
}
