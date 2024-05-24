import java.io.Serializable;

public class Guitarra implements Serializable {
	private static final long serialVersionUID = 1L;
    private String marca;
    private String modelo;
    private double precio;
    private int cantidad;

    public Guitarra(String marca, String modelo, double precio, int cantidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Precio: " + precio + " COP, Cantidad disponible: " + cantidad;
    }
}
