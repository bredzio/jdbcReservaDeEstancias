
package estancias.entidades;

import java.sql.Date;


public class Estancia {
    private Integer id_estancia;
    private Cliente cliente;
    private Casa casa;
    private String nombre_huesped;
    private Date fecha_desde;
    private Date fecha_hasta;

    public Estancia() {
    }

    public Estancia(Integer id_estancia, Cliente cliente, Casa casa, String nombre_huesped, Date fecha_desde, Date fecha_hasta) {
        this.id_estancia = id_estancia;
        this.cliente = cliente;
        this.casa = casa;
        this.nombre_huesped = nombre_huesped;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
    }

    public Integer getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(Integer id_estancia) {
        this.id_estancia = id_estancia;
    }

    public Cliente getId_cliente() {
        return cliente;
    }

    public void setId_cliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Casa getId_casa() {
        return casa;
    }

    public void setId_casa(Casa id_casa) {
        this.casa = id_casa;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public void setNombre_huesped(String nombre_huesped) {
        this.nombre_huesped = nombre_huesped;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }
    
    
}
