#!/bin/bash
rm -rf ../spigotmc/server-builds/plugins/battleshop-*.jar
rm -rf ../spigotmc/server-builds/plugins/devutils-*.jar
rm -rf ../spigotmc/server-builds/plugins/scoreboard-*.jar
rm -rf ../spigotmc/server-builds/plugins/welcome-*.jar

cp battleshop/target/battleshop-*.jar ../spigotmc/server-builds/plugins
cp devutils/target/devutils-*.jar ../spigotmc/server-builds/plugins
cp scoreboard/target/scoreboard-*.jar ../spigotmc/server-builds/plugins
cp welcome/target/welcome-*.jar ../spigotmc/server-builds/plugins
