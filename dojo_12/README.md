### Asignación de aulas

En la Universidad de la Matanza, se dispone de un lugar llamado CAU (Centro Atención Unificado), el cual se encarga de asignar aulas y laboratorios bajo solicitud de los docentes. Dada una solicitud, debe devolverse un aula y una etiqueta, que indique que aula fue asignada y permita pegarse en la puerta de la misma (Ej: "Aula: Lab B").

- Dado un conjunto de Aulas disponibles, se solicita una de ellas con capacidad para al menos 10 personas. 
Ej:  [{nombre:”Lab A”, capacidad:5},{nombre:”Lab B”, capacidad:15}]   -> "Aula: Lab B"

-  Dado el mismo listado, se solicita un aula para 30 personas. Se espera como respuesta: “No hay aula disponible”
Ej:  [{nombre:”Lab A”, capacidad:5},{nombre:”Lab B”, capacidad:15}]   -> “No hay aula disponible” 

[Lista completa de requerimientos](https://docs.google.com/document/d/1PjtEB4CMJLMYpQl03Yq51OaEFJPuCohUiYlokl4kA8M/edit?usp=sharing)

### Metodología

Programación orientada a objetos + TDD

### Agenda

1. Planteo de problema (5 minutos)
2. Codificación (30 - 40 minutos)
3. Puesta en común (Hasta el final)

## Pasos para realizar el workshop 

1. Clonamos el repo:

    ```bash
        git clone https://github.com/diegosanchez/dojo.git
    ```

2. Descargamos el branch remote correspondiente al workshop:

    ```bash
        git checkout workshop
    ```

### Pasos específicos para javascript
0. Instalar [Node Version Manager](https://github.com/creationix/nvm#installation)

1. Ingresar a la carpeta `javascript` del ejercicio sobre el cual vamos a trabajar.

2. Instalar la version de JS que figura en el file [.nvmrc], por ejemplo:

    ```bash
        nvm install 8.9.1
    ```
    > Este paso es necesario solo la primera vez que instalamos cada versión.

3. Decirle a nvm que version de node queremos utilizar

    ```bash
        nvm use
    ```
    > Este comando va a setear la version definida en el file [.nvmrc] como la version de node a utilizar

4. Instalamos las dependencias

    ```bash
        npm i
    ```

4. Ejecutamos los tests

    ```bash
        npm test
    ```

5. Miramos nuestra cobertura

    ```bash
        npm run coverage
    ```

### Pasos específicos para java

1. Ejecutamos los tests

    ```bash
        mvn test
        ( Estando en la carpeta que contiene el pom.xml )
    ```



#### Qué necesito?

1. Maven 3+ ( brew install maven )
2. JDK 1.7 u 1.8## Pasos para realizar el workshop

