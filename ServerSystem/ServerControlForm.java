package ServerSystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ServerControlForm extends JFrame {
    private CardLayout cards = new CardLayout();
    
    public ServerControlForm() {
        setSize(800, 600);
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
         
        getContentPane().add("ManageStartForm", new ManageStartForm(this));
        getContentPane().add("MenuManageForm", new MenuManageForm(this));
        getContentPane().add("CurrentMenuForm", new CurrentMenuForm(this));
        getContentPane().add("DetailMenuForm", new DetailMenuForm(this));
        
        setVisible(true);
    }
     
    public void changePanel(String s) {
        cards.show(this.getContentPane(), s);
    }
}
