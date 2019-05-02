import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class RightClickMenu extends JPopupMenu implements ActionListener {

	PostItNoteFrame note;
	
	public RightClickMenu(PostItNoteFrame PINObject) {
		JMenuItem Cut = new JMenuItem("Cut");
		Cut.addActionListener(this);
		this.add(Cut);
		JMenuItem Copy = new JMenuItem("Copy");
		Copy.addActionListener(this);
		this.add(Copy);
		JMenuItem Paste = new JMenuItem("Paste");
		Paste.addActionListener(this);
		this.add(Paste);
		JMenuItem About = new JMenuItem("About");
		About.addActionListener(this);
		this.add(About);
		JMenuItem Exit = new JMenuItem("Exit");
		Exit.addActionListener(this);
		this.add(Exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){

		case "Cut":
		System.out.println("Cut Post-It note application.");
		break;
		case "Copy":
		System.out.println("Copying Post-It note application.");
		if (note.getPostItNoteContent().getSelectedText() != null) {
			note.setCopiedText(note.getPostItNoteContent().getSelectedText());
			System.out.println("Copied text: " + note.getCopiedText());
			}else {
				break;
			}
		
		break;
		
		case "Paste":
		System.out.println("Paste Post-It note application.");
		break;
		case "About":
		System.out.println("About Post-It note application.");
			 AboutPostItNote p1 = new AboutPostItNote(note);
	        
		
		break;
		case "Exit":
		System.out.println("Exiting Post-It note application.");
		System.exit(0);
		break;

		}
		
		
	}

}
