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
		setTitle("�� ���� ��������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Image img = new ImageIcon("money.png").getImage();
		setIconImage(img);
		
		MyPanel panel = new MyPanel();
		
		TextArea label2 = new TextArea("������ �����մϴ�!\n\t+---------+----------+---------+---------+----------+\n\t�� ������ ������ �ֹ����� �����Ͽ� �����ϰ� �Ǹ��ϴ� �����Դϴ�.\n\t�ǸŸ� �Ͽ� ������ ��� ���ؼ��� ������ ���� ��ǰ�� �����ؾ߰���?\n\t�ֹ��� ������ �� ��ǰ ������ �Ǿ����� ������ ��ǰ�� �Ǹ��� �� �����ϴ�.\n\t����, �ҷ�ǰ�� ���� �� ������ �����ϼ���!(�ҷ�ǰ�� �ս��� �߻���ŵ�ϴ�.)\n\t������ Ư�� ��ǥġ�� �ڱ��� �Ǹ� �������� ������,\n\t�������� 0��  �ǰų� �ں��� 0�� �Ǹ� ���з� ���̳��ϴ�.\n\t�׷� ������ ������ô�~!\n\t+---------+----------+---------+---------+----------+\n");
		panel.add(label2);
		
		JButton button = new JButton("Ȯ��");
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
