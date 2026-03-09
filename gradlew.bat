@echo off
where gradle >nul 2>nul
if %ERRORLEVEL% neq 0 (
  echo Gradle is not installed. Please install Gradle 8.14.3+
  exit /b 1
)
gradle %*
