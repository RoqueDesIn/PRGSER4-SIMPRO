import java.util.LinkedList;
import java.util.Queue;

public class Srt {
	/**

	 * Esta clase define el objeto que procesa el algoritmo SRT.

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
	public Srt() {
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
				// comprobamos SRT
				comprueba();
			}

			// procesa el proceso actual quita uno a la ráfaga para simular el procesado
			if (procesado!=null) {
				System.out.println((i+1)+".- ");
				procesado.toOut();
				procesado.setRafaga(procesado.getRafaga()-1);
			}
		}

		// finaliza for		

	}
	
	/**
	 * Hace las comprobaciones pertinentes de SRT
	 */

	private static void comprueba() {
		
		if (procesado.getRafaga()==0) {
			// si el proceso ha acabado lo cambiamos por el menor SRT
			procesado=cola.menorRfg();
			// borramos el proceso de la cola
			cola.borraIndex(cola.findByPid(procesado.getPID()));
		} else {
			// si hay algun proceso en cola
			if (cola.size()>0) {
				// si ráfaga de procesado es mayor que el SRT 
				if(cola.menorRfg().getRafaga()<procesado.getRafaga()) {
					//guarda procesado en la cola  
					cola.add(procesado);
					// extrae srt
					procesado=cola.menorRfg();
					//borra de la cola el srt
					cola.borraIndex(cola.findByPid(procesado.getPID()));
				}	
			}

		}	
	}
	
}
