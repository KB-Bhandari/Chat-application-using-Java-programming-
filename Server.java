 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
/**
 *
 * @author hp
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.net.*;
import java.io.*;
/**juyy6
 *
 * @author hp
 */
public class Server   implements ActionListener{
    
    
   static JFrame f=new JFrame();
   static JTextField text;
   static JPanel p2, chatPanel;
   static JScrollPane scroll;
   static JPanel rightAlignPanel;                           
           static JScrollBar vertical;
   static DataOutputStream data_Out;
   JPanel p1;
      Server(){
//        setLayout(null);
       f.setTitle("Meet App");
       f.setLocation(200,50);
        p1= new JPanel( new BorderLayout());
        p1.setBackground(new Color(7,94,84));
//        p1.setBounds(0,0,450,70);
        p1.setPreferredSize(new Dimension(400,70));
        
//          add(p1);
//        p1.setLayout(null);

        //Left Panel
        JPanel leftPanel=new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        
        f.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent e){
//                p1.setBounds(0,0,getWidth(),70);
            }
        });
        
        //Arrow button
        ImageIcon icon= new ImageIcon("C:/Users/hp/Documents/NetBeansProjects/ChatApp/src/main/java/com/mycompany/icons/arrow.jpg");
        Image scaledImg=icon.getImage().getScaledInstance(25,25 ,Image.SCALE_DEFAULT);
        ImageIcon scaledIcon= new ImageIcon(scaledImg);
        JLabel backIcon=new JLabel(scaledIcon);
        backIcon.setBounds(5,20,25,25);
        leftPanel.add(backIcon);
        
        backIcon.addMouseListener( new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
            
        });
        
        //Profile Image
        ImageIcon icon2= new ImageIcon("C:/Users/hp/Documents/NetBeansProjects/ChatApp/src/main/java/com/mycompany/icons/profile1.png");
        Image img=icon2.getImage().getScaledInstance(60,60 ,190);
        ImageIcon scaledProfile= new ImageIcon(img);
        JLabel profile =new JLabel(scaledProfile);
        profile.setBounds(40,10,50,50);
        leftPanel.add(profile);
        
        p1.add(leftPanel,BorderLayout.WEST);
        
        
        //Right Panel
        
        JPanel rightPanel=new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new FlowLayout( FlowLayout.RIGHT,10,10));
        
        //Video Icon
        ImageIcon icon3= new ImageIcon("C:/Users/hp/Documents/NetBeansProjects/ChatApp/src/main/java/com/mycompany/icons/video.png");
        Image img1=icon3.getImage().getScaledInstance(25,25 ,Image.SCALE_DEFAULT);
        ImageIcon scaledVideo= new ImageIcon(img1);
        JLabel videoIcon =new JLabel(scaledVideo);
        videoIcon.setBounds(300,10,30,30);
        rightPanel.add(videoIcon);

        //Call Icon
        ImageIcon icon4= new ImageIcon("C:/Users/hp/Documents/NetBeansProjects/ChatApp/src/main/java/com/mycompany/icons/phone.png");
        Image Img2=icon4.getImage().getScaledInstance(25,25 ,Image.SCALE_DEFAULT);
        ImageIcon scaledCall= new ImageIcon(Img2);
        JLabel callIcon=new JLabel(scaledCall);
        callIcon.setBounds(330,10,30,30);
        rightPanel.add(callIcon);
        
        
        //More option Icon
        ImageIcon icon5= new ImageIcon("C:/Users/hp/Documents/NetBeansProjects/ChatApp/src/main/java/com/mycompany/icons/3icon.png");
        Image Img3=icon5.getImage().getScaledInstance(25,25 ,Image.SCALE_DEFAULT);
        ImageIcon scaledImg3= new ImageIcon(Img3);
        JLabel settingIcon=new JLabel(scaledImg3);
        settingIcon.setBounds(360,10,25,25);
        rightPanel.add(settingIcon);
        
        
        p1.add(rightPanel,BorderLayout.EAST);
        
        
        
        //Profile Name
        JLabel name = new JLabel("Hemlata Bhandari");
        name.setBounds(110,15,100,18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,12));
        leftPanel.add(name);
        
        //Status
        JLabel status = new JLabel("Active Now");
        status.setBounds(110,35,100,18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF",Font.ITALIC,8));
        leftPanel.add(status);
        
        
        //Chat Panel
        
//       
        
        f.setLayout(new BorderLayout());
//        Chat Panel
          chatPanel=new JPanel();
         chatPanel.setLayout(new BoxLayout(chatPanel,BoxLayout.Y_AXIS));
//         chatPanel.setBackground(Color.WHITE);

         chatPanel.setAlignmentY(Component.TOP_ALIGNMENT);
         
//         Wrapper panel, wrap the chatPanel and forces msg to always start from top, not float in the middle
         JPanel wrapper=new JPanel(new BorderLayout());
         wrapper.add(chatPanel,BorderLayout.NORTH);
         
          scroll=new JScrollPane(wrapper);
         scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
         
         f.add(scroll,BorderLayout.CENTER);
        
//         Bottom Panel
        p2= new JPanel(new BorderLayout());

        p2.setBackground(Color.WHITE);

         
        
        //Text 
        text=new JTextField();

         text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        p2.add(text,BorderLayout.CENTER);
       

        
        //Send Button
        JButton send=new JButton("Send");
//        send.setBounds(200,600,100,40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);        
        send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
       
        send.addActionListener(this);
         p2.add(send,BorderLayout.EAST);
//        p2.add(send);

        f.add(p2,BorderLayout.SOUTH);
        f.add(p1,BorderLayout.NORTH);
        
       f.setUndecorated(true);
        f.setSize(400,700);
        f.setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
        String output=text.getText().trim();
//        if(!output.isEmpty()){
            if (!output.isEmpty()) {
             data_Out.writeUTF(output);
            addMessage(output); // sent
//            out.println(output); // send to client
            text.setText("");
        }
            
         
        }catch(Exception e){
           e.printStackTrace();
    }    
       }

            public  static JPanel addMessage(String output){
            JLabel l2=new JLabel("<html><p style='width: 200px; margin:0;'>"+output+"</p></html>");
            l2.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
            l2.setBackground(new Color(220,248,198));
            l2.setOpaque(true);
            l2.setBorder(BorderFactory.createEmptyBorder(5, 5,5,5));
//            msgPanel.add(l2,BorderLayout.EAST);
            
//            Align messgae bubble to right side
            rightAlignPanel=new JPanel(new  FlowLayout(FlowLayout.RIGHT,0,0));
            rightAlignPanel.setOpaque(false);
            rightAlignPanel.setBorder(BorderFactory.createEmptyBorder(2, 2,2,2));
            rightAlignPanel.add(l2);
            chatPanel.add(rightAlignPanel);
            chatPanel.revalidate();
            
            vertical= scroll.getVerticalScrollBar();
           vertical.setValue(vertical.getMaximum());
            
            text.setText("");
            
        //Text Time 
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");
        
        JLabel time=new JLabel(sdf.format(cal.getTime()));
        //time.setText();
        
        rightAlignPanel.add(time);
        
        return rightAlignPanel;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        new Server();
        
        new Thread(() -> {
    try {
        ServerSocket skt = new ServerSocket(6001);
        Socket s = skt.accept(); // Wait for client
        
        DataInputStream data_In = new DataInputStream(s.getInputStream());
        data_Out = new DataOutputStream(s.getOutputStream());
        
        while (true) {
            String msg = data_In.readUTF();
            JPanel panel = addMessage(msg);
            
            JPanel left = new JPanel(new BorderLayout());
            left.add(panel, BorderLayout.LINE_START);
            chatPanel.add(left);
            chatPanel.revalidate();
            
            vertical.setValue(vertical.getMaximum());
            f.validate();
        }
    } catch (Exception e) {
        System.out.println("Error in server thread: " + e.getMessage());
    }
}).start();
    }
        
//        try{
//            //Server with port
//            ServerSocket skt= new ServerSocket(6001);
//            
//            //accept msg infinitly
//            while(true){
//                //Client
//                Socket s=skt.accept();
//                
//                //Data recieve
//                DataInputStream data_In=new DataInputStream(s.getInputStream());
//                
//                //Data sent
//                data_Out=new DataOutputStream(s.getOutputStream());
//                
//                //using protocol to read. it return string
//                while(true){
//                    String msg= data_In.readUTF();    
//                    JPanel panel= addMessage(msg);
//                    
//                    JPanel left=new JPanel(new BorderLayout());
//                    left.add(panel,BorderLayout.LINE_START);
//                    vertical.add(left);
//                    f.validate();
//                    
//                    
//                } 
//            }
//        }catch(Exception e){
////            e.printStackTrace();
//
//            System.out.println("Not connected with client:"+e.getMessage());
//        }
//    }
//    
}

