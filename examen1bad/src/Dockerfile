# Usa una imagen base de Java
FROM openjdk:11

# Crea un directorio de trabajo
WORKDIR /app

# Copia los archivos Java al contenedor
COPY .. /app

# Compila los archivos Java
RUN javac ConversorRemoto.java ConversorRemotoImpl.java ServidorRMI.java ClienteRMI.java

# Expone el puerto en el que el servidor RMI escucha (por defecto 1099)
EXPOSE 1099

# Comando para ejecutar el servidor
CMD ["java", "ServidorRMI"]
