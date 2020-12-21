package nuevo.igu.modelo.cliente;

import data.ClienteData;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaModeloClientes extends AbstractTableModel {

    private List<Cliente> lis = new ArrayList();
    private String[] columns = {"Id_Cliente", "Nombres", "Apellidos", "Direccion", "Correo", "Sexo"};
    private Class[] columnsType = {Integer.class, String.class, String.class, String.class, String.class, String.class};
    
    public TablaModeloClientes() {
        lis = ClienteData.list("");
    }

    public TablaModeloClientes(String filter) {

        lis = ClienteData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Cliente cl = (Cliente) lis.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return cl.getNombres();
            case 2:
                return cl.getApellidos();
            case 3:
                return cl.getDireccion();
            case 4:
                return cl.getCorreo();
            case 5:
                return cl.getSexo();
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

    public void addRow(Cliente d) { // con db no se usa
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
