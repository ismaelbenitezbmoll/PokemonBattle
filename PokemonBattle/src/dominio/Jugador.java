package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jugador {

    private final List<Pokemon> pokemons;
    private final String nombre;
    private int nivel;

    public Jugador() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del jugador: ");
        this.nombre = sc.nextLine();
        System.out.println("¡Bienvenido/a, " + nombre + "!");
        this.nivel = 0;
        pokemons = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void añadirPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemon() {
        return pokemons;
    }

    public boolean tienePokemon() {
        return !pokemons.isEmpty();
    }

    public void iniciarBatalla(Pokemon pokemonEnemigo) {
        Scanner sc = new Scanner(System.in);
        Pokemon pokemon = pokemons.get(0); // Solo tomamos el primer Pokémon del jugador
        System.out.println("Elige una acción:");
        System.out.println("1. Ataque básico");
        System.out.println("2. Ataque de tipo");
        char opcion = sc.next().charAt(0);
        switch (opcion) {
            case '1':
                pokemon.ataqueBasico(pokemonEnemigo);
                break;
            case '2':
                pokemon.ataqueTipo(pokemonEnemigo);
                break;
            default:
                System.out.println("Selección inválida");
                break;
        }
    }
}
