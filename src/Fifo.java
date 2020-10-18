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
	protected static Queue<Proceso> cola;
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
		ListaProcesos cola = new ListaProcesos();
// Ejecución
		int contador=0;
		Proceso procesado=null;
		//recorre todos los pasos de proceso
		for (int i=0;i<procesamiento;i++) {
			// recorremos listaProcesos y añadimos a la cola si le toca entrar a algún proceso
			contador=0;
			while ( contador<miLista.size()) {
				if (i==miLista.get(contador).getLlegada()-1) cola.add(miLista.get(contador));
				contador++;
			}
			//finaliza while

			// si la rafaga es 0 toca cambiar de proceso
			// ó procesado es null es el primer proceso
			// sacamos un proceso de la cola para procesarlo
			if ((procesado==null) || (procesado.getRafaga()==0)) {
				// sacamos el último proceso de la cola
				procesado=cola.get(0);
				// borramos el último proceso de la cola
				if (cola.size()>0) cola.borraIndex(0);
			}
			
			// procesa el proceso actual quita uno a la ráfaga para simular el procesado
			if (procesado!=null) {
				procesado.toOut();
				procesado.setRafaga(procesado.getRafaga()-1);
			}
		}

		// finaliza for		

	}

	
}
