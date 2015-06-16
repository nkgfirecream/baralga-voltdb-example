Baralga VoltDB Example
======================

mvn install:install-file \
    -Dfile=./lib/voltdb-5.2.2.jar \
    -DgroupId=org.voltdb -DartifactId=voltdb-client -Dversion=5.2.2 \
    -Dpackaging=jar

mvn spring-boot:run

http://localhost:9000/project
