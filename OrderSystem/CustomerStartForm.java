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
		login = new JButton("로그인");
		signUp = new JButton("회원 가입");
		non_Order = new JButton("비회원 주문");
		id_field = new JPanel();    //Id 레이블과 아이디 넣는 텍스트 필드 
		pw_field = new JPanel();    //pw 레이블과 비밀번호 넣는 텍스트 필드
		login_button_field = new JPanel();  //위에 두개 합치는 필드
		sigUp_Button_field = new JPanel();  //위에 두개와 로그인 버튼을 넣는 필드
		non_Order_Button_field = new JPanel();   //회원 가입 버튼과 비회원 주문 버튼 넣는 필드
		entire_field = new JPanel();   //위에 5개 모두 붙이는 필드
		
		F = f;
		
		login.addActionListener(new ActionListener(){		//로그인
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
		
		signUp.addActionListener(new ActionListener(){		//회원가입
            public void actionPerformed(ActionEvent e) {
            	/*if(e.getSource() == signUp_Button || e.getSource() ==  ){
            		ConfirmID = id.getText();
            		id.requestFocus();
            	}*/
            	
            	//System.out.println(ConfirmID);
            	
            		F.changePanel("SignupForm");

            }
        });
		
		non_Order.addActionListener(new ActionListener(){		//비회원주문 ACTION
            public void actionPerformed(ActionEvent e) {
            		F.changePanel("NonClientInfoForm");
            }
        });
		
		
		
		entire.setLayout(new BoxLayout(entire, BoxLayout.Y_AXIS));
		title.setText("Mr.Mat Restaurant");
		
		Font font = new Font("맑은고딕",Font.PLAIN,20);
		
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