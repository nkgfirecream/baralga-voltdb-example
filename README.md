Baralga VoltDB Example
======================

mvn install:install-file \
    -Dfile=./lib/voltdb-4.6.jar \
    -DgroupId=org.voltdb -DartifactId=voltdb-client -Dversion=4.6 \
    -Dpackaging=jar

mvn spring-boot:run

http://localhost:9000/project
