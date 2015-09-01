package OrderSystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class CustomerStartForm extends JPanel{

	private ClientControlForm F;
	
	private JPanel entire,layout,information;
	private JLabel title, _id, _pw;
	private JTextField id;
	private JPasswordField pw;
	private JButton login, signUp, non_Order;
	
	private JPanel id_field, pw_field, login_button_field,
	       sigUp_Button_field, non_Order_Button_field,
	       entire_field;
	
	private String confirm="";
	private String passID, passPw;
	     
	public CustomerStartForm(ClientControlForm f) {
		entire = new JPanel();
		layout = new JPanel();
		information = new JPanel();
		title = new JLabel();
		_id = new JLabel("ID ");
		_pw = new JLabel("PW");
		id = new JTextField(10);
		pw = new JPasswordField(10);
		login = new JButton("�α���");
		signUp = new JButton("ȸ�� ����");
		non_Order = new JButton("��ȸ�� �ֹ�");
		id_field = new JPanel();    //Id ���̺�� ���̵� �ִ� �ؽ�Ʈ �ʵ� 
		pw_field = new JPanel();    //pw ���̺�� ��й�ȣ �ִ� �ؽ�Ʈ �ʵ�
		login_button_field = new JPanel();  //���� �ΰ� ��ġ�� �ʵ�
		sigUp_Button_field = new JPanel();  //���� �ΰ��� �α��� ��ư�� �ִ� �ʵ�
		non_Order_Button_field = new JPanel();   //ȸ�� ���� ��ư�� ��ȸ�� �ֹ� ��ư �ִ� �ʵ�
		entire_field = new JPanel();   //���� 5�� ��� ���̴� �ʵ�
		
		F = f;
		
		login.addActionListener(new ActionListener(){		//�α���
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource() == login){
            		passID = id.getText();
            		passPw = new String(pw.getPassword());
            		//id.requestFocus();
            		if(!(passID.isEmpty()) && !(passPw.isEmpty())){
            			F.changePanel("ClientMenuForm");
            			confirm = passID+"/"+passPw+"/";
            			OrderManager.getLogin(confirm);
            		}
            	}
            }
        });
		
		signUp.addActionListener(new ActionListener(){		//ȸ������
            public void actionPerformed(ActionEvent e) {
            	/*if(e.getSource() == signUp_Button || e.getSource() ==  ){
            		ConfirmID = id.getText();
            		id.requestFocus();
            	}*/
            	
            	//System.out.println(ConfirmID);
            	
            		F.changePanel("SignupForm");

            }
        });
		
		non_Order.addActionListener(new ActionListener(){		//��ȸ���ֹ� ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("NonClientInfoForm");
            }
        });
		
		
		
		entire.setLayout(new BoxLayout(entire, BoxLayout.Y_AXIS));
		title.setText("Mr.Mat Restaurant");
		
		Font font = new Font("�������",Font.PLAIN,20);
		
		title.setFont(font);
		
		id_field.add(_id); id_field.add(id);
		pw_field.add(_pw); pw_field.add(pw);
		login_button_field.setLayout(new BoxLayout(login_button_field, BoxLayout.Y_AXIS));
		login_button_field.add(id_field); login_button_field.add(pw_field);
		sigUp_Button_field.add(login_button_field); sigUp_Button_field.add(login);
		non_Order_Button_field.add(signUp); non_Order_Button_field.add(non_Order);
		entire_field.setLayout(new BoxLayout(entire_field, BoxLayout.Y_AXIS));
		entire_field.add(sigUp_Button_field); entire_field.add(non_Order_Button_field);
		
		information.add(entire_field);
		
		entire.add(title);
		entire.add(information);
		
		add(entire);
		
		setVisible(true);
		
		
	}
}