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
 Returns documents in the bios collection where _id equals 5:
    *db.bios.find( { _id: 5 } )*

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