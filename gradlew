#!/usr/bin/env sh
set -e
if [ -z "$JAVA_HOME" ] && [ -d "$HOME/.local/share/mise/installs/java/17.0.2" ]; then
  export JAVA_HOME="$HOME/.local/share/mise/installs/java/17.0.2"
  export PATH="$JAVA_HOME/bin:$PATH"
fi
if command -v gradle >/dev/null 2>&1; then
  exec gradle "$@"
else
  echo "Gradle is not installed. Please install Gradle 8.14.3+." >&2
  exit 1
fi
