package ServerSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailMenuForm extends JPanel{
	
	private ServerControlForm F;
	
	JPanel DetailMenuPanel;
	
	JPanel DetailMenuStringPanel;
	
	JPanel DetailMenuCenterPanel;
	JPanel DetailMenuMenuInfoPanel;
	JPanel DetailMenuPriceInfoPanel;
	
	JPanel DetailBottomPanel;
	JPanel DetailButtonPanel;
	JPanel DetailMenuCustomerInfoPanel;
	
	JLabel DetailMenuString;
	
	JTextArea DetailMenuInfoArea;
	JTextField DetailMenuPriceField;
	
	JTextField DetailMenuNameField;
	JTextField DetailMenuAddressField;
	
	JButton DetailMenuButtonPrevios;
	JButton DetailMenuButtonDeliveryDone;
	
	public DetailMenuForm(ServerControlForm f){
		
		F = f;
		
		setSize(800, 600);
		
		DetailMenuPanel = new JPanel();
		
		DetailMenuStringPanel = new JPanel();
		
		DetailMenuCenterPanel = new JPanel();
		DetailMenuMenuInfoPanel = new JPanel();
		DetailMenuPriceInfoPanel = new JPanel();
		
		DetailBottomPanel = new JPanel();
		DetailButtonPanel = new JPanel();
		DetailMenuCustomerInfoPanel = new JPanel();
		
		DetailMenuPanel.setLayout(new BoxLayout(DetailMenuPanel, BoxLayout.Y_AXIS));
		DetailMenuCenterPanel.setLayout(new BoxLayout(DetailMenuCenterPanel, BoxLayout.X_AXIS));
		DetailBottomPanel.setLayout(new BoxLayout(DetailBottomPanel, BoxLayout.X_AXIS));
		DetailButtonPanel.setLayout(new BoxLayout(DetailButtonPanel, BoxLayout.Y_AXIS));
		DetailMenuCustomerInfoPanel.setLayout(new BoxLayout(DetailMenuCustomerInfoPanel, BoxLayout.Y_AXIS));
				
		DetailMenuString = new JLabel("�޴� ��");
		DetailMenuStringPanel.add(DetailMenuString);
		
		DetailMenuInfoArea = new JTextArea();
		DetailMenuInfoArea.setText("�޴� ����"); //���⿡ �޴� ����
		DetailMenuInfoArea.setEditable(false);
		DetailMenuPriceField = new JTextField();
		DetailMenuPriceField.setText(" �� �� : "+" ��"); //���⿡ ���� ����
		DetailMenuPriceField.setEditable(false);
		DetailMenuCenterPanel.add(DetailMenuInfoArea);
		DetailMenuCenterPanel.add(DetailMenuPriceField);
		
		DetailMenuNameField = new JTextField(10);
		DetailMenuNameField.setText("�̸� : "+""); //���⿡ �̸�
		DetailMenuNameField.setEditable(false);
		DetailMenuAddressField = new JTextField(15);
		DetailMenuAddressField.setText("�ּ� : "+"");//���� �ּ�����
		DetailMenuAddressField.setEditable(false);
		DetailMenuCustomerInfoPanel.add(DetailMenuNameField);
		DetailMenuCustomerInfoPanel.add(DetailMenuAddressField);
		
		DetailMenuButtonPrevios = new JButton("��������");
		DetailMenuButtonPrevios.addActionListener(new ActionListener(){		//�������� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("CurrentMenuForm");
            }
        });
		
		DetailMenuButtonDeliveryDone = new JButton("��� �Ϸ�");
		DetailMenuButtonDeliveryDone.addActionListener(new ActionListener(){		//��޿Ϸ� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("CurrentMenuForm");
            }
        });
		
		DetailButtonPanel.add(DetailMenuButtonPrevios);
		DetailButtonPanel.add(DetailMenuButtonDeliveryDone);
		
		DetailBottomPanel.add(DetailMenuCustomerInfoPanel);
		DetailBottomPanel.add(DetailButtonPanel);
		
		DetailMenuPanel.add(DetailMenuStringPanel);
		DetailMenuPanel.add(DetailMenuCenterPanel);
		DetailMenuPanel.add(DetailBottomPanel);
		
		add(DetailMenuPanel);
		setVisible(true);
	}
}
