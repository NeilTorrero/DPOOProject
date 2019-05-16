package Server.View;

import Model.Song;

import java.util.List;

public class View {
    private Graphic graficView;
    private JEvolution evolutionView;
    private JGestor gestorView;
    private JRegister registerView;
    private JTop topView;
    private SongFile songfile;
    private SongView songView;

    public Graphic getGraficView() {
        return graficView;
    }

    public JEvolution getEvolutionView() {
        return evolutionView;
    }

    public JGestor getGestorView() {
        return gestorView;
    }

    public JRegister getRegisterView() {
        return registerView;
    }

    public JTop getTopView() {
        return topView;
    }

    public SongFile getSongfile() {
        return songfile;
    }

    public SongView getSongView() {
        return songView;
    }

    public void initRegisterView() {
            registerView = new JRegister();
    }

    public void initGestorView(List<Song> songs) {
        gestorView = new JGestor(songs);
    }

}
