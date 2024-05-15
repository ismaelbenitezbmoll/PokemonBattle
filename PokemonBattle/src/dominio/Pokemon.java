// Pokemon.java
package dominio;

public abstract class Pokemon {

    protected String nombre;
    protected String tipo;
    protected int nivel;
    protected int vida;

    public Pokemon(String nombre, String tipo, int nivel, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.vida = vida;
    }

    public abstract void ataqueTipo(Pokemon enemigo);

    public void ataqueBasico(Pokemon enemigo) {
        System.out.println(nombre + " ha usado ataque básico!");
        int damage = 10; // Daño del ataque básico
        enemigo.vida -= damage;
        System.out.println("El Pokémon " + enemigo.getNombre() + " ha recibido " + damage + " de daño.");
        System.out.println(enemigo.getNombre() + " tiene " + enemigo.getVida() + " PS.");
        if (enemigo.vida <= 0) {
            System.out.println("El Pokémon " + enemigo.getNombre() + " ha sido derrotado!");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVida() {
        return vida;
    }
}
