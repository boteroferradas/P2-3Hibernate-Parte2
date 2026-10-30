import models.Adestrador;
import models.Pokedex;
import net.bytebuddy.asm.Advice;
import services.AdestradorService;
import services.PokedexService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pokedex> pokemonsAactualizar = new ArrayList<>();
        List<Adestrador> adestradoresAactualizar = new ArrayList<>();


        System.out.println("Insertar 10 pokemons na táboa Pokedex en 2 adestradores na táboa Adestrador");
        System.out.println("--------------------------------------");

        PokedexService pokedexService = new PokedexService();
        AdestradorService adestradorService = new AdestradorService();

        pokedexService.crearPokedex("Charmander", "Fuego", 5);
        pokedexService.crearPokedex("Ghastly", "Fantasma, Veneno", 0.5);
        pokedexService.crearPokedex("Ludicolo", "Agua, Planta", 50);
        pokedexService.crearPokedex("Seedott", "Planta", 10);
        pokedexService.crearPokedex("Kartana", "Planta, Acero", 15);
        pokedexService.crearPokedex("Raging Bolt", "Dragon, Electrico", 20);
        pokedexService.crearPokedex("Zekrom", "Dragon, Electrico", 30);
        pokedexService.crearPokedex("Squirtle", "Agua", 6);
        pokedexService.crearPokedex("Pikachu", "Electrico", 12);
        pokedexService.crearPokedex("Darkrai", "Siniestro", 17);

        adestradorService.crearAdestrador("Rojo" , new Date(1993-3-12));
        adestradorService.crearAdestrador("Misty" , new Date(1998-7-25));

        System.out.println("Listado de todas as entradas de pokedex: ");
        List<Pokedex> listaPokedex = pokedexService.listarPokedex();
        for (Pokedex p : listaPokedex){
            System.out.println(p);
        }

        System.out.println("Listado de todas as entradas de adestrador: ");
        List<Adestrador> listaAdestrador = adestradorService.listarAdestradores();
        for (Adestrador a : listaAdestrador){
            System.out.println(a);
        }

        pokemonsAactualizar.add(pokedexService.lerPokedex("Charmander"));
        pokemonsAactualizar.add(pokedexService.lerPokedex("Ghastly"));
        adestradoresAactualizar.add(adestradorService.lerAdestrador("Ash"));
        adestradoresAactualizar.add(adestradorService.lerAdestrador("Serena"));

//        Pokedex pActualizar1 = listaPokedex.get(1);
//        Pokedex pActualizar2 = listaPokedex.get(2);
//        pActualizar2.setNome("Charizard");
//        pActualizar1.setNome("Lucario");
//        pokedexService.actualizarPokedex(pActualizar1);
//        pokedexService.actualizarPokedex(pActualizar2);

        for (Pokedex p : listaPokedex){
            System.out.println(p);
        }

        pokedexService.eliminarAllPokedex();
    }

    }
