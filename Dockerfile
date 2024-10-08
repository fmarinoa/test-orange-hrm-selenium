# Usa una imagen base de Ubuntu
FROM ubuntu:20.04

# Establecer el entorno no interactivo
ENV DEBIAN_FRONTEND=noninteractive

# Instala las dependencias necesarias
RUN apt-get update && \
    apt-get install -y wget unzip curl gnupg2 maven && \
    rm -rf /var/lib/apt/lists/*

# Agrega la clave de Google y el repositorio de Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list

# Instala Google Chrome
RUN apt-get update && \
    apt-get install -y google-chrome-stable && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Descargar y configurar Chromedriver
RUN CHROMEDRIVER_VERSION=$(curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE) && \
    wget https://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip && \
    unzip chromedriver_linux64.zip && \
    mkdir -p /app/drivers/chrome && \
    mv chromedriver /app/drivers/chrome/chromedriver.exe && \
    chmod +x /app/drivers/chrome/chromedriver.exe && \
    rm chromedriver_linux64.zip

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de tu proyecto
COPY . .

# Comando para ejecutar tu prueba
CMD ["mvn", "test", "-Dtest=runner.Runner"]
