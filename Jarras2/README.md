# Jarras2

Este programa implementa la clase `Jarra`, que permite simular operaciones básicas con jarras de agua.

## Descripción

Cada jarra tiene:
- Una **capacidad fija** (definida en el constructor).
- Un **contenido variable** (cantidad de agua actual).

## Funcionalidades implementadas:
- **Llenar** una jarra por completo desde un grifo.
- **Vaciar** la jarra completamente.
- **Transferir** agua de una jarra a otra, hasta que la jarra destino se llene o la jarra origen se vacíe.

### Ejemplo de uso

Supongamos que tenemos dos jarras:  
- Jarra A con capacidad de **7 litros**  
- Jarra B con capacidad de **4 litros**

Podemos realizar acciones como:
```java
Jarra A = new Jarra(7);
Jarra B = new Jarra(4);

A.llenar();   // Llena la jarra A completamente (7L)
A.vaciar();   // Vacía la jarra A (0L)
A.llenarDesde(B); // Transfiere agua de B a A
