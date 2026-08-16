# Open Water Detector

Client-only Fabric mod for Minecraft Java Edition 26.2.

When a fishing bobber is present, the mod checks the vanilla Open Water state every 5 ticks and prints a chat message only when the state changes (or when a new bobber is cast):

```text
[OWD] Open Water
[OWD] Not Open Water
```

## Build

Minecraft 26.2 requires Java 25. On Windows PowerShell:

```powershell
$env:JAVA_HOME = 'C:\Users\daruks\.jdks\jdk-25.0.4'
\.\gradlew.bat build
```

The mod jar is written to `build/libs/`.
