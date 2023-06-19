from django.contrib.auth.models import User
from django.db import connection
from django.contrib.gis.db import models
from django.contrib.gis.geos import Point

# Create your models here.


class Farm(models.Model):
    name = models.CharField("Nombre", max_length=50) # With "Nombre" in quotation the class model can be anywhere in the file.  
    created_by = models.ForeignKey(User, on_delete=models.CASCADE) # Is auto_created the user who create the table. Need modify the method in the 
    # view form_valid
    location = models.PointField("Localizacion", srid=4326,blank=False,null=False)
    date_created = models.DateTimeField("Fecha de creado", auto_now_add=True) # Is auto_created the datetime when is created the table.
    unitary_price = models.FloatField("Precio Unitario")
    source = models.ForeignKey("Source", on_delete=models.CASCADE, default=None) # The Entity Source between "" is for model declared after the 
    # present model, that mean below.
    parameter = models.ManyToManyField(Parameter) # Relationship Many To Many. The field is puting in only class model. Automaticaly 
    # is created a new table with the two pk from the relantionship.

    class Meta: # Model metadata is "anything that's not a field"
        verbose_name = "Granja" # Show the name friendly to user in the admin template.


    def __str__(self): # Show the srt name of objet, need return a string. 
        return self.name




    






