package nuevo.igu.modelo.venta;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import nuevo.igu.modelo.venta.AddandDeleteProductoPanel;

public class AccionTableCellRenderer implements TableCellRenderer {
    private AddandDeleteProductoPanel compo;

     public AccionTableCellRenderer(final JPanel ifr) {
       compo = new AddandDeleteProductoPanel(ifr);
    }

    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        compo.setTabla(table);        
        return compo;
    }
    
    
}