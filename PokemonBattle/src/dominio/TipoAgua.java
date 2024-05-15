// TipoAgua.java
package dominio;

public class TipoAgua extends Pokemon {

    public TipoAgua(String nombre, String tipo, int nivel, int vida) {
        super(nombre, tipo, nivel, vida);
    }

    @Override
    public void ataqueTipo(Pokemon enemigo) {
        System.out.println(nombre + " ha usado ataque de tipo");
        if ("Fuego".equals(enemigo.getTipo())) {
            System.out.println("CRÍTICO");
            enemigo.vida -= 35;
        } else {
            enemigo.vida -= 20;
        }
        System.out.println("El Pokémon " + enemigo.getNombre() + " ha recibido " + (enemigo.getTipo().equals("Fuego") ? 35 : 20) + " de daño.");
        System.out.println(enemigo.getNombre() + " tiene " + enemigo.getVida() + " PS.");
        if (enemigo.vida <= 0) {
            System.out.println("El Pokémon " + enemigo.getNombre() + " ha sido derrotado!");
        }
    }
}
