package view;

import event.butonEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class windows {
    Dimension preferredSize=new Dimension(160, 60);    //设置尺寸
    Font f = new Font("楷体",Font.PLAIN,40);
    public static JTextArea jta = null;
    static JFrame frame=new JFrame("图床上传工具");    //创建Frame窗口
    public void openWindows(){
        UIManager.put("Button.font",f);
        JPanel jp = new JPanel();    //创建JPanel对象
        JButton btn1 = new JButton("截图");    //创建JButton对象
        JButton btn2 = new JButton("上传");
        btn1.setPreferredSize(preferredSize);
        btn1.addActionListener(new butonEvent().screenEvent());
        btn2.setPreferredSize(preferredSize);
        btn2.addActionListener(new butonEvent().upFile());
        jp.add(btn1);
        jp.add(btn2);
        frame.add(jp);
        jta=new JTextArea("------------------以上为日志------------------------------",20,80);
        jta.setLineWrap(true);    //设置文本域中的文本为自动换行
        jta.setForeground(Color.BLACK);    //设置组件的背景色
        jta.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        jta.setBackground(Color.WHITE);    //设置按钮背景色
        jp.add(jta);
        frame.setBounds(300, 200, 800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new windows().openWindows();
    }
}
