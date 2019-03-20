package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.text.AttributedCharacterIterator;

public class SongView extends JPanel {
    //Atributes of the SongView class
    private JPanel panelPlayInfo;
    private JPanel groupTitleDescription;
    private JLabel titleSong;
    private JLabel description;
    private JLabel musicIcon;
    private JButton playButton;
    private JLabel infoIcon;
    public SongView () {
        setLayout(new BorderLayout());

        //To obtain the resource directly without the full path
        ImageIcon musicImage = new ImageIcon(getClass().getResource("Images/music_1.png"));
        //We scale the image because it's too big
        ImageIcon musicImage_scaled = new ImageIcon(musicImage.getImage().getScaledInstance(musicImage.getIconWidth() / 8, musicImage.getIconHeight() / 8, Image.SCALE_SMOOTH));
        //Initializing the JLabel of music
        musicIcon = new JLabel();
        musicIcon.setIcon(musicImage_scaled);



        //Localizing the image in the project
        ImageIcon infoImage = new ImageIcon(getClass().getResource("Images/info_1.png"));
        //We scale the image because it's too big
        ImageIcon infoImage_scaled = new ImageIcon(infoImage.getImage().getScaledInstance(infoImage.getIconWidth() / 24, infoImage.getIconHeight() / 24, Image.SCALE_SMOOTH));
        //Initializing the JLabel of info
        infoIcon = new JLabel();
        infoIcon.setIcon(infoImage_scaled);


        //We make a button to Play the song
        playButton = new JButton ();
        playButton.setText("Play");

        //We create a panel to add the play button and the info button
        panelPlayInfo = new JPanel();
        panelPlayInfo.setLayout(new BoxLayout(panelPlayInfo,BoxLayout.X_AXIS));
        panelPlayInfo.add(playButton);
        panelPlayInfo.add(infoIcon);

        titleSong = new JLabel("hola");
        description = new JLabel ("patata");

        //We create a panel to add the title and her description
        groupTitleDescription = new JPanel();
        groupTitleDescription.setLayout(new BoxLayout(groupTitleDescription,BoxLayout.Y_AXIS));
        groupTitleDescription.add(titleSong);
        groupTitleDescription.add(description);
        //We make an empty border to down the group of elements
        groupTitleDescription.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));


        //Adding the elements to the JPanel
        add(musicIcon,BorderLayout.LINE_START);
        add(groupTitleDescription,BorderLayout.CENTER);
        add(panelPlayInfo,BorderLayout.LINE_END);

        //We make a border to separate the songs
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
}
