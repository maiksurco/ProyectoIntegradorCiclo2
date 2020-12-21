package nuevo.igu.modelo.categoria;


import data.CategoriaData;
import entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asullom
 */
public class CategoriaTablaModelo extends AbstractTableModel {

    private List<Categoria> lis = new ArrayList();
    private String[] columns = {"id", "nombreCategoria"};
    private Class[] columnsType = {Integer.class, String.class};

    public CategoriaTablaModelo() {
        lis = CategoriaData.list("");
    }

    public CategoriaTablaModelo(String filter) {

        lis = CategoriaData.list(filter);
    }


    @Override
    public Object getValueAt(int row, int column) {
        Categoria cate = (Categoria) lis.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return cate.getNombreCategoria();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        //Categoria cate = (Categoria) lis.get(row);
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

    public void addRow(Categoria cate) { // con db no se usa
        this.lis.add(cate);
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
