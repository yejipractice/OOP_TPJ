package startGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import startGUI.StartFrame.MyPanel;


public class StarttwoFrame extends JFrame
{
	ImageIcon background = new ImageIcon("back.png");
	Image im = background.getImage();
	private static final int FONTSIZE = 15;
	
	public StarttwoFrame(int w, int h)
	{
		setSize(w/3,h/3);
		setLocationByPlatform(true);
		setTitle("내 꿈은 공장장이");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Image img = new ImageIcon("money.png").getImage();
		setIconImage(img);
		
		MyPanel panel = new MyPanel();
		
		TextArea label2 = new TextArea("게임을 시작합니다!\n\t+---------+----------+---------+---------+----------+\n\t본 게임은 랜덤한 주문량을 예측하여 생산하고 판매하는 게임입니다.\n\t판매를 하여 이윤을 얻기 위해서는 적절한 양의 제품을 생산해야겠죠?\n\t주문이 들어왔을 때 제품 생산이 되어있지 않으면 제품을 판매할 수 없습니다.\n\t또한, 불량품도 생길 수 있으니 주의하세요!(불량품은 손실을 발생시킵니다.)\n\t게임은 특정 목표치의 자금이 되면 성공으로 끝나고,\n\t만족도가 0이  되거나 자본이 0이 되면 실패로 끝이납니다.\n\t그럼 공장을 살려봅시다~!\n\t+---------+----------+---------+---------+----------+\n");
		panel.add(label2);
		
		JButton button = new JButton("확인");
		panel.add(button);
		this.add(panel);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				new ThirdFrame(w,h);
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
