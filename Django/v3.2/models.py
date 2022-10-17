from django.db import models

# Create your models here.
class NameOfModel(models.Model):
    ip_addres = models.GenericIPAddressField("IP")
    user_name = models.CharField("Usuario", max_length=200, default=1627704012)
    size_transfered = models.IntegerField("Tamanno de transf")
    date_time = models.DateTimeField("Fecha")
    ip_client = models.GenericIPAddressField("Ip cliente")
    quickAnswer = models.BooleanField("Grup. Respueta Rapida", default=False)
    worker = models.ForeignKey(NameEntity, on_delete=models.CASCADE)

    
    category_black_list = models.ForeignKey(
        CategoryBlackListDomain,
        on_delete=models.CASCADE,
        default=None
    )
    
    nacional = 'nac'
    internacional = 'int'
    correo = 'cor'

    defaultSocial = 'Ninguno'

    serviceNavcell = [
        (internacional, 'Internancional'),
        (correo, 'correo')
    ]
    serviceMail = [
        (nacional, 'Nacional'),
        (internacional, 'Internancional'),
    ]
    serviceNavPc = [
        (nacional, 'Nacional'),
        (internacional, 'Internancional'),
    ]    

    serviceTypeMail = models.CharField("Tipo de servicio Mail", choices=serviceMail, max_length=15, default=nacional)
    
    def __str__(self):
        return self.name.upper()

