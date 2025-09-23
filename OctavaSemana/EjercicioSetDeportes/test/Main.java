package test;

import java.util.Scanner;
import model.Diciplinas;
import model.Jugadores;
import service.TorneoService;
public class Main {
    public static void main(String[] args) {
        TorneoService servicio = new TorneoService();
		insertarDatosDePrueba(servicio);

		int opcion;
		Scanner sc = new Scanner(System.in);
		do {
            System.out.println("=".repeat(15)+"Menu"+"=".repeat(15));
            System.out.println("1. Mostrar jugadores por deporte. \r\n" + 
                            "2. Contar jugadores en cada disciplina. \r\n" + 
                            "3. Fusionar equipos (unión). \r\n" +
                            "4. Ver jugadores en común (intersección). \r\n" + 
                            "5. Transferir un jugador de un deporte a otro. \r\n" + 
                            "6. Mostrar todos los jugadores ordenados por nombre. \r\n" + 
                            "7. Mostrar todos los jugadores en orden de inscripción. \r\n" +
                            "8. Mostrar ranking de jugadores por ID. \r\n" +
                            "9. Salir ");
			while (!sc.hasNextInt()) { sc.next(); }
			opcion = sc.nextInt();

			switch (opcion) {
				case 1:
					menuMostrarPorDeporte(servicio, sc);
					break;
				case 2:
					servicio.contarJugadoresPorDisciplina();
					break;
				case 3:
					Diciplinas d1 = leerDisciplina(sc, "Primera disciplina para unión");
					Diciplinas d2 = leerDisciplina(sc, "Segunda disciplina para unión");
					servicio.fusionarEquipos(d1, d2).forEach(System.out::println);
					break;
				case 4:
					Diciplinas i1 = leerDisciplina(sc, "Primera disciplina para intersección");
					Diciplinas i2 = leerDisciplina(sc, "Segunda disciplina para intersección");
					servicio.interseccionEquipos(i1, i2).forEach(System.out::println);
					break;
				case 5:
					Diciplinas from = leerDisciplina(sc, "Desde qué disciplina transferir");
					Diciplinas to = leerDisciplina(sc, "Hacia qué disciplina transferir");
					System.out.print("ID del jugador a transferir: ");
					int id = sc.nextInt();
					System.out.println(servicio.transferirJugador(id, from, to) ? "Transferido" : "No se pudo transferir");
					break;
				case 6:
					servicio.todosOrdenadosPorNombre().forEach(System.out::println);
					break;
				case 7:
					servicio.todosEnOrdenDeInscripcion().forEach(System.out::println);
					break;
				case 8:
					servicio.rankingPorId().forEach(System.out::println);
					break;
				case 9:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción no válida.");
			}
			System.out.println();
		} while (opcion != 9);
	}

	private static void insertarDatosDePrueba(TorneoService s) {
		s.registrarJugador(Diciplinas.FUTBOL, new Jugadores(1, "Yibran"));
		s.registrarJugador(Diciplinas.FUTBOL, new Jugadores(2, "Pedro"));
		s.registrarJugador(Diciplinas.FUTBOL, new Jugadores(3, "Jess"));

		s.registrarJugador(Diciplinas.BASQUETBOL, new Jugadores(3, "Jess"));
		s.registrarJugador(Diciplinas.BASQUETBOL, new Jugadores(4, "Merari"));
		s.registrarJugador(Diciplinas.BASQUETBOL, new Jugadores(5, "Elena"));

		s.registrarJugador(Diciplinas.VOLEIBOL, new Jugadores(6, "Eduardo"));
		s.registrarJugador(Diciplinas.VOLEIBOL, new Jugadores(7, "Jaun"));
	}

	private static void menuMostrarPorDeporte(TorneoService servicio, Scanner sc) {
		Diciplinas d = leerDisciplina(sc, "Elige disciplina");
		System.out.println("1) HashSet (sin orden)");
		System.out.println("2) LinkedHashSet (orden de inscripción)");
		System.out.println("3) TreeSet (orden alfabético por nombre)");
		while (!sc.hasNextInt()) { sc.next(); }
		int tipo = sc.nextInt();
		switch (tipo) {
			case 1: servicio.mostrarPorDisciplinaHash(d).forEach(System.out::println); break;
			case 2: servicio.mostrarPorDisciplinaLinked(d).forEach(System.out::println); break;
			case 3: servicio.mostrarPorDisciplinaTree(d).forEach(System.out::println); break;
			default: System.out.println("Opción no válida.");
		}
	}

	private static Diciplinas leerDisciplina(Scanner sc, String label) {
		System.out.println(label + ": 1) FUTBOL  2) BASQUETBOL  3) VOLEIBOL");
		int op;
		do {
			while (!sc.hasNextInt()) { sc.next(); }
			op = sc.nextInt();
		} while (op < 1 || op > 3);
		if (op == 1) return Diciplinas.FUTBOL;
		if (op == 2) return Diciplinas.BASQUETBOL;
		return Diciplinas.VOLEIBOL;
	}
}