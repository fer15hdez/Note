import datetime

from django import forms
from .models import BlackListDomain, CategoryBlackListDomain


class filter_userForm(forms.Form):
    user_cell = forms.CharField(label='Cell', max_length=100,
                                widget=forms.TextInput(
                                    attrs={
                                        'placeholder': 'Usuario',

                                    }))
    date_start = forms.DateField(label='Inicio',
                                 widget=forms.TextInput(
                                     attrs={
                                         'placeholder': 'Fecha Inicial',

                                     }))
    date_end = forms.DateField(label='Fin',
                               widget=forms.TextInput(
                                   attrs={
                                       'placeholder': 'Fecha Final',
                                       'class': 'nameClass'

                                   }))
    category = forms.ModelChoiceField(queryset=CategoryBlackListDomain.objects.all(), empty_label="Categoria", label="Categoria")


