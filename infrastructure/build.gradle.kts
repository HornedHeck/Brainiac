dependencies {
//    Modules
    implementation(project(":domain"))
    implementation(project(":adapters"))
    implementation(project(":app"))

//    Opus
    implementation("club.minnced:opus-java-api:1.1.1")
    implementation("club.minnced:opus-java-natives:1.1.1")
    implementation("net.java.dev.jna:jna:5.13.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
