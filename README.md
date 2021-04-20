![Glaze](https://github.com/project-transparent/glaze/blob/main/glaze.png)

**Glaze** is a collection of Java annotations that provide additional ease-of-use features to your projects.

## Overview

Some may recognize Java as a very verbose language, and so to show off Project Transparent's libraries, we created this annotation library alongside them to help reduce the amount of boilerplate in your code. [Project Lombok](https://github.com/rzwitserloot/lombok) inspired this project heavily, but we attempt to offer different, more experimental utilities in less code.

### Requirements
Glaze is designed to use JDK 8 but supports later versions, such versions may be unstable with this project at the moment.

## Installation (Gradle - Local)

1. Clone the repo (https://github.com/project-transparent/glaze).
2. Run `gradlew publishToMavenLocal` in the root directory of the repo.
3. Add `mavenLocal()` to your repositories.
4. Add `compileOnly 'org.transparent:glaze-annotations:<version>'` to your dependencies.
5. Add either of the following to your dependencies: 
    - `annotationProcessor 'org.transparent:glaze-<module>:<version>'` (Individual module)
    - `annotationProcessor 'org.transparent:glaze-all:<version>'` (All modules)
