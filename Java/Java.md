### LAMBDA FUNTION
- En Java, el operador :: se refiere a una referencia de método, que es una forma simplificada 
  de escribir una expresión lambda para llamar a un método.  

### Key word 'this'  
-  La palabra clave 'this' se usa para hacer referencia al objeto actual en un método o constructor, y para resolver ambigüedades en el código.  

### GENERICS
- Although generics can be used in other ways, you’ll often use generics to
  write type-safe collections. In other words, code that makes the compiler
  stop you from putting a Dog into a list of Ducks.

ArrayList<Type>: ArrayList es la clase, Type es el tipo que permite almacenar la clase.

1. Creando instancias de generic clases.
  new ArrayList<Song>()
2. Declarando y asignando varibles de generic types.
  List<Song> songList = new ArrayList<Song>()
3. Declarando y llamando metodos que toman parametros de generic types.
  void foo(List<Song> list)
  x.foo(songList)

- Ejemplo en la documentacion de ArrayList:
  public class ArrayList<E> extends AbstractList<E> implements List<E>
  - Think of “E” as a stand-in for “the type of element you want this collection to
    hold and return.” (E is for Element.)

public <T extends Animal> void takeThing(ArrayList<T> list)
es diferente de:
public void takeThing(ArrayList<Animal> list)

El primero permite un parametro ArrayList de tipo Animal y sus subtype pero
el segundo solo permite un ArrayList de tipo Animal.