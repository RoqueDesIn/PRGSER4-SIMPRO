
public class Rr extends Procesador {

	public Rr(ListaProcesos miLista) {
		super(miLista);

	}

	
	public void comprueba() {
		
		if (procesado.getRafaga()==0) {
			// guarda el tiempo de reloj de fin del proceso en la lista auxiliar
			listaAux.get((listaAux.findByPid(procesado.getPID()))).setFin(iterador);
			// si el proceso ha acabado lo cambiamos por el siguiente en la cola
			procesado=cola.menorRfg();
			// borramos el proceso de la cola
			cola.borraIndex(cola.findByPid(procesado.getPID()));
			// reinicia el contador de quantum
			cntQuantum=0;

		} else {
			// si hay algun proceso en cola
			if (cola.size()>0) {
				// si se ha acabado el quantum cambiamos de proceso 
				if(cntQuantum==quantum) {
					//guarda procesado en la cola  
					cola.add(procesado);
					// extrae srt
					procesado=cola.get(0);
					//borra de la cola el srt
					cola.borraIndex(0);
					// reinicia el contador de quantum
					cntQuantum=0;
				}	
			}
	
		}	
	}
	
}
