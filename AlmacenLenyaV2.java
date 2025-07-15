import java.util.Date;
import java.util.Calendar;

/**
 * Versión mejorada de la clase AlmacenLenya.
 * Añade control de duplicados, cálculo de ganancias y gestión de pedidos pendientes.
 * 
 */
public class AlmacenLenyaV2 extends AlmacenLenya
{
    private double ganancias = 0.0;

    /**
     * Constructor del almacén mejorado.
     */
    AlmacenLenyaV2()
    {
        super();
    }

    /**
     * Añade un pueblo al almacén si no existe otro con el mismo nombre.
     * 
     * @param pueblo Pueblo a añadir.
     */
    @Override
    void anyadirPueblo(Pueblo pueblo)
    {
        String nombrePueblo = pueblo.getNombre();
        for (Pueblo p : this.pueblos)
        {
            if (p.getNombre().equals(nombrePueblo))
            {
                System.out.println("Ya existe un pueblo con el mismo nombre.");
                return;
            }
        }
        super.anyadirPueblo(pueblo);
    }

    /**
     * Añade un pedido si cumple con las condiciones:
     * - Existe el pueblo del cliente.
     * - No hay otro pedido no servido del mismo cliente.
     * - Hay suficiente leña disponible.
     * 
     * @param pedido Pedido a añadir.
     */
    @Override
    void anyadirPedido(Pedido pedido)
    {
        String nombrePueblo = pedido.getCliente().getPueblo().getNombre();
        String nombreCliente = pedido.getCliente().getNombre();
        boolean existePueblo = false;
        boolean existeCliente = false;
        int cantidad = pedido.getCantidad();

        if (cantidad > this.lenya) 
        {
            System.out.println("La cantidad del pedido supera la cantidad de leña disponible.");
            return;
        }

        this.lenya -= cantidad; // Para que tenga sentido, creo

        for (Pueblo p : this.pueblos)
        {
            if (p.getNombre().equals(nombrePueblo))
            {
                existePueblo = true;
            }
        }

        for (Pedido p : this.pedidos)
        {
            if (p.getCliente().getNombre().equals(nombreCliente) && !p.isServido())
            {
                existeCliente = true;
                System.out.println("Ya existe un pedido no servido para un cliente con el mismo nombre.");
            }
        }

        if (!existePueblo) System.out.println("No existe un pueblo con el mismo nombre.");
        if (existePueblo && !existeCliente) super.anyadirPedido(pedido);
    }

    /**
     * Añade un cliente si no existe otro con el mismo nombre.
     * 
     * @param cliente Cliente a añadir.
     */
    @Override
    void anyadirCliente(Cliente cliente)
    {
        String nombreCliente = cliente.getNombre();
        for (Cliente c : this.clientes)
        {
            if (c.getNombre().equals(nombreCliente))
            {
                System.out.println("Ya existe un cliente con el mismo nombre.");
                return;
            }
        }
        super.anyadirCliente(cliente);
    }

    /**
     * Marca como servido un pedido asociado al nombre del cliente.
     * Suma el precio del pedido a las ganancias.
     * 
     * @param nombre Nombre del cliente.
     */
    @Override
    void anotarServido(String nombre)
    {
        boolean encontrado = false;
        for (Pedido pedido : this.pedidos)
        {
            if (pedido.getCliente().getNombre().equals(nombre))
            {
                pedido.setServido(true);

                System.out.println("PEDIDO SERVIDO:");
                pedido.imprimeInformacion();
                encontrado = true;
                this.ganancias += pedido.calcularPrecio();
            }
        }

        if (!encontrado) {
            System.out.println("NO EXISTE NINGÚN PEDIDO POR SERVIR A NOMBRE DE: " + nombre);
        }
    }

    /**
     * Devuelve las ganancias totales acumuladas por los pedidos servidos.
     * 
     * @return Ganancias acumuladas.
     */
    double getGanancias()
    {
        return this.ganancias;
    }

    /**
     * Imprime la cantidad de leña pendiente de entregar por cada pueblo.
     */
    void calcularLenyaPendientePorPueblo()
    {
        System.out.println("Leña pendiente:");
        for (Pueblo pueblo : this.pueblos)
        {
            int lenyaPendiente = 0;
            String nombrePueblo = pueblo.getNombre();
            for (Pedido pedido : this.pedidos)
            {
                if (pedido.getCliente().getPueblo().getNombre().equals(nombrePueblo) && !pedido.isServido())
                {
                    lenyaPendiente += pedido.getCantidad();
                }
            }
            System.out.println("Pueblo " + pueblo.getNombre() + ": " + lenyaPendiente);
        }
    }

    /**
     * Calcula la cantidad de leña necesaria para cubrir los pedidos del último mes.
     * 
     * @return Cantidad total de leña requerida.
     */
    double calcularLenyaParaCubrir()
    {
        int lenya = 0;
        for (Pedido pedido : this.pedidos)
        {
            Date fechaPedido = pedido.getFecha();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, -1);
            Date haceUnMes = cal.getTime();

            if (fechaPedido.after(haceUnMes) && pedido.isServido())
            {
                lenya += pedido.getCantidad();
            }
        }
        return lenya;
    }
}
