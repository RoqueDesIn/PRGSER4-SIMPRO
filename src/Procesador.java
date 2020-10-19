
public class Procesador {
	
	
	/**

	 * Esta clase define el objeto que procesa el algoritmo com�n.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	// estados
	static  protected ListaProcesos cola;
	static protected Proceso procesado;
	static protected ListaProcesos listaAux; 
	static protected int iterador;
	//***************************************************
	// crea el quatum
	static protected int quantum=2;
	static protected int cntQuantum;
	// comportamientos
	/**
	 * constructor vacio
	 */
	public Procesador(ListaProcesos miLista) {
		// guarda la lista en una lista auxiliar
		listaAux=new ListaProcesos(miLista);
		procesa(miLista);
		calcula();
	}
	
	private void calcula() {
		/*
		 *  Rendimiento = Media de penalizaciones	
		 * 	Penalizaci�n = (tiempo fin-tiempo llegada)/Tiempo CPU								
		 */
		float penalizacion=0;
		float sumatoria=0;
		float media=0;
		System.out.println("--------------------------");
		System.out.println("|Proc. | Penalizaci�n    |");
		System.out.println("--------------------------");
		for (int i=0;i<listaAux.size();i++) {
			// 	Penalizaci�n = (tiempo fin-tiempo llegada)/Tiempo CPU
			penalizacion=(float) (listaAux.get(i).getFin()-listaAux.get(i).getLlegada())/listaAux.prtoTot();
			System.out.println("|   "+i+"  | "+penalizacion);
			sumatoria=sumatoria+penalizacion;
		}
		media=sumatoria/listaAux.prtoTot();
		System.out.println("--------------------------");
		System.out.println("|Rendimiento  "+media+"  |");
		System.out.println("--------------------------");
		
	}

	public void procesa(ListaProcesos miLista) {
		// calcula el procesamiento total
		int procesamiento=miLista.prtoTot();
		// crea la cola de procesamiento 
		cola = new ListaProcesos();
		// inicia contadoir de quantum
		cntQuantum=0;
		
// Ejecuci�n
		int contador=0;
		procesado=null;
		//recorre todos los pasos de proceso
		for (iterador=0;iterador<procesamiento;iterador++) {
			// recorremos listaProcesos y a�adimos a la cola si le toca entrar a alg�n proceso
			contador=0;
			while ( contador<miLista.size()) {
				if (iterador==miLista.get(contador).getLlegada()-1) cola.add(miLista.get(contador));
				contador++;
			}
			//finaliza while
			// si procesado es null es el primer proceso
				// sacamos un proceso de la cola para procesarlo
				if (procesado==null) {
					// sacamos el �ltimo proceso de la cola
					procesado=cola.get(0);
					// borramos el �ltimo proceso de la cola
					cola.borraIndex(0);
				} else {
					// comprobamos
					comprueba();
				}
			
			// procesa el proceso actual quita uno a la r�faga para simular el procesado
			if (procesado!=null) {
				procesado.toOut();
				procesado.setRafaga(procesado.getRafaga()-1);
				// solo para RR
				cntQuantum++;
			}
		}
		// guarda el tiempo de reloj de fin del �ltimo proceso en la lista auxiliar
		listaAux.get((listaAux.findByPid(procesado.getPID()))).setFin(procesamiento);
		// finaliza for		

	}
	/**
	 * comprueba el algoritmo en cuesti�n, al ser el padre no hace nada, est� solo para ser Override

	 */
	public void comprueba() {
		// no hacemos nada, est� solo para ser reescrito

		
	}
}
