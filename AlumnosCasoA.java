/*Practica No.2 - Captura de calificaciones en modo grafico CASO A*/

import java.io.*;
import javax.swing.*;

public class AlumnosCasoA{
	
	public static void main(String args[]){
		//Atributos
		
		int promedioPo;
		Alumno al= new Alumno();

        al.nombre = JOptionPane.showInputDialog(null, "Nombre del Alumno nuevo: ", "CAPTURA DE DE DATOS", 3);
        promedioPo = Integer.parseInt(JOptionPane.showInputDialog(null, "promedioPoo del Alumno nuevo : ", "CAPTURA DE DE DATOS", 3));
		al.promedioPoo = promedioPo;
        al.direccion = JOptionPane.showInputDialog(null, "Direccion del Alumno nuevo: ", "CAPTURA DE DE DATOS", 3);
        al.sexo = JOptionPane.showInputDialog(null, "Sexo del Alumno nuevo: ", "CAPTURA DE DE DATOS", 3);
		al.telefono = JOptionPane.showInputDialog(null, "Telefono del Alumno nuevo: ", "CAPTURA DE DE DATOS", 3);
		//Preguntara por los datos completos del alumno
		
		JOptionPane.showMessageDialog(null,"Nombre: " + al.nombre + "\nPromedioPoo: " + al.promedioPoo + "\nDireccion: " + al.direccion + "\nSexo: " + al.sexo + "\nTelefono: " + al.telefono, "PROMEDIO DEL ALUMNO ", 1);
		//Imprime los resultados de cada captura hecha del alumno
	 //   JOptionPane.showMessageDialog.(Component parentComponent, Object message, String title, int messageType);
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