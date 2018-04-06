### Congrats

Dado un objeto de negocio, una contras puntualmente, necesitamos que esta sufra modificaciones en función del cliente 
recibe la respuesta.

Ver aquí ejemplos: 

```java
public class DojoTest {
	
	@Before
	public void setup() {
	}

    @Test
    public void test_congrats_order_paid_off_for_ios_8_10_0() throws IOException {
        Map congrats = JSONMapper.toObject(
                ResourceLoader.getFileAsString("congrats/congrats/congrats_order_paid_off_for_ios_8_10_0.json"),
                Map.class
        );

        assertEquals(
                ((List<Map>)congrats.get("sections")).get(0).get("type"),
                "mlu_offline_payment"
        );

    }

    @Test
    public void test_congrats_order_paid_off_for_android_7_12_0() throws IOException {
        Map congrats = JSONMapper.toObject(
                ResourceLoader.getFileAsString("congrats/congrats/congrats_order_paid_off_for_android_7_12_0.json"),
                Map.class
        );

        assertEquals(
                ((List<Map>)congrats.get("sections")).get(0).get("type"),
                "offline_payment"
        );

    }

}
```

El objetivo del dojo es descubrir los mecanísmos por los cuales esta adaptación puede llevarse a cabo.archivo [test/solution.js](javascripts/test/solution.js)

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
