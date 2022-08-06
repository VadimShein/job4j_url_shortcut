FROM openjdk

WORKDIR shortcut

ADD target/job4j_url_shortcut-1.0.jar app.jar

ENTRYPOINT java -jar app.jar