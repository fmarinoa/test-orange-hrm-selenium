# Usa una imagen base de Java
FROM openjdk:11-jdk-slim

# Instala dependencias necesarias
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    curl \
    gnupg \
    maven \
    libxi6 \
    libgconf-2-4 \
    libnss3 \
    libxss1 \
    --no-install-recommends

# Agrega la clave GPG y el repositorio de Chrome
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list

# Instala Google Chrome
RUN apt-get update && apt-get install -y \
    google-chrome-stable

# Crea la estructura de carpetas para ChromeDriver
RUN mkdir -p /app/drivers/chrome/

# Descarga la última versión de ChromeDriver y lo mueve a la carpeta deseada
RUN LATEST_CHROMEDRIVER_VERSION=$(curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE) && \
    wget -q -O /tmp/chromedriver.zip "https://chromedriver.storage.googleapis.com/${LATEST_CHROMEDRIVER_VERSION}/chromedriver_linux64.zip" && \
    unzip /tmp/chromedriver.zip -d /app/drivers/chrome/ && \
    rm /tmp/chromedriver.zip && \
    chmod +x /app/drivers/chrome/chromedriver

# Limpia la caché de apt-get para reducir el tamaño de la imagen
RUN apt-get clean && rm -rf /var/lib/apt/lists/*

# Crea un directorio para tu aplicación
WORKDIR /app

# Copia tu proyecto al contenedor
COPY . .

# Comando para ejecutar tus pruebas
CMD ["mvn", "test"]
