FROM python:3.10

#crear un directorio de trabajo
WORKDIR /servidor
COPY servidor.py .
EXPOSE 5000

#instala las dependencias
RUN pip install flask
#ejecutar en la aplicacion
CMD [ "python", "servidor.py" ]
