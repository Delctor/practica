/**
 * Clase que representa un pueblo.
 * Contiene el nombre del pueblo y el precio del transporte asociado.
 * 
 */
public class Pueblo
{
    private String nombre;
    private double precioTransporte;

    /**
     * Constructor de la clase Pueblo.
     * 
     * @param nombre Nombre del pueblo.
     */
    public Pueblo(String nombre)
    {
        this.nombre = nombre;
        this.precioTransporte = 10;
    }

    /**
     * Devuelve el nombre del pueblo.
     * 
     * @return Nombre del pueblo.
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Establece el nombre del pueblo.
     * 
     * @param nombre Nuevo nombre del pueblo.
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * Devuelve el precio del transporte al pueblo.
     * 
     * @return Precio del transporte.
     */
    public double getPrecioTransporte()
    {
        return this.precioTransporte;
    }

    /**
     * Establece el precio del transporte al pueblo.
     * 
     * @param precioTransporte Nuevo precio del transporte.
     */
    public void setPrecioTransporte(double precioTransporte)
    {
        this.precioTransporte = precioTransporte;
    }

    /**
     * Imprime en consola la información del pueblo.
     */
    public void imprimeInformacion()
    {
        System.out.println("Población: " + this.nombre);
        System.out.println("Precio del transporte: " + this.precioTransporte + " euros");
    }
}
