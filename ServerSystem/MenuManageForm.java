package ServerSystem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuManageForm extends JPanel{
	
	private ServerControlForm F;
	
	JPanel MenuManageFormPanel;
	JPanel MenuManageStringPanel;	
	JPanel MenuManageMenuPanel;	
	JPanel MenuManageButtonPanel ;
	JPanel MenuManageMenuEachPanel;
	
	JLabel MenuManageString;
	
	JButton MenuManageAddButton;
	JButton MenuManageCloseButton;
	JButton MenuManageEditButton;
	JButton MenuManageDeleteButton;
	
	JTextField MenuManageMenuName;
	JTextField MenuManageMenuPrice;
	
	JScrollPane MenuManageMenuScroll;
	
	
	public MenuManageForm(ServerControlForm f){
		
		F = f;
		
		setSize(800, 600);
		
		MenuManageFormPanel = new JPanel();		//��ü �ǳ�
		MenuManageStringPanel = new JPanel();	//���� ��Ʈ�� ����
		MenuManageMenuPanel = new JPanel();	//�߰� �޴��� ������ �ǳ�
		MenuManageButtonPanel = new JPanel(); // �޴��߰�/�ݱ� �ϴ� �г�
		MenuManageMenuEachPanel = new JPanel();	//�޴� �ϳ��ϳ��� �ִ� �ǳ�
		
		MenuManageFormPanel.setLayout(new BoxLayout(MenuManageFormPanel, BoxLayout.Y_AXIS));
		MenuManageMenuPanel.setLayout(new BoxLayout(MenuManageMenuPanel, BoxLayout.Y_AXIS));
	
		
		MenuManageString = new JLabel("Menu ManageMent");
		MenuManageStringPanel.add(MenuManageString);		//��������� ù��° �� ���� ��Ʈ�� ������ �г�
		
		MenuManageMenuScroll = new JScrollPane(MenuManageMenuEachPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		MenuManageMenuEachPanel.setPreferredSize(new Dimension(600, 5000));
		MenuManageMenuScroll.setPreferredSize(new Dimension(600, 400));
		
		int size = 50;
		for(int i = 0 ; i <size;i++){
			MenuManageMenuName = new JTextField(30);
			MenuManageMenuName.setText(""+i); //�޴� �̸� ��������
			MenuManageMenuName.setEditable(false);
			
			MenuManageMenuPrice = new JTextField(10);
			MenuManageMenuPrice.setText(""); //�޴� ���� ��������
			MenuManageMenuPrice.setEditable(false);
			
			MenuManageEditButton = new JButton("����");
			MenuManageDeleteButton = new JButton("����");
			
			MenuManageMenuEachPanel.add(MenuManageMenuName);
			MenuManageMenuEachPanel.add(MenuManageMenuPrice);
			MenuManageMenuEachPanel.add(MenuManageEditButton);
			MenuManageMenuEachPanel.add(MenuManageDeleteButton);

		}
		
		MenuManageMenuPanel.add(MenuManageMenuScroll);
		
		MenuManageAddButton = new JButton("�޴� �߰�");
		MenuManageCloseButton = new JButton("����");
		MenuManageCloseButton.addActionListener(new ActionListener(){		//���� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("ManageStartForm");
            }
        });
		MenuManageButtonPanel.add(MenuManageAddButton);
		MenuManageButtonPanel.add(MenuManageCloseButton);
		
		
		MenuManageFormPanel.add(MenuManageStringPanel);
		MenuManageFormPanel.add(MenuManageMenuPanel);
		MenuManageFormPanel.add(MenuManageButtonPanel);
		
		add(MenuManageFormPanel);
		setVisible(true);
	}
}
