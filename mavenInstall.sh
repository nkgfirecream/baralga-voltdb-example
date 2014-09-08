mvn install:install-file \
    -Dfile=./lib/voltdb-4.6.jar \
    -DgroupId=org.voltdb -DartifactId=voltdb-client -Dversion=4.6 \
    -Dpackaging=jar