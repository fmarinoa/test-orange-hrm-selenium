# Usa una imagen base de Ubuntu
FROM ubuntu:20.04

# Establecer el entorno no interactivo
ENV DEBIAN_FRONTEND=noninteractive

# Instala dependencias adicionales necesarias, incluyendo wget para la instalación de Chrome
RUN apt-get update && \
    apt-get install -y \
    wget \
    fonts-liberation \
    libappindicator3-1 \
    libasound2 \
    libatk-bridge2.0-0 \
    libatk1.0-0 \
    libgbm1 \
    libgtk-3-0 \
    libnspr4 \
    libnss3 \
    libxss1 \
    libxtst6 \
    xdg-utils \
    gnupg \
    ca-certificates && \
    rm -rf /var/lib/apt/lists/*

# Agrega la clave de firma de Google Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add -

# Agrega el repositorio de Chrome
RUN echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list

# Actualiza e instala Google Chrome
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
