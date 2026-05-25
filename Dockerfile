FROM alpine:3.20

# Definimos la versión exacta que queremos
ENV HUGO_VERSION=0.145.0

# Instalamos dependencias necesarias para Hugo Extended
RUN sed -i 's/https/http/g' /etc/apk/repositories && \
    apk add --no-cache \
    git \
    libc6-compat \
    libstdc++ \
    g++ \
    curl

# Descargamos e instalamos el binario de Hugo Extended
RUN curl -L --insecure "https://github.com/gohugoio/hugo/releases/download/v${HUGO_VERSION}/hugo_extended_${HUGO_VERSION}_linux-64bit.tar.gz" -o /tmp/hugo.tar.gz && \
    tar -xzf /tmp/hugo.tar.gz -C /tmp && \
    mv /tmp/hugo /usr/local/bin/hugo && \
    rm /tmp/hugo.tar.gz

WORKDIR /src
EXPOSE 1313

CMD ["hugo", "server", "--bind", "0.0.0.0", "--appendPort=false", "--disableFastRender"]