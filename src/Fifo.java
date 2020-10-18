import java.util.LinkedList;
import java.util.Queue;

public class Fifo {

	/**

	 * Esta clase define el objeto que procesa el algoritmo FIFO.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	// estados
	protected static ListaProcesos cola;
	protected static Proceso procesado;
	
	// comportamientos
	/**
	 * constructor vacio
	 */
	public Fifo(ListaProcesos miLista) {
		procesa(miLista);
	}

	public static void procesa(ListaProcesos miLista) {
		// calcula el procesamiento total
		int procesamiento=miLista.prtoTot();
		// crea la cola de procesamiento 
		cola = new ListaProcesos();
// Ejecución
		int contador=0;
		procesado=null;
		//recorre todos los pasos de proceso
		for (int i=0;i<procesamiento;i++) {
			// recorremos listaProcesos y añadimos a la cola si le toca entrar a algún proceso
			contador=0;
			while ( contador<miLista.size()) {
				if (i==miLista.get(contador).getLlegada()-1) cola.add(miLista.get(contador));
				contador++;
			}
			//finaliza while
			// si procesado es null es el primer proceso
				// sacamos un proceso de la cola para procesarlo
				if (procesado==null) {
					// sacamos el último proceso de la cola
					procesado=cola.get(0);
					// borramos el último proceso de la cola
					cola.borraIndex(0);
				} else {
					// comprobamos FIFO
					comprueba();
				}
			
			// procesa el proceso actual quita uno a la ráfaga para simular el procesado
			if (procesado!=null) {
				procesado.toOut();
				procesado.setRafaga(procesado.getRafaga()-1);
			}
		}

		// finaliza for		

	}

	private static void comprueba() {
		if  (procesado.getRafaga()==0) {
			// si el proceso ha acabado lo cambiamos por el siguiente
			procesado=cola.get(0);
			// borramos el proceso de la cola
			cola.borraIndex(cola.findByPid(procesado.getPID()));
		}
		
	}

	
}
