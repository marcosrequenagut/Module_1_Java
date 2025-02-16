**Descripción:**

El proyecto **UniversoV2** es una simulación de un universo donde interactúan partículas con características físicas. Cada partícula tiene propiedades como posición, velocidad, masa y radio, y el universo tiene un radio definido. Este proyecto proporciona la base para la creación de universos más complejos en versiones posteriores.

**Estructura:**

El proyecto está compuesto por clases que representan tanto las partículas como el universo, y métodos para interactuar con ellas y simular su comportamiento.

## Clases Principales:

1. **Particula:**
   - **Descripción:** Representa una partícula dentro del universo. Cada partícula tiene propiedades como su posición, velocidad, masa y radio.
   - **Campos:**
     - `posX`, `posY`: Coordenadas de la posición de la partícula.
     - `velX`, `velY`: Componentes del vector velocidad de la partícula.
     - `masa`: Masa de la partícula.
     - `radio`: Radio de la partícula.

2. **Universo:**
   - **Descripción:** Representa el universo donde las partículas interactúan. El universo tiene un radio y un conjunto de partículas que interactúan entre sí.
   - **Métodos:**
     - `agregarParticula(Particula p)`: Agrega una partícula al universo.
     - `simular()`: Realiza una simulación de las interacciones de las partículas en el universo.

3. **Simulacion:**
   - **Descripción:** Clase encargada de gestionar la simulación de las partículas en el universo. Administra el avance del tiempo y la interacción entre las partículas.
   - **Métodos:**
     - `avanzarTiempo()`: Avanza el tiempo en la simulación y actualiza el estado de las partículas.

## Requisitos:
- **Java 11 o superior** para ejecutar el proyecto.
