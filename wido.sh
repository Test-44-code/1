#!/bin/bash

# sudo pacman -S npm
# sudo npm i wikit -g
# oder ==>
#           sudo npm install -g wikit

mkdir lesestoff
input=$1
while IFS= read -r line; do
    echo Artikel: $line

    artikel=`wikit -l de $line`
    echo $artikel > lesestoff/$line.txt

done < $1
