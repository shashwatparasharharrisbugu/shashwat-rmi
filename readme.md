# greetings-rmi Remote Method Invocation with Java

Sample project using Java RMI messaging.

## Runs

### Run rmiregistry

```bash
set CLASSPATH=%CLASSPATH%;target\\greetings-rmi-1.0-SNAPSHOT-jar-with-dependencies.jar
start rmiregistry

```

### Run Server

```bash
java -jar target/greetings-rmi-1.0-SNAPSHOT-jar-with-dependencies.jar server //saintgoretti/GreetingsServer
```

### Run Client

```bash
java -jar target/greetings-rmi-1.0-SNAPSHOT-jar-with-dependencies.jar client //saintgoretti/GreetingsServer "Johnny B Good"
```