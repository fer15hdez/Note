#!/bin/bash

echo "Start script - $(date)" >> /home/fernando/Documentos/Start_script_so/log_script_wifi.txt
path='/home/fernando/Documentos/Script/conectar_wifi'
source $path/wifi_conect_venv/bin/activate
python3 $path/connet_wifi_.py
echo "End script - $(date)" >> /home/fernando/Documentos/Start_script_so/log_script_wifi.txt

exit