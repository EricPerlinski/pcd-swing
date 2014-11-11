package vue;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




import compteur.Compteur;

public class vueCompteur extends JPanel{
	
	private static final long serialVersionUID = -1094533206550892947L;
	
	private Compteur c;
	private JButton decButton;
	private JButton incButton;
	private JLabel borneInf;
	private JLabel borneSup;
	private JLabel valCompteur;
	
	vueCompteur(final Compteur c) {
	
		this.c = c;
		
		borneInf = new JLabel();
		borneInf.setText(Integer.toString(this.c.getBorneInf()));
		borneInf.setPreferredSize(new Dimension( 60, 24 ));
		borneInf.setFont(new Font("Serif", Font.PLAIN, 16));
		this.add(borneInf);
		
	
		valCompteur = new JLabel();
		valCompteur.setPreferredSize(new Dimension( 60, 24 ));
		valCompteur.setFont(new Font("Serif", Font.BOLD, 22));
		valCompteur.setText(Integer.toString(this.c.getNombre()));
		this.add(valCompteur);
		
		borneSup = new JLabel();
		borneSup.setFont(new Font("Serif", Font.PLAIN, 16));
		borneSup.setPreferredSize(new Dimension( 60, 24 ));
		borneSup.setText(Integer.toString(this.c.getBorneSup()));
		this.add(borneSup);
		
		
		
		
		this.decButton = new JButton(" - ");
		this.decButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				if(!(vueCompteur.this.c.compteurDecremente())){
					JOptionPane.showMessageDialog(null, "Le compteur a atteint la borne inferieure !", "Attention", JOptionPane.INFORMATION_MESSAGE);
				}
				borneInf.setText(Integer.toString(c.getBorneInf()));
				borneSup.setText(Integer.toString(c.getBorneSup()));
				valCompteur.setText(Integer.toString(c.getNombre()));
				
			}
		});
		this.add(decButton);
		
		
		this.incButton = new JButton(" + ");
		incButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(vueCompteur.this.c.compteurIncremente())){
					JOptionPane.showMessageDialog(null, "Le compteur a atteint la borne superieur !", "Attention", JOptionPane.INFORMATION_MESSAGE);
				}
				System.out.println(vueCompteur.this.c.toString());
				borneInf.setText(Integer.toString(c.getBorneInf()));
				borneSup.setText(Integer.toString(c.getBorneSup()));
				valCompteur.setText(Integer.toString(c.getNombre()));
			}
		});
		this.add(incButton);
	
	}
	
	public Compteur getC() {
		return c;
	}

	public void setC(Compteur c) {
		this.c = c;
		borneInf.setText(Integer.toString(this.c.getBorneInf()));
		borneSup.setText(Integer.toString(this.c.getBorneSup()));
		valCompteur.setText(Integer.toString(this.c.getNombre()));
	
	}
	
}
