package OrderSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThankYouForm extends JPanel{
	
	private ClientControlForm F;
	
	private JPanel ThankYouPanel;
	private JLabel ThankYouString;
	
	private JButton ThankYouButton;
	
	public ThankYouForm(ClientControlForm f){
		
		F = f;
		
		setSize(800, 600);
		
		ThankYouPanel = new JPanel();

		ThankYouPanel.setLayout(new BoxLayout(ThankYouPanel, BoxLayout.Y_AXIS));
		
		ThankYouString = new JLabel();
		ThankYouString.setText("주문완료 \n 감사합니다.");
		
		ThankYouPanel.add(ThankYouString);
		
		ThankYouButton = new JButton("확인");
		ThankYouPanel.add(ThankYouButton);
		
		ThankYouButton.addActionListener(new ActionListener(){		//확인 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("ClientMenuForm");
            }
        });
		
		add(ThankYouPanel);
		setVisible(true);
	}
}
