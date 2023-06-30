class Autenticacion{
    public static int identificacion;
    public static boolean autenticado;
    public static String nivelAutenticacion;

    public Autenticacion(){
    }

    public boolean identificionCorrecta(int id){
        return id == identificacion;
    }

    public boolean usuarioCorrecto(String nivel){
        return nivel == nivelAutenticacion;
    }
}
