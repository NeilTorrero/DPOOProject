package Client.View;
import Client.Controller.ControllerJSocial;

import javax.swing.*;

public class FinestraJSocial extends JFrame {
    private JSocial jSocial;
    public FinestraJSocial () {
        jSocial = new JSocial();
        setSize(400,405);
        add(jSocial);
        //We make the frame not resizable
        setResizable(false);
        setVisible(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public JSocial getjSocial() {
        return jSocial;
    }

    public void setjSocial(JSocial jSocial) {
        this.jSocial = jSocial;
    }
    public void registerController (ControllerJSocial controllerJSocial) {
        jSocial.registerController(controllerJSocial);
    }

    public void showUserSearch (String name, String imageFile,boolean isFriend) {
        jSocial.showUserSearch(name,imageFile,isFriend);
    }
    public void showUserNotFound () {
        jSocial.showUserNotFound();
    }

}
