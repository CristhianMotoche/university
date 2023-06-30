class App{
    public static void main(String args[]){
        try{
            int x = 10/0;
        }
        catch(Exception e){
            System.err.println("ERROR: NO EXISTE DIVISIÓN PARA CERO");
            System.exit(1);
        }
    }
}
