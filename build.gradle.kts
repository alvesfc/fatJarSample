plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"

}

group = "org.alvesfc"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("commons-codec:commons-codec:1.17.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

// The following code snippet configures the shadowJar task to include the Main-Class attribute in the manifest file:
tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    manifest {
        attributes["Main-Class"] = "org.alvesfc.FatJarSample"
    }
}
// Adding the following line to the build.gradle.kts file will make the shadowJar task depend on the build task:
tasks.build {
    dependsOn("shadowJar")
}