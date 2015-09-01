package OrderSystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import CustomerInfoManagementSystem.*;

public class ClientControlForm extends JFrame {
    private CardLayout cards = new CardLayout();
    
    public ClientControlForm() {
        setSize(800, 600);
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
         
        getContentPane().add("CustomerStartForm", new CustomerStartForm(this));
        getContentPane().add("SignupForm", new SignupForm(this));
        getContentPane().add("ClientMenuForm", new ClientMenuForm(this));
        getContentPane().add("EditCustomerForm", new EditCustomerForm(this));
        getContentPane().add("OrderHistoryForm", new OrderHistoryForm(this));
        getContentPane().add("TotalOrderInfoForm", new TotalOrderInfoForm(this));
        getContentPane().add("ThankYouForm", new ThankYouForm(this));
        getContentPane().add("NonClientInfoForm", new NonClientInfoForm(this));
        getContentPane().add("NonClientMenuForm", new NonClientMenuForm(this));
        getContentPane().add("NonTotalOrderInfoForm", new NonTotalOrderInfoForm(this));
        getContentPane().add("NonThankYouForm", new NonThankYouForm(this));
        
        setVisible(true);
    }
     
    public void changePanel(String s) {
        cards.show(this.getContentPane(), s);
    }
}
