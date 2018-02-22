/*Practica No.3b - Herencia simple con entrada/salida gráfica, con Menu*/

import java.io.*;
import javax.swing.*;

public class Ejercicio3B{
	
	public static void main(String args[]){
		//Atributos
		int i=0,contador=0, opcion=0, confirmacion=2, reCaptura=2;	/*confirmacion y recaptura son dos tipos diferentes de confirmadores*/
		float promedio=0, promedioGrupo=0;
        int totalAlumnos=0, totalProfesores=0;
		String opciones[] = {"Alumnos", "Profesores", "Desplegar Datos" ,"Salir"};	/*Strings para señalar las opciones del menu*/
		Alumno al[] = new Alumno[1];	/*Inicializados en 1 por que JAVA necesita que estos objetos*/
		Profesor pf[] = new Profesor[1];/*esten inicializados antes de comenzar a ejecutar*/
		
		do{
			/*Desplegado del menu principal con 4 opciones*/
			opcion = (JOptionPane.showOptionDialog(null,"Elige que accion quieres hacer:\n\t1. Capturar alumnos\n\t2. Capturar profesores\n\t3. Desplegar los datos capturados\n\t4. Salir del programa","MENU PRINCIPAL", 1 ,3, null ,opciones ,null));
			switch (opcion){
				case 0:	/*Opcion de capturar alumno*/
						/*reCaptura es una confirmacion de volver a capturar datos de alumno (se perderan los ya guardados)*/
						reCaptura = JOptionPane.showConfirmDialog(null, "Si ya has capturado datos, estos se sobrescribiran por los de la nueva captura.\nCorfirma si estas seguro de querer continuar.", "ADVERTENCIA", 2, 2);
						if (reCaptura==0){	/*Si elige capturar, aun cuando estos se sobrescriban*/
							do{
								totalAlumnos = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de alumnos que vas a dar de alta: ","CAPTURA DEL GRUPO",3));
								if (totalAlumnos<2){
									JOptionPane.showMessageDialog(null,"Tienes que dar de alta al menos a dos alumnos.", "INVALIDACION", 2);
								}	//Ciclo do-while para forzar la captura minima de 2 alumnos
							} while (totalAlumnos<2);
							 al= new Alumno[totalAlumnos];
							
							for(i=0;i<totalAlumnos;i++){
								contador=contador+1;
								al[i] = new Alumno();
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
						}
						
						break;
				case 1:	/*Opcion de capturar profesor*/
						/*reCaptura es una confirmacion de volver a capturar datos de profesores (se perderan los ya guardados)*/
						reCaptura = JOptionPane.showConfirmDialog(null, "Si ya has capturado datos, estos seran sobrescritos por los de la nueva captura.\nCorfirma si estas seguro de querer continuar.", "ADVERTENCIA", 2, 2);
						if (reCaptura==0){
							do{
								totalProfesores	= Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de profesores que vas a dar de alta: ","CAPTURA DE LOS DOCENTES",3));
								if (totalProfesores<1){
									JOptionPane.showMessageDialog(null,"Tienes que dar de alta al menos a un profesor.", "INVALIDACION", 2);
								}
							} while (totalProfesores<1);	//Ciclo do-while para forzar la captura minima de 1 profesor
							
							 pf = new Profesor[totalProfesores];
							
							for(i=0;i<totalProfesores;i++){
								pf[i] = new Profesor();
								//Captura los datos de cada rango por maestro
								pf[i].setNombre(JOptionPane.showInputDialog(null, "Nombre del Profesor No. " +(i+1), "REGISTRO DE DOCENTES", 3));	//Captura de Datos del Profesor
								pf[i].setEmpleado(Integer.parseInt(JOptionPane.showInputDialog(null, "No. de Empleado del Profesor", "REGISTRO DE DOCENTES", 3)));
								pf[i].setSueldo(Float.parseFloat(JOptionPane.showInputDialog(null, "Pago semanal del Profesor (En Dlls)", "REGISTRO DE DOCENTES", 3)));
								pf[i].setDireccion(JOptionPane.showInputDialog(null, "Direccion del Profesor (Ciudad, municipio,etc)", "REGISTRO DE DOCENTES", 3));
								pf[i].setCorreo(JOptionPane.showInputDialog(null, "Correo del Profesor ", "REGISTRO DE DOCENTES", 3));
								pf[i].setTelefono(JOptionPane.showInputDialog(null, "Telefono del Profesor (LADA - 000-0000)", "REGISTRO DE DOCENTES", 3));
							}
						}
						break;
				case 2:	/*Desplegar las capturas hechas*/
						if (totalAlumnos==0 && totalProfesores==0)	/*Condicional para cuando no existan datos ni de alumnos ni de profesor*/
							JOptionPane.showMessageDialog(null,"No existen datos capturados de ningun tipo.", "NO HAY DATOS", 2);
						
						else{
							for(i=0;i<totalAlumnos;i++) //Imprime los datos de todos los alumnos
								JOptionPane.showMessageDialog(null,"Nombre: " + al[i].getNombre() + "\nMatricula: " + al[i].getMatricula() + "\nPromedio: " + al[i].getPromedio() + "\nDireccion: " + al[i].getDireccion() + "\nCorreo: " + al[i].getCorreo() + "\nTelefono: " + al[i].getTelefono(), "DATOS DEL ALUMNO " + (i+1), 1);
							
							for(i=0;i<totalProfesores;i++) //Imprime los datos de o de los profesores
								JOptionPane.showMessageDialog(null,"Nombre: " + pf[i].getNombre() + "\nNo. Empleado: " + pf[i].getEmpleado() + "\nSueldo: " + pf[i].getSueldo() + " Dlls\nDireccion: " + pf[i].getDireccion() + "\nCorreo: " + pf[i].getCorreo() + "\nTelefono: " + pf[i].getTelefono(), "DATOS DEL PROFESOR " + (i+1), 1);
							
							if (totalAlumnos>=2)	/*No lo despliedara hasta que se hayan capturado al menos a dos alumnos*/
							JOptionPane.showMessageDialog(null,"Promedio del grupo: " + promedioGrupo, "PROMEDIO GENERAL", 1);
							 //	Despliega en pantalla el promedio
						}
						
						break;
				case 3:	/*Salir del programa*/
						confirmacion = JOptionPane.showConfirmDialog(null, "Confirma si quiere salir del programa.", "Cerrar la aplicacion", 2, 2);
						break;
			}
		} while (confirmacion!=0);	/*condicional para que confirma la salida del programa*/
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