
public class Sjf extends Procesador {

	public Sjf(ListaProcesos miLista) {
		super(miLista);
	}

	public void comprueba() {
		
		if (procesado.getRafaga()==0) {
			// guarda el tiempo de reloj de fin del proceso en la lista auxiliar
			listaAux.get((listaAux.findByPid(procesado.getPID()))).setFin(iterador);
			// si el proceso ha acabado lo cambiamos por el menor sjf
			procesado=cola.menorRfg();
			// borramos el proceso de la cola
			cola.borraIndex(cola.findByPid(procesado.getPID()));

		} else {
			// es un proceso no apropiativo por lo que no cambia nada en caso de que no se agote el proceso

		}	
	}
	
}
