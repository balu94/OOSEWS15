import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements IReporter {

	private Arena _arena;
	float _geld = 100;
	float _einsatz = 0;
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
		// this.giveNewMessage("test");

		_label = new JLabel("Geldbetrag: " + _geld + " Sesterzen");
		add(_label, java.awt.BorderLayout.NORTH);

		txtKampfBericht = new JTextArea(10, 10);
		// add(txtKampfBericht, java.awt.BorderLayout.CENTER);

		_cboGladiator = new JComboBox<Gladiator>();
		_cboGladiator.addItem(_arena.getGlad1());
		_cboGladiator.addItem(_arena.getGlad2());
		_cboGladiator.setSelectedItem("Wähle.."); // -> Vorauswahl deaktivieren
		add(_cboGladiator, java.awt.BorderLayout.WEST);

		scroll = new JScrollPane(txtKampfBericht);
		this.getContentPane().add(scroll, java.awt.BorderLayout.CENTER);

		_wettbetrag = new JTextField();
		_wettbetrag.setPreferredSize(new Dimension(50, 30));
		JPanel jpan = new JPanel();
		// add(_wettbetrag, java.awt.BorderLayout.EAST);

		add(jpan, java.awt.BorderLayout.EAST);
		jpan.add(_wettbetrag, java.awt.BorderLayout.CENTER);

	/*	JButton b1 = new JButton("Kämpfe");
		jpan.add(b1, java.awt.BorderLayout.NORTH);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				_label.setText("Geldbetrag: " + _geld + " Sesterzen");
				// Gladiator ausgewaehlt ?
				if (_cboGladiator.getSelectedIndex() != -1) {
					_gladGewettet = (Gladiator) _cboGladiator.getSelectedItem();
					System.out.println(_cboGladiator.getSelectedIndex());
					// _txtkampfbericht.setText("" + _gladwettet.getName());
				} else {// if (_cboGladiator.getSelectedItem()== null) {
					JOptionPane.showMessageDialog(null,
							"Keinen Gladiator ausgewaehlt.\nBitte einen Gladiator auswaehlen", "Fehlermeldung",
							JOptionPane.ERROR_MESSAGE);
				}
				try {
					if (!_wettbetrag.getText().equals(" ") && (0 < Float.parseFloat(_wettbetrag.getText())
							&& Float.parseFloat(_wettbetrag.getText()) <= _geld)) {
						_einsatz = Float.parseFloat(_wettbetrag.getText());

					} else {
						// wenn zu viel oder kein Betrag eingegeben wird kommt
						// eine Errormeldung
						JOptionPane.showMessageDialog(null, "kein gueltiger betrag", "fehlermeldung",
								JOptionPane.ERROR_MESSAGE);
						_arena.starteKampf(); // Kampf starten

					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "kein gueltiger betrag", "fehlermeldung",
							JOptionPane.ERROR_MESSAGE);
				}

				Gladiator sieger;
				// ermitteln wer gewonen hat
				if (_arena._glad1._le > _arena._glad2._le) {
					sieger = _arena._glad1;
				} else {
					sieger = _arena._glad2;
				}

				// ermitteln ob auf sieger gesetzt wurde
				if (_gladGewettet.getName().equals(sieger.getName())) { // besser
																		// equals
																		// methode
																		// überschreiben
					_geld = _geld + _einsatz;

					if (JOptionPane.showConfirmDialog(null, "Möchtest du weiter spielen?", "JA ODER NEIN ",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
						// _arena=new Arena();
						_arena.waehleNeueGladiatoren();
						_cboGladiator.removeAllItems();
						_cboGladiator.addItem(_arena._glad1);
						_cboGladiator.addItem(_arena._glad2);
						txtKampfBericht.setText("");
						_wettbetrag.setText("");
						_label.setText("Geldbetrag: " + _geld + " Sesterzen");

					} else {
						System.exit(0);
					}
				} else {
					_geld = _geld - _einsatz;
					if (_geld == 0) {
						JOptionPane.showMessageDialog(null, "Verlust", "Du bist pleite. ", JOptionPane.ERROR_MESSAGE);
						System.exit(0);

					} else {
						if (JOptionPane.showConfirmDialog(null, "Verlust moechtest du weiterspielen?", "JA ODER NEIN ",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
							_arena.waehleNeueGladiatoren();
							// _arena= new Arena(); // neue Arena erzeugen? oder
							// nur neue Gladiatoren
							_cboGladiator.removeAllItems();
							_cboGladiator.addItem(_arena._glad1);
							_cboGladiator.addItem(_arena._glad2);
							txtKampfBericht.setText("");
							_wettbetrag.setText("");
							_label.setText("Geldbetrag: " + _geld + " Sesterzen");
						} else {
							System.exit(0);
						}
					}
				}

				
				 * _arena=new arena(); _cboGladiator.removeAllItems();
				 * _cboGladiator.addItem(_arena._glad1);
				 * _cboGladiator.addItem(_arena._glad2);
				 
			}

		});*/

		
			

			starteKampf = new JButton("Starte Kampf");
			add(starteKampf, java.awt.BorderLayout.SOUTH);
			starteKampf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (_cboGladiator.getSelectedItem() == _arena._glad1
						|| _cboGladiator.getSelectedItem() == _arena._glad2) {
					_gladGewettet = (Gladiator) _cboGladiator.getSelectedItem();
				} else {
					JOptionPane.showMessageDialog(null, "Es wurde kein gueltiger Gladiator ausgewählt", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				// _wettbetrag parsen und prüfen ob genug Geld vorhanden ist
				try {
					if (!_wettbetrag.getText().equals(" ") && (0 < Float.parseFloat(_wettbetrag.getText())
							&& Float.parseFloat(_wettbetrag.getText()) <= _geld)) {
						_einsatz = Float.parseFloat(_wettbetrag.getText());
						_arena.starteKampf(); // Kampf starten

					} /*
						 * else { // wenn zu viel oder kein Betrag eingegeben
						 * wird kommt // eine Errormeldung
						 * JOptionPane.showMessageDialog(null,
						 * "Kein gültiger Betrag", "Fehlermeldung",
						 * JOptionPane.ERROR_MESSAGE);
						 * 
						 * }// eleganter mit try-catch
						 */
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Kein gültiger betrag", "Fehlermeldung",
							JOptionPane.ERROR_MESSAGE);
				}

				Gladiator sieger;
				// ermitteln wer gewonen hat
				if (_arena._glad1._le > _arena._glad2._le) {
					sieger = _arena._glad1;
				} else {
					sieger = _arena._glad2;
				}

				// ermitteln ob auf sieger gesetzt wurde
				if (_gladGewettet.getName().equals(sieger.getName())) { // besser
																		// equals
																		// methode
																		// überschreiben
					_geld = _geld + _einsatz;

					if (JOptionPane.showConfirmDialog(null, "Möchtest du weiter spielen?", "JA ODER NEIN ",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
						// _arena=new Arena();
						_arena.waehleNeueGladiatoren();
						_cboGladiator.removeAllItems();
						_cboGladiator.addItem(_arena._glad1);
						_cboGladiator.addItem(_arena._glad2);
						txtKampfBericht.setText("");
						_wettbetrag.setText("");
						_label.setText("Geldbetrag: " + _geld + " Sesterzen");

					} else {
						System.exit(0);
					}
				} else {
					_geld = _geld - _einsatz;
					if (_geld == 0) {
						JOptionPane.showMessageDialog(null, "Verlust", "Du bist pleite. ", JOptionPane.ERROR_MESSAGE);
						System.exit(0);

					} else {
						if (JOptionPane.showConfirmDialog(null, "Verlust möchtest du weiterspielen?", "JA ODER NEIN ",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
							_arena.waehleNeueGladiatoren();
							// _arena= new Arena(); // neue Arena erzeugen? oder
							// nur neue Gladiatoren
							_cboGladiator.removeAllItems();
							_cboGladiator.addItem(_arena._glad1);
							_cboGladiator.addItem(_arena._glad2);
							txtKampfBericht.setText("");
							_wettbetrag.setText("");
							_label.setText("Geldbetrag: " + _geld + " Sesterzen");
						} else {
							System.exit(0);
						}
					}
				}
			}
		});

		// this.pack(); // Fenster an Komponenten anpassen

		setSize(400, 400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zum sauberen
																// Beenden

	}

	@Override
	public void giveNewMessage(String s) {
		txtKampfBericht.setText(txtKampfBericht.getText() + "\n" + s);

		_arena = new Arena(this);

	}

}
