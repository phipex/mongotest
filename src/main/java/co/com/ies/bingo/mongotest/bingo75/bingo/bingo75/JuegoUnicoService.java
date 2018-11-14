package co.com.ies.bingo.mongotest.bingo75.bingo.bingo75;

import co.com.ies.bingo.mongotest.bingo75.bingo.bingo75.bingo.*;


import java.util.ArrayList;
import java.util.List;


public class JuegoUnicoService {

  private Juego juego;

  /**
   * 
   * @param juegoID
   *          es el id del sorteo
   * @param columnasSPC
   *          ejemplo "b,i,n,g,o"
   * @return
   * @throws BaloteraException
   */
  public boolean inicializaJuego(Long juegoID, String columnasSPC) throws BaloteraException {

    if (juego != null) {
      throw new BaloteraException("Ya hay un juego inicializado");
    }

    Balotera balotera = new Balotera();

    String[] columnas = columnasSPC.split(",");

    List<ColumnasBingo> columnasBingos = new ArrayList<>();

    for (String scolumna : columnas) {
      ColumnasBingo columna = ColumnasBingo75.getEnum(scolumna);

      columnasBingos.add(columna);

    }

    juego = new Juego(juegoID, balotera, columnasBingos);

    return true;

  }

  public boolean recuperaJuego(long juegoID, String columnasSPC, List<Integer> balotasActuales)
      throws BaloteraException {

    Balotera balotera = new Balotera(balotasActuales);

    String[] columnas = columnasSPC.split(",");

    List<ColumnasBingo> columnasBingos = new ArrayList<>();

    for (String scolumna : columnas) {
      ColumnasBingo columna = ColumnasBingo75.getEnum(scolumna);

      columnasBingos.add(columna);

    }

    juego = new Juego(juegoID, balotasActuales, balotera, columnasBingos);

    return true;

  }

  public boolean terminarJuego(long juegoID) throws BaloteraException {
    if (juego != null) {
      juego.terminaJuego(juegoID);
      juego = null;
    }

    return true;
  }

  public int getSiguienteBalota(long juegoID) throws BaloteraException {
    return juego.solicitaBalota(juegoID);
  }

  public boolean faltanBalotas() {
    return juego.cantidadBalotasPorSalir() > 0;

  }

}
