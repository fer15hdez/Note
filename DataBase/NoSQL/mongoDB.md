# Install
https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-ubuntu/  

# DRUD Version mongoDB 7  
https://www.mongodb.com/docs/manual/crud/  

### Insert
***db.collection.insertOne() ***  
*Example*  
try {
   db.collection.insertOne( 
    { item: "card", 
    qty: 15 } );
} catch (e) {
   print (e);
};

*Insertar un documento con un documento embebido: -- detalles*
db.productos.insertOne({
  "nombre": "Smartphone Samsung Galaxy S23",
  "precio": 999.00,
  "categoria": "Electrónica",
  "stock": 10,
  "detalles": {
    "pantalla": "6.1 pulgadas AMOLED",
    "procesador": "Snapdragon 8 Gen 2",
    "memoriaRAM": "8GB"
  }
})

*Insertar un documento con un array de valores: -- temas*
db.productos.insertOne({
  "nombre": "Curso de Desarrollo Web",
  "precio": 49.99,
  "categoria": "Educación",
  "temas": ["HTML", "CSS", "JavaScript", "Node.js"]
})

***db.collection.insertMany() ***
*Example*  
try {
   db.products.insertMany( [
      { item: "card", qty: 15 },
      { item: "envelope", qty: 20 },
      { item: "stamps" , qty: 30 }
   ] );
} catch (e) {
   print (e);
}

### Read
***db.collection.find()***
db.collection.find( <query>, <projection>, <options> )  
- <projection>: El segundo argumento opcional del método find(). Es un documento JSON que especifica qué campos incluir o excluir de los documentos devueltos.   
 Returns documents in the bios collection where _id equals 5:   
    *db.bios.find( { _id: 5 } )*  

*Operadores de Comparación*   
    `$eq`: "igual a",  
    `$ne`: "no igual a",   
    `$gt`: "mayor que",   
    `$gte`: "mayor o igual que",   
    `$lt`: "menor que",    
    `$lte`: "menor o igual que",   
    `$in`: "coincide con cualquiera de los valores especificados en un array",   
    `$nin`: "no coincide con ninguno de los valores especificados en un array"  

*Operadores Lógicos*     
   `$and`: (y),   
   `$or`: (o),   
   `$not`: (no),   
   `$nor`: (ni)  

*Operadores de Elemento*  
`$exists`: (verifica si un campo existe),   
`$type`: (verifica el tipo de un campo).  

*Operadores de Evaluación*  
`$regex`: (permite búsquedas basadas en expresiones regulares),   
`$where`: (permite usar expresiones JavaScript para la consulta).  

*Operadores de Array*  
`$all`: (coincide con documentos que contienen todos los elementos especificados en un array),   
`$elemMatch`: (coincide con documentos que contienen un elemento dentro de un array que coincide con todos los criterios especificados),   
`$size`: (coincide con documentos cuyo array tiene un tamaño específico).    

*Ejemplos*  
`db.productos.find({ "categoria": "Electrónica", "stock": { $gt: 10 } })`   
`db.productos.find({ $or: [ { "precio": { $lt: 30 } }, { "categoria": "Libros" } ] })`   
`db.productos.find({}, { "nombre": 1, "precio": 1, "_id": 0 })`: Utilizar proyecciones para incluir solo ciertos campos (nombre y precio)  
`db.productos.find({ "nombre": { $regex: "portátil", $options: "i" } })`: todos los productos cuyo nombre contenga la palabra "portátil" (sin importar si está en mayúsculas o minúsculas: $options: "i").    
`db.productos.find({ "nombre": { $regex: "^M" } })`: todos los productos cuyo nombre comience con la letra "M".  
*Esto devolverá todos los productos cuya categoría sea "Electrónica" o "Libros"*    
`db.productos.find({ "categoria": { $in: ["Electrónica", "Libros"] } })`: Utilizar operadores de array ($in para buscar productos en ciertas categorías)   
`db.collection.find().sort({ <campo1>: <orden>, <campo2>: <orden>, ... })`: Ordenar resultados.  `1`: ascedente, `-1`: descendente.  
`db.productos.find().sort({ precio: -1 }).limit(10)`: Limitar resultados en 10.  
<code>
db.productos.insertMany([
  { "nombre": "Producto A", "etiquetas": ["rojo", "grande", "brillante"] },
  { "nombre": "Producto B", "etiquetas": ["azul", "pequeño"] },
  { "nombre": "Producto C", "etiquetas": ["grande", "brillante"] }
]);

db.productos.find({ "etiquetas": { $all: ["grande", "brillante"] } })
</code>
Esto devolverá los documentos "Producto A" y "Producto C", ya que ambos tienen las etiquetas "grande" y "brillante".

*Contar documentos*
`db.miColeccion.countDocuments({})` : contar todos los documentos en una colección
`db.miColeccion.countDocuments({ estado: "activo" })` : contar documentos que cumplen con un criterio específico


***db.collection.findOne()***
- Devuelve un único documento que coincide con los criterios de búsqueda especificados.  

### Update
db.collection.updateOne(filter, update, options)   
**Syntax**
db.collection.updateOne(
   <filter>,
   <update>,
   {
     upsert: <boolean>,
     writeConcern: <document>,
     collation: <document>,
     arrayFilters: [ <filterdocument1>, ... ],
     hint:  <document|string>        // Available starting in MongoDB 4.2.1
   }
)  
*Example*  
db.students.updateOne(
   { _id: 1 },
   { $set: { key: "value", } },
)

db.collection.updateMany()  
**ReplaceOne() replaces the first matching document in the collection that matches the filter, using the replacement document.**
db.collection.replaceOne()    
db.collection.replaceOne(
   <filter>,
   <replacement>,
   {
      upsert: <boolean>,
      writeConcern: <document>,
      collation: <document>,
      hint: <document|string>                   // Available starting in 4.2.1
   }
)

### Delete
**Syntasi**
***Deletes the first document that matches the filter. Use a field that is part of a unique index such as _id for precise deletions.***
db.collection.deleteOne(
    <filter>,
    {
      writeConcern: <document>,
      collation: <document>,
      hint: <document|string>
    }
)
**Example**
try {
   db.orders.deleteOne( { "_id" : ObjectId("563237a41a4d68582c2509da") } );
} catch (e) {
   print(e);
}
db.collection.deleteMany()
db.collection.deleteMany(
   <filter>,
   {
      writeConcern: <document>,
      collation: <document>
   }
)

**Example** 
**The following operation deletes all documents where client : "Crude Traders Inc.":** 
try {
   db.orders.deleteMany( { "client" : "Crude Traders Inc." } );
} catch (e) {
   print (e);
}