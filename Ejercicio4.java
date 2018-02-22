//Ejercicio 4 - Generación e impresión de matrices - Con herencia simple

import java.io.*;
import javax.swing.*;
import java.text.DecimalFormat;	/*Class DecimalFormat - usado para dar formato a los numeros decimales*/

public class Ejercicio4 {
	public static void main(String[] args) {
		int i, j, vertical, horizontal;
		Captura entero = new Captura();
		Captura flotante = new Captura();
		
		entero.iniciaEntero();
		flotante.iniciaFlotante();
		
		entero.imprimeEntero();
		flotante.imprimeFlotante();
		
	}
}

class Captura{	/*Clase Captura con metodos de captura e impresion*/
	int i, j, vertical, horizontal;
	MatrizInt m1 = new MatrizInt(1,1);
	MatrizFlo m2 = new MatrizFlo(1,1);
	
	public void iniciaEntero(){
		vertical = Integer.parseInt(JOptionPane.showInputDialog(null, "Largo (Vertical) que tendra tu matriz:","MATRIZ ENTERA",3));
		horizontal = Integer.parseInt(JOptionPane.showInputDialog(null, "Ancho (Horizontal) que tendra tu matriz:","MATRIZ ENTERA",3));
		int intAleatorio = Integer.parseInt(JOptionPane.showInputDialog(null, "Define el numero mas grande que generara tu matriz entera:","MATRIZ ENTERA",3));
		m1 = new MatrizInt(horizontal, vertical);
		m1.intMatriz(intAleatorio);
	}
	
	public void imprimeEntero(){
		m1.impMatrizInt();
	}
	
	public void iniciaFlotante(){
		vertical = Integer.parseInt(JOptionPane.showInputDialog(null, "Largo (Vertical) que tendra tu matriz:","MATRIZ FLOTANTE",3));
		horizontal = Integer.parseInt(JOptionPane.showInputDialog(null, "Ancho (Horizontal) que tendra tu matriz:","MATRIZ FLOTANTE",3));
		float floatAleatorio = Float.parseFloat(JOptionPane.showInputDialog(null, "Define el numero mas grande que generara tu matriz flotante:","MATRIZ FLOTANTE",3));
		m2 = new MatrizFlo(horizontal, vertical);
		m2.floatMatriz(floatAleatorio);
	}
	
	public void imprimeFlotante(){
		m2.impMatrizFlo();
	}
}

class Matriz{	/*Clase Matriz con los atributos que contienen todas las matrices*/
	int columnas;
	int filas;
	public Matriz (int f, int c){
		filas=f;
		columnas=c;
	}
}

class MatrizInt extends Matriz{	/*Clase MatrizInt para trabajar con matrices enteras*/
	int arre[][];
	int i, j; /*Inicializa prototipo de matriz*/
	
	public MatrizInt(int f, int c){
		super(f, c);
		arre = new int [filas][columnas];
	}
	
	public void intMatriz(int aleatorio){	//iniMatriz -> initMatriz (inicializar Matriz)	
		for (i=0;i<filas;i++)
			for (j=0;j<columnas;j++){
				arre[i][j] = (int)(Math.random()*aleatorio); //Math.random() regresa un numero double, (int) puede forzar al resultado a que sea integer		
			}
	}
	
	public void impMatrizInt(){
		String matriz="";
		System.out.println("\n\nMATRIZ ENTERA GENERADA\n");
		for (i=0;i<filas;i++){
			for (j=0;j<columnas;j++){
				System.out.print("["  + arre[i][j] + "]\t");
				matriz=matriz+"[" + (arre[i][j]) + "]";
			}
			System.out.println();
			matriz=matriz+"\n";
		}
		JOptionPane.showMessageDialog(null,"DATOS\n\n" + matriz, "MATRIZ ENTERA", 1);
	}
	
}

class MatrizFlo extends Matriz{	/*Clase MatrizFlo para trabajar con matrices flotantes*/
	float arre[][];
	int i, j;	/*Inicializa prototipo de matriz*/
	DecimalFormat formato = new DecimalFormat("#0.0000");	/*DecimalFormat da formato en decimal a los numeros flotantes*/
													//Decimal format solo da formato devolviendo una variable tipo String
	public MatrizFlo(int f, int c){
		super(f, c);
		arre = new float [filas][columnas];
	}
	
	public void floatMatriz(float aleatorio){
		for (i=0;i<filas;i++)
			for (j=0;j<columnas;j++){
				//arre[i][j] = numero.nextFloat(aleatorio);
				arre[i][j] = (float)(Math.random()*aleatorio);				
			}
	}
	
	public void impMatrizFlo(){
		String matriz="";
		System.out.println("\n\nMATRIZ FLOTANTE GENERADA\n");
		for (i=0;i<filas;i++){
			for (j=0;j<columnas;j++){
				System.out.print("["  + formato.format(arre[i][j]) + "]\t");	//Metodo format que devuelve el String del numero con n enteros y n decimales
				matriz=matriz+"[" + (formato.format(arre[i][j])) + "]\t";
			}
			System.out.println();
			matriz=matriz+"\n";
		}
		JOptionPane.showMessageDialog(null,"DATOS\n\n" + matriz, "MATRIZ FLOTANTE", 1);
	}
}

//Wrapper - Envolvente - usado para convertir datos primitivos en datos de tipo objeto