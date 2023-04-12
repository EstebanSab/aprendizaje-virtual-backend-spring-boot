# Plataforma Educativa Virtual

Plataforma Educativa Virtual es un proyecto API REST.

Su propósito es generar un sistema que permita manejar estudiantes,profesores y cursos asi como la creacion y acceso a los contenidos de los cursos.

Para poder descargar la Api:
docker pull esdocker13/campus-api-test

Para poder correr la Api:
docker run -p 8080:8080 -e DATABASE_URL='<database>' -e DATABASE_PASSWORD=password esdocker13/campus-api-test .

La app comenzará en http://localhost:8080.

El link de '<database>' debe ser asi por ejemplo:
jdbc:postgresql://containers.app:1111/db 


# Documentacion 

Esta API fue documentada con Open API. Para verla, ir a 
http://localhost:8080/swagger-ui/index.html#/