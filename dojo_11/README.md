### Edit Mode

El flow de checkout tiene diferentes pasos que se suceden a medida que el usuario hace selecciones. El ultimo paso es la “Review” donde se muestra un resumen de las selecciones, con la posibilidad de modificar alguna.
Desde la review se puede modificar lo antes seleccionado. Yendo a pantallas antes mostradas.

En caso de modificar alguna opción, el paso siguiente no debe ser el mismo que durante la primer selección.

Para ello en las aplicaciones existe una clase Flow que determina cual es el siguiente paso, usando un flag booleano *editMode*.


Ver aquí ejemplos: 

```java
public class DojoTest {
	
	@Before
	public void setup() {
	    
	}
	

}
```

El objetivo del ejercicio es evitar el uso de un flag booleano.

### Conclusiones

A lo largo del dojo nos topamos con distintos problemas que nos hicieron llegar a las siguientes conclusiones:

- Capas de abstracción ahísladas: El servicio de Gateway (que nos dice si pedir o no SEC) debe existir en una capa de abstracción distina a la de los pasos (CheckoutStep).

- Dar entidad a los conceptos del negocio: ```SeleccionDeMedioDePago```, ```SeleccionDeMedioDeEnvio```, ```Visa```, ```RedlinkATM```, etc.

- Mitigar métodos ```isABC```: [Cómo?](https://github.com/diegosanchez/writting_ifs). [Porqué?](https://meli.facebook.com/groups/1600815993576388/2023747861283197/).

- Test de Integración vs. Test Unitarios: Encontramos que los test de integración favorecieron el entendimiento del problema sumado a que permiten probar interacciones completas.

- Favorece colaboración externa: Un integrante del equipo se sumó al dojo (luego de estar ausente) y tomando un código escrito por un tercero pudo retomar el desarrollo sin demoras.

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

1. Instalamos módulos

    ```bash
        npm install
    ```

2. Ejecutamos los tests

    ```bash
        npm run test
    ```
    
    o
    
    ```bash
        make
    ```

#### Qué necesito?

2. node 4.2.3
3. npm  2.14.7


### Pasos específicos para java

1. Ejecutamos los tests

    ```bash
        mvn test
        ( Estando en la carpeta que contiene el pom.xml )
    ```



#### Qué necesito?

1. Maven 3+ ( brew install maven )
2. JDK 1.7 u 1.8## Pasos para realizar el workshop


## Qué necesito?

1. Notebook para realizar workshop (si queres hacerlo, sino podes venir a compartir tus experiencias)
2. Ganas de compartir tu solución.
