package vue;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class nouvelleBorne extends JFrame{
	
	private JTextField textinfsup;
	private JButton ok;
	private JButton annuler;
	private boolean changement = false;
	private int val;
	
	private static final long serialVersionUID = 2162188030585505581L;
	
	nouvelleBorne(boolean is){
	
		textinfsup = new JTextField();
		this.setSize(350, 150);
		this.setMinimumSize(new Dimension(350,150));
		
		if(is){
			this.setTitle("Definir la valeur minimale");
			
		}else{
			this.setTitle("Definir la valeur maximale");
		}
		
	
		this.setLocationRelativeTo(null);
			
		textinfsup = new JTextField();
		textinfsup.setPreferredSize( new Dimension( 200, 24 ) );
		ok = new JButton("Valider");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!textinfsup.getText().equals(null) && !textinfsup.getText().equals("")){
					try{
					
						val = Integer.parseInt(textinfsup.getText());
						setChangement(true);
						nouvelleBorne.this.setVisible(false);
				
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Veuillez rentrer une valeur entiere!", "Attention", JOptionPane.INFORMATION_MESSAGE);
						nouvelleBorne.this.setVisible(true);
					}
				
				} else{
					JOptionPane.showMessageDialog(null, "Veuillez rentrer une valeur !", "Attention", JOptionPane.INFORMATION_MESSAGE);
					nouvelleBorne.this.setVisible(true);
				}
			}
		});
		annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nouvelleBorne.this.dispose();
			}
		});
		
		
			
		JPanel jPanel = new JPanel();
		jPanel.add(textinfsup);
		JPanel jPanel2 = new JPanel();
		jPanel2.add(ok);
		jPanel2.add(annuler);
		this.setLayout(new FlowLayout());
		this.add(jPanel);
		this.add(jPanel2);	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public boolean isChangement() {
		return changement;
	}

	public void setChangement(boolean changement) {
		this.changement = changement;
	}
	
}
