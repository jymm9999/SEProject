package ServerSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentMenuForm extends JPanel{
	
	private ServerControlForm F;
	
	JPanel CurrentMenuPanel;
	JPanel CurrentMenuStringPanel;
	JPanel CurremtMenuCenterPanel;
	JPanel CurruntMenuButtonPanel;
	JPanel CurrentMenuMenuPanel;
	JLabel CurrentMenuString;
	
	JButton CurrentMenuButton;
	JButton CurrentMenuMenuManagement;
	JButton CurrentMenuPreviosButton;
	
	JScrollPane CurrentMenuScroll;
		
	public CurrentMenuForm(ServerControlForm f){
		
		F = f;
		
		setSize(800, 600);
		
		CurrentMenuPanel = new JPanel();
		CurrentMenuStringPanel = new JPanel();
		CurremtMenuCenterPanel = new JPanel();
		CurruntMenuButtonPanel = new JPanel();
		CurrentMenuMenuPanel = new JPanel();
		
		CurrentMenuPanel.setLayout(new BoxLayout(CurrentMenuPanel, BoxLayout.Y_AXIS));		
		CurrentMenuString = new JLabel("�޴� ��Ȳǥ");
		CurrentMenuStringPanel.add(CurrentMenuString);
		
		CurrentMenuScroll = new JScrollPane(CurrentMenuMenuPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		CurrentMenuMenuPanel.setPreferredSize(new Dimension(600, 10000));
		CurrentMenuScroll.setPreferredSize(new Dimension(600, 400));
		
		int size = 100;
		for(int i = 0 ; i <size;i++){
			CurrentMenuButton = new JButton();
			CurrentMenuButton.addActionListener(new ActionListener(){		//�������� ACTION
	            public void actionPerformed(ActionEvent e) {
	            		F.changePanel("DetailMenuForm");
	            }
	        });
			
			CurrentMenuButton.setText(i+"");//���⿡ �޴� ���� �����ͼ� �־�ΰ�
			CurrentMenuButton.setPreferredSize(new Dimension(180, 180));
			
			CurrentMenuMenuPanel.add(CurrentMenuButton);
		}
		
		CurremtMenuCenterPanel.add(CurrentMenuScroll);
		
		//CurrentMenuMenuManagement = new JButton("�޴� ����");
		
		CurrentMenuPreviosButton = new JButton("����");
		CurrentMenuPreviosButton.addActionListener(new ActionListener(){		//�������� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("ManageStartForm");
            }
        });
		
		//CurruntMenuButtonPanel.add(CurrentMenuMenuManagement);
		CurruntMenuButtonPanel.add(CurrentMenuPreviosButton);
		
		CurrentMenuPanel.add(CurrentMenuStringPanel);
		CurrentMenuPanel.add(CurremtMenuCenterPanel);
		CurrentMenuPanel.add(CurruntMenuButtonPanel);
		
		add(CurrentMenuPanel);
		setVisible(true);
	}
}
