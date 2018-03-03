/*Calcular RFC en base a...
a) Nombre Completo
b) Nombre, Apellido Paterno y Apellido Materno
c) Nombre1, Nombre2, Apellido Paterno y Apellido Materno
*/
import java.io.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class practica_1{
	public static void main(String args[]){
		String opciones[] = {"Alumnos", "Profesores", "Desplegar Datos", "Salir"};
		int opcion=0, confirmacion=2;
		Captura principal = new Captura();
		do{
			opcion = (JOptionPane.showOptionDialog(null,"Elige que accion quieres hacer:\n\t1. Capturar alumnos\n\t2. Capturar profesores\n\t3. Desplegar los datos capturados\n\t4. Salir del programa","MENU PRINCIPAL", 1 ,3, null ,opciones ,null));
			switch (opcion){
				case 0:	
						principal.capturaAlumno();
						break;
				case 1:	
						principal.capturaProfesor();
						break;
				case 2:
						principal.desplegar();
						break;
				case 3:
						confirmacion = principal.salida();
						break;
			}
		} while (confirmacion!=0);	/*condicional para que confirma la salida del programa*/
	}
}

class Captura{
	int i=0,contador=0, confirmacion=2, reCaptura=2;	/*confirmacion y recaptura son dos tipos diferentes de confirmadores*/
	float promedio=0, promedioGrupo=0;
    int totalAlumnos=0, totalProfesores=0;
	String fechaNac;
	String opcion_dia[] = {	"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
							"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
							"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	String opcion_mes[] = {	"1", "2", "3", "4", "5", "6",
							"7", "8", "9", "10","11", "12"};
	String opcion_anio[] = {"2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009",
							"2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999",
							"1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989",
							"1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979",
							"1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969",
							"1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959",
							"1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949",
							"1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939",
							"1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929",
							"1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919",
							"1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909",
							"1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900"};
	
	Alumno al[] = new Alumno[1];	/*Inicializados en 1 por que JAVA necesita que estos objetos*/
	Profesor pf[] = new Profesor[1];/*esten inicializados antes de comenzar a ejecutar*/
	calculo_rfc objeto = new calculo_rfc();
	
	public void capturaAlumno(){
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
					al[i].setNombre((JOptionPane.showInputDialog(null, "Nombre del Alumno no. " + (i +1), "REGISTRO DE ALUMNOS", 3)).toUpperCase());
					
					al[i].setPaterno((JOptionPane.showInputDialog(null, "Apellido Paterno:\nNota: Si carece de uno, deje el cuadro vacio", "REGISTRO DE ALUMNOS", 3)).toUpperCase());
					al[i].setMaterno((JOptionPane.showInputDialog(null, "Apellido Materno:\nNota: Si carece de uno, deje el cuadro vacio", "REGISTRO DE ALUMNOS", 3)).toUpperCase());
					al[i].setDia(Integer.parseInt((String) JOptionPane.showInputDialog(null, "Dia de nacimiento", "REGISTRO DE ALUMNOS",JOptionPane.QUESTION_MESSAGE,null, opcion_dia,opcion_dia[0])));
					al[i].setMes(Integer.parseInt((String) JOptionPane.showInputDialog(null, "Mes de nacimiento:\n\t1 - Enero\n\t2 - Febrero\n\t3 - Marzo\n\t4 - Abril\n\t5 - Mayo\n\t6 - Junio\n\t7 - Julio\n\t8 - Agosto\n\t9 - Septiembre\n\t10 - Octubre\n\t11 - Noviembre\n\t12 - Diciembre", "REGISTRO DE ALUMNOS",JOptionPane.QUESTION_MESSAGE,null, opcion_mes,opcion_mes[0])));
					al[i].setAnio(Integer.parseInt((String) JOptionPane.showInputDialog(null, "A\u00f1o de nacimiento", "REGISTRO DE ALUMNOS",JOptionPane.QUESTION_MESSAGE,null, opcion_anio,opcion_anio[0])));
					
					al[i].setMatricula(JOptionPane.showInputDialog(null, "Matricula del Alumno ", "REGISTRO DE ALUMNOS", 3));
					promedio = Float.parseFloat(JOptionPane.showInputDialog(null, "Promedio del Alumno (Max. 100.0) ", "REGISTRO DE ALUMNOS", 3));
					al[i].setPromedio(promedio);	//Guarda la captura de promedio una variable "promedio", y guarda ese valor directamente en el arreglo del alumno
					al[i].setDireccion(JOptionPane.showInputDialog(null, "Direccion del Alumno (Ciudad, municipio,etc)", "REGISTRO DE ALUMNOS", 3));
					al[i].setCorreo(JOptionPane.showInputDialog(null, "Correo del Alumno ", "REGISTRO DE ALUMNOS", 3));
					al[i].setTelefono(JOptionPane.showInputDialog(null, "Telefono del Alumno (LADA - 000-0000)", "REGISTRO DE ALUMNOS", 3));
					promedioGrupo+=promedio;	 		//Agrega el promedio actual capturado al grupal para despues promediarse
					
					fechaNac = objeto.acronimo_fecha(al[i].getAnio(), al[i].getMes(), al[i].getDia());
					objeto.claveHomonima(al[i].getNombre(), al[i].getPaterno(), al[i].getMaterno());
					al[i].rfc = calcularRFC(al[i].getNombre(), al[i].getPaterno(), al[i].getMaterno(), fechaNac);
				
				}
				promedioGrupo/=contador;	/*Al final promedia*/
			}
	}
	
	public void capturaProfesor(){
		reCaptura = JOptionPane.showConfirmDialog(null, "Si ya has capturado datos, estos seran sobrescritos por los de la nueva captura.\nCorfirma si estas seguro de querer continuar.", "ADVERTENCIA", 2, 2);
		if (reCaptura==0){
			do{
				totalProfesores	= Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de profesores que vas a dar de alta: ","CAPTURA DE LOS DOCENTES",3));
				if (totalProfesores<1){
				JOptionPane.showMessageDialog(null,"Tienes que dar de alta al menos a un profesor.", "INVALIDACION", 2);
				}
			} while (totalProfesores<1);	//Ciclo do-while para forzar la captura minima de 1 profesor*/	
			pf = new Profesor[totalProfesores];
			for(i=0;i<totalProfesores;i++){
				pf[i] = new Profesor();
				//Captura los datos de cada rango por maestro
				pf[i].setNombre((JOptionPane.showInputDialog(null, "Nombre del Profesor No. " +(i+1), "REGISTRO DE DOCENTES", 3)).toUpperCase());	//Captura de Datos del Profesor
				pf[i].setPaterno((JOptionPane.showInputDialog(null, "Apellido Paterno:\nNota: Si carece de uno, deje el cuadro vacio", "REGISTRO DE DOCENTES", 3)).toUpperCase());
				pf[i].setMaterno((JOptionPane.showInputDialog(null, "Apellido Materno:\nNota: Si carece de uno, deje el cuadro vacio", "REGISTRO DE DOCENTES", 3)).toUpperCase());
				pf[i].setDia(Integer.parseInt((String) JOptionPane.showInputDialog(null, "Dia de nacimiento", "REGISTRO DE DOCENTES",JOptionPane.QUESTION_MESSAGE,null, opcion_dia,opcion_dia[0])));
				pf[i].setMes(Integer.parseInt((String) JOptionPane.showInputDialog(null, "Mes de nacimiento:\n\t1 - Enero\n\t2 - Febrero\n\t3 - Marzo\n\t4 - Abril\n\t5 - Mayo\n\t6 - Junio\n\t7 - Julio\n\t8 - Agosto\n\t9 - Septiembre\n\t10 - Octubre\n\t11 - Noviembre\n\t12 - Diciembre", "REGISTRO DE DOCENTES",JOptionPane.QUESTION_MESSAGE,null, opcion_mes,opcion_mes[0])));
				pf[i].setAnio(Integer.parseInt((String) JOptionPane.showInputDialog(null, "A\u00f1o de nacimiento", "REGISTRO DE DOCENTES",JOptionPane.QUESTION_MESSAGE,null, opcion_anio,opcion_anio[0])));
				
				pf[i].setEmpleado(Integer.parseInt(JOptionPane.showInputDialog(null, "No. de Empleado del Profesor", "REGISTRO DE DOCENTES", 3)));
				pf[i].setSueldo(Float.parseFloat(JOptionPane.showInputDialog(null, "Pago semanal del Profesor (En Dlls)", "REGISTRO DE DOCENTES", 3)));
				pf[i].setDireccion(JOptionPane.showInputDialog(null, "Direccion del Profesor (Ciudad, municipio,etc)", "REGISTRO DE DOCENTES", 3));
				pf[i].setCorreo(JOptionPane.showInputDialog(null, "Correo del Profesor ", "REGISTRO DE DOCENTES", 3));
				pf[i].setTelefono(JOptionPane.showInputDialog(null, "Telefono del Profesor (LADA - 000-0000)", "REGISTRO DE DOCENTES", 3));
				
				fechaNac = objeto.acronimo_fecha(pf[i].getAnio(), pf[i].getMes(), pf[i].getDia());
				objeto.claveHomonima(pf[i].getNombre(), pf[i].getPaterno(), pf[i].getMaterno());
				pf[i].rfc = calcularRFC(pf[i].getNombre(), pf[i].getPaterno(), pf[i].getMaterno(), fechaNac);
			}
		}
	}
	
	public void desplegar(){
		if (totalAlumnos==0 && totalProfesores==0)	/*Condicional para cuando no existan datos ni de alumnos ni de profesor*/
			JOptionPane.showMessageDialog(null,"No existen datos capturados de ningun tipo.", "NO HAY DATOS", 2);
		else{
			for(i=0;i<totalAlumnos;i++) //Imprime los datos de todos los alumnos
				JOptionPane.showMessageDialog(null,"Nombre: " + al[i].getNombre() + "\nApellido Paterno: " + al[i].getPaterno() + "\nApellido Materno: " + al[i].getMaterno() + "\nFecha de nacimiento (DD/MM/AAAA): " + al[i].getDia() + "/" + al[i].getMes() + "/" + al[i].getAnio() + "\nRFC : " + al[i].rfc + "\nMatricula: " + al[i].getMatricula() + "\nPromedio: " + al[i].getPromedio() + "\nDireccion: " + al[i].getDireccion() + "\nCorreo: " + al[i].getCorreo() + "\nTelefono: " + al[i].getTelefono(), "DATOS DEL ALUMNO " + (i+1), 1);
							
			for(i=0;i<totalProfesores;i++) //Imprime los datos de o de los profesores
				JOptionPane.showMessageDialog(null,"Nombre: " + pf[i].getNombre() + "\nApellido Paterno: " + pf[i].getPaterno() + "\nApellido Materno: " + pf[i].getMaterno() + "\nFecha de nacimiento (DD/MM/AAAA): " + pf[i].getDia() + "/" + pf[i].getMes() + "/" + pf[i].getAnio() + "\nRFC : " + pf[i].rfc + "\nNo. Empleado: " + pf[i].getEmpleado() + "\nSueldo: " + pf[i].getSueldo() + " Dlls\nDireccion: " + pf[i].getDireccion() + "\nCorreo: " + pf[i].getCorreo() + "\nTelefono: " + pf[i].getTelefono(), "DATOS DEL PROFESOR " + (i+1), 1);
			if (totalAlumnos>=2)	/*No lo despliedara hasta que se hayan capturado al menos a dos alumnos*/
				JOptionPane.showMessageDialog(null,"Promedio del grupo: " + promedioGrupo, "PROMEDIO GENERAL", 1);
							 //	Despliega en pantalla el promedio
		}
	}
	
	public int salida(){
		confirmacion = JOptionPane.showConfirmDialog(null, "Confirma si quiere salir del programa.", "Cerrar la aplicacion", 2, 2);
		return confirmacion;
	}
	
	public String calcularRFC(String nombre, String apPaterno, String apMaterno, String fechaNac){
		String clave_nombre, clave_paterno, clave_materno, clave_fecha, clave_auxiliar, clave_Identificadora;
		clave_nombre = objeto.acronimo_nombre(nombre);
		
		//1er Caso - Tiene un apellido paterno de dos o menos letras
		if (((apPaterno.isEmpty())==false) && ((apPaterno.length()) <=2)){
				clave_paterno = objeto.acronimo_apellido(apPaterno);
				clave_materno = objeto.acronimo_apellido(apMaterno);
				clave_auxiliar = objeto.determinaAcronimo(clave_paterno, clave_materno.valueOf(clave_materno.charAt(0)), clave_nombre);
				clave_auxiliar = objeto.inconveniente(clave_auxiliar);
		}
		//2do Caso - Tiene un apellido paterno que no tiene vocales
		else if (((apPaterno.isEmpty())==false) && (objeto.verificaVocal(apPaterno)==-1))
			{
				clave_paterno = apPaterno.substring(0,2);
				clave_materno = objeto.acronimo_apellido(apMaterno);
				clave_auxiliar = objeto.determinaAcronimo(clave_paterno, clave_materno.valueOf(clave_materno.charAt(0)), clave_nombre.valueOf(clave_nombre.charAt(0)));
				clave_auxiliar = objeto.inconveniente(clave_auxiliar);
			}
		//3er Caso - No tiene apellido paterno
		else if ((apPaterno.isEmpty())==true){
				clave_materno = objeto.acronimo_apellido(apMaterno);
				clave_auxiliar = objeto.determinaAcronimo("", clave_materno, clave_nombre);
				clave_auxiliar = objeto.inconveniente(clave_auxiliar);
		}
		//4to Caso - No tiene apellido materno
		else if ((apMaterno.isEmpty())==true){
				clave_paterno = objeto.acronimo_apellido(apPaterno);
				clave_auxiliar = objeto.determinaAcronimo(clave_paterno, "", clave_nombre);
				clave_auxiliar = objeto.inconveniente(clave_auxiliar);
		}
		//5to Caso - Tiene un apellido del formato "De la O" "De A"
		else if ((objeto.acronimo_apellido(apPaterno)).length()<=1){
			clave_paterno = objeto.acronimo_apellido(apPaterno);
			clave_materno = objeto.acronimo_apellido(apMaterno);
			clave_auxiliar = objeto.determinaAcronimo(clave_paterno, clave_materno.valueOf(clave_materno.charAt(0)), clave_nombre.valueOf(clave_nombre));
			clave_auxiliar = objeto.inconveniente(clave_auxiliar);
		}
		//6to Caso - Tiene un apellido sin restricciones especiales
		else{
				clave_paterno = objeto.acronimo_apellido(apPaterno);
				clave_materno = objeto.acronimo_apellido(apMaterno);
				clave_auxiliar = objeto.determinaAcronimo(clave_paterno, clave_materno.valueOf(clave_materno.charAt(0)), clave_nombre.valueOf(clave_nombre.charAt(0)));
				clave_auxiliar = objeto.inconveniente(clave_auxiliar);
			}
		clave_Identificadora = objeto.claveIdentificadora(clave_auxiliar + fechaNac + objeto.claveHomonima(nombre, apPaterno, apMaterno));
		return (clave_auxiliar + fechaNac + objeto.claveHomonima(nombre, apPaterno, apMaterno) + clave_Identificadora);
	}
}

class calculo_rfc{
	int i, j;
	String auxiliar;
	String fecha;
	
	public String acronimo_nombre(String nombre){
		String clave = new String(), auxiliar_nombre;
		int palabras=1;
		for (i=0;i<nombre.length();i++){
			if (nombre.charAt(i) == ' ')
				palabras++;
		}
		if (palabras>1){
			if ((nombre.indexOf("JOSE JOSE")!= -1))
				clave = nombre.substring(0, 2);
			else if ((nombre.indexOf("JOSE MARIA")!= -1))
				clave = nombre.substring(0, 2);
			else if ((nombre.indexOf("MARIA JOSE")!= -1))
				clave = nombre.substring(0, 2);
			else if ((nombre.indexOf("JOSE")!= -1) && (nombre.indexOf("JOSE")==0)){
				if (nombre.length()<=4)
					clave = nombre.substring(0, 2);
				else
					clave = nombre.substring(5, 7);
			}
			else if ((nombre.indexOf("MARIA")!= -1) && (nombre.indexOf("MARIA")==0)){
				if (nombre.length()<=5)
					clave = nombre.substring(0, 2);
				else
					clave = nombre.substring(0, 2);
			}
			else
				clave = nombre.substring(0,2);				
		}
		else
			clave = nombre.substring(0,2);
		return clave;
	}
	
	public int verificaVocal(String palabra){
		int contador=1;
		String auxiliar = palabra.toUpperCase();
		if ((auxiliar.length())>0){
			do{
				if ((auxiliar.charAt(contador)=='A') || (auxiliar.charAt(contador)=='E') || (auxiliar.charAt(contador)=='I') || (auxiliar.charAt(contador)=='O') || (auxiliar.charAt(contador)=='U'))
					return (contador);
				contador++;
			} while ((contador)<=(palabra.length()-1));
		return (-1);
		}
		else
			return (-1);
			
	}
	
	public String acronimo_apellido(String apellido){
		String clave = new String();
		String temporal = new String();
		int palabras=1;
		String casos[] = {"LAS", "LOS", "DEL", "LA", "DE" , "Y"};
		apellido = apellido.toUpperCase();
		if ((apellido.length())<=2){
			return (apellido.valueOf(apellido.charAt(0)));
		}
		else{
			for (i=0;i<apellido.length();i++){
				if (apellido.charAt(i) == ' ')
					palabras++;
			}
			i=0;
			if (palabras>1){
				do{
					if ((apellido.indexOf(casos[i])!= -1) && (apellido.indexOf(casos[i])== 0)){	//para apellidos como "de", "y" , "del"
						clave = apellido.valueOf(apellido.charAt( casos[i].length() + 1));
						temporal = apellido.substring(apellido.indexOf(casos[i]) + casos[i].length() + 2);
					}
					else if ((apellido.indexOf(casos[i])!= -1) && (apellido.substring(0,2).compareToIgnoreCase("DE")!=0)){ //Excepcion para apellidos como "de la" y "de los"
						clave = apellido.valueOf(apellido.charAt(0));
						temporal = apellido.substring(1);
					}
					else if ((apellido.indexOf(casos[i])!= -1) && (apellido.indexOf(casos[i])!= 0)){
						clave = apellido.valueOf(apellido.charAt( apellido.indexOf(casos[i]) + casos[i].length() + 1));
						temporal = apellido.substring( apellido.indexOf(casos[i]) + casos[i].length() + 2);
					}
					else{	//apellido sin excepciones
						clave = apellido.valueOf(apellido.charAt(0));
						temporal = apellido.substring(1);
					}
					i++;
				}while((i<5) && !(apellido.indexOf(casos[i-1])!= -1));
			}
			else{
				clave = apellido.valueOf(apellido.charAt(0));
				temporal = apellido.substring(1);
			}
			i=0;
			if (temporal.isEmpty()==false){
				do{
					if ((temporal.charAt(i)=='A') || (temporal.charAt(i)=='E') || (temporal.charAt(i)=='I') || (temporal.charAt(i)=='O') || (temporal.charAt(i)=='U'))
						clave += temporal.valueOf(temporal.charAt(i));
						i++;
				}while ( (!(temporal.charAt(i-1)=='A') && !(temporal.charAt(i-1)=='E') && !(temporal.charAt(i-1)=='I') && !(temporal.charAt(i-1)=='O') && !(temporal.charAt(i-1)=='U')) && (i < temporal.length()));
			}
		}
		return clave;
	}
	
	public String acronimo_fecha(int anio, int mes, int dia){
		int a, m, d;
		DecimalFormat formato = new DecimalFormat("#00");	//Permitira crear un string de formato 00 + 00 + 00 (Año + Mes + Dia)
		a = (anio%100);
		m = (mes);
		d = (dia);
		fecha =  formato.format(a) + formato.format(m) + formato.format(d);
		return fecha;
	}
	
	public String determinaAcronimo(String paterno, String materno, String nombre){
		String acronimo = new String();
			acronimo = paterno + materno + nombre;
		return acronimo;
	}
	
	public String inconveniente(String acro){
		int i=0;
		String lista[] = {	"BUEI", "BUEY", "CACA", "CACO", "CAGA", "CAGO", "CAKA", "CAKO", "LOBA", "KOJA",
							"COGE", "COJA", "COJE", "COJI", "COJO", "CULO", "FETO", "GUEY", "LOCA", "KOGI",
							"JOTO", "KACA", "KACO", "KAGA", "KAGO", "KOGE", "KOJO", "KAKA", "KOJE", "COGI",
							"KULO", "MAME", "MAMO", "MEAR", "MEAS", "MEON", "MION", "MOCO", "GUEI",
							"MULA", "PEDA", "PEDO", "PENE", "PUTA", "PUTO", "QULO", "RATA", "RUIN",			};
		do{
			if ((acro.compareToIgnoreCase(lista[i]))==0)
				acro = lista[i].substring(0, 3) + "X";
			i++;
		}	while	(i<(lista.length));
		return (acro.toUpperCase());
	}
	
	public String claveHomonima(String nombre, String apPaterno, String apMaterno){
		String nombre_completo = new String();
		String codigo_numerico = new String();
		String clave = new String();
		int sumatoria=0, cociente, residuo;
		String tablaClaveDiferenciadora = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";
		String tablaClave[] = {	"00","00","01","02","03","04","05","06","07","08","09","10",
								"11","12","13","14","15","16","17","18","19",
								"21","22","23","24","25","26","27","28","29",
								"32","33","34","35","36","37","38","39","40", };
		String tablaCaracteres = " 0123456789&ABCDEFGHIJKLMNOPQRSTUVWXYZÑ";
		nombre_completo = (apPaterno + " " + apMaterno + " " + nombre);
		codigo_numerico = "0";
		for (i=0;i<(nombre_completo.length());i++)
			for (j=0;j<(tablaCaracteres.length());j++){
				if ((nombre_completo.charAt(i)) == (tablaCaracteres.charAt(j)))
					codigo_numerico += tablaClave[j];
			}
		for (i=0;i<(codigo_numerico.length()-1);i++){
			sumatoria += ((Integer.parseInt(codigo_numerico.substring(i, i+2)))*(Integer.parseInt( codigo_numerico.substring(i+1, i+2))));
		}
		sumatoria%=1000;
		cociente = sumatoria/34;
		residuo = sumatoria%34;
		clave = tablaClaveDiferenciadora.substring(cociente, cociente+1) + tablaClaveDiferenciadora.substring(residuo, residuo+1);
		return clave;
	}
	
	public String claveIdentificadora(String rfc){
		String codigo_numerico = new String();
		String clave = new String();
		int sumatoria=0, residuo=0;
		String tablaClaveIdentificadora = "0123456789ABCDEFGHIJKLMN&OPQRSTUVWXYZ Ñ";
		String tablaClaveNumerica[] = {	"00","01","02","03","04","05","06","07","08","09","10",
										"11","12","13","14","15","16","17","18","19","20",
										"21","22","23","24","25","26","27","28","29","30",
										"31","32","33","34","35","36","37","38"};
		for (i=0;i<(rfc.length());i++)
			for (j=0;j<(tablaClaveIdentificadora.length());j++){
				if ((rfc.charAt(i)) == (tablaClaveIdentificadora.charAt(j)))
					codigo_numerico += tablaClaveNumerica[j];
			}
		j=0;
		for (i=0;i<(codigo_numerico.length()-1);i+=2){
			sumatoria += ((Integer.parseInt(codigo_numerico.substring(i, i+2)))*((rfc.length()+1)-(j)));
			j++;
			}
		residuo = sumatoria%11;
		if (residuo == 0)
			return "0";
		else if (residuo == 10)
			return "A";
		return (clave.valueOf(11-residuo));
	}
}

class Persona{		/*Clase Persona, con atributos y metodos*/
		// Atributos de Persona, estos los puede heredar a otra clase con el comando "extends"
		String nombre;
		String correo;
		String telefono;
		String direccion;
		
		String rfc;
		String ap_Paterno;
		String ap_Materno;
		int anio_nac;
		int mes_nac;
		int dia_nac;
		
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
		
		public void setPaterno(String ap_Paterno){
			this.ap_Paterno = ap_Paterno;
		}
		public void setMaterno(String ap_Materno){
			this.ap_Materno = ap_Materno;
		}
		public void setAnio(int anio_nac){
			this.anio_nac = anio_nac;
		}
		public void setMes(int mes_nac){
			this.mes_nac = mes_nac;
		}
		public void setDia(int dia_nac){
			this.dia_nac = dia_nac;
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
		
		public String getPaterno(){
			return ap_Paterno;
		}
		public String getMaterno(){
			return ap_Materno;
		}
		public int getAnio(){
			return anio_nac;
		}
		public int getMes(){
			return mes_nac;
		}
		public int getDia(){
			return dia_nac;
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