package AntesDelFin;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement
public class Pedidos {
    private HashMap<Integer, Pedido> pedidos;

    public Pedidos() {
        pedidos = new HashMap<>();
    }

    public Pedidos(HashMap<Integer, Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public HashMap<Integer, Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(HashMap<Integer, Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "pedidos=" + pedidos +
                '}';
    }
}
