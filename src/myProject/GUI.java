package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.EventListener;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JPanel panelPrincipal, panelUserName;
    private JTextField textField;
    private Escucha escucha;
    private FileManager fileManager;
    private ImageIcon background;
    private JLabel label;
    private Image image;



    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I Know That Word");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object
        escucha = new Escucha();
        fileManager = new FileManager();
        //Set up JComponents
        headerProject = new Header("I Know That Word", new Color(54,133,140));
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(headerProject,constraints); //Change this line if you change JFrame Container's Layout


        panelPrincipal = new PanelImageFondo(setImageBackground("/resources/FondoPanel.jpg"));
        panelPrincipal.setName("panelPrincipal");
        panelPrincipal.setPreferredSize(new Dimension(1080,675));
        panelPrincipal.setLayout(new GridBagLayout());
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.CENTER;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelPrincipal,constraints);

        panelUserName = new JPanel();
        panelUserName.setName("panelUserName");
        panelUserName.setLayout(new GridBagLayout());
        panelUserName.setPreferredSize(new Dimension(300,200));
        panelUserName.setBorder(BorderFactory.createLineBorder(new Color(255,166,74),5));
        panelUserName.setBackground(new Color(243,121,46));
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        panelPrincipal.add(panelUserName,constraints);


        label = new JLabel("Escribe Tu Nombre");
        label.setFont(new Font("Comic Sans MS", Font.BOLD,20));
        label.setForeground(new Color(255,255,255));
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.fill= GridBagConstraints.CENTER;
        panelUserName.add(label,constraints);


        textField = new JTextField(20);
        textField.addActionListener(escucha);
        textField.setPreferredSize(new Dimension(150,50));
        textField.setBackground(new Color(255,166,74));
        textField.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        textField.setForeground(Color.WHITE);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(BorderFactory.createEmptyBorder());
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.fill= GridBagConstraints.CENTER;
        constraints.weightx=1;
        panelUserName.add(textField,constraints);



    }


    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }
    public Image setImageBackground(String url){
        background = new ImageIcon(getClass().getResource(url));
        image = background.getImage();
        return image;
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fileManager.writer(textField.getText());
            textField.setText("");

        }
    }
}
