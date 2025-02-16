# Proyecto UniversoV1 - Simulación de Partículas en un Universo

**Descripción:**

El proyecto **UniversoV1** simula un universo en el que las partículas interactúan a través de la gravedad. Cada partícula tiene propiedades como posición, velocidad, masa y radio. Las partículas se atraen entre sí según la ley de la gravitación universal, y la simulación permite observar cómo se mueven las partículas en función de su interacción.

**Paquete `universo`:**

Este paquete contiene dos clases principales que permiten crear y simular las partículas en el universo:

### 1. **Clase `Particula`:**
   Representa una partícula en el universo. Cada partícula tiene:
   - **Atributos:**
     - `posicion`: Una instancia de la clase `Punto` que indica la posición de la partícula.
     - `velocidad`: Un vector de la clase `Vector` que indica la velocidad de la partícula.
     - `masa`: La masa de la partícula.
     - `radio`: El radio de la partícula.

   - **Métodos:**
     - `fuerzaDesde(Particula part)`: Calcula la fuerza de atracción que ejerce esta partícula sobre otra, basada en la ley de la gravitación universal.
     - `mueve(Vector vz, double dt)`: Actualiza la posición y velocidad de la partícula considerando una fuerza aplicada durante un tiempo determinado (`dt`).
     - `toString()`: Devuelve una representación en cadena de la partícula con sus propiedades.

### 2. **Clase `Universo`:**
   Representa el universo que contiene un conjunto de partículas. El universo tiene:
   - **Atributos:**
     - Un **array** de partículas que forman el universo.
     - Un **radio** que representa el espacio visible del universo.
  
   - **Métodos:**
     - `avanza(double dt)`: Simula cómo las partículas se mueven dentro del universo durante un intervalo de tiempo (`dt`). Calcula las fuerzas de atracción entre las partículas y actualiza sus posiciones y velocidades.

**Interacción entre partículas:**
- Para cada partícula, se calcula la fuerza resultante por la atracción gravitatoria de todas las demás partículas en el universo, sumando las fuerzas de todas las partículas con las que interactúa.
- Luego, con esta fuerza, se actualizan la posición y velocidad de cada partícula.

**Dependencias:**
- **Proyecto `Rectas`:** El proyecto **UniversoV1** depende de las clases `Punto` y `Vector` del proyecto **Rectas**. Asegúrate de incluir el proyecto `Rectas` en tu `pom.xml`.

**Instrucciones de Uso:**

1. **Clonar el proyecto y compilar:**
   Clona el repositorio y compílalo con Maven. Asegúrate de agregar las dependencias adecuadas en el archivo `pom.xml`, incluyendo la referencia al proyecto `Rectas`.

2. **Ejecutar la simulación:**
   La clase `Main` contiene varios ejemplos que muestran cómo inicializar el universo y simular la interacción entre las partículas. Descomenta las líneas correspondientes en el método `main` para probar los ejemplos.

3. **Visualización:**
   El paquete `gui` incluye la clase `PanelUniverso`, que permite visualizar gráficamente el universo y las partículas en movimiento.
