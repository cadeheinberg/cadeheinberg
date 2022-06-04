git add -A
git commit -m "test"
git push
ssh -i C:\\Users\\cadeh\\.ssh\\id_rsa cade_bambam62@35.225.65.136 -t "cd /var/www/cadeheinberg ; bash --login ; exit"