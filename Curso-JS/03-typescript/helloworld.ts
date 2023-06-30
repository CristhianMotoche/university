interface UsuarioLogin {
  nombre: string,
  apellido: string,
  direccion?: string
}

let usuario:UsuarioLogin = {
  nombre: "LoL",
  apellido: "xD",
  direccion: "asdf"
}

class Persona {
  name:string = "Nom";
  private apellido: string;
  public fechaNac:Date;
  constructor(name, apellido, fechaNac) {
    this.name = name;
    this.apellido = apellido;
    this.fechaNac = fechaNac;
  }

  imprimir():UsuarioLogin{
    return { nombre: this.name, apellido: this.apellido };
  }
}

let cm = new Persona("Cristhian", "Motoche", new Date());
console.log(cm.imprimir());
