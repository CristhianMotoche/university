var usuario = {
    nombre: "LoL",
    apellido: "xD",
    direccion: "asdf"
};
var Persona = (function () {
    function Persona(name, apellido, fechaNac) {
        this.name = "Nom";
        this.name = name;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }
    Persona.prototype.imprimir = function () {
        return { nombre: this.name, apellido: this.apellido };
    };
    return Persona;
}());
var cm = new Persona("Cristhian", "Motoche", new Date());
console.log(cm.imprimir());
