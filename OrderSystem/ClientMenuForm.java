package OrderSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClientMenuForm extends JPanel{
	
	private ClientControlForm F;
	
	JPanel ClientMenuPanel;
	JPanel ClientMenuTopPanel;		//이게 영준이가 원하는 위에꺼
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
		ClientMenuIDLabel.setText("ID : " + "");//여기에 아이디 가져오기
		ClientMenuPreviuosOrderButton = new JButton("이전 주문 내역");
		ClientMenuEditCustomerInfoButton = new JButton("회원정보수정");
		ClientMenuLogOutButton = new JButton("로그 아웃");
		
		ClientMenuTopPanel.add(ClientMenuIDLabel);
		ClientMenuTopPanel.add(ClientMenuPreviuosOrderButton);
		ClientMenuTopPanel.add(ClientMenuEditCustomerInfoButton);
		ClientMenuTopPanel.add(ClientMenuLogOutButton);
		
		ClientMenuTopPanel.setPreferredSize(new Dimension(450, 50));
		
		ClientMenuMenuScrollPane = new JScrollPane(ClientMenuMenuScrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ClientMenuMenuScrollPane.setPreferredSize(new Dimension(450, 400));
		ClientMenuMenuScrollPanel.setPreferredSize(new Dimension(450, 5000));
		
		ClientMenuPreviuosOrderButton.addActionListener(new ActionListener(){		//이전주문내역 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("OrderHistoryForm");
            }
        });
		
		ClientMenuEditCustomerInfoButton.addActionListener(new ActionListener(){		//회원정보 수정 ACTION
            public void actionPerformed(ActionEvent e) {
            	
            		F.changePanel("EditCustomerForm");
            }
        });
		
		ClientMenuLogOutButton.addActionListener(new ActionListener(){		//회원정보 수정 ACTION
            public void actionPerformed(ActionEvent e) {
            	
            		F.changePanel("CustomerStartForm");
            }
        });
		
		
		
		int size = 50;
		for(int i = 0 ; i<size;i++){
			ClientMenuMenuButton = new JButton();
			ClientMenuMenuButton.setText(""+i);	//여기에 메뉴 정보
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
		ClientMenuMenuPriceLabel.setText("총 합 : "+" 원");
		ClientMenuOrderButton = new JButton("주문");
		
		ClientMenuOrderButton.addActionListener(new ActionListener(){		//이전주문내역 ACTION
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

