package reality;

import java.util.ArrayList;

import compBatallas.compIdiomas;
import compBatallas.compInstrumentos;
import criteriosParticipantes.CriterioCantMinParticipantesInstrumento;
import criteriosParticipantes.CriterioEdadMayor;
import criteriosParticipantes.CriterioGeneroPreferencia;
import criteriosParticipantes.CriterioIdioma;
import criteriosParticipantes.CriterioIdiomas;
import criteriosParticipantes.CriterioInstrumento;
import criteriosParticipantes.CriterioInterpretaTema;
import criteriosParticipantes.CriterioOK;
import criteriosParticipantes.CriterioParticipante;
import criteriosParticipantes.CriterioParticipanteAnd;
import criteriosParticipantes.CriterioParticipanteNot;
import criteriosParticipantes.CriterioParticipanteOr;

public class Main {
	public static void main(String args[]) {
		ArrayList<String> generos = new ArrayList<>();
		generos.add("Rock");
		generos.add("Jazz");
		generos.add("Musica clasica");
		generos.add("Musica electronica");
		generos.add("Electro");
		generos.add("Dupstep");
		ArrayList<String> generos1 = new ArrayList<>();
		generos1.add("Rock");
		generos1.add("Jazz");
		ArrayList<String> generos2 = new ArrayList<>();
		generos2.add("Musica clasica");
		generos2.add("Musica electronica");
		ArrayList<String> generos3 = new ArrayList<>();
		generos3.add("Electro");
		generos3.add("Dupstep");

		ArrayList<String> instrumentos = new ArrayList<>();
		instrumentos.add("Guitarra");
		instrumentos.add("Piano");
		instrumentos.add("Violin");
		instrumentos.add("Bateria");
		instrumentos.add("Bajo");
		ArrayList<String> instrumentos1 = new ArrayList<>();
		instrumentos1.add("Guitarra");
		instrumentos1.add("Piano");
		ArrayList<String> instrumentos2 = new ArrayList<>();
		instrumentos2.add("Violin");
		instrumentos2.add("Bateria");
		ArrayList<String> instrumentos3 = new ArrayList<>();
		instrumentos3.add("Bajo");

		TemaMusical tema1 = new TemaMusical("tema1", "Ingles", generos1, instrumentos1, new CriterioOK());
		TemaMusical tema2 = new TemaMusical("tema2", "Español", generos2, instrumentos2,
				new CriterioCantMinParticipantesInstrumento(2, "Guitarra"));
		TemaMusical tema3 = new TemaMusical("tema3", "Aleman", generos3, instrumentos3,
				new CriterioCantMinParticipantesInstrumento(3, "Guitarra"));
		ArrayList<TemaMusical> temasMusicalesPosibles = new ArrayList<>();
		temasMusicalesPosibles.add(tema1);
		temasMusicalesPosibles.add(tema2);
		temasMusicalesPosibles.add(tema3);

		ArrayList<String> idiomas = new ArrayList<>();
		idiomas.add("Español");
		idiomas.add("Ingles");
		idiomas.add("Aleman");
		idiomas.add("Frances");
		idiomas.add("Japones");
		ArrayList<String> idiomas1 = new ArrayList<>();
		idiomas1.add("Español");
		idiomas1.add("Ingles");
		ArrayList<String> idiomas2 = new ArrayList<>();
		idiomas2.add("Aleman");
		idiomas2.add("Frances");
		ArrayList<String> idiomas3 = new ArrayList<>();
		idiomas3.add("Japones");

		Participante p1 = new Participante("Marcos", "Celor", 19, generos1, idiomas1, instrumentos1);
		Participante p2 = new Participante("Carlos", "Celor", 27, generos2, idiomas2, instrumentos2);
		Participante p3 = new Participante("Juan", "Zon", 39, generos3, idiomas3, instrumentos3);
		Participante p4 = new Participante("Pedro", "Lanz", 17, generos1, idiomas1, instrumentos1);
		Participante p5 = new Participante("Kevin", "Yante", 41, generos2, idiomas2, instrumentos2);
		Participante p6 = new Participante("Ignacio", "Varne", 22, generos3, idiomas3, instrumentos3);
		Participante p7 = new Participante("Roberto", "Varne", 35, generos1, idiomas1, instrumentos1);
		Participante p8 = new Participante("Aaron", "Varne", 29, generos1, idiomas1, instrumentos1);
		Banda b1 = new Banda("Banda1");
		b1.addMiembro(p2);
		b1.addMiembro(p3);
		b1.addMiembro(p4);
		Banda b2 = new Banda("Banda2");
		b2.addMiembro(p5);
		b2.addMiembro(p6);
		b2.addMiembro(b1);
		Banda b3 = new Banda("Banda3");
		b3.addMiembro(p7);
		b3.addMiembro(p8);
		Participante p9 = new Participante("Franco", "Reter", 30, generos3, idiomas3, instrumentos3);
		Participante p10 = new Participante("Franco", "Reter", 30, generos1, idiomas1, instrumentos1);

		Coach c1 = new Coach("Pedro", "Genom", 30);
		Coach c2 = new Coach("Lautaro", "Perez", 27);
		Coach c3 = new Coach("Valentin", "Treno", 34);
		Coach c4 = new Coach("Ulises", "Dante", 40);
		c1.addParticipante(p1);
		c2.addParticipante(b3);
		c3.addParticipante(b2);
		c4.addParticipante(p9);
		c4.addParticipante(p10);
		ArrayList<Coach> coaches = new ArrayList<>();
		coaches.add(c1);
		coaches.add(c2);
		coaches.add(c3);
		coaches.add(c4);

		System.out.println("Informacion de equipos de Coach\n");
		System.out.println("Nombres de participantes de  equipo de coach: " + c2.getNombre());
		System.out.println("Instrumentos: \n" + c2.getInstrumentosEquipo());
		System.out.println("Promedio edad: \n" + c2.getPromedioEdadEquipo());
		System.out.println("Generos de preferencia: \n" + c2.getGenerosPreferenciaEquipo());

		System.out.println("\n\nNombres de participantes de  equipo de coach: " + c3.getNombre());
		System.out.println("Instrumentos: \n" + c3.getInstrumentosEquipo());
		System.out.println("Promedio edad: \n" + c3.getPromedioEdadEquipo());
		System.out.println("Generos de preferencia: \n" + c3.getGenerosPreferenciaEquipo());
		System.out.println("///////////////////////////////////");
		System.out.println("Criterios de participantes para batallas\n\n");
		System.out.println(
				"Participantes que cantan en Ingles: \n" + c3.buscarParticipantes(new CriterioIdioma("Ingles")));
		System.out.println("Participantes que su genero preferido es Rock: \n"
				+ c3.buscarParticipantes(new CriterioGeneroPreferencia("Rock")));
		System.out.println("Participantes que cantan en Aleman y tocan Guitarra: \n" + c3.buscarParticipantes(
				new CriterioParticipanteAnd(new CriterioIdioma("Aleman"), new CriterioInstrumento("Guitarra"))));
		System.out.println(
				"Participantes que son mayores a 19 años: \n" + c3.buscarParticipantes(new CriterioEdadMayor(19)));
		System.out.println("Participantes que pueden interpretar tema1: \n"
				+ c3.buscarParticipantes(new CriterioInterpretaTema(tema1)));

		System.out.println("///////////////////////////////////");

		System.out.println("Criterios con combinaciones logicas\n");
		CriterioParticipante cGuitarra = new CriterioInstrumento("Guitarra");
		CriterioParticipante cBateria = new CriterioInstrumento("Bateria");
		CriterioParticipante cBalada = new CriterioGeneroPreferencia("Balada");
		CriterioParticipante cPop = new CriterioGeneroPreferencia("Pop");
		CriterioParticipante cRock = new CriterioGeneroPreferencia("Rock");
		CriterioParticipante cIngles = new CriterioIdioma("Ingles");

		System.out.println(
				"Participantes que toquen “guitarra” y prefieran el género “balada” O que canten en “inglés”: \n"
						+ c1.buscarParticipantes(
								new CriterioParticipanteOr(new CriterioParticipanteAnd(cGuitarra, cBalada), cIngles)));
		System.out.println(
				"Participantes que toquen “guitarra” y prefieran el género “balada” Y que canten en “inglés”: \n"
						+ c1.buscarParticipantes(
								new CriterioParticipanteAnd(new CriterioParticipanteAnd(cGuitarra, cBalada), cIngles)));
		System.out.println("Participantes que NO prefieran el género “balada” y NO toquen guitarra: \n"
				+ c1.buscarParticipantes(new CriterioParticipanteNot(new CriterioParticipanteAnd(cGuitarra, cBalada))));

		ArrayList<String> idiomasEspecificos = new ArrayList<>();
		idiomasEspecificos.add("Español");
		idiomasEspecificos.add("Ingles");
		CriterioParticipante cEspañolEIngles = new CriterioIdiomas(idiomasEspecificos);

		CriterioParticipante comports = new CriterioParticipanteAnd(cBateria,
				new CriterioParticipanteAnd(cEspañolEIngles, cPop));
		c2.setComport(comports);

		System.out.println("///////////////////////////////////");

		System.out.println("Coach exigente\n\n");
		System.out.println("Coach exigente: " + c2.getNombre() + " agrega a participante: " + p1.getNombre() + " ? "
				+ "\n" + c2.addParticipante(p1));
		System.out.println("Coach exigente: " + c2.getNombre() + " cambio genero requerido de Pop a Rock \n");
		CriterioParticipante comports2 = new CriterioParticipanteAnd(cGuitarra,
				new CriterioParticipanteAnd(cEspañolEIngles, cRock));
		c2.setComport(comports2);
		System.out.println("Coach exigente: " + c2.getNombre() + " agrega a participante: " + p1.getNombre() + " ? "
				+ "\n" + c2.addParticipante(p1));

		System.out.println("\n\n///////////////////////////////////");
		System.out.println("Lista para batalla");
		System.out.println(c4.getListaParticipantes(new compIdiomas()));
		System.out.println("\n\n/////////");
		System.out.println("Batallas \n");
		Reality r1 = new Reality("r1", coaches, temasMusicalesPosibles, new compInstrumentos());
		String winner = r1.batallaCoaches(c2, c4);
		System.out.println(c2.getNombre() + " vs " + c4.getNombre());
		System.out.println("Ganador es: " + winner);
		System.out.println("\nPor puntos");
		String winner2 = r1.batallaCoachesPorPuntos(c2, c4);
		System.out.println(c2.getNombre() + " vs " + c4.getNombre());
		System.out.println("Ganador es: " + winner2);
		System.out.println("\n" + p1.getNombre() + " vs " + p2.getNombre());
		int res = r1.batalla(p1, p2);
		String ganador = null;
		if (res > 0)
			ganador = "Ganador = " + p1.getNombre();
		else if (res < 0)
			ganador = "Ganador = " + p2.getNombre();
		else
			ganador = "Empate";
		System.out.println("Resultado = " + ganador);

	}

}
