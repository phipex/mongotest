package co.com.ies.bingo.mongotest.bingo75.bingo.bingo75.bingo;


import java.util.ArrayList;
import java.util.List;

public class Juego {

	private List<Integer> balotasActuales;

	private long juegoID;
	
	private Balotera balotera;
	
	/**
	 * Constructos con las balo
	 * @param enEjecucion
	 * @param balotasActuales
	 * @throws BaloteraException 
	 */
	public Juego(long juegoID, List<Integer> balotasActuales, Balotera balotera, List<ColumnasBingo> columnasJuegos) throws BaloteraException {
		
		this.juegoID = juegoID;
		this.balotera = balotera;
		this.balotasActuales = balotasActuales;
		
		if(balotera != null) {
			this.balotera.inicializarBalotera(columnasJuegos);
		}else {
			throw new BaloteraException("No se ha ingresado una instancia inicializada");
		}
		
	}

	/**
	 * @throws BaloteraException 
	 * 
	 */
	public Juego(long juegoID, Balotera balotera,List<ColumnasBingo> columnasJuegos ) throws BaloteraException {
		
		this(juegoID, new ArrayList<>(), balotera, columnasJuegos);
		
		
	}
	
	/**
	 * 
	 * @param juego
	 * @throws BaloteraException 
	 */
	public void iniciaJuego(long juego) throws BaloteraException {
		validaJuego(juego);
	}
	
	/**
	 * 
	 * @param juego
	 * @throws BaloteraException 
	 */
	public int solicitaBalota(long juego) throws BaloteraException {
		validaJuego(juego);
		final int nuevaBalota = balotera.getNuevaBalota();
		this.balotasActuales.add(nuevaBalota);
		
		return nuevaBalota;
	}
	
	/**
	 * 
	 * @param juego
	 * @throws BaloteraException 
	 */
	public void terminaJuego(long juego) throws BaloteraException {
		validaJuego(juego);
	}
	
	/**
	 * valida que el id entrado como parametro sea el asignado al juego
	 * @param juego
	 * @return
	 * @throws BaloteraException 
	 */
	private boolean validaJuego(long juego) throws BaloteraException {
		boolean numeroJuegoValido = juego == this.juegoID;
		
		if(!numeroJuegoValido) {
			throw new BaloteraException("El id del juego no es valido");
		}
		
		return numeroJuegoValido;
	}

	public int cantidadBalotasPorSalir() {
		return balotera.cantidadBalotasPorSalir();
	}
	
	public List<Integer> getBalotasActuales() {
		return balotasActuales;
	}

	public void setBalotasActuales(List<Integer> balotasActuales) {
		this.balotasActuales = balotasActuales;
	}

	public long getJuegoID() {
		return juegoID;
	}

	public void setJuegoID(long juegoID) {
		this.juegoID = juegoID;
	}
	
	
	
}
