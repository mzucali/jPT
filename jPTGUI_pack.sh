#!/bin/sh -f


echo "INSERISCI il nome del file jar"
read input
mkdir jPT2012


cp dist/"$input" jPT2012/jPT2012.jar

##mv jPT2012/"$input" jPT2012/jPT2012.jar

cp example_data_files/input_format.txt jPT2012/
cp mineral_labels_oxygens.xls jPT2012/

#cp -r dist/lib jPTGUI_2.076/
#cp -r dist/javadoc jPTGUI_2.076/
#rm jPTGUI_dist/._.DS_Store
#rm jPTGUI_dist/.DS_Store
#rm jPTGUI_dist/._Mintab_testdata_3.txt
#cp examples/Jeol_in_test.txt jPTGUI_dist/
#cp examples/2ax_test.txt jPTGUI_dist/

##tar -cvzf jPTGUI2.tgz jPTGUI_dist
zip -r jPT2012.zip jPT2012/
rm -r jPT2012

##echo "creating jPTGUI2.tgz archive"
echo "creating jPT2012.zip archive"
echo "last update ....." 
#echo date
echo "copying to users.unimi.it"
# cp jPTGUI2.zip /Users/miki/Sites/users.unimi.it/mzucali/public_html/dev/java/JPTproject
# cp jPTGUI2.tgz /Users/miki/Sites/users.unimi.it/mzucali/public_html/dev/java/JPTproject
# date
##sftp mzucali@users.unimi.it <<EOF
ftp mzucali@users.unimi.it <<EOF
epsv4
passive
cd public_html/mzucali/Download_files
binary
put jPT2012.zip
quit
EOF

echo "all done"
echo "clearing files"
##rm jPT2012.zip

echo "SEE you next time"