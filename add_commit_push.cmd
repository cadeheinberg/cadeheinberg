git add -A
git commit -m "test"
git push
ssh -i C:\\Users\\cadeh\\.ssh\\id_rsa cade_bambam62@35.225.65.136 -t "bash /var/www/mysites/cadeheinberg/pull_from_github.sh ; bash --login"