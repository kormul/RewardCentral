FROM openjdk:8
WORKDIR /usr/app
COPY /build/libs/rewardCentral-1.0.0.jar reward-central.jar
CMD ["java", "-jar", "reward-central.jar"]
EXPOSE 8083