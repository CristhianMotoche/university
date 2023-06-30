class Permisos{
    public boolean tienePermisos(int permiso, ArrayList<Privilegios> privilegios){
        if(usuario.getPermisos() != null){
            if(usuario.getPrivilegio() != null){
                for(Privilegio privilegio: privilegios){
                    if(usuario.getPrivilegio() == privilegio){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
