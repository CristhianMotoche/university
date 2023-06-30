# Variables
## Assignment
Variables in JS are declared before they are used.

## Values
All values (boolean, numbers, strings, objects, and so on) have properties. For
instance:
```javascript
var string = "hello";
string.toUpperCase(); // Will produce: HELLO
```

## Primitive Values Versus Objects
*Primitive values*:
- booleans, numbers, strings, null and undefined.

All values with the same "content" are the same:

```javascript
> var prim1 = 123;
> var prim2 = 123;
> prim1 === prim2
true
```

The properties of primitive values cannot be changed.

```javascript
> var string = "hello";
> string.length = 1; // Will not affect the property
> string.length
4
```

*Object values*:
- all other values.

Each object is unique, so comparing two different object (even with the same
properties) will be `false`.

```javascript
> var obj1 = {};  // an empty object
> var obj2 = {};  // another empty object
> obj1 === obj2
false
> obj1 === obj1
true
```

There are literal for:
- Objects
```javascript
{ foo: "bar",
  baz: "tar"
}
```
- Arrays
```javascript
[1,2,3,4]
```
- Regular Expressions
```javascript
/^a+b+$/
```

## Categorizing Values
- *typeof*
Used for primitives.

NOTE: *null* is not an objet, althought `typeof null` will return `object`
because of a bug that cannot be solved.

- *instanceof*
Used to compare if an object is an instance of some Constructor.

## Boolean
- *Falsy* - The following values are considered `false`:
  * undefined
  * null
  * 0, NaN
  * ''

- *Truthy* - All other values (primitives and objects) are considered `true`

## Numbers
There are some data types in JS:
- Numbers
  - JavaScript Numbers are Always 64-bit Floating Point
  - This format stores numbers in 64 bits, where the number (the fraction) is stored
  in bits 0 to 51, the exponent in bits 52 to 62, and the sign in bit 63:

|Mantissa|Exponent|Sign|
----
|52 bits(0-51)|11 bits (52-62)|1 bit (63)|

- Precision
  - Integers (numbers without a period or exponent notation) are considered accurate up to **15 digits**.
  - The maximum number of **decimals is 17**, but floating point arithmetic is not always 100% accurate:

## String
Remember that strings are primitive values, that means that they are **inmutable**.

## Bottom types
- *undefined*
It means "no value"

- *null*
It means "no object"

There values can be interpreted as `false`.

## Difference between Undefined and Null

```javascript
typeof undefined           // undefined
typeof null                // object
null === undefined         // false
null == undefined          // true
```

Use `typeof` to see the data type of a indentifier or a value.

## Define variables
Using the keyword `var`.

**JavaScript evaluates expressions from left to right.**

Notes taken from: [W3C][w3c]
[w3c]: https://www.w3schools.com/js/js_datatypes.asp
