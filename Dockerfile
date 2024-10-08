# Usa una imagen base de Ubuntu
FROM ubuntu:20.04

# Establecer el entorno no interactivo
ENV DEBIAN_FRONTEND=noninteractive

# Actualiza e instala dependencias necesarias
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    curl \
    gnupg \
    --no-install-recommends

# Agrega la clave GPG directamente y configura el repositorio de Chrome
RUN mkdir -p /etc/apt/keyrings && \
    wget -qO- https://dl.google.com/linux/linux_signing_key.pub | tee /etc/apt/keyrings/google_linux_signing_key.pub > /dev/null && \
    echo "deb [arch=amd64 signed-by=/etc/apt/keyrings/google_linux_signing_key.pub] http://dl.google.com/linux/chrome/deb/ stable main" | tee /etc/apt/sources.list.d/google-chrome.list > /dev/null

# Agrega una verificación para asegurar que el archivo se creó correctamente
RUN cat /etc/apt/sources.list.d/google-chrome.list

# Actualiza e instala Google Chrome
RUN apt-get update && apt-get install -y \
    google-chrome-stable \
    --no-install-recommends

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

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de tu proyecto
COPY . .

# Comando para ejecutar tu prueba
CMD ["mvn", "test", "-Dtest=runner.Runner"]
