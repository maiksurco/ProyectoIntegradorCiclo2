package nuevo.igu.modelo.venta;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import nuevo.igu.modelo.venta.AddandDeleteProductoPanel;

public class CeldaAccionEditor extends AbstractCellEditor implements TableCellEditor{

    private AddandDeleteProductoPanel ad;
    public CeldaAccionEditor(JPanel ifrd) {
        ad = new AddandDeleteProductoPanel(ifrd);
        ad.setCeldaEditor(this);
        
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ad.setTabla(table);
        ad.setIndexFila(row);        
        return ad;
    }
    
    public void lanzarDetencionEdicion()
    {
        this.fireEditingStopped();
    }
    
}

    

