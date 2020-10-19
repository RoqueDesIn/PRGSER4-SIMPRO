import java.util.LinkedList;
import java.util.Queue;

public class Fifo  extends Procesador{

	/**

	 * Esta clase define el objeto que procesa el algoritmo FIFO.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	// estados

	// comportamientos
	/**
	 * constructor heredado
	 */
	public Fifo(ListaProcesos miLista) {
		super(miLista);
		}
	
	/**
	 * comprueba Fifo
	 */
	@Override
	public void comprueba() {
		if  (procesado.getRafaga()==0) {
			// guarda el tiempo de reloj de fin del proceso en la lista auxiliar
			listaAux.get((listaAux.findByPid(procesado.getPID()))).setFin(iterador);
			// si el proceso ha acabado lo cambiamos por el siguiente
			procesado=cola.get(0);
			// borramos el proceso de la cola
			cola.borraIndex(cola.findByPid(procesado.getPID()));
			
		} else {
			// es un proceso no apropiativo por lo que no cambia nada en caso de que no se agote el proceso
		}	
		
	}

	
}
