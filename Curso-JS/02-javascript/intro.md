# Introduction
## JavaScript vs ECMAScript
- JavaScript is the programming language
- ECMAScript is the name used by the language specification

## Influences
- Java
- Scheme
- Self
- AWK
- Python
- Lisp

It is a mixture of programming paradigms: functional and object oriented.

## Statement vs Expression
- Statement -> "Do things".
```javascript
var foo; // This code declares (create) a variable called foo.
```

```javascript
var x;
if (y >= 0) {
    x = y;
} else {
    x = -y;
}

```

- Expression -> Produce values.
```javascript
3 * 7
```

```javascript
var x = y >= 0 ? y : -y;
```

- Expression statement
The whole line is a statement, but the function call foo(7, 1) is an expression.

```javascript
foo(4,6)
```

## Semicolons
Semicolons terminate statements, but not blocks. Exception: a function expression
is an expression that ends with a block. If such an expression comes last in a
statement, it is followed by a semicolon:

```javascript
// Pattern: var _ = ___;
var x = 3 * 7;
var f = function () { };  // function expr. inside var decl.
```

## Comments
- Single
```javascript
// single line comments
```

- Block
```javascript
/*
 * Multiple lines
 */
```
