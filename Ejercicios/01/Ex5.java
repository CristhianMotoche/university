class Cliente{
    private String nombre;
    private String direccion;
    private String identificador;
    private PreferenciasDeCompra preferencias;
    private Orden ultimaOrden;
}

class ClientePremium extends Cliente{
    private int descuento;
    private Promocion promocion;
}

class ReferenciaCliente extends Cliente{
    private String referencia;

    public void imprimirInforme(){
        System.out.println("INFORME");
        System.out.println("Nombre: " + nombre);
        System.out.println("Direccion: " + direccion);
        System.out.println("Referencia: " + referencia);
    }
}
