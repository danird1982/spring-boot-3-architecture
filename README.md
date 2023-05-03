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

Elegir perfil al arrancar: -Dspring.profiles.active=development

Heroku
usuario: danird@gmail.com	
pass: Algraf17#

Ejemplo proyecto spring boot que despliega en heroku
https://github.com/heroku/java-getting-started

App Spring-boot con Mysql
GET
http://localhost:8080/
http://localhost:8080/user/findall

Tutorial
https://www.codejava.net/heroku/deploy-spring-boot-app-with-mysql

usar Salesforce Autheticator para hacer el login (instalar la app en el movil)

1)
heroku login
prompt @$f

2)
heroku create springboot3architecture

https://springboot3architecture.herokuapp.com/ | https://git.heroku.com/springboot3architecture.git

3)
git remote -v 

heroku  https://git.heroku.com/springboot3architecture.git (fetch)
heroku  https://git.heroku.com/springboot3architecture.git (push)
origin  https://github.com/danird1982/spring-boot-3-architecture.git (fetch)
origin  https://github.com/danird1982/spring-boot-3-architecture.git (push)

Es necesario crear un fichero denominado "system.properties" y ubicarlo en la raiz del proyecto, indicando la versión de Java a utilizar. El contenido del fichero debe ser:

java.runtime.version=19


Ademas también es necesario incluir en la raíz del proyecto un fichero denominado "Profile" con el siguiente contenido:

web: java -jar target/soledad_aprendizaje-0.0.1-SNAPSHOT.jar (cambiar el nombre del jar)

Seguidamente podemos realizar el paso 4

4) git push heroku main ( heroku restart para reiniciar la app sin cambios en el repositorio)

La aplicación estará desplegada en https://springboot3architecture.herokuapp.com

5) heroku apps (mostrar las apps que están desplegadas)

6) heroku open (lanzar la aplicación en el navegador)

7) heroku logs (visualizar los logs)

8)Instaalr Mysql
https://elements.heroku.com/addons/cleardb

heroku addons:create cleardb:ignite (instalar la base de datos)

heroku run -a springboot3architecture printenv (para ver las variables de entorno)

JAVA_HOME=/app/.jdk
JDBC_DATABASE_URL=jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_a7dad4494ee8d87?password=cba1ccd7&reconnect=true&user=b444ae4da08626
JAVA_OPTS=-XX:+UseContainerSupport -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8
PWD=/app
PORT=51429
LINES=50
HOME=/app
SPRING_DATASOURCE_USERNAME=b444ae4da08626
COLUMNS=211
SPRING_DATASOURCE_URL=jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_a7dad4494ee8d87?password=cba1ccd7&reconnect=true&user=b444ae4da08626
CLEARDB_DATABASE_URL=mysql://b444ae4da08626:cba1ccd7@us-cdbr-east-06.cleardb.net/heroku_a7dad4494ee8d87?reconnect=true
JDBC_DATABASE_PASSWORD=cba1ccd7
JDBC_DATABASE_USERNAME=b444ae4da08626
SHLVL=0
LD_LIBRARY_PATH=/app/.jdk/lib/server:
PS1=\[\033[01;34m\]\w\[\033[00m\] \[\033[01;32m\]$ \[\033[00m\]
SPRING_DATASOURCE_PASSWORD=cba1ccd7
PATH=/app/.heroku/bin:/app/.jdk/bin:/usr/local/bin:/usr/bin:/bin
DYNO=run.5638
_=/usr/bin/printenv

