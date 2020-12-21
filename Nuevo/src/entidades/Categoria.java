package entidades;

public class Categoria {
    private int id;
    private String nombreCategoria;
    
    public Categoria() {
    }
    public Categoria(String nombres) {
        this.nombreCategoria=nombreCategoria;
    }
    
    public String toString() {
        return nombreCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
