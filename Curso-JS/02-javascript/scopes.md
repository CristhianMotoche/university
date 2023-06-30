# Lexical Scoping

First off, JavaScript has *lexical scoping* with *function scope*. In other words,
even though JavaScript looks like it should have block scope because it uses curly
braces { }, a new scope is created only when you create a new function.

In order to resolve variables, JavaScript starts at the innermost scope and searches
outwards until it finds the variable it was looking for.

## Hoisting variables
Variable declarations are hoisted. That means that they are moved to the beggining
of the function.

However, initialization stay in the same possition.

```javascript
function foo() {
    console.log(tmp); // undefined
    if (false) {
        var tmp = 3;  // (1)
    }
}
```

Internally, the preceding function is executed like this:

```javascript
function foo() {
    var tmp;  // hoisted declaration
    console.log(tmp);
    if (false) {
        tmp = 3;  // assignment stays put
    }
}
```

## Closures
It is a closure and the connection to the variables of its surrounding scopes.

## The IIFE Pattern: Introducing a New Scope
IIFE -> Immediately Invoked Function Expression
An IIFE is a function expression that is called immediately after you define it.
Inside the function, a new scope exists, preventing tmp from becoming global

Notes taken from: [Kaitlin Davis][blog-kd-js-scope]

[blog-kd-js-scope][https://spin.atomicobject.com/2014/10/20/javascript-scope-closures/]
