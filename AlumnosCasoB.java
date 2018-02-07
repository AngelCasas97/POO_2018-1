/*Practica No.2 - Captura de calificaciones en modo grafico CASO B*/

import java.io.*;
import javax.swing.*;

public class AlumnosCasoB{
	
	public static void main(String args[]){
		//Atributos
		int i,promedioGrupo=0,contador=0,promedioPo;
        int total= Integer.parseInt(JOptionPane.showInputDialog(null, "Dame el numero de alumnos que vas a dar de alta al sistema:","CAPTURA DE CANTIDAD",3));
		Alumno al[]= new Alumno[total];

	for(i=0;i<total;i++){ 
		contador=contador+1;
        al[i] = new Alumno();
        al[i].nombre = JOptionPane.showInputDialog(null, "Nombre del Alumno nuevo: " + (i +1), "CAPTURA DE DE DATOS", 3);
        promedioPo = Integer.parseInt(JOptionPane.showInputDialog(null, "promedioPoo del Alumno nuevo : " + (i + 1), "CAPTURA DE DE DATOS", 3));
		al[i].promedioPoo = promedioPo; 
        al[i].direccion = JOptionPane.showInputDialog(null, "Direccion del Alumno nuevo: " + (i +1), "CAPTURA DE DE DATOS", 3);
        al[i].sexo = JOptionPane.showInputDialog(null, "Sexo del Alumno nuevo: " + (i +1), "CAPTURA DE DE DATOS", 3);
		al[i].telefono = JOptionPane.showInputDialog(null, "Telefono del Alumno nuevo: " + (i +1), "CAPTURA DE DE DATOS", 3);
		promedioGrupo+=promedioPo;	 	 
	}	//Preguntara por los datos completos por alumno
	promedioGrupo/=contador;
	
	for(i=0;i<total;i++){
		JOptionPane.showMessageDialog(null,"Nombre: " + al[i].nombre + "\nPromedioPoo: " + al[i].promedioPoo + "\nDireccion: " + al[i].direccion + "\nSexo: " + al[i].sexo + "\nTelefono: " + al[i].telefono, "PROMEDIO DEL ALUMNO " + (i+1), 1);
		//Imprime los resultados de cada captura hecha de todos los alumnos por bloque
	}
	JOptionPane.showMessageDialog(null,"Promedio del grupo: " + promedioGrupo, "PROMEDIO GENERAL", 1);
	 //   JOptionPane.showMessageDialog.(Component parentComponent, Object message, String title, int messageType);
	 //		Component parentComponent --- componente del objeto, si no va a pasar nada, se puede poner "null"
	 //0 - ERROR_MESSAGE
	 //1 - INFORMATION_MESSAGE
	 //2 - WARNING_MESSAGE
	 //3 - QUESTION_MESSAGE
	 //4 - PLAIN_MESSAGE
	}
}

class Alumno {
	String nombre, telefono, direccion, sexo;
	int promedioPoo;
}