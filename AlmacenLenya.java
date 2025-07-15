import java.util.ArrayList;

/**
 * Clase que representa un almacén de leña.
 * Gestiona pueblos, clientes, pedidos y el stock de leña disponible.
 * 
 */
public class AlmacenLenya
{
    protected ArrayList<Pueblo> pueblos;
    protected ArrayList<Cliente> clientes;
    protected ArrayList<Pedido> pedidos;
    protected int lenya;

    /**
     * Constructor de la clase AlmacenLenya.
     * Inicializa listas vacías y el stock de leña a cero.
     */
    AlmacenLenya()
    {
        this.lenya = 0;
        this.pueblos = new ArrayList<Pueblo>();
        this.clientes = new ArrayList<Cliente>();
        this.pedidos = new ArrayList<Pedido>();
    }

    /**
     * Devuelve la lista de pueblos.
     * 
     * @return Lista de pueblos.
     */
    ArrayList<Pueblo> getPueblos()
    {
        return this.pueblos;
    }

    /**
     * Establece la lista de pueblos.
     * 
     * @param pueblos Nueva lista de pueblos.
     */
    void setPueblos(ArrayList<Pueblo> pueblos)
    {
        this.pueblos = pueblos;
    }

    /**
     * Devuelve la lista de clientes.
     * 
     * @return Lista de clientes.
     */
    ArrayList<Cliente> getClientes()
    {
        return this.clientes;
    }

    /**
     * Establece la lista de clientes.
     * 
     * @param clientes Nueva lista de clientes.
     */
    void setClientes(ArrayList<Cliente> clientes)
    {
        this.clientes = clientes;
    }

    /**
     * Devuelve la lista de pedidos.
     * 
     * @return Lista de pedidos.
     */
    ArrayList<Pedido> getPedidos()
    {
        return this.pedidos;
    }

    /**
     * Establece la lista de pedidos.
     * 
     * @param pedidos Nueva lista de pedidos.
     */
    void setPedidos(ArrayList<Pedido> pedidos)
    {
        this.pedidos = pedidos;
    }

    /**
     * Añade una cantidad de leña al almacén.
     * 
     * @param lenya Cantidad de leña a añadir.
     */
    void anyadirLenya(int lenya)
    {
        this.lenya += lenya;

        System.out.println("SE HAN AÑADIDO " + lenya + " KILOS DE LEÑA AL ALMACÉN.");
        System.out.println("CANTIDAD ACTUAL: " + this.lenya + " KILOS.");
    }

    /**
     * Añade un nuevo pueblo al almacén.
     * 
     * @param pueblo Pueblo a añadir.
     */
    void anyadirPueblo(Pueblo pueblo)
    {
        this.pueblos.add(pueblo);

        System.out.println("PUEBLO AÑADIDO:");
        pueblo.imprimeInformacion();
    }

    /**
     * Añade un nuevo cliente al almacén.
     * 
     * @param cliente Cliente a añadir.
     */
    void anyadirCliente(Cliente cliente)
    {
        this.clientes.add(cliente);

        System.out.println("CLIENTE AÑADIDO:");
        cliente.imprimeInformacion();
    }

    /**
     * Añade un nuevo pedido al almacén.
     * 
     * @param pedido Pedido a añadir.
     */
    void anyadirPedido(Pedido pedido)
    {
        this.pedidos.add(pedido);

        System.out.println("PEDIDO AÑADIDO:");
        pedido.imprimeInformacion();
    }

    /**
     * Marca como servido el pedido de un cliente por nombre.
     * 
     * @param nombre Nombre del cliente cuyo pedido se desea marcar como servido.
     */
    void anotarServido(String nombre)
    {
        boolean found = false;
        for (Pedido pedido : this.pedidos)
        {
            if (pedido.getCliente().getNombre().equals(nombre))
            {
                pedido.setServido(true);

                System.out.println("PEDIDO SERVIDO:");
                pedido.imprimeInformacion();
                found = true;
            }
        }

        if (!found) {
            System.out.println("NO EXISTE NINGÚN PEDIDO POR SERVIR A NOMBRE DE: " + nombre);
        }
    }
}
