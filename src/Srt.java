import java.util.LinkedList;
import java.util.Queue;

public class Srt extends Procesador{
	/**

	 * Esta clase define el objeto que procesa el algoritmo SRT.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	// estados
	
	// comportamientos
	/**
	 * constructor 
	 */
	public Srt(ListaProcesos miLista) {
		super(miLista);
	}

	/**
	 * Hace las comprobaciones pertinentes de SRT
	 */
	@Override
	public void comprueba() {
		
		if (procesado.getRafaga()==0) {
			// guarda el tiempo de reloj de fin del proceso en la lista auxiliar
			listaAux.get((listaAux.findByPid(procesado.getPID()))).setFin(iterador);
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
