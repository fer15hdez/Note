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
0, null, undefined, NaN, "" 	false
any other value 	true

### Operator
alert( 4 ** (1/2) ); // 2 (power of 1/2 is the same as a square root)
alert( 8 ** (1/3) ); // 2 (power of 1/3 is the same as a cubic root)