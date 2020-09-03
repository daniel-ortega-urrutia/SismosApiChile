package cl.desafiolatam;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Sismos sismos = new Sismos();// instancio la clase
		// creo una nueva lista, le entrego el metodo que me retorna una lista con los
		// sismos
		List<Sismos> listaSismos = sismos.retornarSismos();
		Scanner sc = new Scanner(System.in);
		String opcion = "";
		System.out.println("Bienvenido: \n¿Que desea hacer?");
		while (!opcion.equals("salir")) {
			System.out.printf("1-Listar ultimo sismo \n");
			System.out.printf("2-Listar todos los sismos \n");
			System.out.printf("escriba salir para terminar el programa \n");
			opcion = sc.nextLine();

			if (opcion.equalsIgnoreCase("1")) {
				sismos.mostrarUltimoSismo(listaSismos);

			} else if (opcion.equalsIgnoreCase("2")) {
				System.out.println(listaSismos);
			} else if (opcion.equalsIgnoreCase("salir")) {
				System.out.println("Saliendo... \n");
//			cerramos el programa
				System.exit(0);

			} else {
				System.out.println("Opcion invalida \n");
			}
		}
		// termina metodo main

	}

}
