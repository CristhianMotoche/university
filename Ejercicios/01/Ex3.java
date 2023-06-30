class Usuario{
    private String nombre;
    private String cedula;
    private int edad;

    public Usuario(String nombre, String cedula, int edad){
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public Usuario getUsuario(int id){
        Conexion conexion = new Conexion();
        Serializardor serializador = new Serializardor();
        return  serializador.serializarUsuario(conexion.ejecutar("SELECT * FROM USUARIO WHERE ID = " + id));
    }
}
