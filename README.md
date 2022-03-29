# Prerequisites:
1. Install :
java 8, maven, docker


# Execute Below Steps:
1. Open terminal and clone the repository.
2. go to enterpreneurfirst folder (`cd enterpreneurfirst`)
2. Run below command to build and create jar in target folder
`mvn clean package`
3. Run `docker build --tag=efservice:latest .` to build docker image of enterpreneurfirst service
4. Run `docker-compose up -d` to start service
