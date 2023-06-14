package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * La clase GUI es una clase que extiende de JFrame y representa la interfaz gráfica de usuario del proyecto.
 */
public class GUI extends JFrame {
    public static final String MENSAJE_AYUDA = "INSTRUCCIONES DEL JUEGO:\n" +
            "\n" +
            "MEMORIZA LAS PALABRAS: Se te mostrará una secuencia de palabras una por una durante 5 segundos cada una." +
            "\n"+
            " Tu objetivo es recordarlas en orden.\n" +
            "\n" +
            "ELIGE LAS PALABRAS CORRECTAS: Después de la serie de palabras, se te presentará una lista con el doble de palabras." +
            "\n"+
            "Debes indicar cuáles de ellas estaban en la lista original que memorizaste. Tienes 7 segundos para responder.\n" +
            "\n" +
            "SUPERA LOS NIVELES: Comienzas en el nivel 1 y solo podrás avanzar al siguiente nivel si lo superas con éxito. " +
            "\n" +
            "El programa recordará tu progreso para que puedas continuar desde donde lo dejaste.\n" +
            "\n" +
            "MANTÉN TU MEMORIA ACTIVA: Este juego te ayuda a entrenar tu memoria episódica verbal reciente, " +
            "\n" +
            "lo cual es útil en situaciones donde debes recordar información que has escuchado anteriormente.\n" +
            "\n" +
            "¡Diviértete y desafía tu capacidad de memoria en cada nivel!";
    private Header headerProject,nivelEnd;
    private JPanel panelPrincipal, panelUserName, panelLogin;
    private JTextField textField;
    private Escucha escucha;
    private FileManager fileManager;
    private ModelIKnowThatWord modelIKnowThatWord;
    private ImageIcon background;
    private JLabel label, palabras,segundos;
    private Image image;
    private int option,level,indiceNivel,indiceUsuario;
    private JButton registrarse,iniciarSesion,volver,iniciarNivel,optionSi,optionNo,ayuda,salir;



    /**
     * Constructor de la clase GUI.
     * Inicializa la interfaz gráfica de usuario y configura la ventana JFrame.
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

    /**
     * Establece un componente en el contenedor utilizando el diseño GridBagLayout con las restricciones especificadas.
     */
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
     * Inicializa la interfaz gráfica de usuario (GUI).
     * Configura los componentes y establece su diseño utilizando el diseño GridBagLayout.
     */
    private void initGUI() {
        //Configuración del diseño del contenedor JFrame
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Creación de objetos de escucha y control
        escucha = new Escucha();
        fileManager = new FileManager();
        modelIKnowThatWord = new ModelIKnowThatWord();
        //Configuración de los componentes
        //headerProject
        headerProject = new Header("I Know That Word", new Color(54,133,140));
        setGridBagLayout(headerProject,this.getContentPane(),0,0,3,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER);

        //panelPrincipal
        panelPrincipal = new PanelImageFondo(setImageBackground("/resources/FondoPanel.jpg"));
        panelPrincipal.setName("panelPrincipal");
        panelPrincipal.setPreferredSize(new Dimension(1080,600));
        panelPrincipal.setLayout(new GridBagLayout());
        setGridBagLayout(panelPrincipal,this.getContentPane(),0,1,3,1,GridBagConstraints.CENTER,GridBagConstraints.CENTER);

        //optionSi
        optionSi = new JButton("SI");
        optionSi.addActionListener(escucha);
        optionSi.setBackground(new Color(255,166,74));
        optionSi.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        optionSi.setForeground(Color.WHITE);
        optionSi.setVisible(false);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelPrincipal.add(optionSi,constraints);

        //palabras
        palabras = new JLabel();
        palabras.setFont(new Font("Comic Sans MS", Font.BOLD,60));
        palabras.setForeground(new Color(255,255,255));
        palabras.setBackground(new Color(54,133,140));
        palabras.setOpaque(true);
        palabras.setVisible(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panelPrincipal.add(palabras,constraints);

        //optionNo
        optionNo = new JButton("NO");
        optionNo.addActionListener(escucha);
        optionNo.setBackground(new Color(255,166,74));
        optionNo.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        optionNo.setForeground(Color.WHITE);
        optionNo.setVisible(false);
        constraints.gridx = 2;
        constraints.gridy = 0;
        panelPrincipal.add(optionNo,constraints);

        //segundos
        segundos = new JLabel("Tiempo");
        segundos.setFont(new Font("Comic Sans MS", Font.BOLD+Font.ITALIC,40));
        segundos.setForeground(new Color(255,255,255));
        segundos.setVisible(false);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.fill= GridBagConstraints.CENTER;
        panelPrincipal.add(segundos,constraints);

        //panelLogin
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

        //registrarse
        registrarse = new JButton("Registrarse");
        registrarse.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        registrarse.setForeground(Color.WHITE);
        registrarse.setBackground(new Color(255,166,74));
        registrarse.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.fill= GridBagConstraints.CENTER;
        panelLogin.add(registrarse,constraints);

        //iniciarSesion
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

        //ayuda
        ayuda = new JButton("¿Como Jugar?");
        ayuda.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        ayuda.setForeground(Color.WHITE);
        ayuda.setBackground(new Color(255,166,74));
        ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.fill= GridBagConstraints.CENTER;
        constraints.weightx=1;
        panelLogin.add(ayuda,constraints);

        //salir
        salir = new JButton("Salir");
        salir.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        salir.setForeground(Color.WHITE);
        salir.setBackground(new Color(255,166,74));
        salir.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.fill= GridBagConstraints.CENTER;
        constraints.weightx=1;
        panelLogin.add(salir,constraints);

        //panelUserName
        panelUserName = new JPanel();
        panelUserName.setName("panelUserName");
        panelUserName.setLayout(new GridBagLayout());
        panelUserName.setPreferredSize(new Dimension(300,200));
        panelUserName.setBorder(BorderFactory.createLineBorder(new Color(255,166,74),5));
        panelUserName.setBackground(new Color(243,121,46));
        panelUserName.setVisible(false);
        setGridBagLayout(panelUserName,panelPrincipal,0,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.CENTER);

        //label
        label = new JLabel("Escribe Tu Usuario");
        label.setFont(new Font("Comic Sans MS", Font.BOLD,20));
        label.setForeground(new Color(255,255,255));
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.fill= GridBagConstraints.CENTER;
        panelUserName.add(label,constraints);

        //textField
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

        //volver
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

        //iniciarNivel
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

        //nivelEnd
        nivelEnd = new Header("Nivel: 1",new Color(54,133,140));
        setGridBagLayout(nivelEnd,this.getContentPane(),0,2,3,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER);
    }


    /**
     * Punto de entrada de la aplicación.
     * Crea una instancia de la GUI y la inicia en el hilo de despacho de eventos.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }
    /**
     * Establece una imagen de fondo a partir de la URL especificada.
     *
     * @param url La URL de la imagen de fondo.
     * @return La imagen de fondo establecida.
     */
    public Image setImageBackground(String url){
        background = new ImageIcon(getClass().getResource(url));
        image = background.getImage();
        return image;
    }
    /**
     * Realiza la verificación del registro de un usuario.
     * Verifica si el nombre de usuario ya existe en el archivo de usuarios.
     * Si el usuario ya existe, muestra un mensaje de error.
     * Si el nombre de usuario es inválido (contiene espacios o está vacío), muestra un mensaje de error.
     * Si el nombre de usuario es válido y no existe previamente, realiza el registro.
     * Actualiza el nivel del usuario, muestra el nivel actualizado en la interfaz y permite iniciar el nivel.
     */
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
            label.setText("Comenzar Nivel: "+level);
            iniciarNivel.setVisible(true);
            textField.setVisible(false);
            volver.setVisible(false);
            panelUserName.repaint();
            nivelEnd.repaint();
            nivelEnd.revalidate();
        }
    }
    /**
     * Realiza la verificación del inicio de sesión de un usuario.
     * Verifica si el nombre de usuario existe en el archivo de usuarios.
     * Si el usuario existe, obtiene el nivel correspondiente del usuario y realiza las acciones necesarias.
     * Si el usuario no existe, muestra un mensaje de error.
     */
    public void verificacionInicioSesion(){
        if (fileManager.reader().indexOf(textField.getText().toUpperCase()+" ") != -1){
            String nivel = String.valueOf(fileManager.reader().charAt(fileManager.reader().indexOf(textField.getText().toUpperCase()+" ") + textField.getText().length() + 6 ));
            nivel += String.valueOf(fileManager.reader().charAt(fileManager.reader().indexOf(textField.getText().toUpperCase()+" ") + textField.getText().length() + 7 ));
            nivelEnd.setText("Nivel: "+nivel);
            nivel = nivel.trim();
            level = Integer.parseInt(nivel);
            indiceNivel = fileManager.reader().indexOf(textField.getText().toUpperCase()+" ") + textField.getText().length() + 6;
            indiceUsuario = fileManager.reader().indexOf(textField.getText().toUpperCase()+" ");
            label.setText("Comenzar Nivel: "+nivel);
            palabras.setText("¡PREPARATE!");
            textField.setVisible(false);
            volver.setVisible(false);
            iniciarNivel.setVisible(true);
            panelUserName.repaint();
            nivelEnd.repaint();
            nivelEnd.revalidate();
        }else{
            JOptionPane.showMessageDialog(null,"Por Favor Registrese","Usuario No Existe",JOptionPane.INFORMATION_MESSAGE);
            textField.setText("");
        }
    }

    /**
     * Clase interna que implementa la interfaz ActionListener para manejar eventos.
     */
    private class Escucha implements ActionListener{
        /**
         * Método que se ejecuta cuando ocurre un evento.
         * Realiza acciones específicas dependiendo del origen del evento.
         *
         * @param e El objeto ActionEvent que representa el evento.
         */
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
            } else if(e.getSource() == ayuda){
                JOptionPane.showMessageDialog(null,MENSAJE_AYUDA,"¿Como se Juega?",JOptionPane.INFORMATION_MESSAGE);
            }else if (e.getSource() == volver) {
                panelUserName.setVisible(false);
                panelLogin.setVisible(true);
                textField.setText("");
            } else if (e.getSource() == salir) {
                System.exit(0);
            }
            if (e.getSource() == iniciarNivel){
                label.setText("Escribe Tu Usuario");
                palabras.setText("¡PREPARATE!");
                textField.setVisible(true);
                volver.setVisible(true);
                iniciarNivel.setVisible(false);
                panelUserName.setVisible(false);
                modelIKnowThatWord.showWords(level,nivelEnd,indiceUsuario,indiceNivel,palabras,segundos,optionSi,optionNo,panelLogin);
            }
            if (e.getSource() == textField && option == 1){
                verificacionRegistro();
            } else if (e.getSource()==textField && option == 2) {
                verificacionInicioSesion();
            }
        }
    }
}
