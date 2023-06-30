// Variables
var number = 4.4;
var string = "Hello world!";
var bool = true;
var array = [ 1, 2, true];
var date = new Date();
var object = {field1:"John", field2:"Doe", fieldi:{ fieldi1: 2, fieldi2: []}, fieldN:"blue"};
var myfunction = function(argument) {
  return argument;
};
var undefinedvalue;
var nullvalue = null;

console.log("Number:", number);
console.log("String:", string);
console.log("Boolean:", bool);
console.log("Date:", date);
console.log("Literal array", array);
console.log("Object:", object);
console.log("Access to object.field1:", object.field1);
console.log("Access to object.notdefined:", object.notdefined);
console.log("Access to object.fieldi.fieldi1:", object.fieldi.fieldi1);
console.log("Function:", myfunction);
console.log("Undefined:", undefinedvalue);
console.log("Null:", nullvalue);

console.log("Typeof undefined:", typeof undefined);           // undefined
console.log("Typeof null (remember the bug :P):", typeof null);                // object
console.log("Compare null with undefined by content and type:", null === undefined);         // false
console.log("Compare null with undefined by content:", null == undefined);        // true

var myDate = new Date();
console.log("myDate instanceof Date:", myDate instanceof Date);
