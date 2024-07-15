FROM python:3.10
WORKDIR /servidor2

COPY aplicacion.py . 
EXPOSE 5000

RUN pip install flask
CMD ["python","aplicacion.py"]