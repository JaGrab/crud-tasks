call runcrud
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo RUNCRUD has errors - breaking work
goto fail

:browser
echo Waiting for tomcat
timeout 15 /NOBREAK
"C:\Program Files\Mozilla Firefox\firefox.exe" http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo Deployment errors

:end
echo.
echo Finished.