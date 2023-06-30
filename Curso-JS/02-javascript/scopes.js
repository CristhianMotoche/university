// Lexical scope
var outerFunction  = function(){

   if(true){
      var x = "Outer";
      // console.log(y); //line 1, ReferenceError: y not defined
   }

   var nestedFunction = function() {

      if(true){
         var y = "Inner";
         console.log(x); //line 2, x will still be known prints "Outer"
      }

      if(true){
         console.log(y); //line 3, prints "Inner"
       }
   };
   return nestedFunction;
};

var myFunction = outerFunction();
myFunction();

// Closures
function createIncrementor(start) {
    return function () {  // (1)
        start++;
        return start;
    };
}

var inc = createIncrementor(4);
inc();
inc();
inc();

// The IIFE Pattern

function iife(){
  (function () {  // open IIFE
    var tmp = 3;  // not a global variable
  }());  // close IIFE
  // The following line will make the program fail
  // console.log(tmp);
}

console.log("IIFE: ", iife());
