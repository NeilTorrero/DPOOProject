package Client.View;

import Client.View.Images.SongPrueba;

import javax.swing.*;
import java.util.ArrayList;

public class FinestraJSong extends JFrame{
    public FinestraJSong () {
        add(new JSong());
        setSize(400,1000);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}