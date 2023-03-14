# Descripción del proyecto

Este módulo representa la aplicación de backend destinada a proporcionar la información necesaria para la aplicación de ranking propuesta en la actividad. Las tecnologías con
las que se ha implementado son

* Java 17
* Spring Boot v3
* Spring Framework v6 (módulos web, JDBC y test)
* H2 (base de datos embebida)

# ⚠️ ¿Qué necesito para empezar?

Para poder desarrollar la prueba, necesitas tener instalado el siguiente software:

* JDK 17. Recomendamos usar la distribución de Eclipse Temurin: https://adoptium.net/es/temurin/releases/
* IDE. IntelliJ IDEA o Eclipse

# 🚀 ¿Cómo lo ejecuto en local?

Para ejecutar la aplicación en local, puedes hacerlo de varias maneras. En cualquiera de los siguientes casos
podrás observar que los test de la aplicación *fallan*.

Tu tarea será implementar en el código los ejercicios que se muestran más abajo para que estos tests den 
un resultado positivo. **NO DEBES MODIFICAR** los tests, únicamente añadir la implementación en la aplicación.

Tienes anotados con comentarios (`TODO: ...`) unos puntos de referencia dentro del código parar guiar la 
resolución de los ejercicios.

## IDE

Cualquiera de los IDEs mencionados en el apartado anterior proveen soporte a la ejecución de aplicaciones de tipo Spring Boot.

Simplemente, haz click derecho sobre la clase `ZboostApplication.java` dentro de `src/main/java/com/inditex/zara/`y selecciona la opción para lanzar (`Run`) o debuggear (`Debug`) la aplicación.

Para validar la aplicación puedes ejecutar desde el IDE todos los tests contenidos en el directorio `src/tests/java/`. Por ejemplo, en IntelliJ puedes seleccionar directamente el proyecto, click derecho y `Run 'All Tests'`. Otros IDEs tiene un sistema similar para ejecutarlos.

**¡Ooops!** :fearful: Veras que hay varios tests fallidos. Debes de completar la implemetación dentro de la aplicación para que den un resultado
positivo pero no debes modificar estos tests.

## Terminal

1. Abre una terminal y muévete a la raíz del proyecto. Por ejemplo, si hemos hecho clone del repositorio
dentro de la carpeta `projects` del usuario actual:

```shell
cd $HOME/projects/zararanking/actividad-backend/zboost
```

2. Dentro de ella, deberías poder ver los siguientes archivos si lanzas un comando `ls`

```shell
> ls
README.md  mvnw   mvnw.cmd   pom.xml   src 
```

3. Lanza la construcción del proyecto con el script de Maven wrapper:

```shell
./mvnw clean install -DskipTests
```

**¡Ooops!** :fearful: En este punto la operación debería de fallar y te debe de mostrar que hay
varios tests con errores.

Como parte del ejercicio deberás completar el código de la aplicación, pero no debes modificar estos tests.

4. Una vez la construcción haya finalizado correctamente, lanza el siguiente comando:

```shell
./mvnw spring-boot:run
```
5. Listo! La aplicación estaría levantada en `localhost:8080`. Al final del log que se imprime por consola deberías poder
ver algo como lo siguiente:

```shell
2023-02-17T18:08:35.206+01:00  INFO 55467 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-02-17T18:08:35.213+01:00  INFO 55467 --- [           main] com.inditex.zboost.ZboostApplication     : Started ZboostApplication in 1.241 seconds (process running for 1.418)
```

# 🗽 Proyecto

El código de este proyecto está organizado con la siguiente estructura de paquetes:

* **controller**: Recoge la implementación del API introducida para esta actividad, organizándola en controladores REST para
cada entidad (Order, Product, Ranking, ReportSummary).
* **entity**: Entidades de negocio de la aplicación.
* **exception**: Excepciones que se pueden producir en la ejecución de la lógica de negocio.
* **service**: Aquí podrás encontrar los servicios encargados de aplicar la lógica necesaria.
* **repository**: Clases encargadas de recuperar datos de la BD.
* **utils**: Clases de utilidad.

Adicionalmente, en la carpeta `resources` encontrarás los archivos DML y DDL usados para crear el modelo de datos. No
te preocupes, se cargarán automáticamente cada vez que arranques la aplicación, pero siéntete libre de consultarlos si
así lo deseas 😄.

# 📦 Preparación de la prueba

¡Sabemos que estás deseoso de empezar! 🫠 Aun así, consideramos que te puede ser de mucha ayuda tener presente los siguientes
puntos:

🔎 Consulta el API propuesta para la actividad. Al final, el código que crearás en los ejercicios no es más que una implementación
de los endpoints que en ella se definen. Para consultar los detalles de la API puedes cargar el archivo `openapi.yaml` que se encuentra
en el directorio `api/` de la raiz del repositorio, puedes usar cualquier herramienta que soporte la visualización de OpenAPI 
(por ejemplo [Swagger Editor](https://editor.swagger.io)).

📖 Lee detenidamente lo que se pide tanto en la actividad como en cada ejercicio.


💿 Accede a la consola web de la base de datos siempre que quieras. La base de datos embebida escogida para la prueba (H2)
expone en el puerto 8082 una GUI cada vez que se levanta la aplicación. Te puede resultar de mucha utilidad para probar 
queries y ver los datos que devuelven. Los datos originales están almacenados en el directorio `data/` en la raiz del repositorio.

Para conectarte a ella, realiza lo siguiente:

1. Arranca la aplicación siguiendo los pasos que mencionamos anteriormente en esta guía.
2. Accede a http://localhost:8080/h2-console desde tu navegador.
3. Asegúrate de introducir los datos correctos siguiendo las propiedades establecidas en el fichero `src/main/resources/application.properties`
4. Haz click en `Connect`
![img.png](assets%2Fh2_login.png)
5. Estás dentro! Ahora ya puedes consultar el modelo de datos así como lanzar alguna query 😉
![img.png](assets%2Fh2_console.png)

   
# 💪 Ejercicios

### 📝 Nota
Los ejercicios tendrán dentro del código comentarios con `TODOs` para guiarte:

```java
// TODO: Ejercicio X --------------
``` 

Puedes apoyarte en las herramientas que te ofrecen los IDEs seleccionados para la prueba para que te muestren donde se 
encuentran repartidos de una forma centralizada:

* IntelliJ Idea: https://www.jetbrains.com/help/idea/todo-tool-window.html
* Eclipse: https://stackoverflow.com/questions/16903046/find-todo-tags-in-eclipse

**RECUERDA**: No debes de modificar los test, únicamente el código de la aplicación.

## Ejercicio 1: Productos

En este ejercicio implementaremos las funcionalidades relativas a una de las entidades básicas de la aplicación, que proveerán
los datos necesarios para poder pintar la parrilla de productos ordenada en función de su `score`. 
Puedes encontrar los endpoints expuestos en el API bajo el tag `products`.

### 1.a) Listar productos

En este caso de uso se requiere que la aplicación devuelva el listado de productos disponibles. **Opcionalmente**, el consumidor
de nuestra API puede querer filtrar productos por sus categorías y dicho filtro debe aplicarse de forma **case-insensitive**
(por ejemplo: filtrando por las categorías _'PANTs'_ o _'drEssES'_ no debe afectar al número de resultados devuelto).

### 1.b) Listar categorías de productos

Dado que tenemos un catálogo de productos en nuestra base de datos, en este caso de uso lo que se requiere es devolver 
un listado de las **diferentes** categorías de los productos.

## Ejercicio 2: Pedidos

Ya tenemos nuestro catálogo de productos listo, así que ahora debemos implementar la lógica necesaria para poder recuperar
información relativa a los pedidos que existen para los productos de nuestra compañía. El contrato que es necesario implementar
se encuentra en el API bajo el tag `orders`.

### 2.a) Listar pedidos

Una vez tenemos nuestro catálogo de productos disponible, queremos recuperar información relativa a los pedidos realizados 
sobre ellos. Por lo tanto, el objetivo de este caso de uso es recuperar un listado de los **últimos N pedidos**, siendo
de obligatorio cumplimiento que:

```
1 <= N <= 100
```

Dado que se requiere poder recuperar los últimos pedidos realizados, debes tener en cuenta que se debe realizar una **ordenación
por fecha de pedido**.

### 2.b) Recuperar detalle de pedido

En cualquier momento un usuario puede necesitar ver los detalles de cualquiera de sus pedidos. Para ello este caso de uso
debe devolver el detalle de un pedido dado su _ID_, el cual incluye el listado de los productos que se encuentran en el 
junto con los subtotales y su precio total.

## Ejercicio 3: Reporte sumarizado

Hasta ahora hemos ido implementando funcionalidad básica para recuperar datos de productos y sus pedidos, pero nuestros usuarios
nos han pedido poder ver, a modo de resumen, un reporte con las métricas más importantes para ellos:

* Total de productos existentes en el catálogo.
* Total de pedidos realizados.
* Importe total acumulado de todas las ventas (esto es, el sumatorio del precio total de todos los pedidos registrados).
* Total de productos existentes desgranados por categoría.

## Ejercicio 4: Ranking

Nuestros usuarios están encantados con la funcionalidad que hemos ido incorporando hasta ahora en la app, pero necesitan 
tener una visión más completa acerca de cómo se están vendiendo los productos de la compañía. Es por ello que nos han trasladado
la necesidad de tener disponible un **ranking de productos más vendidos (en función de determinados criterios) entre dos fechas 
concretas**.

Los criterios que pueden escoger para la generación del ranking son:

* **Pedidos (orders)**. Si el usuario escoge este criterio, el ranking debe listar los productos más pedidos, de mayor a menor.
Se debe contabilizar **únicamente en cuantos pedidos aparece un producto, sin importar la cantidad que se ha pedido de él**.
* **Unidades (units)**. Por este criterio el ranking lista los productos con más unidades vendidas, de mayor a menor.
* **Importe total vendido (amount)**. Por último, este ranking listaría los productos con mayor importe vendido, de mayor a menor.

Cuando el ranking se ha generado, cada producto debe llevar informado tanto su posición dentro de este (_rank_) como la
cifra que da significado a su posición (_score_) y que es relativa al criterio escogido.
