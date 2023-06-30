// Function declaration
function holaMundo(){
  console.log('Hello world!');
}

// Function definition
console.log(holaMundo);

// Function call
console.log(holaMundo());

// Function expression
var hello = function(par1, par2){
  return "Hello";
};

// Function call
console.log(hello);

// Function expression
console.log(hello(1,2));

// Arguments variable
function zeroArgs(){
  console.log(arguments);
}

zeroArgs(1,2,3,4);
