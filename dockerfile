From openjdk:8
copy ./target/entrepreneurfirst-0.0.1-SNAPSHOT.jar entrepreneurfirst-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","entrepreneurfirst-0.0.1-SNAPSHOT.jar"]