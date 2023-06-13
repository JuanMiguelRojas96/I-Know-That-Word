package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject,nivelEnd;
    private JPanel panelPrincipal, panelUserName, panelLogin;
    private JTextField textField;
    private Escucha escucha;
    private FileManager fileManager;
    private ModelIKnowThatWord modelIKnowThatWord;
    private ImageIcon background;
    private JLabel label, palabras,segundos;
    private Image image;
    private int option,level;
    private JButton registrarse,iniciarSesion,volver,iniciarNivel,optionSi,optionNo;



    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("I Know That Word");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    private void setGridBagLayout(Component component,Container container,int gridx, int gridy,int gridwidth, int gridheight,int fill,int anchor){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx=gridx;
        constraints.gridy=gridy;
        constraints.gridwidth=gridwidth;
        constraints.gridheight=gridheight;
        constraints.fill=fill;
        constraints.anchor=anchor;
        container.add(component,constraints);
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
        modelIKnowThatWord = new ModelIKnowThatWord();
        //Set up JComponents
        headerProject = new Header("I Know That Word", new Color(54,133,140));
        setGridBagLayout(headerProject,this.getContentPane(),0,0,3,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER);


        panelPrincipal = new PanelImageFondo(setImageBackground("/resources/FondoPanel.jpg"));
        panelPrincipal.setName("panelPrincipal");
        panelPrincipal.setPreferredSize(new Dimension(1080,600));
        panelPrincipal.setLayout(new GridBagLayout());
        setGridBagLayout(panelPrincipal,this.getContentPane(),0,1,3,1,GridBagConstraints.CENTER,GridBagConstraints.CENTER);

        optionSi = new JButton("SI");
        optionSi.addActionListener(escucha);
        optionSi.setBackground(new Color(255,166,74));
        optionSi.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        optionSi.setForeground(Color.WHITE);
        optionSi.setVisible(false);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelPrincipal.add(optionSi,constraints);


        palabras = new JLabel();
        palabras.setFont(new Font("Comic Sans MS", Font.BOLD,60));
        palabras.setForeground(new Color(255,255,255));
        palabras.setBackground(new Color(54,133,140));
        palabras.setOpaque(true);
        palabras.setVisible(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panelPrincipal.add(palabras,constraints);

        optionNo = new JButton("NO");
        optionNo.addActionListener(escucha);
        optionNo.setBackground(new Color(255,166,74));
        optionNo.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        optionNo.setForeground(Color.WHITE);
        optionNo.setVisible(false);
        constraints.gridx = 2;
        constraints.gridy = 0;
        panelPrincipal.add(optionNo,constraints);

        segundos = new JLabel("Tiempo");
        segundos.setFont(new Font("Comic Sans MS", Font.BOLD+Font.ITALIC,40));
        segundos.setForeground(new Color(255,255,255));
        segundos.setVisible(false);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.fill= GridBagConstraints.CENTER;
        panelPrincipal.add(segundos,constraints);


        panelLogin = new JPanel();
        panelLogin.setName("panelLogin");
        panelLogin.setPreferredSize(new Dimension(300,200));
        panelLogin.setLayout(new GridBagLayout());
        panelLogin.setBorder(BorderFactory.createLineBorder(new Color(255,166,74),5));
        panelLogin.setBackground(new Color(243,121,46));
        panelLogin.setVisible(true);
        setGridBagLayout(panelLogin,panelPrincipal,0,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.CENTER);
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        panelPrincipal.add(panelLogin,constraints);

        registrarse = new JButton("Registrarse");
        registrarse.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        registrarse.setForeground(Color.WHITE);
        registrarse.setBackground(new Color(255,166,74));
        registrarse.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.fill= GridBagConstraints.CENTER;
        panelLogin.add(registrarse,constraints);

        iniciarSesion = new JButton("Iniciar Sesión");
        iniciarSesion.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        iniciarSesion.setForeground(Color.WHITE);
        iniciarSesion.setBackground(new Color(255,166,74));
        iniciarSesion.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.fill= GridBagConstraints.CENTER;
        constraints.weightx=1;
        panelLogin.add(iniciarSesion,constraints);



        panelUserName = new JPanel();
        panelUserName.setName("panelUserName");
        panelUserName.setLayout(new GridBagLayout());
        panelUserName.setPreferredSize(new Dimension(300,200));
        panelUserName.setBorder(BorderFactory.createLineBorder(new Color(255,166,74),5));
        panelUserName.setBackground(new Color(243,121,46));
        panelUserName.setVisible(false);
        setGridBagLayout(panelUserName,panelPrincipal,0,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.CENTER);

        label = new JLabel("Escribe Tu Usuario");
        label.setFont(new Font("Comic Sans MS", Font.BOLD,20));
        label.setForeground(new Color(255,255,255));
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.fill= GridBagConstraints.CENTER;
        panelUserName.add(label,constraints);

        textField = new JTextField(18);
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

        volver = new JButton("Volver");
        volver.addActionListener(escucha);
        volver.setBackground(new Color(255,166,74));
        volver.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        volver.setForeground(Color.WHITE);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.fill= GridBagConstraints.CENTER;
        constraints.weightx=1;
        panelUserName.add(volver,constraints);

        iniciarNivel = new JButton("Iniciar");
        iniciarNivel.addActionListener(escucha);
        iniciarNivel.setBackground(new Color(255,166,74));
        iniciarNivel.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        iniciarNivel.setForeground(Color.WHITE);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.fill= GridBagConstraints.CENTER;
        constraints.weightx=1;
        iniciarNivel.setVisible(false);
        panelUserName.add(iniciarNivel,constraints);


        nivelEnd = new Header("Nivel: 1",new Color(54,133,140));
        setGridBagLayout(nivelEnd,this.getContentPane(),0,2,3,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER);
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
    public void verificacionRegistro(){
        if(fileManager.reader().contains(textField.getText().toUpperCase()+" ") == true){
            JOptionPane.showMessageDialog(null,"Ya Existe un Usuario con este Nombre","Usuario Existente",JOptionPane.INFORMATION_MESSAGE);
            textField.setText("");
        } else if (textField.getText().contains(" ") || textField.getText().isEmpty() || textField.getText() == null) {
            JOptionPane.showMessageDialog(null,"Ingrese un usuario válido y que no contenga espacios","Usuario Inválido",JOptionPane.INFORMATION_MESSAGE);
            textField.setText("");
        }else{
            fileManager.writer(textField.getText().toUpperCase()+" Nivel1");
            level = 1;
            nivelEnd.setText("Nivel: "+level);
            textField.setText("");
            panelUserName.remove(textField);
            label.setText("Comenzar Nivel: "+level);
            iniciarNivel.setVisible(true);
            volver.setVisible(false);
            panelUserName.repaint();
            nivelEnd.repaint();
            nivelEnd.revalidate();
        }
    }

    public void verificacionInicioSesion(){
        if (fileManager.reader().indexOf(textField.getText().toUpperCase()+" ") != -1){
            String nivel = String.valueOf(fileManager.reader().charAt(fileManager.reader().indexOf(textField.getText().toUpperCase()+" ") + textField.getText().length() + 6 ));
            nivel += String.valueOf(fileManager.reader().charAt(fileManager.reader().indexOf(textField.getText().toUpperCase()+" ") + textField.getText().length() + 7 ));
            nivelEnd.setText("Nivel: "+nivel);
            nivel = nivel.trim();
            level = Integer.parseInt(nivel);
            panelUserName.remove(textField);
            label.setText("Comenzar Nivel: "+nivel);
            iniciarNivel.setVisible(true);
            volver.setVisible(false);
            panelUserName.repaint();
            nivelEnd.repaint();
            nivelEnd.revalidate();
        }else{
            JOptionPane.showMessageDialog(null,"Por Favor Registrese","Usuario No Existe",JOptionPane.INFORMATION_MESSAGE);
            textField.setText("");
        }
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener, MouseListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == registrarse){
                panelUserName.setVisible(true);
                panelLogin.setVisible(false);
                option = 1;
            } else if (e.getSource() == iniciarSesion) {
                panelUserName.setVisible(true);
                panelLogin.setVisible(false);
                option = 2;
            } else if (e.getSource() == volver) {
                panelUserName.setVisible(false);
                panelLogin.setVisible(true);
                textField.setText("");
            }else if (e.getSource() == iniciarNivel){
                panelUserName.setVisible(false);
                modelIKnowThatWord.showWords(level,palabras,segundos,optionSi,optionNo);
            }
            if (e.getSource() == textField && option == 1){
                verificacionRegistro();
            } else if (e.getSource()==textField && option == 2) {
                verificacionInicioSesion();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
