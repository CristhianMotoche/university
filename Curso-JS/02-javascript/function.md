# Functions
A JavaScript function is a block of code designed to perform a particular task:


- When an event occurs (when a user clicks a button)
- When it is invoked (called) from JavaScript code
- Automatically (self invoked)

A JavaScript function is executed when "something" invokes it (calls it).

When JavaScript reaches a `return` statement, the function will stop executing.

```javascript
function toCelsius(fahrenheit) {
    return (5/9) * (fahrenheit-32);
}
```

- toCelsius <- Function definition
- toCelsius(3) <- Function execution

## Function declaration
```javascript
function add(param1, param2) {
    return param1 + param2;
}
```

## Function expresion
```javascript
var add = function (param1, param2) {
    return param1 + param2;
};
```

## Functions are hoisted
It means that they are entirety moved to the beginning of the current scope.
So functions can be called in everywhere inside the scope.

```javascript
function f(){
  g();
  function g(){}
}
```

## Arguments
The number of arguments in JS is arbitrary. All the arguments can be accesed
by the variable `arguments`. Looks like an array, but it is not.

```javascript
function zeroArgs(){
  console.log(arguments);
}

zeroArgs(1,2,3,4);
```

## Default parameters
Common pattern to define default parameters:

```javascript
function fun(y){
	y = y || 0;
}
```

If `y` is truthy then `y` keeps its value.
