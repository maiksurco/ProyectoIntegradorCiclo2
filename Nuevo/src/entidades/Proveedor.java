package entidades;

public class Proveedor {
    
   private int idProveedor;
   private String nombreProveedor;
   private String apellidoProveedor;
   private Double telefono;
   private String sexo;
   private Double ruc;

   public Proveedor() {
    }
    public Proveedor(String nombreProveedor) {
        this.nombreProveedor=nombreProveedor;
    }
    
    public String toString() {
        return nombreProveedor;
    }
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getApellidoProveedor() {
        return apellidoProveedor;
    }

    public void setApellidoProveedor(String apellidoProveedor) {
        this.apellidoProveedor = apellidoProveedor;
    }

    public Double getTelefono() {
        return telefono;
    }

    public void setTelefono(Double telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getRuc() {
        return ruc;
    }

    public void setRuc(Double ruc) {
        this.ruc = ruc;
    }
}
