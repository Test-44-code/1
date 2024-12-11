#!/bin/bash

for file in $@;do
    cp $file $file.bak 

    sed -i 's/daß/dass/g' $file
    sed -i 's/muß/muss/g' $file

    echo $file is done
done

echo the prossecs is done