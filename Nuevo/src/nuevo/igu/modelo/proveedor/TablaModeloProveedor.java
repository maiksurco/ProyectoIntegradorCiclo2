package nuevo.igu.modelo.proveedor;

import data.ProveedorData;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaModeloProveedor extends AbstractTableModel {

    private List<Proveedor> lis = new ArrayList();
    private String[] columns = {"idProveedores", "nombreProveedor", "apellidoProveedor", "telefono", "sexo", "ruc"};
    private Class[] columnsType = {Integer.class, String.class, String.class, String.class, String.class, String.class};
    
    public TablaModeloProveedor() {
        lis = ProveedorData.list("");
    }

    public TablaModeloProveedor(String filter) {

        lis = ProveedorData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Proveedor pro = (Proveedor) lis.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return pro.getNombreProveedor();
            case 2:
                return pro.getApellidoProveedor();
            case 3:
                return pro.getTelefono();
            case 4:
                return pro.getSexo();
            case 5:
                return pro.getRuc();
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

    public void addRow(Proveedor d) { // con db no se usa
        this.lis.add(d);
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
