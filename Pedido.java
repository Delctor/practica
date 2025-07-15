import java.util.Date;

/**
 * Clase que representa un pedido realizado por un cliente.
 * Incluye información sobre la fecha, cantidad de leña, bolsas de astillas y estado del pedido.
 * 
 */
public class Pedido
{
    private Cliente cliente;
    private Date fecha;
    private int cantidad;
    private int bolsasAstillas;
    private boolean servido;
    private static double precioPorKilo;
    private static double precioPorBolsa;

    /**
     * Constructor de la clase Pedido.
     * Inicializa un pedido con cliente, fecha actual y valores por defecto.
     * 
     * @param cliente Cliente que realiza el pedido.
     */
    Pedido(Cliente cliente)
    {
        this.cliente = cliente;
        this.fecha = new Date();
        this.cantidad = 0;
        this.bolsasAstillas = 0;
        this.servido = false;
    }

    /**
     * Obtiene el cliente asociado al pedido.
     * 
     * @return Cliente del pedido.
     */
    Cliente getCliente()
    {
        return this.cliente;
    }

    /**
     * Establece el cliente del pedido.
     * 
     * @param cliente Cliente a asignar.
     */
    void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    /**
     * Obtiene la fecha del pedido.
     * 
     * @return Fecha del pedido.
     */
    Date getFecha()
    {
        return this.fecha;
    }

    /**
     * Establece la fecha del pedido.
     * 
     * @param fecha Nueva fecha del pedido.
     */
    void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    /**
     * Obtiene la cantidad de leña en kilos.
     * 
     * @return Cantidad de kilos.
     */
    int getCantidad()
    {
        return this.cantidad;
    }

    /**
     * Establece la cantidad de leña en kilos.
     * 
     * @param cantidad Cantidad a establecer.
     */
    void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el número de bolsas de astillas.
     * 
     * @return Número de bolsas de astillas.
     */
    int getBolsasAstillas()
    {
        return this.bolsasAstillas;
    }

    /**
     * Establece el número de bolsas de astillas.
     * 
     * @param bolsasAstillas Número de bolsas.
     */
    void setBolsasAstillas(int bolsasAstillas)
    {
        this.bolsasAstillas = bolsasAstillas;
    }

    /**
     * Indica si el pedido ha sido servido.
     * 
     * @return true si ha sido servido, false en caso contrario.
     */
    boolean isServido()
    {
        return this.servido;
    }

    /**
     * Establece si el pedido ha sido servido.
     * 
     * @param servido Estado del pedido.
     */
    void setServido(boolean servido)
    {
        this.servido = servido;
    }

    /**
     * Obtiene el precio por kilo de leña.
     * 
     * @return Precio por kilo.
     */
    static double getPrecioPorKilo()
    {
        return precioPorKilo;
    }

    /**
     * Establece el precio por kilo de leña.
     * 
     * @param p Precio a establecer.
     */
    static void setPrecioPorKilo(double p)
    {
        precioPorKilo = p;
    }

    /**
     * Obtiene el precio por bolsa de astillas.
     * 
     * @return Precio por bolsa.
     */
    public static double getPrecioPorBolsa()
    {
        return precioPorBolsa;
    }

    /**
     * Establece el precio por bolsa de astillas.
     * 
     * @param p Precio a establecer.
     */
    public static void setPrecioPorBolsa(double p)
    {
        precioPorBolsa = p;
    }

    /**
     * Calcula el precio total del pedido considerando el transporte.
     * 
     * @return Precio total del pedido.
     */
    double calcularPrecio()
    {
        return this.cantidad * precioPorKilo +
               this.bolsasAstillas * precioPorBolsa +
               this.cliente.getPueblo().getPrecioTransporte();
    }

    /**
     * Imprime en consola la información detallada del pedido.
     */
    void imprimeInformacion()
    {
        System.out.println("INFORMACIÓN DEL PEDIDO");
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Cantidad (kg): " + this.cantidad);
        System.out.println("Número de bolsas de astillas: " + this.bolsasAstillas);
        this.cliente.imprimeInformacion();
        System.out.println("Precio del pedido: " + this.calcularPrecio());
        System.out.println("Estado del pedido: " + (this.servido ? "Servido" : "No servido"));
    }
}
