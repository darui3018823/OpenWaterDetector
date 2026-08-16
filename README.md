# Open Water Detector

Client-only Fabric mod for Minecraft Java Edition 26.2.

Install the built jar together with Fabric Loader 0.19.3+, Fabric API, and Fabric Language Kotlin 1.13.13+ in the client instance.

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
