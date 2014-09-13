package arboles;
/***************************************************************
	Universidad del Valle de Guatemala
	Algoritmos y Estructura de Datos
	Integrantes:
	Carlos Cordero		(13152)
	Juan Tzun			(13017)
	Tomas Garcia		(13019)
	Sergio Mendez		(13452)
*****************************************************************/

public class  Asociacion <K, V>{

	K key;
	V valor;
	
	public void addAsociacion(K key, V valor){
		this.key = key;
		this.valor = valor;
		
	}
	
	public K getKey(){
		return this.key;
	}
	
	public V getValor(){
		return this.valor;
	}
	
}