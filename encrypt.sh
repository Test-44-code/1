#!/bin/bash

# sudo pacman -Syu
# sudo pacman -S man-db
# gbg --full-generate-key

for img in *.jpg *.png; do
    
    echo "Encrypting $img..."
        
    # Verschlüsseln mit GPG unter Verwendung der Schlüssel-ID
    gpg --output "$img.gpg" --encrypt --recipient 6ECF2ECA5C9151C7FD455B48C9B8FDFC23908FC3 "$img"

    # Löschen des Originalbildes
    rm "$img"
done

echo "Encryption process complete."
