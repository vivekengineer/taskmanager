FROM openjdk:8
ADD /taskmanager-service-0.0.1-SNAPSHOT.jar taskmanager-service-0.0.1-SNAPSHOT.jar
EXPOSE 8092
RUN bash -c 'touch /taskmanager-service-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","taskmanager-service-0.0.1-SNAPSHOT.jar"]
