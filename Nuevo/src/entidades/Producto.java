package entidades;


public class Producto {
    private int idProducto;
    private String nameProduct;
    private Double costUnitProduct;
    private Double stockProduct;
    private Double defecProduct;
    private String marcaProduct;

    
    public Producto() {
    }
    public Producto(String nameProduct) {
        this.nameProduct=nameProduct;
    }
    
    public String toString() {
        return nameProduct;
    }
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getCostUnitProduct() {
        return costUnitProduct;
    }

    public void setCostUnitProduct(Double costUnitProduct) {
        this.costUnitProduct = costUnitProduct;
    }

    public Double getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(Double stockProduct) {
        this.stockProduct = stockProduct;
    }

    public Double getDefecProduct() {
        return defecProduct;
    }

    public void setDefecProduct(Double defecProduct) {
        this.defecProduct = defecProduct;
    }

    public String getMarcaProduct() {
        return marcaProduct;
    }

    public void setMarcaProduct(String marcaProduct) {
        this.marcaProduct = marcaProduct;
    }

    
    }