FROM openjdk:13-alpine

WORKDIR /usr/local/books
ARG BOOKS_VERSION
ENV BOOKS_VERSION $BOOKS_VERSION

ADD ./target/books-$BOOKS_VERSION.jar .

CMD java -jar books-$BOOKS_VERSION.jar
