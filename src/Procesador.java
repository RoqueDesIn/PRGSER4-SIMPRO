
public class Procesador {
	
	
	/**

	 * Esta clase define el objeto que procesa el algoritmo común.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	// estados
	static  protected ListaProcesos cola;
	static protected Proceso procesado;
	//***************************************************
	// crea el quatum
	static protected int quantum=2;
	static protected int cntQuantum;
	// comportamientos
	/**
	 * constructor vacio
	 */
	public Procesador(ListaProcesos miLista) {
		procesa(miLista);
	}
	
	public void procesa(ListaProcesos miLista) {
		// calcula el procesamiento total
		int procesamiento=miLista.prtoTot();
		// crea la cola de procesamiento 
		cola = new ListaProcesos();
		// inicia contadoir de quantum
		cntQuantum=0;
		
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
					// comprobamos
					comprueba();
				}
			
			// procesa el proceso actual quita uno a la ráfaga para simular el procesado
			if (procesado!=null) {
				procesado.toOut();
				procesado.setRafaga(procesado.getRafaga()-1);
				// solo para RR
				cntQuantum++;
			}
		}

		// finaliza for		

	}
	/**
	 * comprueba el algoritmo en cuestión, al ser el padre no hace nada, está solo para ser Override

	 */
	public void comprueba() {
		// no hacemos nada, está solo para ser reescrito

		
	}
}
