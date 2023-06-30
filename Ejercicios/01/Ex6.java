class Permisos{
    public String determinarPersimo(int permiso){
        if (permiso == 1){
            return "ADMIN";
        } else {
            return "VENDEDOR";
        }
    }
}

class Admin{
    private String nombre;
    private int permiso;
}

class Vendedor{
    private String nombre;
    private int permiso;
    private int ventas;
}
