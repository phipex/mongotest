package co.com.ies.bingo.mongotest.bingo75.bingo.bingo75.bingo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa la balotera
 *
 * @author root
 */
public class Balotera {

    /**
     * balotas que faltan por salir
     */
    List<Integer> balotasPorSalir;

    /**
     * balotas actuales
     */
    List<Integer> balotasActuales;

    /**
     * gestor del ramdon
     */
    Random random;

    /**
     *
     */
    public Balotera() {
        this(new ArrayList<Integer>());
    }

    /**
     * balotera ya inicializada
     *
     * @param balotasActuales
     */
    public Balotera(List<Integer> balotasActuales) {
        this.balotasActuales = new ArrayList<>(balotasActuales);

        this.random = new SecureRandom();
    }

    /**
     * retorna una nueva balota
     *
     * @return
     * @throws BaloteraException
     */
    public int getNuevaBalota() throws BaloteraException {

        if (balotasPorSalir.isEmpty()) {
            throw new BaloteraException("No hay mas balotas por salir");
        }

        final int faltantes = balotasPorSalir.size();
        final int indiceRemover = random.nextInt(faltantes);
        final Integer nuevaBalota = this.balotasPorSalir.remove(indiceRemover);
        this.balotasActuales.add(nuevaBalota);

        return nuevaBalota;
    }

    /**
     * inicializa la balotera
     *
     * @param columnasJuegos
     */
    public void inicializarBalotera(List<ColumnasBingo> columnasJuegos) {

        this.balotasPorSalir = new ArrayList<>();

        boolean hayPorSalir = this.balotasActuales != null && !this.balotasActuales.isEmpty();

        List<Integer> temporal = null;

        if (hayPorSalir) {
            temporal = new ArrayList<>(this.balotasActuales);
        }

        for (ColumnasBingo columnaBingo75 : columnasJuegos) {
            this.balotasPorSalir.addAll(columnaBingo75.getBalotas());
        }

        if (hayPorSalir) {
            this.balotasPorSalir.removeAll(temporal);
        }

    }

    public int cantidadBalotasPorSalir() {
        return balotasPorSalir.size();
    }


    public List<Integer> getBalotasPorSalir() {
        return balotasPorSalir;
    }

    public List<Integer> getBalotasActuales() {
        return balotasActuales;
    }

}
