package Quiz.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener{
    JButton Playagain,Close;
    Score(String name,int score)
    {
        setBounds(0,0,1285,700);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Icons/Score.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1250,300);
        add(image);

        JLabel sco = new JLabel();
        sco.setBounds(500,300,700,300);
        sco.setFont(new Font("Tahoma",Font.BOLD,20));
        sco.setForeground(Color.black);
        if(score>70) {
            sco.setText(
                    "<html>" +
                            "Congratulations "+name+" you are selected !!" + "<br><br>" +
                            "Your Score : " + score + "/100"+ "<br><br>" +
                            "<html>"
            );
        }else
        {
            sco.setText(
                    "<html>" +
                            "Better Luck next time !!" + "<br><br>" +
                            "Your Score : " + score + "/100"+"<br><br>" +
                            "<html>"
            );

        }
        add(sco);

        Playagain=new JButton("Play again");
        Playagain.setBounds(500,500,125,25);
        Playagain.setBackground(Color.LIGHT_GRAY);
        Playagain.setForeground(Color.BLACK);
        Playagain.addActionListener(this);
        add(Playagain);

        Close=new JButton("Close");
        Close.setBounds(700,500,125,25);
        Close.setBackground(Color.LIGHT_GRAY);
        Close.setForeground(Color.BLACK);
        Close.addActionListener(this);
        add(Close);

        setSize(1285,700);
        setLocation(0,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Playagain)
        {
            setVisible(false);
            new Login();
        }
        else if(ae.getSource()==Close)
        {
            setVisible(false);
        }
    }
    public static void main(String str[])
    {
        new Score("user",0);
    }
}
