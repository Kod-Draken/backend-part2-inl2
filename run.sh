#!/bin/bash



echo "Building and running the Spring Boot application..."

# Step 1: Build
mvn clean install

# Step 2: Run
java -jar target/inl2-0.0.1-SNAPSHOT.jar
