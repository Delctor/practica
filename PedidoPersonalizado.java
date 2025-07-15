/**
 * Clase que representa un pedido personalizado.
 * Permite establecer proporciones específicas para los distintos tipos de leña.
 * 
 */
public class PedidoPersonalizado extends Pedido
{
    private static double costeAdicional = 30.0;
    private int proporcion1 = 0;
    private int proporcion2 = 0;
    private int proporcion3 = 0;

    /**
     * Constructor de la clase PedidoPersonalizado.
     * 
     * @param cliente Cliente que realiza el pedido.
     */
    PedidoPersonalizado(Cliente cliente)
    {
        super(cliente);
    }
    
    /**
     * Establece las proporciones de leña pequeña, mediana y grande.
     * Las proporciones deben sumar exactamente 100.
     * 
     * @param proporcion1 Proporción de leña pequeña.
     * @param proporcion2 Proporción de leña mediana.
     * @param proporcion3 Proporción de leña grande.
     */
    void setProporciones(int proporcion1, int proporcion2, int proporcion3)
    {
        if (proporcion1 + proporcion2 + proporcion3 != 100)
        {
            System.out.println("Las tres proporciones no suman 100.");
        }
        else
        {
            this.proporcion1 = proporcion1;
            this.proporcion2 = proporcion2;
            this.proporcion3 = proporcion3;
        }
    }
    
    /**
     * Calcula el precio total del pedido, incluyendo el coste adicional por personalización.
     * 
     * @return Precio total considerando el coste adicional.
     */
    @Override
    double calcularPrecio()
    {
        return super.calcularPrecio() + costeAdicional;
    }
    
    /**
     * Imprime la información del pedido personalizado, incluyendo proporciones y coste adicional.
     */
    @Override
    void imprimeInformacion()
    {
        super.imprimeInformacion();
        System.out.println("Proporción de leña pequeña: " + this.proporcion1 + "%");
        System.out.println("Proporción de leña mediana: " + this.proporcion2 + "%");
        System.out.println("Proporción de leña grande: " + this.proporcion3 + "%");
        System.out.println("Coste adicional por pedido personalizado: " + costeAdicional);
    }
}
