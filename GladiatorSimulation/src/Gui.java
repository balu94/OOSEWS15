import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
	
	Arena arena = new Arena();
	// Hilfsvariablen
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
	
	Gui(String title){
		super(title);
		
		_label = new JLabel("Geldbetrag: "+_geld+" Sesterzen");
		add(_label, java.awt.BorderLayout.NORTH);
		
		txtKampfBericht = new JTextArea(10,10);
//		add(txtKampfBericht, java.awt.BorderLayout.CENTER);
		
		_cboGladiator = new JComboBox();
		_cboGladiator.addItem(arena.uebergabeGlad1());
		_cboGladiator.addItem(arena.uebergabeGlad2());
		add(_cboGladiator, java.awt.BorderLayout.WEST);
		
		scroll = new JScrollPane(txtKampfBericht);
		this.getContentPane().add(scroll, java.awt.BorderLayout.CENTER);
		
		_wettbetrag = new JTextField("Wettbetrag");
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
				txtKampfBericht.setText("Los gehts!");
				txtKampfBericht.append("TEST");
				arena.starteKampf();
				
			}
		});
		
//		this.pack(); // Fenster an Komponenten anpassen
		
		setSize(400,400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zum sauberen Beenden
		
	}
	

/*	public static void main(String[] args) {
		
		new Gui("Gladiatorenwette");

	}*/

}
