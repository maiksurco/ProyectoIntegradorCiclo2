package nuevo.igu.modelo.producto;

import data.ProductoData;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaModeloProductos extends AbstractTableModel {

    private List<Producto> lis = new ArrayList();
    private String[] columns = {"Id_Producto", "Nombre Producto", "Costo Producto", "Stock Porducto", "Productos Defectuosos", "Marca / Categoria"};
    private Class[] columnsType = {Integer.class, String.class, Double.class, Double.class, Double.class, String.class};
    
    public TablaModeloProductos() {
        lis = ProductoData.list("");
    }

    public TablaModeloProductos(String filter) {

        lis = ProductoData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Producto prd = (Producto) lis.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return prd.getNameProduct();
            case 2:
                return prd.getCostUnitProduct();
            case 3:
                return prd.getStockProduct();

            case 4:
                return prd.getDefecProduct();

            case 5:
                return prd.getMarcaProduct();
     default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        //Cliente c = (Cliente) lis.get(row);
        if (column >= 0 && column != 0) {
            //return true;
        }
        return false;//bloquear edicion
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class getColumnClass(int column) {
        return columnsType[column];
    }

    @Override
    public int getRowCount() {
        return lis.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public void addRow(Producto p) { // con db no se usa
        this.lis.add(p);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lis.size(), lis.size());
    }

    public void removeRow(int linha) { // con db no se usa
        this.lis.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Object getRow(int row) { // usado para paintForm
        this.fireTableRowsUpdated(row, row);
        return lis.get(row);
    }

}
