package OrderSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NonThankYouForm extends JPanel{
	
	private ClientControlForm F;
	
	private JPanel NonThankYouPanel;
	private JLabel NonThankYouString;
	
	private JButton NonThankYouButton;
	
	public NonThankYouForm(ClientControlForm f){
		
		F = f;
		
		setSize(800, 600);
		
		NonThankYouPanel = new JPanel();
		
		NonThankYouPanel.setLayout(new BoxLayout(NonThankYouPanel, BoxLayout.Y_AXIS));
		
		NonThankYouString = new JLabel();
		NonThankYouString.setText("주문완료 \n 감사합니다.");
		
		NonThankYouPanel.add(NonThankYouString);
	
		NonThankYouButton = new JButton("확인");
		
		NonThankYouButton.addActionListener(new ActionListener(){		//확인 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("NonClientMenuForm");
            }
        });
		
		NonThankYouPanel.add(NonThankYouButton);
		
		
		add(NonThankYouPanel);
		setVisible(true);
	}
}
