# Proyecto: Fábrica de Transformaciones de Piezas

## Descripción:
Este proyecto simula una fábrica con una cadena de montaje que transforma una pieza a través de distintas máquinas. Las máquinas modifican la pieza en función de su tipo (fresadora, lijadora, taladradora, rotadora) y los parámetros especificados (grosor, dirección, etc.).

Cada máquina actúa sobre una parte específica de la pieza, la cual está representada por una matriz 3x3. Las máquinas pueden realizar varias transformaciones sobre cada cuadro de la matriz, y el resultado final se puede ver como una representación de texto de la pieza transformada.

## Requisitos:
- Java 8 o superior.
- IDE: Se recomienda usar IntelliJ IDEA o Eclipse.

## Estructura del Proyecto:
### Clases principales:
- **Fábrica**: Controla las máquinas y gestiona el proceso de transformación.
- **Pieza**: Representa la pieza sobre la que actúan las máquinas.
- **Maquina**: Interfaz con el método actua(Pieza).
- **Fresadora**, **Lijadora**, **Taladradora**, **Rotadora**: Implementaciones de la interfaz **Maquina**.

### Métodos Clave:
- **actua(Pieza)**: Método que modifica una pieza cuando una máquina la usa.
- **aleatoria(int n)**: Método de clase que crea una fábrica aleatoria con n máquinas.

## Ejemplo de Uso:
Crear una fábrica aleatoria: Puedes crear una fábrica aleatoria con el siguiente código:

```java
Fabrica fabrica = Fabrica.aleatoria(10);
Esto generará una cadena de montaje con 10 máquinas de tipo aleatorio.

Representación de la pieza:
La pieza se muestra como una matriz de 3x3, donde cada cuadro tiene marcas representando las transformaciones realizadas.

Representación de la Pieza:
Cada cuadro de la pieza está representado por tres espacios de caracteres, donde se muestra la marca y el grosor de la transformación realizada. Ejemplo:

Copiar
Editar
| LE2 FH3 FI1 TL1 | LO3 |
| TL3 | FI2 |
| | | |
Consideraciones:
No tiene sentido girar una pieza en un sentido para inmediatamente después girarla en el sentido contrario.
Los giros al principio de la cadena de montaje no tienen sentido práctico.




