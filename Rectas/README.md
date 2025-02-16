## Descripción

Este proyecto contiene la implementación de las clases necesarias para trabajar con puntos, vectores y rectas en el plano 2D. Las clases están implementadas como `record` en Java, aprovechando sus ventajas en términos de inmutabilidad y eficiencia.

### Clases Implementadas:

1. **Punto**:
   - Representa un punto en el plano con dos coordenadas: abscisa y ordenada.
   - Incluye un método para calcular la distancia entre dos puntos.

2. **Vector**:
   - Representa un vector con un extremo en el origen.
   - Incluye métodos para calcular el ortogonal, la dirección, y la magnitud del vector.
   - Determina si dos vectores son paralelos y si un vector está ortogonal a otro.

3. **Recta**:
   - Define una recta a partir de un punto y un vector director.
   - Calcula la intersección entre dos rectas usando la regla de Cramer.
   - Genera la ecuación implícita de la recta en forma `ax + by + c = 0`.
   - Permite calcular rectas paralelas y perpendiculares a la recta original, y calcula la distancia entre un punto y la recta.

### Funciones de la Clase Recta:
- `paralelaPor(Punto p)`: Devuelve una recta paralela a la recta actual que pase por el punto `p`.
- `perpendicularPor(Punto p)`: Devuelve una recta perpendicular a la recta actual que pase por el punto `p`.
- `distanciaDesde(Punto p)`: Calcula la distancia entre la recta y el punto `p`.

### Métodos Clave en la Clase Vector:
- `extremoDesde(Punto org)`: Calcula el extremo del vector desde un punto de origen dado.
- `modulo()`: Devuelve el módulo (longitud) del vector.
- `dirección()`: Devuelve un vector unitario con la misma dirección.

### Ejemplo de uso:

```java
// Crear un punto
Punto p1 = new Punto(0, 0);

// Crear un vector con un punto extremo
Vector v1 = new Vector(p1, new Punto(3, 4));

// Crear una recta con un vector director y un punto
Recta recta = new Recta(v1, p1);
