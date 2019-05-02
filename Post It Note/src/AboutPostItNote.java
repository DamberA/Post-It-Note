import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
 
//About screen
public class AboutPostItNote extends JDialog implements ActionListener {
   
    public AboutPostItNote(PostItNoteFrame aboutFrame){
       
        setModal(true);
        setSize(200,200);
        setTitle("About Post-IT Note");
        setLayout(new BorderLayout());
        add(gridInfo(),BorderLayout.CENTER);
        add(createOkButton(),BorderLayout.SOUTH);
       
        setVisible(true);
    }
   
    private Component createOkButton() {
        FlowLayout buttonLayout = new FlowLayout(FlowLayout.CENTER);
        JPanel ButtonPannel = new JPanel();
        ButtonPannel.setLayout(buttonLayout);
       
        JButton ok = new JButton("OK");
        ok.setActionCommand("CloseAbout");
        ok.addActionListener(this);
       
        ButtonPannel.add(ok);
        
        return ButtonPannel;
    }
 
    private JPanel gridInfo(){
        JPanel labelPanel = new JPanel();
       
        labelPanel.setLayout(new GridLayout(0,1));
        labelPanel.add(new JLabel("Post-IT Note using Swing"));
        labelPanel.add(new JLabel("Version 1.1"));
        labelPanel.add(new JLabel("Copyright: (c) 2017"));
           
        return labelPanel;
    }
   
   
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CloseAbout")){
            this.dispose();
        }
       
    }
 
}