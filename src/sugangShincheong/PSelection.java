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

public class PSelection extends PGangjwaContainer {
	private static final long serialVersionUID = 1L;

	private PHakgwaSelection pHakgwaSelection;
	private PGangjwaSelection pGangjwaSelection;
	private String fileName;
	public PSelection(ListSelectionListener listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.pHakgwaSelection = new PHakgwaSelection(listSelectionHandler);
		this.add(pHakgwaSelection);
		
		JScrollPane scrollPane = new JScrollPane();
		this.pGangjwaSelection = new PGangjwaSelection();
		scrollPane.setViewportView(this.pGangjwaSelection);
		this.add(scrollPane);
	}
	
	public void initialize(Vector<VGangjwa> miridamgiGangjwas, Vector<VGangjwa> shincheongGangjwas) {
		this.pHakgwaSelection.initialize();
		this.fileName = this.pHakgwaSelection.getFileName();
		this.pGangjwaSelection.initialize(fileName);
		this.pGangjwaSelection.removeDuplicated(miridamgiGangjwas);
		this.pGangjwaSelection.removeDuplicated(shincheongGangjwas);
		this.pGangjwaSelection.updateTableContents();
	}
	
	public void updateGangjwas(Object source, Vector<VGangjwa> miridamgiGangjwas, Vector<VGangjwa> sincheongGangjwas) {
		this.fileName = this.pHakgwaSelection.update(source);
		this.pGangjwaSelection.update(this.fileName);
		this.pGangjwaSelection.removeDuplicated(miridamgiGangjwas);
		this.pGangjwaSelection.removeDuplicated(sincheongGangjwas);
		this.pGangjwaSelection.updateTableContents();
	}
	
	@Override
	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		
		this.pGangjwaSelection.addGangjwas(vSelectedGangjwas,this.fileName);		
	}
	@Override
	public Vector<VGangjwa> removeSelectedGangjwas() {
		return this.pGangjwaSelection.removeSelectedGangjwas();
	}

	
}
