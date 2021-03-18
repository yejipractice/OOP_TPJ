package startGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartFrame extends JFrame
{
	
	private JLabel label;
	private static final int FONTSIZE = 24;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int Height = screenSize.height;
	int Width = screenSize.width;
	ImageIcon background = new ImageIcon("back.png");
	Image im = background.getImage();
	
	public StartFrame()
	{
		setSize(Width/3,Height/3);
		setLocationByPlatform(true);
		
		Image img = new ImageIcon("money.png").getImage();
		setIconImage(img);
		
		MyPanel panel = new MyPanel();
		panel.setLayout(new GridLayout(2,0));
		
		label = new JLabel("게임을 시작하시겠습니까?");
		label.setFont(new Font("함초롱바탕",Font.BOLD,FONTSIZE));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,2));
		JButton yesbutton = new JButton("YES");
		JButton nobutton = new JButton("NO");
		buttonPanel.add(yesbutton);
		buttonPanel.add(nobutton);
		this.add(panel);
		this.add(buttonPanel,BorderLayout.SOUTH);
		
		yesbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				new StarttwoFrame(Width,Height);
			}
			
		});
		nobutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				System.exit(0);
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
