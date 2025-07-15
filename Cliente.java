/**
 * Clase que representa a un cliente.
 * Contiene información sobre su nombre, dirección y pueblo de residencia.
 * 
 */
public class Cliente
{
    private String nombre;
    private String direccion;
    private Pueblo pueblo;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre Nombre del cliente.
     * @param pueblo Pueblo al que pertenece el cliente.
     */
    Cliente(String nombre, Pueblo pueblo)
    {
        this.nombre = nombre;
        this.pueblo = pueblo;
    }

    /**
     * Devuelve el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    String getNombre()
    {
        return this.nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre Nuevo nombre del cliente.
     */
    void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * Devuelve la dirección del cliente.
     * 
     * @return Dirección del cliente.
     */
    String getDireccion()
    {
        return this.direccion;
    }

    /**
     * Establece la dirección del cliente.
     * 
     * @param direccion Nueva dirección del cliente.
     */
    void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    /**
     * Devuelve el pueblo del cliente.
     * 
     * @return Pueblo del cliente.
     */
    Pueblo getPueblo()
    {
        return this.pueblo;
    }

    /**
     * Establece el pueblo del cliente.
     * 
     * @param pueblo Nuevo pueblo del cliente.
     */
    void setPueblo(Pueblo pueblo)
    {
        this.pueblo = pueblo;    
    }

    /**
     * Imprime la información del cliente en consola.
     */
    void imprimeInformacion()
    {
        System.out.println("Cliente: " + this.nombre);
        System.out.println("    Dirección: " + this.direccion);
        System.out.println("    Población: " + this.pueblo.getNombre());
        System.out.println("    Precio del transporte: " + this.pueblo.getPrecioTransporte());
    }
}
