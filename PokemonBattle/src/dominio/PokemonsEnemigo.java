
// PokemonsEnemigo.java
package dominio;

import java.util.ArrayList;
import java.util.List;

public class PokemonsEnemigo {
    
    private final List<Pokemon> pokemonsEnemigo;

    public PokemonsEnemigo() {
        pokemonsEnemigo = new ArrayList<>();
    }

    public void añadirPokemon(Pokemon pokemon) {
        pokemonsEnemigo.add(pokemon);
    }

    public int size() {
        return pokemonsEnemigo.size();
    }

    public Pokemon getPokemonEnemigo(int indice) {
        if (indice >= 0 && indice < pokemonsEnemigo.size()) {
            return pokemonsEnemigo.get(indice);
        } else {
            System.out.println("Índice de Pokémon no válido");
            return null;
        }
    }

    public List<Pokemon> getPokemon() {
        return pokemonsEnemigo;
    }
}
