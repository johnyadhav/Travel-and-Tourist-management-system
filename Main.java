import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        new home();
    }
}


class home extends JFrame
{
    public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static int windowwidth = (int)size.getWidth();
    public static int windowheight = (int)size.getHeight();

    JLabel l1;
    home()
    {
        System.out.println(windowwidth+""+windowheight);
        setLocation(windowwidth/2-400,windowheight/2-200);
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        l1=new JLabel("Travel And Tourism Management System");
        l1.setBounds(windowwidth/2-400,200,800,100);
        l1.setFont(new Font("Arial",Font.BOLD,40));
        l1.setForeground(new Color(0x5C9393));
        add(l1);

        JButton lg=new JButton("login");
        lg.setBounds(windowwidth/2-50,350,100,30);
        lg.setForeground(new Color(0xffffff));
        lg.setBackground(new Color(0x5C9393));
        lg.setFont(new Font("Arial",Font.BOLD,20));
        lg.setFocusable(false);
        lg.setBorderPainted(false);
        add(lg);
        lg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                dispose();
            }
        });
        lg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lg.setBackground(new Color(0x42FFE9));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lg.setBackground(new Color(0x5C9393));

            }
        });

        JLabel label = new JLabel("<HTML><U>want to create a new account?</U></HTML>");
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setBounds(windowwidth/2-80,390,300,30);
        add(label);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new signin();
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(new Color(0x5C9393));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(new Color(0x000000));

            }
        });



        ImageIcon img =new ImageIcon("A:\\java programming\\java project\\bg.png");

        JLabel bg=new JLabel(img);
        bg.setBounds(0,0,windowwidth,windowheight);
        add(bg);
        setVisible(true);
    }
}


class login extends JFrame
{
    public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static int windowwidth = (int)size.getWidth();
    public static int windowheight = (int)size.getHeight();
    login()
    {
        System.out.println(windowwidth+""+windowheight);
        setLocation(windowwidth/2-400,windowheight/2-200);
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JButton home=new JButton("home");
        home.setBounds(windowwidth-140,20,100,30);
        home.setBorderPainted(false);
        home.setFocusPainted(false);
        home.setBackground(new Color(0xFF5C5C));
        home.setForeground(new Color(0xffffff));
        home.setFont(new Font("Arial",Font.BOLD,15));
        add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setBackground(new Color(0xFF0C0C));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                home.setBackground(new Color(0xFF5C5C));

            }
        });
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new home();
                dispose();
            }
        });

        JLabel user=new JLabel("username");
        user.setBounds(windowwidth/2-100,200,200,30);
        user.setFont(new Font("Arial",Font.BOLD,15));
        user.setForeground(new Color(0xFF5C5C));
        add(user);

        JTextField ui=new JTextField();
        ui.setBounds(windowwidth/2-100,230,250,40);
        ui.setFont(new Font("Arial",Font.PLAIN,15));
        ui.setForeground(new Color(0xFF5C5C));
        ui.setOpaque(false);
        ui.setBorder(new LineBorder(new Color(0xFF5C5C),2));
        add(ui);

        ui.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.setBorder(new LineBorder(new Color(0xFF0C0C),2));
            }
        });


        JLabel pass =new JLabel("password");
        pass.setBounds(windowwidth/2-100,280,200,30);
        pass.setFont(new Font("Arial",Font.BOLD,15));
        pass.setForeground(new Color(0xFF5C5C));
        add(pass);


        JTextField i=new JPasswordField();
        ((JPasswordField) i).setEchoChar('*');
        i.setBounds(windowwidth/2-100,310,250,40);
        i.setFont(new Font("Arial",Font.PLAIN,15));
        i.setForeground(new Color(0xFF5C5C));
        i.setOpaque(false);
        i.setBorder(new LineBorder(new Color(0xFF5C5C),2));
        add(i);

        i.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                i.setBorder(new LineBorder(new Color(0xFF0C0C),2));
            }
        });


        JButton lg=new JButton("login");
        lg.setBounds(windowwidth/2-100,380,250,30);
        lg.setBackground(new Color(0xFF0C0C));
        lg.setForeground(new Color(0xFFFFFF));
        lg.setFont(new Font("Arial",Font.BOLD,18));
        lg.setFocusable(false);
        lg.setBorderPainted(false);
        add(lg);

        lg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file=new File("A:\\java programming\\java project\\database.txt");
                Scanner sc = null;
                try {
                    sc = new Scanner(file);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                // we just need to use \\Z as delimiter
                sc.useDelimiter("\\Z");
                String info=sc.next();
                char infonew[]=info.toCharArray();
                int en=0,un=0;
                int count=0;
                for(int i=1;i<infonew.length-2;i++)
                {
                    if(infonew[i]==',')
                    {
                        count++;
                        if(count==1)
                        {
                            en=i;
                        }
                        if(count==2)
                        {
                            un=i;
                            break;
                        }
                    }
                }
                String emailentered="";
                for(int i=1;i<en;i++)
                {
                    emailentered+=infonew[i];
                }
                String usernameentered="";
                for(int i=en+1;i<un;i++)
                {
                    usernameentered+=infonew[i];
                }
                String passwordentered="";
                for(int i=un+1;i<infonew.length-2;i++)
                {
                    passwordentered+=infonew[i];
                }
                System.out.println(emailentered+","+usernameentered+","+passwordentered);
                if(ui.getText().equals(usernameentered) && i.getText().equals(passwordentered))
                {
                    new homepage();
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"wrong username or password");
                }
            }
        });




        ImageIcon img =new ImageIcon("A:\\java programming\\java project\\loginbg.png");

        JLabel bg=new JLabel(img);
        bg.setBounds(0,0,windowwidth,windowheight);
        add(bg);

        setVisible(true);
    }
}

class signin extends JFrame
{
    public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static int windowwidth = (int)size.getWidth();
    public static int windowheight = (int)size.getHeight();
    signin()
    {
        System.out.println(windowwidth+""+windowheight);
        setLocation(windowwidth/2-400,windowheight/2-200);
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        ImageIcon img =new ImageIcon("A:\\java programming\\java project\\bg3.png");

        JButton home=new JButton("home");
        home.setBounds(windowwidth-140,20,100,30);
        home.setBorderPainted(false);
        home.setFocusPainted(false);
        home.setBackground(new Color(0x37F3C7));
        home.setForeground(new Color(0xffffff));
        home.setFont(new Font("Arial",Font.BOLD,15));
        add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setBackground(new Color(0x218F77));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                home.setBackground(new Color(0x37F3C7));

            }
        });
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new home();
                dispose();
            }
        });

        Label eml=new Label("e-mail:");
        eml.setBounds(windowwidth/2-120,180,100,20);
        eml.setFont(new Font("Arial",Font.BOLD,12));
        eml.setForeground(new Color(0x37F3C7));
        eml.setBackground(new Color(0xFFFFFF));
        add(eml);

        JTextField email=new JTextField();
        email.setBounds(windowwidth/2-120,200,230,30);
        email.setBorder(new LineBorder(new Color(0x37F3C7),2));
        email.setForeground(new Color(0x37F3C7));
        email.setFont(new Font("Arial",Font.PLAIN,15));
        add(email);

//        JButton verify=new JButton("verify");
//        verify.setBounds(windowwidth/2-120,240,230,30);
//        verify.setBackground(new Color(0x37F3C7));
//        verify.setForeground(new Color(0xffffff));
//        verify.setFont(new Font("Arial",Font.BOLD,18));
//        verify.setBorderPainted(false);
//        verify.setFocusPainted(false);
//        add(verify);
//        verify.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String to=email.getText();
//                String from="nani@gmail.com";
//                String host = "172.21.1.4";
//
//                Properties properties = System.getProperties();
//                ((Properties) properties).setProperty("mail.smtp.host", host);
//                Session session = Session.getDefaultInstance(properties);
//
//                try{
//                    MimeMessage message = new MimeMessage(session);
//                    message.setFrom(new InternetAddress(from));
//                    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
//                    message.setSubject("verification");
//                    message.setText("3278254");
//
//                    // Send message
//                    Transport.send(message);
//                    System.out.println("message sent successfully....");
//
//                }catch (MessagingException mex) {mex.printStackTrace();}
//            }
//        });
        Label un=new Label("username:");
        un.setBounds(windowwidth/2-120,240,100,20);
        un.setFont(new Font("Arial",Font.BOLD,12));
        un.setForeground(new Color(0x37F3C7));
        un.setBackground(new Color(0xFFFFFF));
        add(un);


        JTextField user =new JTextField();
        user.setBounds(windowwidth/2-120,260,230,30);
        user.setBorder(new LineBorder(new Color(0x37F3C7),2));
        user.setForeground(new Color(0x37F3C7));
        user.setFont(new Font("Arial",Font.PLAIN,15));
        add(user);

        Label p =new Label("password:");
        p.setBounds(windowwidth/2-120,300,100,20);
        p.setFont(new Font("Arial",Font.BOLD,12));
        p.setForeground(new Color(0x37F3C7));
        p.setBackground(new Color(0xFFFFFF));
        add(p);



        JTextField pass =new JPasswordField();
        ((JPasswordField) pass).setEchoChar('*');
        pass.setBounds(windowwidth/2-120,320,230,30);
        pass.setBorder(new LineBorder(new Color(0x37F3C7),2));
        pass.setForeground(new Color(0x37F3C7));
        pass.setFont(new Font("Arial",Font.PLAIN,15));
        add(pass);

        Label cp =new Label("confirm password:");

        cp.setBounds(windowwidth/2-120,360,100,20);
        cp.setFont(new Font("Arial",Font.BOLD,12));
        cp.setForeground(new Color(0x37F3C7));
        cp.setBackground(new Color(0xFFFFFF));
        add(cp);


        JTextField cpass =new JPasswordField();
        ((JPasswordField) cpass).setEchoChar('*');
        cpass.setBounds(windowwidth/2-120,380,230,30);
        cpass.setBorder(new LineBorder(new Color(0x37F3C7),2));
        cpass.setForeground(new Color(0x37F3C7));
        cpass.setFont(new Font("Arial",Font.PLAIN,15));
        add(cpass);

        JButton signup =new JButton("signup");
        signup.setBounds(windowwidth/2-120,440,230,30);
        signup.setBackground(new Color(0x37F3C7));
        signup.setForeground(new Color(0xffffff));
        signup.setFont(new Font("Arial",Font.BOLD,18));
        signup.setBorderPainted(false);
        signup.setFocusPainted(false);
        add(signup);
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signup.setBackground(new Color(0x218F77));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                signup.setBackground(new Color(0x37F3C7));

            }
        });
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1=pass.getText();
                String s2=cpass.getText();
                if(s1.equals(s2))
                {
                    String em=email.getText();
                    String username=user.getText();
                    String password=pass.getText();
                    try{
                        FileOutputStream fout=new FileOutputStream("A:\\java programming\\java project\\database.txt");
                        String s="{"+em+","+username+","+password+"} ";
                        fout.write(s.getBytes());
                        fout.close();

                        new homepage();
                        dispose();
                    }catch (IOException E){
                        JOptionPane.showMessageDialog(null,"an error has occured please try again.");
//                        System.out.println("an error has occured.");
                    }


                }
                else {
                    JOptionPane.showMessageDialog(null,"please enter same password in both fields.");
                }
            }
        });





        Label l=new Label("");
        l.setBackground(new Color(0xFFFFFF));
        l.setBounds(windowwidth/2-150,130,300,400);
        add(l);

        JLabel bg=new JLabel(img);
        bg.setBounds(0,0,windowwidth,windowheight);
        add(bg);
        setVisible(true);
    }
}



class homepage extends JFrame
{
    public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static int windowwidth = (int)size.getWidth();
    public static int windowheight = (int)size.getHeight();
    JButton b[]=new JButton[10];
    JLabel l[]=new JLabel[10];
    JButton book[]=new JButton[10];
    Imagepanel p1;

    homepage()
    {
        System.out.println(windowwidth+""+windowheight);
        setLocation(windowwidth/2-400,windowheight/2-200);
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        ImageIcon img =new ImageIcon("A:\\java programming\\java project\\bg1.png");
        ImageIcon taj=new ImageIcon("A:\\java programming\\java project\\tajnew.png");
        ImageIcon tajd=new ImageIcon("A:\\java programming\\java project\\tajnewd.png");
        ImageIcon qutab=new ImageIcon("A:\\java programming\\java project\\qutab.png");
        ImageIcon qutabd=new ImageIcon("A:\\java programming\\java project\\qutabd.png");
        ImageIcon lake=new ImageIcon("A:\\java programming\\java project\\lakenew.png");
        ImageIcon laked=new ImageIcon("A:\\java programming\\java project\\lakenewd.png");
        ImageIcon sikkim=new ImageIcon("A:\\java programming\\java project\\sikkimnew.png");
        ImageIcon sikkimd=new ImageIcon("A:\\java programming\\java project\\sikkimnewd.png");
        ImageIcon waterfall=new ImageIcon("A:\\java programming\\java project\\waterfallnew.png");
        ImageIcon waterfalld=new ImageIcon("A:\\java programming\\java project\\waterfallnewd.png");
        ImageIcon kajjar=new ImageIcon("A:\\java programming\\java project\\kajjarnew.png");
        ImageIcon kajjard=new ImageIcon("A:\\java programming\\java project\\kajjarnewd.png");
        ImageIcon ladakh=new ImageIcon("A:\\java programming\\java project\\ladakhnew.png");
        ImageIcon ladakhd=new ImageIcon("A:\\java programming\\java project\\ladakhnewd.png");
        ImageIcon flowervalley=new ImageIcon("A:\\java programming\\java project\\flowervalleynew.png");
        ImageIcon flowervalleyd=new ImageIcon("A:\\java programming\\java project\\flowervalleynewd.png");
        ImageIcon munnar=new ImageIcon("A:\\java programming\\java project\\munnarnew.png");
        ImageIcon munnard=new ImageIcon("A:\\java programming\\java project\\munnarnewd.png");
        ImageIcon varanasi=new ImageIcon("A:\\java programming\\java project\\varanasinew.png");
        ImageIcon varanasid=new ImageIcon("A:\\java programming\\java project\\varanasinewd.png");

        for(int i=0;i<10;i++)
        {
            l[i]=new JLabel("");
            l[i].setBounds(0,0,0,0);
            add(l[i]);
        }

        p1=new Imagepanel(img.getImage());
        p1.setLayout(null);
        JLabel p1bg=new JLabel(img);
        p1bg.setBounds(0,0,windowwidth,windowheight);



        JPanel p2=new JPanel();
        p2.setLayout(null);


        JTabbedPane jtp=new JTabbedPane();
        jtp.setBounds(0,0,windowwidth,windowheight);
        int ctr=70;
        for(int i=0;i<5;i++)
        {
            l[i]=new JLabel("");
            l[i].setBounds(ctr+(i*300),20,300,300);
            l[i].setForeground(new Color(0xFFFFFF));
            l[i].setFont(new Font("Arial",Font.BOLD,30));
            p1.add(l[i]);
            ctr+=5;
        }
        ctr=70;
        for(int i=5;i<10;i++)
        {
            l[i]=new JLabel("");
            l[i].setBounds(ctr+((i-5)*300),360,300,300);
            l[i].setForeground(new Color(0xFFFFFF));
            l[i].setFont(new Font("Arial",Font.BOLD,30));
            p1.add(l[i]);
            ctr+=5;
        }

        ctr=5;
        for(int i=0;i<5;i++)
        {
            if(i==0) {
                b[i] = new JButton("Taj mahal", taj);
            }
            if(i==1) {
                b[i] = new JButton("Qutab minar", qutab);
            }
            if(i==2) {
                b[i] = new JButton("Dal-lake", lake);
            }
            if(i==3) {
                b[i] = new JButton("Ladakh", ladakh);
            }
            if(i==4) {
                b[i] = new JButton("Munnar", munnar);
            }
            book[i]=new JButton("Book now");
            book[i].setBounds(ctr+(i*300),335,300,40);
            b[i].setBounds(ctr+(i*300),30,300,300);
            p1.add(b[i]);
            p1.add(book[i]);
            ctr+=5;
        }
        ctr=5;
        for(int i=5;i<10;i++)
        {
            if(i==5) {
                b[i] = new JButton("Waterfalls-Dudhsagar", waterfall);
            }
            if(i==6) {
                b[i] = new JButton("Sikkim", sikkim);
            }
            if(i==7) {
                b[i] = new JButton("Kajjar", kajjar);
            }
            if(i==8) {
                b[i] = new JButton("Varanasi", varanasi);
            }
            if(i==9) {
                b[i] = new JButton("Flower valley", flowervalley);
            }
            book[i]=new JButton("Book now");
            book[i].setBounds(ctr+((i-5)*300),685,300,40);
            b[i].setBounds(ctr+((i-5)*300),380,300,300);
            p1.add(b[i]);
            p1.add(book[i]);
            ctr+=5;
        }


        for(int i=0;i<10;i++)
        {
            b[i].setFocusable(false);
            b[i].setBorderPainted(false);
//            b[i].setOpaque(true);
            b[i].setContentAreaFilled(false);
            b[i].setForeground(new Color(0xFFFFFF));
            b[i].setFont(new Font("Arial",Font.BOLD,20));
//            b[i].addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    animate();
//                }
//                public void mouseExited(MouseEvent e){
//                    disappear();
//                }
//            });

            book[i].setBorderPainted(false);
            book[i].setFocusable(false);
            book[i].setForeground(new Color(0xFFFFFF));
            book[i].setFont(new Font("Arial",Font.BOLD,20));
            book[i].setBackground(new Color(0x2ED9FF));
            int finalI = i;
            book[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    book[finalI].setBackground(new Color(0x228BA6));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    book[finalI].setBackground(new Color(0x2ED9FF));
                }
            });
            String location=b[i].getText();
            book[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame f=new JFrame("booking");
                    f.setLocation(windowwidth/2-200,windowheight/2-350);
                    f.setSize(400,700);
                    f.setResizable(false);
                    f.setLayout(null);

                    Label l1=new Label("location : "+location);
                    l1.setFont(new Font("Arial",Font.PLAIN,20));
                    l1.setForeground(new Color(0xFFFFFF));
                    l1.setBackground(new Color(0x30DBFF));
                    l1.setBounds(50,50,200,80);
                    f.add(l1);

                    Label l2 =new Label("your location :");
                    l2.setFont(new Font("Arial",Font.PLAIN,20));
                    l2.setForeground(new Color(0xFFFFFF));
                    l2.setBackground(new Color(0x30DBFF));
                    l2.setBounds(50,150,130,80);
                    f.add(l2);

                    JTextField entry=new JTextField();
                    entry.setBounds(180,180,200,30);
                    f.add(entry);

                    Label l3 =new Label("vehicle :");
                    l3.setFont(new Font("Arial",Font.PLAIN,20));
                    l3.setForeground(new Color(0xFFFFFF));
                    l3.setBackground(new Color(0x30DBFF));
                    l3.setBounds(50,220,130,80);
                    f.add(l3);

                    String vehicle[]={"select","Bike","Bus","Train","Aeroplane","Cruice","Blimp","Car"};
                    JComboBox options=new JComboBox(vehicle);
                    options.setBounds(180,250,200,30);
                    f.add(options);

                    Label l4 =new Label("Price : 10000rs");
                    l4.setFont(new Font("Arial",Font.PLAIN,20));
                    l4.setForeground(new Color(0xFFFFFF));
                    l4.setBackground(new Color(0x30DBFF));
                    l4.setBounds(50,300,180,80);
                    f.add(l4);

                    Label l5 =new Label("also want :");
                    l5.setFont(new Font("Arial",Font.PLAIN,20));
                    l5.setForeground(new Color(0xFFFFFF));
                    l5.setBackground(new Color(0x30DBFF));
                    l5.setBounds(50,400,100,80);
                    f.add(l5);

                    JCheckBox c1=new JCheckBox("Hotel(5000/-)");
                    c1.setBounds(180,430,200,30);
                    c1.setFont(new Font("Arial",Font.PLAIN,15));
                    c1.setForeground(new Color(0xffffff));
                    c1.setBackground(new Color(0x30DBFF));
                    f.add(c1);

                    JCheckBox c2 =new JCheckBox("Car(2000/-)");
                    c2.setBounds(180,470,200,30);
                    c2.setFont(new Font("Arial",Font.PLAIN,15));
                    c2.setForeground(new Color(0xffffff));
                    c2.setBackground(new Color(0x30DBFF));
                    f.add(c2);

                    JCheckBox c3 =new JCheckBox("Guide(1000/-)");
                    c3.setBounds(180,510,200,30);
                    c3.setFont(new Font("Arial",Font.PLAIN,15));
                    c3.setForeground(new Color(0xffffff));
                    c3.setBackground(new Color(0x30DBFF));
                    f.add(c3);

                    JButton update=new JButton("update");
                    update.setBounds(50,550,300,40);
                    update.setBorderPainted(false);
                    update.setFocusPainted(false);
                    update.setForeground(new Color(0x30DBFF));
                    update.setBackground(new Color(0xffffff));
                    update.setFont(new Font("Arial",Font.PLAIN,24));
                    f.add(update);
                    update.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
//                            String v=options.get;
                            String price="Price :";
                            int sum=10000;
                            if(c1.isSelected())
                            {
                                sum+=5000;
                            }
                            if(c2.isSelected())
                            {
                                sum+=2000;
                            }
                            if(c3.isSelected())
                            {
                                sum+=1000;
                            }
                            l4.setText(price+sum);
                        }
                    });

                    JButton confirm=new JButton("Confirm");
                    confirm.setBounds(50,600,300,40);
                    confirm.setBorderPainted(false);
                    confirm.setFocusPainted(false);
                    confirm.setForeground(new Color(0x30DBFF));
                    confirm.setBackground(new Color(0xffffff));
                    confirm.setFont(new Font("Arial",Font.PLAIN,24));
                    f.add(confirm);
                    confirm.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null,"you booking is confirmed,we will further inform you through your mail.");
                            f.dispose();
                        }
                    });


                    Label lbg=new Label("");
                    lbg.setBackground(new Color(0x30DBFF));
                    lbg.setBounds(0,0,400,700);
                    f.add(lbg);

                    f.setVisible(true);
                }
            });

        }



        l[0].setText(b[0].getText());
        l[1].setText(b[1].getText());
        l[2].setText(b[2].getText());
        l[3].setText(b[3].getText());
        l[4].setText(b[4].getText());
        l[5].setText("WaterFall");
        l[6].setText(b[6].getText());
        l[7].setText(b[7].getText());
        l[8].setText(b[8].getText());
        l[9].setText(b[9].getText());

        p1.add(p1bg);

        b[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[0].setIcon(tajd);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b[0].setIcon(taj);
            }
        });

        b[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[1].setIcon(qutabd);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b[1].setIcon(qutab);

            }
        });
        b[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[2].setIcon(laked);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                b[2].setIcon(lake);

            }
        });

        b[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[3].setIcon(ladakhd);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b[3].setIcon(ladakh);

            }
        });

        b[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[4].setIcon(munnard);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b[4].setIcon(munnar);

            }
        });

        b[5].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[5].setIcon(waterfalld);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b[5].setIcon(waterfall);

            }
        });

        b[6].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[6].setIcon(sikkimd);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b[6].setIcon(sikkim);

            }
        });

        b[7].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[7].setIcon(kajjard);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b[7].setIcon(kajjar);

            }
        });
        b[8].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[8].setIcon(varanasid);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b[8].setIcon(varanasi);

            }
        });
        b[9].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b[9].setIcon(flowervalleyd);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                b[9].setIcon(flowervalley);

            }
        });



        // p2-->profile

        File file=new File("A:\\java programming\\java project\\database.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // we just need to use \\Z as delimiter
        sc.useDelimiter("\\Z");
        String info=sc.next();
        char infonew[]=info.toCharArray();
        int en=0,un=0;
        int count=0;
        for(int i=1;i<infonew.length-2;i++)
        {
            if(infonew[i]==',')
            {
                count++;
                if(count==1)
                {
                    en=i;
                }
                if(count==2)
                {
                    un=i;
                    break;
                }
            }
        }
        String emailentered="";
        for(int i=1;i<en;i++)
        {
            emailentered+=infonew[i];
        }
        String usernameentered="";
        for(int i=en+1;i<un;i++)
        {
            usernameentered+=infonew[i];
        }
        String passwordentered="";
        for(int i=un+1;i<infonew.length-2;i++)
        {
            passwordentered+=infonew[i];
        }



        JLabel l1=new JLabel("username :");
        l1.setBounds(windowwidth/2-200,100,200,40);
        l1.setFont(new Font("Arial",Font.PLAIN,20));
        l1.setForeground(new Color(0x1883DA));
        p2.add(l1);

        JLabel l2 =new JLabel(usernameentered);
        l2.setBounds(windowwidth/2-80,100,200,40);
        l2.setFont(new Font("Arial",Font.PLAIN,20));
        l2.setForeground(new Color(0x1883DA));
        p2.add(l2);


        JLabel l3 =new JLabel("email :");
        l3.setBounds(windowwidth/2-200,130,200,40);
        l3.setFont(new Font("Arial",Font.PLAIN,20));
        l3.setForeground(new Color(0x1883DA));
        p2.add(l3);

        JLabel l4 =new JLabel(emailentered);
        l4.setBounds(windowwidth/2-80,130,200,40);
        l4.setFont(new Font("Arial",Font.PLAIN,20));
        l4.setForeground(new Color(0x1883DA));
        p2.add(l4);




        p2.add(p1bg);


        jtp.add("Locations",p1);
        jtp.add("Profile",p2);
        jtp.setRequestFocusEnabled(false);


        jtp.setFont(new Font("Arial",Font.BOLD,15));
        add(jtp);




        setVisible(true);
    }

    void animate()
    {
        int ctr=5;

        for(int i=0;i<5;i++)
        {
            String name=b[i].getText();
            if(i==0)
                l[i].setText("Taj mahal");
            if(i==1)
                l[i].setText("Qutab minar");
            if(i==2)
                l[i].setText("Dal-lake");
            if(i==3)
                l[i].setText("Ladakh");
            if(i==4)
                l[i].setText("Munnar");
            l[i].setBounds(ctr+(i*300),30,300,300);
            p1.add(b[i]);
            ctr+=5;
        }
        ctr=5;
        for(int i=5;i<10;i++)
        {
            String name=b[i].getText();
            l[i].setText("Location : "+name);
            l[i].setBounds(ctr+((i-5)*300),380,300,300);
//            p1.add(b[i]);
            ctr+=5;
        }
    }

    void disappear()
    {
        for(int i=0;i<10;i++)
        {
            l[i].setText("");
        }
    }


}



class Imagepanel extends JPanel
{
    private Image img;
    public Imagepanel(String img){
        this(new ImageIcon(img).getImage());
    }

    public Imagepanel(Image img)
    {
        this.img=img;
        Dimension size=new Dimension(img.getWidth(null),img.getHeight(null));
        setPreferredSize(size);
        setMaximumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }


}