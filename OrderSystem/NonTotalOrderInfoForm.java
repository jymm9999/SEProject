package OrderSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NonTotalOrderInfoForm extends JPanel{

	private ClientControlForm F;
	
	private JPanel info_field, check_field, menu_field, sum_field,
				   detail_field, pay_field, detail_pay_field, entire_field;
	
	private JTextArea menu_total, sum_total, detail_total;
	private JButton pay_Button;
	private JLabel order_check, id_name, arrow;
	
	
	public NonTotalOrderInfoForm(ClientControlForm f) {
		
		F = f;
		
		info_field = new JPanel();	check_field = new JPanel();
		menu_field = new JPanel();  sum_field = new JPanel();
		detail_field = new JPanel();pay_field = new JPanel(); 
		detail_pay_field =new JPanel(); entire_field=new JPanel();
		menu_total = new JTextArea(5,10);sum_total = new JTextArea(5,10);
		detail_total = new JTextArea(5,10); 
		
		pay_Button = new JButton("결제");
		pay_Button.addActionListener(new ActionListener(){		//결제 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("NonThankYouForm");
            }
        });	
		
		
		order_check= new JLabel("주문 확인");
		arrow = new JLabel("->");
		// 디비에서 아이디랑 이름을 가져와서 여기에 넣어야함
		id_name = new JLabel("비회원 : 송태훈");
	
		
	
		
		// text area 초기화 + 데이터 입력
		menu_total.setEditable(false);
		menu_total.setText("");
		sum_total.setEditable(false);
		sum_total.setText("");
		detail_total.setEditable(false);
		detail_total.setText("");
		int size = 5;
		for(int i = 0 ;i<size;i++){
			menu_total.append(i+"\n");
			sum_total.append(i+5+"\n");
			detail_total.append(i+10+"\n");
			
		}
		//-------------------패널 붙이는 부분-----------------------------------------------			
		info_field.add(id_name);
		check_field.add(order_check); menu_field.add(menu_total);
		sum_field.add(sum_total); detail_field.add(detail_total);
		pay_field.add(pay_Button); detail_pay_field.add(detail_field);
		detail_pay_field.add(pay_Button);
		
		entire_field.setLayout(new BorderLayout());
		
		entire_field.add(check_field, BorderLayout.PAGE_START);
		entire_field.add(menu_field,BorderLayout.LINE_START);
		entire_field.add(arrow,BorderLayout.CENTER);
		entire_field.add(sum_total,BorderLayout.LINE_END);
		entire_field.add(detail_pay_field,BorderLayout.PAGE_END);
	
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(info_field);
		add(entire_field);
		
		setVisible(true);
		
		
		
	}
	
	
}
