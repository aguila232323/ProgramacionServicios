public class coche implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private static final int DISTANCIA_META = 100; // Distancia hasta la meta
    private static boolean hayGanador = false; // Para anunciar el ganador solo una vez

    public coche(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < DISTANCIA_META && !hayGanador) {
            avanzar();
            mostrarPosicion();
            try {
                Thread.sleep(500); // Simulación de tiempo de movimiento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void avanzar() {
        int avance = (int) (Math.random() * 10) + 1; // Avanza entre 1 y 10 unidades
        int obstaculo = (int) (Math.random() * 100); // Posibilidad de obstáculo

        // Si hay un obstáculo, el coche se ralentiza
        if (obstaculo < 20) { // 20% de probabilidad de un obstáculo
            System.out.println(nombre + " ha encontrado un obstáculo y se ha ralentizado.");
            avance = avance / 2; // El coche avanza más lento
        }

        distanciaRecorrida += avance;


        if (distanciaRecorrida >= DISTANCIA_META && !hayGanador) {
            hayGanador = true;
            System.out.println("¡¡¡" + nombre + " ha ganado la carrera!!!");
        }
    }


    private void mostrarPosicion() {
        StringBuilder visualizacion = new StringBuilder();
        for (int i = 0; i < DISTANCIA_META; i += 10) {
            if (i < distanciaRecorrida) {
                visualizacion.append("=");
            } else if (i == distanciaRecorrida) {
                visualizacion.append(">");
            } else {
                visualizacion.append(" ");
            }
        }
        System.out.println(nombre + ": " + visualizacion.toString() + " (" + distanciaRecorrida + "/" + DISTANCIA_META + ")");
    }
}
