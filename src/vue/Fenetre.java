package vue;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


import compteur.BorneInfException;
import compteur.Compteur;

public class Fenetre extends JFrame implements Observer,ComponentListener{

	private static final long serialVersionUID = -2225594646240870070L;
	public JMenuBar mb;
	public Compteur c;
	public vueCompteur vc;
		
	public Fenetre(final Compteur c) {
		this.setSize(400, 120);
		this.setMinimumSize(new Dimension(400,120));

		this.setLocationRelativeTo(null);
		this.setTitle("Simple Compteur");
		this.c = c;
		
		this.vc = new vueCompteur(c);
		
		int raccourcisClavier = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() ;

		mb = new JMenuBar();

		JMenu fichier = new JMenu("Fichier");
		JMenu modifier = new JMenu("Modif");
		JMenu intervalle = new JMenu("Intervalle");
		
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Fenetre.this.dispose();
			}
		});
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,raccourcisClavier));
		
		JMenuItem dec = new JMenuItem("-1");
		dec.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(!(c.compteurDecremente())){
					JOptionPane.showMessageDialog(null, "Le compteur a atteint sa valeur minimale", "Attention", JOptionPane.INFORMATION_MESSAGE);
				}
				vc.setC(c);
			}
		});
		dec.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,raccourcisClavier));
		
		
		JMenuItem inc = new JMenuItem("+1");
		inc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(c.compteurIncremente())){
					JOptionPane.showMessageDialog(null, "Le compteur a atteint sa valeur maximale", "Attention", JOptionPane.INFORMATION_MESSAGE);
				}
				vc.setC(c);
			}
		});
		inc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,raccourcisClavier));
		
		
	
		JMenuItem newBorneInf = new JMenuItem("Definir valeur minimale");
		newBorneInf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final nouvelleBorne nouvelle = new nouvelleBorne(true);
				nouvelle.setVisible(true);
				nouvelle.addWindowListener(new WindowListener() {
				
					@Override
					public void windowOpened(WindowEvent arg0) {
					}
					
					@Override
					public void windowIconified(WindowEvent arg0) {
					}
					
					@Override
					public void windowDeiconified(WindowEvent arg0) {
					}
					
					@Override
					public void windowDeactivated(WindowEvent arg0) {
						if(nouvelle.isChangement()){
							try{
								c.compteurChangeBorneInf(nouvelle.getVal());
								vc.setC(c);
							
							}catch(BorneInfException e){
								JOptionPane.showMessageDialog(null, "La borne inferieure est superieure a la borne superieure actuelle !", "Attention", JOptionPane.INFORMATION_MESSAGE);
							} catch (Exception e) {
							}
						}
						nouvelle.dispose();
					}
					
					@Override
					public void windowClosing(WindowEvent arg0) {
					}
					
					@Override
					public void windowClosed(WindowEvent arg0) {			
					}
					
					@Override
					public void windowActivated(WindowEvent arg0) {
					}
				});

			}
		});
		newBorneInf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,raccourcisClavier));
		
		JMenuItem newBorneSup = new JMenuItem("Definir valeur maximale");
		newBorneSup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final nouvelleBorne nouvelle = new nouvelleBorne(false);
				nouvelle.setVisible(true);
				nouvelle.addWindowListener(new WindowListener() {
				
					@Override
					public void windowOpened(WindowEvent arg0) {
					}
					
					@Override
					public void windowIconified(WindowEvent arg0) {
					}
					
					@Override
					public void windowDeiconified(WindowEvent arg0) {
					}
					
					@Override
					public void windowDeactivated(WindowEvent arg0) {
						if(nouvelle.isChangement()){
						
							try{
								c.compteurChangeBorneSup(nouvelle.getVal());
								vc.setC(c);
							}catch(BorneInfException e){
								JOptionPane.showMessageDialog(null, "La borne superieure est inferieure a la borne inferieure actuelle !", "Attention", JOptionPane.INFORMATION_MESSAGE);
							}catch(Exception e) {
							}
							
							nouvelle.dispose();
						}
					}
					
					@Override
					public void windowClosing(WindowEvent arg0) {
					}
					
					@Override
					public void windowClosed(WindowEvent arg0) {			
					}
					
					@Override
					public void windowActivated(WindowEvent arg0) {
					}
				});

			}
		});
		newBorneSup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,raccourcisClavier));
		
		fichier.add(quitter);
		modifier.add(dec);
		modifier.add(inc);
		intervalle.add(newBorneInf);
		intervalle.add(newBorneSup);
		
		
		mb.add(fichier);
		mb.add(modifier);
		mb.add(intervalle);
		
		JPanel jPanel = new JPanel();
		jPanel.add(vc);
		this.setLayout(new FlowLayout());
		this.add(jPanel);
		this.setJMenuBar(mb);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;

		
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
	}

	@Override
	public void componentShown(ComponentEvent arg0) {		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	}

	public Compteur getC() {
		return c;
	}

	public void setC(Compteur c) {
		this.c = c;
		this.vc.setC(c);
	}
	
	
	
}
