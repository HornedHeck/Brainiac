dependencies {
//    Modules
    implementation(project(":domain"))
    implementation(project(":adapters"))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
