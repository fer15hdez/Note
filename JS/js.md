### Numeric Conversion – Occurs in math operations.
Value 	Becomes…
undefined ->	NaN
null ->	0
true / false ->	1 / 0
string ->	The string is read “as is”, whitespaces (includes spaces, tabs \t, newlines \n etc.) from both sides are ignored. An empty string becomes 0. An error gives NaN. 

***Example***
alert( Number("   123   ") ); // 123
alert( Number("123z") );      // NaN (error reading a number at "z")
alert( Number(true) );        // 1
alert( Number(false) );       // 0

### Boolean Conversion – Occurs in logical operations.
Value 	Becomes…
0, null, undefined, NaN, "" ->	false
any other value ->	true

### Operator
The exponentiation operator a ** b raises 'a' to the power of 'b'.
alert( 2 ** 2 ); // 2² = 4

***unary + ***
- The plus operator + applied to a single value, doesn’t do anything to numbers. But if the operand is not a number, the unary plus converts it into a number.
- It actually does the same thing as Number(...), but is shorter.
// Converts non-numbers
alert( +true ); // 1
alert( +"" );   // 0

### Root of a number
alert( 4 ** (1/2) ); // 2 (power of 1/2 is the same as a square root)
alert( 8 ** (1/3) ); // 2 (power of 1/3 is the same as a cubic root)

### String concatenation with binary +
let s = "my" + "string";
alert(s); // mystring
***If any of the operands is a string, then the other one is converted to a string too.***
alert( '1' + 2 ); // "12"
alert( 2 + '1' ); // "21"
alert(2 + 2 + '1' ); // "41" and not "221"
alert('1' + 2 + 2); // "122" and not "14"

***The binary + is the only operator that supports strings in such a way. Other arithmetic operators work only with numbers and always convert their operands to numbers.***

Here’s the demo for subtraction and division:
alert( 6 - '2' ); // 4, converts '2' to a number
alert( '6' / '2' ); // 3, converts both operands to numbers

### Increase counter
***This operator do same increase over the var but the diference is the result ***
let counter = 0;
alert( ++counter ); // 1
alert( counter ); // 1

let counter = 0;
alert( counter++ ); // 0
alert( counter ); // 1

### Nullish coalescing operator '??'
The result of a ?? b is:

    if 'a' is defined, then 'a',
    if 'a' isn’t null/defined, then 'b'.
