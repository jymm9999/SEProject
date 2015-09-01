package OrderSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClientMenuForm extends JPanel{
	
	private ClientControlForm F;
	
	JPanel ClientMenuPanel;
	JPanel ClientMenuTopPanel;		//�̰� �����̰� ���ϴ� ������
	JPanel ClientMenuMenuPanel;		
	JPanel ClientMenuPricePanel;
	JPanel ClientMenuPriceEachPanel;
	JPanel ClientMenuPriceSumPanel;
	JPanel ClientMenuLeftPanel;
	JPanel ClientMenuRightPanel;
	JPanel ClientMenuMenuScrollPanel;
	
	JButton ClientMenuMenuButton;
	JButton ClientMenuPreviuosOrderButton;
	JButton ClientMenuEditCustomerInfoButton;
	JButton ClientMenuOrderButton;
	JButton ClientMenuLogOutButton;
	
	JLabel ClientMenuMenuPriceLabel;
	JLabel ClientMenuIDLabel;	
	
	JScrollPane ClientMenuMenuScrollPane;
	
	public ClientMenuForm(ClientControlForm f){
		
		F = f;
		
		setSize(800, 600);
		
		ClientMenuPanel = new JPanel();
		ClientMenuTopPanel = new JPanel();
		ClientMenuMenuPanel = new JPanel();
		ClientMenuPricePanel = new JPanel();
		ClientMenuPriceSumPanel = new JPanel();
		ClientMenuLeftPanel = new JPanel();
		ClientMenuRightPanel = new JPanel();
		ClientMenuMenuScrollPanel = new JPanel();
		
		ClientMenuIDLabel = new JLabel();
		ClientMenuIDLabel.setText("ID : " + "");//���⿡ ���̵� ��������
		ClientMenuPreviuosOrderButton = new JButton("���� �ֹ� ����");
		ClientMenuEditCustomerInfoButton = new JButton("ȸ����������");
		ClientMenuLogOutButton = new JButton("�α� �ƿ�");
		
		ClientMenuTopPanel.add(ClientMenuIDLabel);
		ClientMenuTopPanel.add(ClientMenuPreviuosOrderButton);
		ClientMenuTopPanel.add(ClientMenuEditCustomerInfoButton);
		ClientMenuTopPanel.add(ClientMenuLogOutButton);
		
		ClientMenuTopPanel.setPreferredSize(new Dimension(450, 50));
		
		ClientMenuMenuScrollPane = new JScrollPane(ClientMenuMenuScrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ClientMenuMenuScrollPane.setPreferredSize(new Dimension(450, 400));
		ClientMenuMenuScrollPanel.setPreferredSize(new Dimension(450, 5000));
		
		ClientMenuPreviuosOrderButton.addActionListener(new ActionListener(){		//�����ֹ����� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("OrderHistoryForm");
            }
        });
		
		ClientMenuEditCustomerInfoButton.addActionListener(new ActionListener(){		//ȸ������ ���� ACTION
            public void actionPerformed(ActionEvent e) {
            	
            		F.changePanel("EditCustomerForm");
            }
        });
		
		ClientMenuLogOutButton.addActionListener(new ActionListener(){		//ȸ������ ���� ACTION
            public void actionPerformed(ActionEvent e) {
            	
            		F.changePanel("CustomerStartForm");
            }
        });
		
		
		
		int size = 50;
		for(int i = 0 ; i<size;i++){
			ClientMenuMenuButton = new JButton();
			ClientMenuMenuButton.setText(""+i);	//���⿡ �޴� ����
			ClientMenuMenuButton.setPreferredSize(new Dimension(180, 180));
			ClientMenuMenuScrollPanel.add(ClientMenuMenuButton);
		}
		
		ClientMenuMenuPanel.add(ClientMenuMenuScrollPane);
		
		ClientMenuLeftPanel.add(ClientMenuTopPanel);
		ClientMenuLeftPanel.add(ClientMenuMenuPanel);
		ClientMenuLeftPanel.setPreferredSize(new Dimension(450, 800));
		

		ClientMenuPricePanel.setLayout(new BoxLayout(ClientMenuPricePanel, BoxLayout.Y_AXIS));
		
		
		for(int i = 0 ; i<size;i++){
			ClientMenuMenuPriceLabel = new JLabel();
			ClientMenuMenuPriceLabel.setText(""+i);
			
			ClientMenuPricePanel.add(ClientMenuMenuPriceLabel);
		}
		ClientMenuPricePanel.setPreferredSize(new Dimension(300, 500));
		
		ClientMenuMenuPriceLabel = new JLabel();
		ClientMenuMenuPriceLabel.setText("�� �� : "+" ��");
		ClientMenuOrderButton = new JButton("�ֹ�");
		
		ClientMenuOrderButton.addActionListener(new ActionListener(){		//�����ֹ����� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("TotalOrderInfoForm");
            }
        });
		
		ClientMenuPriceSumPanel.add(ClientMenuMenuPriceLabel);
		ClientMenuPriceSumPanel.add(ClientMenuOrderButton);
		ClientMenuPriceSumPanel.setPreferredSize(new Dimension(300, 200));
		
		ClientMenuRightPanel.add(ClientMenuPricePanel);
		ClientMenuRightPanel.add(ClientMenuPriceSumPanel);
		ClientMenuRightPanel.setPreferredSize(new Dimension(300, 800));
		
		
		ClientMenuPanel.add(ClientMenuLeftPanel);
		ClientMenuPanel.add(ClientMenuRightPanel);
		
		
		setVisible(true);
		add(ClientMenuPanel);
		
	}
}

