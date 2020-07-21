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
		System.out.println(listaSismos);// imprimo los sismos
		sismos.mostrarUltimoSismo(listaSismos);// muestra el ultimo sismo en chile
		
		System.out.println("Creacion de nuevo menu: ");
		Scanner sc = new Scanner(System.in);

	}
}
