// PokemonBattle.java
package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class PokemonBattle {

    public static void menu() {
        Jugador jugador1 = new Jugador();
        PokemonsEnemigo enemigos = new PokemonsEnemigo();

        Scanner sc = new Scanner(System.in);
        int elec;
        int val = 0;
        while (val == 0) {
            System.out.println("***********************");
            System.out.println("*        MENU         *");
            System.out.println("*                     *");
            System.out.println("*  1  Elegir          *");
            System.out.println("*  2  Pelear          *");
            System.out.println("*  3  Salir           *");
            System.out.println("***********************");

            if (sc.hasNextInt()) {
                elec = sc.nextInt();

                switch (elec) {
                    case 1:
                        eleccionPokemon(jugador1, enemigos);
                        val = 1;
                        break;
                    case 2:
                        System.out.println("Preparando para la batalla...");
                        Pokemon pokemonEnemigo = seleccionarPokemonEnemigo(enemigos);
                        batalla(jugador1, pokemonEnemigo);
                        val = 1;
                        break;
                    case 3:
                        System.out.println("Gracias por jugar");
                        val = 1;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Selección inválida");
                }
            } else {
                // Si no se ingresa un número entero, se limpia la entrada
                System.out.println("Entrada inválida");
                sc.next(); // Limpiar el buffer de entrada
            }
        }
        sc.close();
    }

    public static void eleccionPokemon(Jugador jugador1, PokemonsEnemigo enemigos) {
        char pok;
        Pokemon charmander = new TipoFuego("Charmander", "Fuego", 1, 100);
        Pokemon bulbasaur = new TipoPlanta("Bulbasaur", "Planta", 1, 100);
        Pokemon squirtle = new TipoAgua("Squirtle", "Agua", 1, 100);

        // Añade los Pokémon enemigos a la lista
        enemigos.añadirPokemon(charmander);
        enemigos.añadirPokemon(squirtle);
        enemigos.añadirPokemon(bulbasaur);
        
        //Seleccionamos eleatoriamente el pokemon enemigo
        Pokemon x = seleccionarPokemonEnemigo(enemigos);

        Scanner sc = new Scanner(System.in);
        System.out.println("Elige a tu Pokémon!");
        System.out.println("'1' Charmander Tipo Fuego");
        System.out.println("'2' Squirtle Tipo Agua");
        System.out.println("'3' Bulbasaur Tipo Planta");
        pok = sc.next().charAt(0);
        switch (pok) {
            case '1':
                System.out.println("Has elegido a Charmander!");
                jugador1.añadirPokemon(charmander);
                batalla(jugador1,x);
                break;
            case '2':
                System.out.println("Has elegido a Squirtle!");
                jugador1.añadirPokemon(squirtle);
               batalla(jugador1,x);
                break;
            case '3':
                System.out.println("Has elegido a Bulbasaur!");
                jugador1.añadirPokemon(bulbasaur);
                batalla(jugador1,x);
                break;
            default:
                System.out.println("Selección inválida");
        }
    }

    public static Pokemon seleccionarPokemonEnemigo(PokemonsEnemigo enemigos) {
        Random rand = new Random();
        int randNum = rand.nextInt(enemigos.size());
        return enemigos.getPokemonEnemigo(randNum);
    }

    public static void batalla(Jugador jugador1, Pokemon pokemonEnemigo) {
        Scanner sc = new Scanner(System.in);
        int turno = 1;

        while (true) {
            System.out.println("Turno " + turno);

            // Acciones del jugador 1
            System.out.println(jugador1.getNombre() + ", elige una acción:");
            System.out.println("'1' ATAQUE BÁSICO");
            System.out.println("'2' ATAQUE DE TIPO");
            char atak = sc.next().charAt(0);

            switch (atak) {
                case '1':
                    jugador1.getPokemon().get(0).ataqueBasico(pokemonEnemigo);
                    break;
                case '2':
                    jugador1.getPokemon().get(0).ataqueTipo(pokemonEnemigo);
                    break;
                default:
                    System.out.println("Selección inválida");
                    continue; // Reintentar el turno si la selección es inválida
            }

            if (pokemonEnemigo.getVida() <= 0) {
                System.out.println("¡Has derrotado al Pokémon enemigo!");
                break;
            }

            // Turno del Pokémon enemigo
            System.out.println("Turno del enemigo:");
            Random rand = new Random();
            int ataqueEnemigo = rand.nextInt(2) + 1;
            if (ataqueEnemigo == 1) {
                pokemonEnemigo.ataqueBasico(jugador1.getPokemon().get(0));
            } else {
                pokemonEnemigo.ataqueTipo(jugador1.getPokemon().get(0));
            }

            if (jugador1.getPokemon().get(0).getVida() <= 0) {
                System.out.println("Tu Pokémon ha sido derrotado.");
                break;
            }

            turno++;
        }
    }
}
