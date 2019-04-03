package Client.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class JPrincipal extends JFrame {
    private BufferedImage iTitle;

    private JButton buttonPiano;
    private JButton buttonAmics;
    private JButton buttonSignOut;
    private JButton buttonDeleteAccount;

    private JPanel imagePanel;

    /**
     * Constructor encarregat de mostrar la finestra principal deicada a l'accés a les funcionalitats principals
     * del Client.
     */
    public JPrincipal() {
        try {
            iTitle = ImageIO.read(new File("Project_IMG/SmartPianoTitle.png"));
            ImageIcon imageicon=new ImageIcon(iTitle);
            imageicon = new ImageIcon(imageicon.getImage().getScaledInstance(300,110, Image.SCALE_SMOOTH));
            JLabel label= new JLabel(imageicon);
            imagePanel = new JPanel();
            imagePanel.add(label);
            imagePanel.setBackground(Color.WHITE);
            add(imagePanel, BorderLayout.NORTH);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error, no 'sha pogut accedir a la imatge interna");
        }

        JPanel vButtons = new JPanel();
        vButtons.setLayout(new BoxLayout(vButtons, BoxLayout.Y_AXIS));

        JPanel vApp = new JPanel();
        //vApp.setLayout(new BoxLayout(vApp, BoxLayout.Y_AXIS));
        vApp.setLayout(new GridLayout(2,0));


        buttonPiano = new JButton("Piano");
        buttonPiano.setPreferredSize(new Dimension(250, 40));
        vApp.add(buttonPiano);

        buttonAmics = new JButton("Social");
        buttonAmics.setPreferredSize(new Dimension(250, 40));
        vApp.add(buttonAmics);

        vApp.setBorder(BorderFactory.createEmptyBorder(0,70,0,70));
        vButtons.add(vApp);

        JPanel vOut = new JPanel();
        vOut.setLayout(new FlowLayout());

        buttonSignOut = new JButton("Sign Out");
        buttonSignOut.setPreferredSize(new Dimension(125, 40));
        vOut.add(buttonSignOut);
        buttonDeleteAccount = new JButton("Delete Account");
        buttonDeleteAccount.setPreferredSize(new Dimension(125, 40));
        vOut.add(buttonDeleteAccount);
        vOut.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        vButtons.add(vOut);
        add(vButtons, BorderLayout.CENTER);

        vApp.setBackground(Color.WHITE);
        vOut.setBackground(Color.WHITE);
        vButtons.setBackground(Color.WHITE);

        //Definim propietats de la finestra
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setMaximumSize(new Dimension(400, 300));
        setTitle("Smart Piano");
        setVisible(true);
    }
}