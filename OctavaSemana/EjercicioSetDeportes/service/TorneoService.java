package service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import model.Diciplinas;
import model.Jugadores;
public class TorneoService {
    private final LinkedHashSet<Jugadores> futbol = new LinkedHashSet<>();
    private final LinkedHashSet<Jugadores> basquetbol = new LinkedHashSet<>();
    private final LinkedHashSet<Jugadores> voleibol = new LinkedHashSet<>();

    private LinkedHashSet<Jugadores> set(Diciplinas d){
        switch (d) {
            case FUTBOL: return futbol;
            case BASQUETBOL: return basquetbol;
            default: return voleibol;
        }
    }
    public boolean registrarJugador(Diciplinas d, Jugadores j){
        return set(d).add(j);
    }
    public boolean existeEnDiciplinas(Diciplinas d, int id){
        for(Jugadores j: set(d)){
            if(j.getId() == id ){ return true;}
        }
        return false;
    }
    
	// Eliminar por id
	public boolean eliminarDeDisciplina(Diciplinas d, int id) {
		return set(d).removeIf(j -> j.getId() == id);
	}

	// Mostrar por disciplina con distintas implementaciones
	public HashSet<Jugadores> mostrarPorDisciplinaHash(Diciplinas d) {
		return new HashSet<>(set(d));
	}
	public LinkedHashSet<Jugadores> mostrarPorDisciplinaLinked(Diciplinas d) {
		return new LinkedHashSet<>(set(d));
	}
	public SortedSet<Jugadores> mostrarPorDisciplinaTree(Diciplinas d) {
		return new TreeSet<>(set(d)); // compareTo por nombre
	}

	// Contar jugadores en cada disciplina (impresión simple sin Map)
	public void contarJugadoresPorDisciplina() {
		System.out.println("FUTBOL: " + futbol.size());
		System.out.println("BASQUETBOL: " + basquetbol.size());
		System.out.println("VOLEIBOL: " + voleibol.size());
	}

	// Unión
	public LinkedHashSet<Jugadores> fusionarEquipos(Diciplinas a, Diciplinas b) {
		LinkedHashSet<Jugadores> u = new LinkedHashSet<>();
		u.addAll(set(a));
		u.addAll(set(b));
		return u;
	}

	// Intersección
	public LinkedHashSet<Jugadores> interseccionEquipos(Diciplinas a, Diciplinas b) {
		LinkedHashSet<Jugadores> i = new LinkedHashSet<>();
		for (Jugadores j : set(a)) {
			if (set(b).contains(j)) i.add(j);
		}
		return i;
	}

	// Transferir jugador entre disciplinas
	public boolean transferirJugador(int id, Diciplinas from, Diciplinas to) {
		if (from == to) return false;
		Jugadores encontrado = null;
		for (Jugadores j : set(from)) {
			if (j.getId() == id) {
				encontrado = j;
				break;
			}
		}
		if (encontrado == null) return false;
		if (!set(to).add(encontrado)) return false; // ya estaba
		set(from).remove(encontrado);
		return true;
	}

	// Todos ordenados por nombre (todas las disciplinas)
	public SortedSet<Jugadores> todosOrdenadosPorNombre() {
		TreeSet<Jugadores> t = new TreeSet<>();
		t.addAll(futbol);
		t.addAll(basquetbol);
		t.addAll(voleibol);
		return t;
	}

	// Todos en orden de inscripción (consolidado)
	public LinkedHashSet<Jugadores> todosEnOrdenDeInscripcion() {
		LinkedHashSet<Jugadores> l = new LinkedHashSet<>();
		l.addAll(futbol);
		l.addAll(basquetbol);
		l.addAll(voleibol);
		return l;
	}

	// Ranking por ID (menor a mayor)
	public SortedSet<Jugadores> rankingPorId() {
		TreeSet<Jugadores> porId = new TreeSet<>(Comparator.comparingInt(Jugadores::getId));
		porId.addAll(futbol);
		porId.addAll(basquetbol);
		porId.addAll(voleibol);
		return porId;
	}
}