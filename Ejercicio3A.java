/*Practica No.3a - Herencia simple con entrada/salida gráfica*/

import java.io.*;
import javax.swing.*;

public class Ejercicio3A{
	
	public static void main(String args[]){
		//Atributos
		int i=0,contador=0;
		float promedio=0, promedioGrupo=0;
        int totalAlumnos= Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de alumnos que vas a dar de alta: ","CAPTURA DEL GRUPO",3));
		int totalProfesores = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de profesores que vas a dar de alta: ","CAPTURA DE LOS DOCENTES",3));
		Alumno al[]= new Alumno[totalAlumnos];	//Aqui inicializa una lista de "n" objetos de clase "Alumno"
		Profesor pf[] = new Profesor[totalProfesores]; //Aqui inicializa una lista de "n" objetos de clase "Profesor"

		for(i=0;i<totalAlumnos;i++){
			contador=contador+1;
			al[i] = new Alumno();	//inicializacion de cada miembro de la lista con una clase "Alumno"
			//Captura los datos de cada rango por alumno
			al[i].setNombre(JOptionPane.showInputDialog(null, "Nombre del Alumno no. " + (i +1), "REGISTRO DE ALUMNOS", 3));
			al[i].setMatricula(JOptionPane.showInputDialog(null, "Matricula del Alumno ", "REGISTRO DE ALUMNOS", 3));
			promedio = Float.parseFloat(JOptionPane.showInputDialog(null, "Promedio del Alumno (Max. 100.0) ", "REGISTRO DE ALUMNOS", 3));
			al[i].setPromedio(promedio);	/*Guarda la captura de promedio una variable "promedio", y guarda ese valor directamente en el arreglo del alumno*/ 
			al[i].setDireccion(JOptionPane.showInputDialog(null, "Direccion del Alumno (Ciudad, municipio,etc)", "REGISTRO DE ALUMNOS", 3));
			al[i].setCorreo(JOptionPane.showInputDialog(null, "Correo del Alumno ", "REGISTRO DE ALUMNOS", 3));
			al[i].setTelefono(JOptionPane.showInputDialog(null, "Telefono del Alumno (LADA - 000-0000)", "REGISTRO DE ALUMNOS", 3));
			promedioGrupo+=promedio;	 		//Agrega el promedio actual capturado al grupal para despues promediarse
		}
		promedioGrupo/=contador;	/*Al final promedia*/
		
		for(i=0;i<totalProfesores;i++){
			pf[i] = new Profesor();	//inicializacion de cada miembro de la lista con una clase "profesor"
			//Captura los datos de cada rango por maestro
			pf[i].setNombre(JOptionPane.showInputDialog(null, "Nombre del Profesor No. " +(i+1), "REGISTRO DE DOCENTES", 3));	//Captura de Datos del Profesor
			pf[i].setEmpleado(Integer.parseInt(JOptionPane.showInputDialog(null, "No. de Empleado del Profesor", "REGISTRO DE DOCENTES", 3)));
			pf[i].setSueldo(Float.parseFloat(JOptionPane.showInputDialog(null, "Pago semanal del Profesor (En Dlls)", "REGISTRO DE DOCENTES", 3)));
			pf[i].setDireccion(JOptionPane.showInputDialog(null, "Direccion del Profesor (Ciudad, municipio,etc)", "REGISTRO DE DOCENTES", 3));
			pf[i].setCorreo(JOptionPane.showInputDialog(null, "Correo del Profesor ", "REGISTRO DE DOCENTES", 3));
			pf[i].setTelefono(JOptionPane.showInputDialog(null, "Telefono del Profesor (LADA - 000-0000)", "REGISTRO DE DOCENTES", 3));
		}
		
		for(i=0;i<totalAlumnos;i++){
			JOptionPane.showMessageDialog(null,"Nombre: " + al[i].getNombre() + "\nMatricula: " + al[i].getMatricula() + "\nPromedio: " + al[i].getPromedio() + "\nDireccion: " + al[i].getDireccion() + "\nCorreo: " + al[i].getCorreo() + "\nTelefono: " + al[i].getTelefono(), "DATOS DEL ALUMNO " + (i+1), 1);
			//Imprime los resultados de cada captura hecha de todos los alumnos
		}
		
		for(i=0;i<totalProfesores;i++){
			JOptionPane.showMessageDialog(null,"Nombre: " + pf[i].getNombre() + "\nNo. Empleado: " + pf[i].getEmpleado() + "\nSueldo: " + pf[i].getSueldo() + " Dlls\nDireccion: " + pf[i].getDireccion() + "\nCorreo: " + pf[i].getCorreo() + "\nTelefono: " + pf[i].getTelefono(), "DATOS DEL PROFESOR " + (i+1), 1);
			//Imprime los datos de o de los profesores
		}
		
		JOptionPane.showMessageDialog(null,"Promedio del grupo: " + promedioGrupo, "PROMEDIO GENERAL", 1);
		 //	Despliega en pantalla el promedio
		}
}

class Persona{		/*Clase Persona, con atributos y metodos*/
		// Atributos de Persona, estos los puede heredar a otra clase con el comando "extends"
		String nombre;
		String correo;
		String telefono;
		String direccion;
		
		public void setNombre(String nombre){	/*Metodo set para el almacenamiento de variables*/
			this.nombre = nombre;
		}
		public void setCorreo(String correo){
			this.correo = correo;
		}
		public void setTelefono(String telefono){
			this.telefono = telefono;
		}
		public void setDireccion(String direccion){
			this.direccion = direccion;
		}
		public String getNombre(){	/*Metodo get para devolver el contenido de variables*/
			return nombre;
		}
		public String getCorreo(){
			return correo;
		}
		public String getTelefono(){
			return telefono;
		}
		public String getDireccion(){
			return direccion;
		}
	}
	
class Alumno extends Persona{	/*Abstraccion hecha en la clase Alumno que hereda los atributos de Persona y tiene unos unicos de su propia clase*/
		//Atributos excusivos de Alumno
		String matricula;
		float promedio;
		
		public void setMatricula(String matricula){
			this.matricula = matricula;
		}
		public void setPromedio(float promedio){
			this.promedio = promedio;
		}
		public String getMatricula(){
			return matricula;
		}
		public float getPromedio(){
			return promedio;
		}
	}
	
class Profesor extends Persona{ /*Abstraccion hecha en la clase Profesor que hereda los atributos de Persona y tiene unos unicos de su propia clase*/
		//Atributos excusivos de Profesor
		int num_Empleado;
		float sueldo;
		
		public void setEmpleado(int num_Empleado){
			this.num_Empleado = num_Empleado;
		}
		public void setSueldo(float sueldo){
			this.sueldo = sueldo;
		}
		public int getEmpleado(){
			return num_Empleado;
		}
		public float getSueldo(){
			return sueldo;
		}
	}