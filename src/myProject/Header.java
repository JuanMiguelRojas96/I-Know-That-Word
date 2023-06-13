package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * La clase Header extiende de JLabel y se utiliza para crear un encabezado con un título y un fondo de color personalizado.
 */
public class Header extends JLabel {
    /**
     * Constructor de la clase Header.
     * @param title El título del encabezado.
     * @param colorBackground El color de fondo del encabezado.
     */
    public Header(String title, Color colorBackground){
        this.setText(title);
        this.setBackground(colorBackground);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
