mvn install:install-file \
    -Dfile=./lib/voltdb-5.2.2.jar \
    -DgroupId=org.voltdb -DartifactId=voltdb -Dversion=5.2.2 \
    -Dpackaging=jar