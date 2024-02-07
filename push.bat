git add .
SET /p str=Commit: 
git commit -m "%str%"
git push
pause
exit