#!/usr/bin/env bash

# find voltdb binaries in either installation or distribution directory.

if [ -n "$(which voltdb 2> /dev/null)" ]; then
    VOLTDB_BIN=$(dirname "$(which voltdb)")
else
    VOLTDB_BIN="$(dirname $(dirname $(pwd)))/bin"
    echo "The VoltDB scripts are not in your PATH."
    echo "For ease of use, add the VoltDB bin directory: "
    echo
    echo $VOLTDB_BIN
    echo
    echo "to your PATH."
    echo
fi

# Compile Stored Procedure
javac -cp ./lib/voltdb-4.6.jar ./baralga-voltdb-example/src/main/java/com/remast/baralga/LastXActivitiesJava.java

# Include Stored Procedure
voltdb compile --classpath=baralga-voltdb-example/src/main/java/ -o baralga.jar baralga.sql
