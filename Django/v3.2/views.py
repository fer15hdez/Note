
from xml.dom.minidom import Entity

def report_withoutuser(request):
    #Recive the param sending from the template
    request.GET.get('nameParam')
    request.POST.get('nameParam')

    #Make a querry
    Entity.objects.filter(date_time__range=(firstParam, endParam).
                          exclude(user__contains="False").
                          filter(ip_client__contains=user_cell).
                          filter(date_time__range=(date_start, date_end)).
                          filter(name_of_field__contains=category_black_list.pk).
        order_by('name_of_field_entity')[:100] #slice, 100 tuple 
  

    # Paginator
    # Paginator(query to paginate, number_of_line) "Objet to manage the query"
    number_of_line = 50
    paginator_squid = Paginator(query, number_of_line) 
    paginator_kerio = Paginator(query_kerio, 50)

    page_number = request.GET.get('page')
    page_query_squid = paginator_squid.get_page(page_number) # Return a list with the element the page specified
    page_query_kerio = paginator_kerio.get_page(page_number)

    # Render the view
    context = {'query': page_query_squid,
                'query_kerio': page_query_kerio,
                'form': form,

                'param_form_squid_first': request.GET.get('StarDate'),
                }

    return render(request, 'dir_where_isTheFile/name_file.html', context)