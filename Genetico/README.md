# Proyecto Genético - Implementación

Este directorio contiene la implementación del algoritmo genético. Las clases y interfaces se organizan para permitir la resolución de problemas de optimización utilizando cromosomas binarios.

## Estructura del Código

- **Cromosoma.java**: Representación de un cromosoma, con métodos para mutación y acceso a los genes.
- **Problema.java**: Interfaz para definir problemas de optimización. Implementada por clases como OneMax y CeroMax.
- **Individuo.java**: Representación de un individuo con un cromosoma y su fitness asociado.
- **Poblacion.java**: Clase que gestiona una población de individuos, permitiendo obtener el mejor individuo y reemplazar al peor.
- **AlgoritmoGenetico.java**: Clase base para los algoritmos genéticos. Contiene la lógica general de ejecución del algoritmo.
- **AGUnPunto.java** y **AGUniforme.java**: Implementaciones de algoritmos genéticos con diferentes métodos de recombinación de cromosomas.

## Funcionamiento

1. **Cromosomas** son generados de manera aleatoria o inicializados.
2. **Individuos** se crean con un cromosoma y su fitness evaluado.
3. **AlgoritmoGenetico** ejecuta generaciones de evolución con selección, recombinación y mutación.
4. **Poblacion** gestiona los individuos y realiza reemplazo de los peores individuos por mejores soluciones.

## Ejecución

1. Inicializa el algoritmo genético con parámetros específicos.
2. Llama al método `ejecuta()` para realizar el proceso de optimización.

## Test

Se incluye la clase **TestGenetico** para probar los dos tipos de algoritmos genéticos implementados (un punto y uniforme).
