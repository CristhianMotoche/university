/*
 * JavaScript tutorial
 *
 * This file is for testing things
 */

var Cristhian = {
  nombre: "Cristhian",
  apellido: "Motoche",
  printName: function () {
    console.log("Nombre:", Cristhian.nombre);
    console.log("Apellido:", Cristhian.apellido);
  },
  year: function () {
    return (new Date()).getFullYear();
  },
  compareAges: function (age) {
    console.log(Math.abs(age - this.year()));
  }
};

Cristhian.printName();
Cristhian.year();
Cristhian.compareAges(20);
