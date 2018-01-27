FROM clojure:alpine
LABEL maintainer="vale@valerauko.net"

RUN apk update && apk add mongodb

WORKDIR /var/www

EXPOSE 27017
