package Modelos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;


public class ListaProcesos {
	/**

	 * Esta clase define el objeto lista de Procesos.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 14/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	// estados
	private ArrayList <Proceso> listaProcesos;
	
	//comportamientos
	/**
	 * Constructor vacio
	 * @param listaProcesos
	 */
	public ListaProcesos() {
		listaProcesos=new ArrayList<Proceso>();
	}
	

	/**
	 * copia una lista de procesos a partir de un parámetro lista de procesos
	 * @param listaAux
	 */
	public ListaProcesos(ListaProcesos listaAux) {
		listaProcesos=new ArrayList<Proceso>();
		for (int i=0;i<listaAux.size();i++) {
			Proceso p=new Proceso(listaAux.get(i).getPID(), 
					listaAux.get(i).getLlegada(),listaAux.get(i).getRafaga());
			listaProcesos.add (p);
		}
	}
	
	/**
	 *  añade un proceso a nuestra lista
	 * @param miProcesoA
	 */
	public void add(Proceso miProcesoA) {
		listaProcesos.add(miProcesoA);		
	}

	/**
	 * recorre la lista y la muestra por pantalla
	 */
	public String  toOut() {
		String resultado=" ";
		// muestra la lista a procesar ordenada
		for (Proceso p:listaProcesos) {
			resultado= resultado + ("Proceso: "+p.PID+" Llegada: "+p.llegada+" Ráfaga: "+p.rafaga+"\n");
		}	
		return resultado;
	}
	
	/**
	 * devuelve el procesamiento total estimado sumando las ráfagas
	 */
	public int prtoTot() {
		int total=0;
		// recorre la lista a procesar y calcula el procesamiento total estimado
		for (Proceso p:listaProcesos) {
			total=total+p.getRafaga();
			// suma las ráfagas para saber cuanto durará el procesamiento completo
		}	
		return total;
	}
	
	/**
	 * devuelve el Proceso de indice i
	 * @param i
	 * @return
	 */
	public Proceso get(int i) {
		return listaProcesos.get(i);
	}
	
	// getters
	public ArrayList<Proceso> getListaProcesos() {
		return listaProcesos;
	}
	// devuelve el tamaño de nuestra lista
	public int size() {
		return listaProcesos.size();
	}

	/**
	 * ordena la lista por orden de llegada
	 */
	public void ordenarxLlegada() {
		//ordena la lista por llegada
		Collections.sort(listaProcesos);
	}

	/**
	 * devuelve el proceso de menor llegada de la lista
	 * @return
	 */
	public Proceso menorRfg() {
		Proceso resultado=listaProcesos.get(0);
		for (int i=1;i<listaProcesos.size();i++) {
			if (listaProcesos.get(i).getRafaga()<resultado.getRafaga()) {
				resultado=listaProcesos.get(i);
			}
		}
		return resultado;
		
	}
/**
 * borra todo el array
 */
	public void clear() {
		listaProcesos.clear();		
	}

	/** 
	 * borra el proceso de la lista con index solicitado
	 * @param index
	 * @return
	 */
	public void borraIndex(int index) {
		listaProcesos.remove(index);
	}
	/**
	 * devuelve el index del proceso con PID solicitado
	 * @param pid
	 * @return
	 */
	public int findByPid(int pid) {
		int resultado=-1;
		for (int i=0; i<listaProcesos.size();i++) {
			if (listaProcesos.get(i).getPID()==pid) resultado= i;
		}
		return resultado;
	}

}
