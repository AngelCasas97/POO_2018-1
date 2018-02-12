/*
Programa para calcular el promedio por alumno y grupo
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct alumno
{
    char nombre[40];
    int matricula;
    int materiasCursadas;   /*Lleva el conteo de carga (2 materias, 4 materias, etc.)*/
    char materias[7][40];   /*con este arreglo se pueden capturas 7 cadenas de 30 caracteres*/
    float calificacion[5];  /*Lleva el regstro de calificaciones*/
    float promedio;
};

void captura(struct alumno [], int);    /*Captura de todos los datos de un alumno*/
void mostrar(struct alumno [], int, float); /*Despliega todos los datos registrados*/
float promedio(struct alumno [], int , int );   /*Calclula el promedio de un alumno*/
float promGrupo(struct alumno [], int );    /*Calcula el promedio grupal*/

int main()
{
    struct alumno lista[50];
    char opcion;
    int contador=0, i=0, j=0;
    float suma=0, promGral=0;

    system("cls");
    printf("Captura los datos individuales de al menos 2 personas.\n");
    do
    {
        do
        {
            captura(lista, contador);
            fflush(stdin);
            contador++;
            if(contador>1)  /*Hara capturar a dos alumnos como minimo*/
            {
                printf("Quiere capturar las calificaciones de un alumno mas?(S/N): ");
                opcion=getchar();
            }
        } while (contador<=1);/*En caso de querer registrar mas de dos alumnos*/
    } while ((opcion!='N') && (opcion!='n'));
    promGral=promGrupo(lista, contador);
    mostrar(lista, contador, promGral);
    system("pause");
    return 0;
}

void captura(struct alumno lista[], int contador)
{
    float moldeCalif=0;
    int cantidad=0, materias=0;

    printf("\nEscribe el nombre completo del alumno no. %d: ", contador+1);
    fflush(stdin);
    gets(lista[contador].nombre);
    printf("Matricula: ");
    fflush(stdin);
    scanf("%d", &lista[contador].matricula);
    fflush(stdin);
    do
    {
        printf("Escrbe el numero de materias que esta cursando este alumno: ");
        scanf("%d", &cantidad);
        if (cantidad<2)
            printf("El alumno debe de cursar al menos dos materias.\nPor favor, ingresa otra vez una carga valida.\n");
    }   while (cantidad<2);                     /*Con esta condicion, se esta obligado a capturar dos materias*/
    lista[contador].materiasCursadas = cantidad;
    for (materias=0;materias<cantidad;materias++)   /*En este ciclo se lleva el registro de nombres y de calificaciones*/
    {
        fflush(stdin);
        printf("Captura el nombre de la materia no. %d: ", materias+1);
        gets(lista[contador].materias[materias]);   /*Captura la cadena en cada renglon de la matriz*/
        fflush(stdin);
        printf("Captura la calificacion en esta materia: ");
        scanf("%f", &moldeCalif);
        lista[contador].calificacion[materias]=moldeCalif;
    }
    lista[contador].promedio=promedio(lista, contador, cantidad);
    printf("\nLos datos de este alumno estan registrados.\n");  /*Aviso de cambio de llenado de datos a otro alumno*/
}

float promedio(struct alumno lista[], int contador, int materias)   /*contador es el numero de alumno que a promediar*/
{                                                                   /*materias es la carga que lleva el alumno a promediar*/
    float suma=0;
    int conteo=0;
    for (conteo=0;conteo<materias;conteo++)
        suma+=lista[contador].calificacion[conteo];
    return (suma/materias);
}

float promGrupo(struct alumno lista[], int contador)    /*contador es el numero de alumno que a promediar*/
{
    float suma=0;
    int conteo=0;
    for (conteo=0;conteo<contador;conteo++)
        suma+=lista[conteo].promedio;
    return(suma/contador);
}

void mostrar(struct alumno lista[], int contador, float promGral)   /*Los datos externos que necesita son la cantidad de alumnos y el promedio general*/
{                                                                   /*El resto de datos los tiene la estructura*/
    int cuentaAlumno, cuentaCalif;
    int materia=0;
    printf("\n\nLISTA DE CALIFICACIONES\n\n");  /*Primero imprime un bonito encabezado*/

    for (cuentaAlumno=0;cuentaAlumno<contador;cuentaAlumno++)   /*Esta accion se repetira con todos los alumnos*/
    {
        cuentaCalif=0;
        materia=0;
        printf("%07d ----- %s\n", lista[cuentaAlumno].matricula, lista[cuentaAlumno].nombre); /*Imprime nombre y matricula*/
        do
        {
            printf("\t%-40s --- %.2f\n", lista[cuentaAlumno].materias[materia++] ,lista[cuentaAlumno].calificacion[cuentaCalif++]);
        } while (lista[cuentaAlumno].materiasCursadas>materia); /*Aqui imprime las materias y calificaciones cursadas por el alumno*/
        printf("%-40s --- %.2f\n", "\t\tPromedio" ,lista[cuentaAlumno].promedio);   /*Como ultimo dato del alumno, su promedio*/
        printf("----------------------------------------------------------------------\n");   /*divisores de impresion por alumno*/
    }
     printf("----------------------------------------------------------------------\n");  /*divisores de impresion para el promedio final*/
    printf("%-40s ------- %.2f\n\n", "\t\t\tPromedio del grupo" , promGral);    /*Y por ultimo, el promedio de grupo*/
}
