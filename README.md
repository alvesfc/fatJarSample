# Fat Jar Sample

This project provides a step-by-step guide for creating a "fat" JAR (Java Archive) using Gradle and Maven.

 - <b>Combine Dependencies:</b> Bundle all necessary libraries and dependencies within a single JAR.
- <b>Configure Gradle:</b> Use Gradle's shadow plugin to build a fat JAR.
- <b>Set Up Maven:</b> Leverage Maven's shade plugin for fat JAR creation.
- <b>Run and Test:</b> Execute and test your fat JAR to ensure it works as a standalone application.

## Gradle Shadow Plugin Solution

The project uses the Shadow plugin (`com.github.johnrengelman.shadow`), a Gradle plugin used to create a "fat" JAR of 
the project. A "fat" JAR, also known as an "uber" JAR, is a JAR file containing the project's compiled classes and all 
of its runtime dependencies. This means the JAR can be distributed and run on any system with a compatible JVM
without distributing the dependencies separately.

The Shadow plugin also provides a feature to relocate classes from their original package to a new package. This can be 
useful to avoid version conflicts when the project and its dependencies require different versions of the same library.

In the `build.gradle.kts` file, the Shadow plugin is used to set the `Main-Class` attribute in the JAR file manifest file.
This attribute specifies the application's entry point, i.e., the class with the `main` method that will be run when the
JAR is executed using the `java -jar` command.

## Features

The project provides the following operations:

- <b>Encode</b>: This operation takes a string as input and encodes it using Base64 encoding. The encoded string is then
  printed to the standard output. You can use this operation by running the application with the encode command and the
  string you want to encode.

- <b>Decode</b>: This operation takes a Base64 encoded string as input and decodes it. The decoded string is then printed to
  the standard output. You can use this operation by running the application with the decode command and the string you
  want to decode.

### Usage

To build the project, you can use the following command:

```shell
./gradlew clean build
```

To encode a string, you can use the following command:

```shell
java -jar build/libs/fatJarSample-1.0-all.jar encode hello-world
```

To decode a string, you can use the following command:

```shell
java -jar build/libs/fatJarSample-1.0-all.jar decode aGVsbG8td29ybGQ=
```

## Maven Shade Plugin Solution
The Maven Shade Plugin provides the capability to package the artifact in an uber-jar, including its dependencies 
and to shade - i.e. rename - the packages of some of the dependencies.  In the context of this project, we use the 
Maven Shade Plugin to create a "fat" JAR that includes not only the project's compiled classes, but also all of its 
runtime dependencies. This means that the JAR can be distributed and run on any system with a compatible JVM, without 
needing to separately distribute the dependencies.

### Usage

To build the project, you can use the following command:

```shell
./mvnw clean package
```

To encode a string, you can use the following command:

```shell
java -jar target/fatJarSample-1.0.jar encode hello-world
```

To decode a string, you can use the following command:

```shell
java -jar target/fatJarSample-1.0.jar decode aGVsbG8td29ybGQ=
```

## License

[MIT](https://choosealicense.com/licenses/mit/)
