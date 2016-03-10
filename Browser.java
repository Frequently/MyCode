package Default;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Browser extends JFrame{
	
	JTextField text ;
	JEditorPane pane;
	
	public Browser()
	{
		setTitle("My Browser");
		setSize(300,400);
		setVisible(true);
		
		text = new JTextField("Enter a valid URL");
		pane = new JEditorPane();
		pane.setEditable(false);
		
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				loadUrl(text.getText());
			}
		});
		
		pane.addHyperlinkListener(new HyperlinkListener() {
			
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				// TODO Auto-generated method stub
				if(e.getEventType() == HyperlinkEvent.EventType.ENTERED)
				{
					loadUrl(e.getURL().toString());
				}
			}
		});
		
		
		add(text,BorderLayout.NORTH);
		add(new JScrollPane(pane),BorderLayout.CENTER);
	}
	
	public void loadUrl(String  u)
	{
		try {
			URL url = new URL(u);
			
				pane.setPage(url);
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
