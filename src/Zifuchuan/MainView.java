package Zifuchuan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainView extends JFrame {
	public static void main(String[] args) {
		MainView mv=new MainView();
	    mv.setLayout(null);
	    JTextArea jta= new JTextArea();
	    JTextArea jta1= new JTextArea();
	    JTextArea shuru= new JTextArea();
	    JButton btn=new JButton("查询");
	    btn.setBounds(215, 400, 80, 30);
	    JButton btn_shuru=new JButton("确认输入");
	    btn_shuru.setBounds(215, 500, 100, 30);
	    
        
	    btn_shuru.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		StringBuffer aa = new StringBuffer();
	    		aa.append(Btn_click(shuru));
	    		StringBuffer str=aa;
	    		StringBuffer str1=new StringBuffer();
	    		str1=FormatOutput(str);
	    		String str2=new String(str1);
	    		jta.append(str2);
	    		btn.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent arg0) {
	    				int i=WordFrequency(str2,jta1.getText());
	    				JOptionPane.showMessageDialog(null, "该文字在古诗中出现的次数为:  "+i);
	    			}
	    		});
	    		}});
	    
	    
	    
	    shuru.setBounds(50, 500, 150, 30);
	    
	    jta1.setBounds(50, 400, 150, 30);
	    jta.setColumns(16);
	    jta.setRows(50);
	    jta.setLineWrap(true);
	    
	    JScrollPane jsp = new JScrollPane(jta);
	    jsp.setBounds(15, 10, 350, 340);
	    jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    mv.add(shuru);
	    
	    mv.add(btn_shuru);
	    mv.add(btn);
	    mv.add(jta1);
	    mv.add(jsp);
	    mv.setSize(400, 600);
	    mv.setVisible(true);
	    mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static String Btn_click(JTextArea a){
		
    		String zfc=a.getText();
    		return zfc;}
    	
	
	//数组转换成字符串函数	
	public static StringBuffer ArrayToString(String[] args) {
		StringBuffer str=new StringBuffer();
		for(int i=0;i<args.length;i++) {
			str.append(args[i]);
		}
		return str;
	}
	
	//格式化输出函数 
	public static StringBuffer FormatOutput(StringBuffer str) {
		StringBuffer str2=new StringBuffer();
		for(int i=0;i<str.length()/7;i++) {
			str2.append(str.substring(7*i, 7*(i+1)));
			if((i+1)%2!=0) {
				str2.append(",");
			}
			else {
				str2.append("。").append("\n");
			}
		}
		return str2;
	}
	
	//词频统计函数
	public static int WordFrequency(String str1,String str0) {
		int i=0;
		while(str1.indexOf(str0)!=-1) {
			if(str1.indexOf(str0)!=-1) {
				i++;
				str1=str1.substring(str1.indexOf(str0)+str0.length(), str1.length());
			}
		}
		return i;
	}
}