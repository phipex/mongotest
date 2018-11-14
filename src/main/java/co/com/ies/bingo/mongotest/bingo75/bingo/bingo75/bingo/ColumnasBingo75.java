package co.com.ies.bingo.mongotest.bingo75.bingo.bingo75.bingo;

import java.util.Arrays;
import java.util.List;

/**
 * Enumeracion que representa las columnas de las balotas
 * @author root
 *
 */
public enum ColumnasBingo75 implements ColumnasBingo {

	
	COLUMNA_B(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),
	COLUMNA_I(16,17,18,19,20,21,22,23,24,25,26,27,28,29,30),
	COLUMNA_N(31,32,33,34,35,36,37,38,39,40,41,42,43,44,45),
	COLUMNA_G(46,47,48,49,50,51,52,53,54,55,56,57,58,59,60),
	COLUMNA_0(61,62,63,64,65,66,67,68,69,70,71,72,73,74,75);
	

    private List<Integer> balotas;

    ColumnasBingo75(Integer ...balotas){
        this.balotas = Arrays.asList(balotas);
    }
	
    /* (non-Javadoc)
	 * @see co.com.ies.co.com.ies.ColumnasBingo#getBalotas()
	 */
    @Override
	public List<Integer> getBalotas(){
    	return this.balotas;
    }

	
	public static ColumnasBingo getEnum(String value) {
		
		if(value == null || "".equals(value)) {
			throw new IllegalArgumentException("El argumento no puede ser vacio");
		}
		
		String valueLower = value.toLowerCase();
		
		switch (valueLower) {
		case "b":
			return COLUMNA_B;
		case "i":
			return COLUMNA_I;
		case "n":
			return COLUMNA_N;
		case "g":
			return COLUMNA_G;
		case "o":
			return COLUMNA_0;	
		default:
			break;
		}
		
		return null;
	}
    
    
}
