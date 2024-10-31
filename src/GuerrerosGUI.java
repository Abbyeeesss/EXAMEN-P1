import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuerrerosGUI {
    private JPanel Pgeneral;
    private JTextArea Resultado;
    private JTextField NombreTxt;
    private JTextField RazaTxt;
    private JTextField PoderTxt;
    private JTextField HabilidadTxt;
    private JButton añadirButton;
    private ColaGuerreros colaGuerreros = new ColaGuerreros();
    public GuerrerosGUI() {
        colaGuerreros.encolarPredefinidos(Resultado);

        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = NombreTxt.getText();
                    String raza = RazaTxt.getText();
                    int nivelPoder = Integer.parseInt(PoderTxt.getText());
                    String habilidad = HabilidadTxt.getText();

                    colaGuerreros.anadirGuerrero(nombre, raza, nivelPoder, habilidad, Resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese datos válidos para el poder.");
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GuerreroGUI");
        frame.setContentPane(new GuerrerosGUI().Pgeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}