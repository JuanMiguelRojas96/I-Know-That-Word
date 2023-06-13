package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * La clase PanelImageFondo extiende de JPanel y se utiliza para mostrar una imagen de fondo en un panel.
 */
public class PanelImageFondo extends JPanel {
    private Image image;
    /**
     * Constructor de la clase PanelImageFondo.
     *
     * @param image La imagen que se utilizará como fondo del panel.
     */
    public PanelImageFondo (Image image){

        this.image = image;
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    /**
     * Sobrescribe el método paintComponent para dibujar la imagen de fondo en el panel.
     *
     * @param g El objeto Graphics utilizado para dibujar.
     */

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
    }
}
