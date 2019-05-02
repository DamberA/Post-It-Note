import	java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PostItNoteFrame extends JFrame implements ActionListener,MouseListener, MouseMotionListener{
	JButton newPostItNote;
	JButton deletePostItNote;
	
	JScrollPane postItNoteScroll;
	JTextArea postItNoteContent;
	

	private JTextArea selectedText;
	public void setPostItNoteContent(JTextArea postItNoteContent) {
		this.postItNoteContent = postItNoteContent;
	}
	
	public JTextArea getPostItNoteContent() {
		return postItNoteContent;
	}
	public void setCopiedText(String selectedText) {
		this.selectedText = postItNoteContent;
		
	}
	public JTextArea getCopiedText() {
		return selectedText;
	}


	private Color bodyColor = new Color(253, 253, 201);
	private Color titleColor = new Color(248, 247, 182);
	private Font buttonFont = new Font("Arial", Font.BOLD, 30);
	
	private void createMenu(MouseEvent e) {
		RightClickMenu menu = new RightClickMenu(this);
		menu.show(e.getComponent(), e.getX(), e.getY());		
	}
	public void mouseClicked(MouseEvent e) {
		
	}
	private Point initialClick;
	
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
//		initialClick = e.getPoint();


		if (e.isPopupTrigger()){
			createMenu(e);
			}

	}
	
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()){
			createMenu(e);
			}
	}
	public void mouseEntered(MouseEvent e) {	
	}
	public void mouseExited(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("CreateNewPostItNote")) {
			PostItNote.incPostItNoteCount();
			
			Point startLoc = this.getLocation();
			startLoc.x = startLoc.x+this.getWidth();
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			if (startLoc.x > screen.width - getWidth()){
			//If so move down y and reset x pos
			startLoc.x = 0;
			startLoc.y += this.getHeight();
			}
			PostItNoteFrame note = new PostItNoteFrame(startLoc, new Point(200,200));
			

			
		}
		else if (e.getActionCommand().equals("DeletePostItNote")){
			this.dispose();	
			
			PostItNote.decPostItNoteCount();
			if (PostItNote.getPostItNoteCount() == 0) {
				System.exit(0);
			}

				
			}

	}
	PostItNoteFrame(Point startLoc, Point dim) {
		 this(dim);
		 this.setLocation(startLoc);
		 
		}
	
	public PostItNoteFrame(Point dim) {
		this.setSize(new Dimension(dim.x, dim.y));
		this.setTitle("Post-It Note");
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);	
		this.createButtonArea();
//		this.createContent();
		
		JTextArea postItNoteContent = new JTextArea();
		JScrollPane postItNoteScroll = new JScrollPane (postItNoteContent);
		this.add(postItNoteScroll, BorderLayout.CENTER);
		
		// body color and removes connected bar.
		postItNoteContent.setBackground(bodyColor);
		postItNoteScroll.setBorder(null);
		postItNoteContent.setMargin(new Insets(10,10,10,10));

		this.addMouseListener(this);
//		this.setUndecorated(true);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	private JPanel createButtonArea(){
		JPanel buttonArea = new JPanel();
		buttonArea.setBackground(titleColor);
		this.add(buttonArea, BorderLayout.NORTH);
		
		buttonArea.setLayout(new BorderLayout());
		
		newPostItNote = new JButton("+");
		newPostItNote.setBackground(titleColor);
		newPostItNote.setOpaque(true);
		newPostItNote.setBorderPainted(false);
		newPostItNote.setFont(buttonFont);
		newPostItNote.setForeground(Color.GRAY);
		
		newPostItNote.setActionCommand("CreateNewPostItNote");
		newPostItNote.addActionListener(this);
				
		buttonArea.add(newPostItNote, BorderLayout.WEST);
		
		deletePostItNote = new JButton("x");
		deletePostItNote.setBackground(titleColor);
		deletePostItNote.setOpaque(true);
		deletePostItNote.setBorderPainted(false);
		deletePostItNote.setFont(buttonFont);
		deletePostItNote.setForeground(Color.GRAY);
		
		deletePostItNote.setActionCommand("DeletePostItNote");
		deletePostItNote.addActionListener(this);
		
		buttonArea.add(deletePostItNote, BorderLayout.EAST);
		
		return buttonArea;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	


