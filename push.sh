#!/bin/sh

./gradlew clean
./gradlew build --stacktrace

docker build --tag junghee0130/onemm .
docker push junghee0130/onemm
