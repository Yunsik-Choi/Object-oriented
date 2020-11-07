package sugangShincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;

import valueObject.VGangjwa;

public class PSelection extends JPanel {
	private static final long serialVersionUID = 1L;

	private PHakgwaSelection pHakgwaSelection;
	private PGangjwaSelection pGangjwaSelection;
	
	public PSelection(ListSelectionListener listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.pHakgwaSelection = new PHakgwaSelection(listSelectionHandler);
		this.add(pHakgwaSelection);
		
		JScrollPane scrollPane = new JScrollPane();
		this.pGangjwaSelection = new PGangjwaSelection();
		scrollPane.setViewportView(this.pGangjwaSelection);
		this.add(scrollPane);
	}
	
	public void initialize(Vector<VGangjwa> miridamgiGangjwas, Vector<VGangjwa> shincehongGangjwas) {
		this.pHakgwaSelection.initialize();
		String fileName = this.pHakgwaSelection.getFileName();
		this.pGangjwaSelection.initialize(fileName,miridamgiGangjwas,shincehongGangjwas);
	}
	
	public void updateGangjwas(Object source, Vector<VGangjwa> miridamgiGangjwas, Vector<VGangjwa> sincehongGangjwas) {
		String hakgwafileName = this.pHakgwaSelection.update(source);
		this.pGangjwaSelection.update(hakgwafileName,miridamgiGangjwas,sincehongGangjwas);
	}	

	public Vector<VGangjwa> getSelectedGangjwas() {
		return pGangjwaSelection.getSelectedGangjwas();
	}

	private Vector<VGangjwa> getGangjwas() {
		return this.pGangjwaSelection.getGangjwas();
	}
}
