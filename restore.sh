#!/bin/bash

for img in *.gpg; do
    # Name anpassen (.gpg entfernen)
    original_name=${img%.gpg}
    echo Restoring $original_name...

    # Entschlüsseln mit GPG
    gpg --output $original_name --decrypt $img
    
    # Löschen der verschlüsselten Datei
    rm $img
    
done

echo Restoration process complete.

