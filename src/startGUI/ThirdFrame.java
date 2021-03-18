package startGUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import game.option;
import startGUI.StarttwoFrame.MyPanel;

public class ThirdFrame extends JFrame
{
	ImageIcon background = new ImageIcon("back.png");
	Image im = background.getImage();
	
	public ThirdFrame(int w, int h)
	{
		setSize(w/3,h/3);
		setLocationByPlatform(true);
		setTitle("내 꿈은 공장장이");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Image img = new ImageIcon("money.png").getImage();
		setIconImage(img);
		
		MyPanel p2 = new MyPanel();
		p2.setLayout(null);
		JLabel nmlb = new JLabel("User's name:");
		p2.add(nmlb);
		JTextField namefield = new JTextField(20);
		p2.add(namefield);
		
		JLabel lb1 = new JLabel("Item1's name:");
		p2.add(lb1);
		JTextField field1 = new JTextField(20);
		p2.add(field1);
		JLabel lb2 = new JLabel("Item2's name:");
		p2.add(lb2);
		JTextField field2 = new JTextField(20);
		p2.add(field2);
		JLabel lb3 = new JLabel("Item3's name:");
		p2.add(lb3);
		JTextField field3 = new JTextField(20);
		p2.add(field3);
		JLabel lb4 = new JLabel("Item4's name:");
		p2.add(lb4);
		JTextField field4 = new JTextField(20);
		p2.add(field4);
		JLabel lb5 = new JLabel("Item5's name:");
		p2.add(lb5);
		JTextField field5 = new JTextField(20);
		p2.add(field5);
		JButton button = new JButton("입력");
		p2.add(button);
		JLabel label = new JLabel("사용자명과 제품명을 입력해주세요.");
		p2.add(label,JLabel.CENTER);
		label.setBounds(150,15,300,20);
		nmlb.setBounds(100, 50, 80, 20);
		namefield.setBounds(200,50,150,20);
		lb1.setBounds(100, 85, 80, 20);
		field1.setBounds(200,85,150,20);
		lb2.setBounds(100, 120, 80, 20);
		field2.setBounds(200,120,150,20);
		lb3.setBounds(100, 155, 80, 20);
		field3.setBounds(200,155,150,20);
		lb4.setBounds(100, 190, 80, 20);
		field4.setBounds(200,190,150,20);
		lb5.setBounds(100, 225, 80, 20);
		field5.setBounds(200,225,150,20);
		button.setBounds(390,70,80,100);
		add(p2);
		

		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String a = nmlb.getText();
				String b = field1.getText();
				String c = field2.getText();
				String d = field3.getText();
				String ee = field4.getText();
				String f = field5.getText();
				if(a.equals("") || b.equals("") || c.equals("") || d.equals("") || ee.equals("") || f.equals(""))
				{
					JOptionPane n = new JOptionPane();
					JOptionPane.showMessageDialog(null,"잘못된 입력입니다.","입력 에러 메세지",JOptionPane.ERROR_MESSAGE);
					System.out.println("입력 오류로 인해 시스템이 종료되었습니다.");
					System.exit(0);
				}
				option.user_name = a;
				option.p1name = b;
				option.p2name = c;
				option.p3name = d;
				option.p4name = ee;
				option.p5name = f;
				setVisible(false);
				new FourthFrame(w,h);
				
			}
			
		});
		
		
		}
	
	
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(im,0,0,this);
		}
	}
}
