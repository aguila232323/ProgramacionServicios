public class Carrera {
    public static void main(String[] args) {
        // Crear coches
        coche coche1 = new coche("Coche 1");
        coche coche2 = new coche("Coche 2");
        coche coche3 = new coche("Coche 3");

        // Crear hilos
        Thread hiloCoche1 = new Thread(coche1);
        Thread hiloCoche2 = new Thread(coche2);
        Thread hiloCoche3 = new Thread(coche3);

        // Iniciar la carrera
        System.out.println("¡Comienza la carrera!");
        hiloCoche1.start();
        hiloCoche2.start();
        hiloCoche3.start();

        // Esperar a que todos los coches terminen
        try {
            hiloCoche1.join();
            hiloCoche2.join();
            hiloCoche3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("La carrera ha terminado.");
    }
}
