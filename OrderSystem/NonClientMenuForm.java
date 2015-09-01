package OrderSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NonClientMenuForm extends JPanel{

	private ClientControlForm F;
	
	JPanel NonClientMenuPanel;
	JPanel NonClientMenuTopPanel;		//�̰� �����̰� ���ϴ� ������
	JPanel NonClientMenuMenuPanel;		
	JPanel NonClientMenuPricePanel;
	JPanel NonClientMenuPriceEachPanel;
	JPanel NonClientMenuPriceSumPanel;
	JPanel NonClientMenuLeftPanel;
	JPanel NonClientMenuRightPanel;
	JPanel NonClientMenuMenuScrollPanel;
	
	JButton NonClientMenuMenuButton;
	JButton NonClientMenuOrderButton;
	
	JLabel NonClientMenuMenuPriceLabel;
	JLabel NonClientMenuIDLabel;	
	
	JScrollPane NonClientMenuMenuScrollPane;
	
	public NonClientMenuForm(ClientControlForm f){
		
		setSize(800, 600);
		
		F = f;
		
		NonClientMenuPanel = new JPanel();
		NonClientMenuTopPanel = new JPanel();
		NonClientMenuMenuPanel = new JPanel();
		NonClientMenuPricePanel = new JPanel();
		NonClientMenuPriceSumPanel = new JPanel();
		NonClientMenuLeftPanel = new JPanel();
		NonClientMenuRightPanel = new JPanel();
		NonClientMenuMenuScrollPanel = new JPanel();
		
		NonClientMenuIDLabel = new JLabel();
		NonClientMenuIDLabel.setText("��ȸ���ֹ� ");//���⿡ ���̵� ��������
		
		NonClientMenuTopPanel.add(NonClientMenuIDLabel);
		
		NonClientMenuTopPanel.setPreferredSize(new Dimension(450, 50));
		
		NonClientMenuMenuScrollPane = new JScrollPane(NonClientMenuMenuScrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		NonClientMenuMenuScrollPane.setPreferredSize(new Dimension(450, 400));
		NonClientMenuMenuScrollPanel.setPreferredSize(new Dimension(450, 5000));
		
		int size = 50;
		for(int i = 0 ; i<size;i++){
			NonClientMenuMenuButton = new JButton();
			NonClientMenuMenuButton.setText(""+i);	//���⿡ �޴� ����
			NonClientMenuMenuButton.setPreferredSize(new Dimension(180, 180));
			NonClientMenuMenuScrollPanel.add(NonClientMenuMenuButton);
		}
		
		NonClientMenuMenuPanel.add(NonClientMenuMenuScrollPane);
		
		NonClientMenuLeftPanel.add(NonClientMenuTopPanel);
		NonClientMenuLeftPanel.add(NonClientMenuMenuPanel);
		NonClientMenuLeftPanel.setPreferredSize(new Dimension(450, 800));
		

		NonClientMenuPricePanel.setLayout(new BoxLayout(NonClientMenuPricePanel, BoxLayout.Y_AXIS));
		
		
		for(int i = 0 ; i<size;i++){
			NonClientMenuMenuPriceLabel = new JLabel();
			NonClientMenuMenuPriceLabel.setText(""+i);
			
			NonClientMenuPricePanel.add(NonClientMenuMenuPriceLabel);
		}
		NonClientMenuPricePanel.setPreferredSize(new Dimension(300, 500));
		
		NonClientMenuMenuPriceLabel = new JLabel();
		NonClientMenuMenuPriceLabel.setText("�� �� : "+" ��");
		NonClientMenuOrderButton = new JButton("�ֹ�");
		NonClientMenuOrderButton.addActionListener(new ActionListener(){		//ȸ���������� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("NonTotalOrderInfoForm");
            }
        });
		
		NonClientMenuPriceSumPanel.add(NonClientMenuMenuPriceLabel);
		NonClientMenuPriceSumPanel.add(NonClientMenuOrderButton);
		NonClientMenuPriceSumPanel.setPreferredSize(new Dimension(300, 200));
		
		NonClientMenuRightPanel.add(NonClientMenuPricePanel);
		NonClientMenuRightPanel.add(NonClientMenuPriceSumPanel);
		NonClientMenuRightPanel.setPreferredSize(new Dimension(300, 800));
		
		
		NonClientMenuPanel.add(NonClientMenuLeftPanel);
		NonClientMenuPanel.add(NonClientMenuRightPanel);
		
		
		setVisible(true);
		add(NonClientMenuPanel);
	}
}
