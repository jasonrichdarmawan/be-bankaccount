FROM adoptopenjdk/openjdk11:jdk-11.0.9_11-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/depedency && (cd target/depedency; jar -xf ../*.jar)

FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine
VOLUME /tmp
ARG DEPEDENCY=/workspace/app/target/depedency
COPY --from=build ${DEPEDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPEDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPEDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.personal.bebankaccount.BeBankaccountApplication"]