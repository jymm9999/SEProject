package ServerSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class ManageStartForm extends JPanel{
	
	private ServerControlForm F;
	
	JPanel ManageStartFormPanel;
	JPanel ManageStartButtonPanel;
	JPanel ManageStartStringPanel;
	
	JButton MenuManagementButton;
	JButton CurrentMenuButton;
	
	JLabel MenuStartString;
	
	
	public ManageStartForm(ServerControlForm f){
		
		F = f;
		
		setSize(800, 600);

		ManageStartFormPanel = new JPanel();
		ManageStartButtonPanel = new JPanel();
		ManageStartStringPanel = new JPanel();
		
		ManageStartFormPanel.setLayout(new BoxLayout(ManageStartFormPanel, BoxLayout.Y_AXIS));
		
		MenuManagementButton = new JButton("메뉴 관리");
		MenuManagementButton.addActionListener(new ActionListener(){		//메뉴관리 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("MenuManageForm");
            }
        });
		CurrentMenuButton = new JButton("주문 상황");
		CurrentMenuButton.addActionListener(new ActionListener(){		//주문상황 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("CurrentMenuForm");
            }
        });
		
		ManageStartButtonPanel.add(MenuManagementButton);
		ManageStartButtonPanel.add(CurrentMenuButton);
		
		MenuStartString = new JLabel("Mr.Mats Restaurant Management System");
		
		ManageStartStringPanel.add(MenuStartString);
		
		ManageStartFormPanel.add(ManageStartStringPanel);
		ManageStartFormPanel.add(ManageStartButtonPanel);
		
		add(ManageStartFormPanel);
		
		setVisible(true);
		
	}
}
