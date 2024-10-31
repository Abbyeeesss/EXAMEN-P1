import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class ColaGuerreros {
    Queue<Guerrero> colaGuerrero = new LinkedList<>();

    public ColaGuerreros() {
    }

    public void encolarPredefinidos(JTextArea textArea) {
        colaGuerrero.add(new Guerrero());
        colaGuerrero.add(new Guerrero("Goku", "Saiyajin", 500, "Kamehameha"));
        colaGuerrero.add(new Guerrero("Piccolo", "Namekusein", 80, "Cañón Especial"));
        colaGuerrero.add(new Guerrero("Krillin", "Terrícola", 40, "Disco Destructor"));
        colaGuerrero.add(new Guerrero("Vegeta", "Saiyajin", 950, "Galick Gun"));
        calcularNivelPoder();
        actualizarTextArea(textArea);
    }

    public void anadirGuerrero(String nombre, String raza, int nivelPoder, String habilidad, JTextArea textArea) {
        colaGuerrero.add(new Guerrero(nombre, raza, nivelPoder, habilidad));
        calcularNivelPoder();
        actualizarTextArea(textArea);
    }

    public void quitarGuerrero(JTextArea textArea) {
        colaGuerrero.poll();
        actualizarTextArea(textArea);
    }

    public boolean estaVacio() {
        return colaGuerrero.isEmpty();
    }

    public void mostrarGuerreros(JTextArea textArea) {
        if (estaVacio()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía");
            textArea.setText(" ");
        } else {
            StringBuilder cola = new StringBuilder();
            for (Guerrero gr : colaGuerrero) {
                cola.append("Nombre: ").append(gr.nombre).append("\n");
                cola.append("Raza: ").append(gr.raza).append("\n");
                cola.append("Habilidad: ").append(gr.habilidad).append("\n");
                cola.append("Nivel de Poder: ").append(gr.nivelPoder).append("\n\n");
            }
            textArea.setText(cola.toString());
        }
    }

    public void calcularNivelPoder() {
        for (Guerrero gr : colaGuerrero) {
            double poderCalculado = gr.nivelPoder;
            if (gr.raza.equals("Saiyajin")) {
                poderCalculado *= 1.5;
            } else if (gr.raza.equals("Namekusein")) {
                poderCalculado *= 1.2;
            }

            String mensaje = "Nombre: " + gr.nombre + "\n" +
                    "Raza: " + gr.raza + "\n" +
                    "Habilidad: " + gr.habilidad + "\n" +
                    "Nivel de Poder Original: " + gr.nivelPoder + "\n" +
                    "Nivel de Poder Calculado: " + poderCalculado;

            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    public void actualizarTextArea(JTextArea textArea) {
        mostrarGuerreros(textArea);
    }


    public void copiarGuerrerosPorHabilidad(String habilidad, JTextArea textAreaOriginal, JTextArea textAreaCopia) {
        Queue<Guerrero> nuevaCola = new LinkedList<>();

        for (Guerrero gr : colaGuerrero) {
            if (gr.habilidad.equalsIgnoreCase(habilidad)) {
                nuevaCola.add(gr);
            }
        }

        mostrarCola(colaGuerrero, textAreaOriginal);
        mostrarCola(nuevaCola, textAreaCopia);
    }

    private void mostrarCola(Queue<Guerrero> cola, JTextArea textArea) {
        StringBuilder texto = new StringBuilder();
        for (Guerrero gr : cola) {
            texto.append("Nombre: ").append(gr.nombre).append("\n");
            texto.append("Raza: ").append(gr.raza).append("\n");
            texto.append("Habilidad: ").append(gr.habilidad).append("\n");
            texto.append("Nivel de Poder: ").append(gr.nivelPoder).append("\n\n");
        }
        textArea.setText(texto.toString());
    }
}