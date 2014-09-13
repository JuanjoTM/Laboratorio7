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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.LinkedList;
import java.util.List; 
import java.util.*;

public class main{

	public static void main(String[] args){
		ArrayList<Asociacion>elDiccionario= new ArrayList();
		File f = new File ("diccionario.txt");
		BufferedReader enter;
		
		try{
		enter = new BufferedReader( new FileReader (f));
		String line;
		
		line = enter.readLine();
		
			while(enter.ready()){
				line = enter.readLine();
				
				String vector[] = line.split(",");
				Asociacion separado = new Asociacion();
				separado.addAsociacion( vector[0].substring(1), vector[1].substring(0,vector[1].length()-1));
				
				elDiccionario.add(separado);
			}
			} catch (IOException e){
			e.printStackTrace();
			}
			
			System.out.println(elDiccionario.size());
			System.out.println(elDiccionario);
			BinaryTree diccionario = new BinaryTree();
			
			for (int x = 0; x < elDiccionario.size(); x++){
				diccionario.addNode(elDiccionario.get(x).getKey().toString(),elDiccionario.get(x).getValor().toString());
			}
			
			System.out.println(diccionario);
			
			diccionario.inOrderTraverseTree(diccionario.root);
			
			int contador = elDiccionario.size();
			System.out.println(contador);
			
			File f1 = new File("src/texto.txt");
			BufferedReader enter1;
			try {
			
				enter1 = new BufferedReader( new FileReader (f1));
				String line1;
				line1 = enter1.readLine();
				line1 = line1.toLowerCase();
				System.out.println(line1);
				
				String [] significado = line1.split(" ");
				String cad= "";
				for ( int x = 0; x< significado.length; x++){
					System.out.println(significado[x]);
					String trac = diccionario.findName(significado[x].toString());
					System.out.println(trac);
					if(significado[x].equals("eats")|| significado[x].equals("beans")|| significado[x].equals("test")|| significado[x].equals("three")|| significado[x].equals("points")|| significado[x].equals("calculous")|| significado[x].equals("studies")|| significado[x].equals("the")){
						cad += trac + " ";
					} else{
						cad += "*"+significado[x]+"*";
					}
				}
						
			
			
				System.out.println(cad);
			}catch (IOException e){
			e.printStackTrace();
			}
			
		}
 }
