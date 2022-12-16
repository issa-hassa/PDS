#!/bin/sh

source  /Users/ahmed-korom/git/PDS-TP2-java/compile

blue='\033[0;34m'
NC='\033[0m' # No Color
printf "$blue le code produit est : $NC\n"

name="$1.ll "
echo $name
cat $name


printf "$blue execution du code produit :$NC\n"
./$1
echo $?
