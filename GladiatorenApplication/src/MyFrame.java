import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements IReporter {

	private Arena _arena;
	float _geld = 100;
	float _einsatz =0;
	Gladiator _gladGewettet;
	
	// Gui-Komponenten
	JLabel _label;
	public JTextArea txtKampfBericht;
	public JComboBox<Gladiator> _cboGladiator;
	JTextField _wettbetrag;
	JButton starteKampf;
	JScrollPane scroll;
	
	public MyFrame(String title)
	{
		super(title);
		_arena = new Arena(this);
		//this.giveNewMessage("test");
		
		_label = new JLabel("Geldbetrag: "+_geld+" Sesterzen");
		add(_label, java.awt.BorderLayout.NORTH);
		
		txtKampfBericht = new JTextArea(10,10);
//		add(txtKampfBericht, java.awt.BorderLayout.CENTER);
		
		_cboGladiator = new JComboBox();
		_cboGladiator.addItem(_arena.getGlad1());
		_cboGladiator.addItem(_arena.getGlad2());
		add(_cboGladiator, java.awt.BorderLayout.WEST);
		
		scroll = new JScrollPane(txtKampfBericht);
		this.getContentPane().add(scroll, java.awt.BorderLayout.CENTER);
		
		_wettbetrag = new JTextField();
		_wettbetrag.setPreferredSize(new Dimension(50, 30));
		JPanel jpan = new JPanel();
//		add(_wettbetrag, java.awt.BorderLayout.EAST);
		
		add(jpan,java.awt.BorderLayout.EAST);
		jpan.add(_wettbetrag, java.awt.BorderLayout.CENTER);
		
		starteKampf = new JButton("Starte Kampf");
		add(starteKampf, java.awt.BorderLayout.SOUTH);
		starteKampf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				_arena.starteKampf();  // Kampf starten
				
			}
		});
		
//		this.pack(); // Fenster an Komponenten anpassen
		
		setSize(400,400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zum sauberen Beenden
		
	}
	
	
	@Override
	public void giveNewMessage(String s) {
		txtKampfBericht.setText(txtKampfBericht.getText()+"\n"+s);
		
		_arena = new Arena(this);
		
	}
	
	
}
