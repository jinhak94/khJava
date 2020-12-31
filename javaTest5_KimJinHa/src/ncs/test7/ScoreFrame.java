package ncs.test7;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ScoreFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField javaScore;
	private JTextField sqlScore;
	private JTextField total;
	private JTextField average;
	private JButton calcBtn;
	private JLabel title;
	private JLabel javaLabel;
	private JLabel sqlLabel;
	private JLabel totalLabel;
	private JLabel avgLabel;
	
	public ScoreFrame() {
		setLayout(null);
		setTitle("문제 7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 500, 500);
		javaScore = new JTextField();
		sqlScore = new JTextField();
		total = new JTextField();
		average = new JTextField();
		calcBtn = new JButton("계산하기");
		title = new JLabel("점수를 입력하세요");
		javaLabel = new JLabel("자바 : ");
		sqlLabel = new JLabel("sql : ");
		totalLabel = new JLabel("총점 : ");
		avgLabel = new JLabel("평균 : ");
		
		title.setBounds(20,20,480,100);
		title.setFont(new Font("돋움",Font.PLAIN,53));
		javaLabel.setBounds(20,130,40,30);
		javaScore.setBounds(60,130,150,30);
		
		sqlLabel.setBounds(280,130,50,30);
		sqlScore.setBounds(310,130,150,30);
		calcBtn.setBounds(190,230,110,40);
		
		totalLabel.setBounds(20,340,40,30);
		total.setBounds(60,340,150,30);
		avgLabel.setBounds(275,340,50,30);
		average.setBounds(310,340,150,30);
		
		calcBtn.addActionListener(new ActionHandler());
		
		add(javaScore);
		add(sqlScore);
		add(total);
		add(average);
		add(calcBtn);
		add(title);
		add(javaLabel);
		add(sqlLabel);
		add(totalLabel);
		add(avgLabel);
		
		setVisible(true);
	}

	public class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int sum = 0;
			int avg;
			try {
				sum = Integer.parseInt(javaScore.getText())
					+ Integer.parseInt(sqlScore.getText());
				avg = sum / 2;
				total.setText(String.valueOf(sum));
				average.setText(String.valueOf(avg));
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.");
				}
		}
	}
}
