# GUÍA COMPLETA: IMPLEMENTACIÓN DEL CIFRADO PAILLIER

## Requisitos del Sistema

### Software Necesario
- **Java Development Kit (JDK)** versión 8 o superior
- Editor de texto o IDE (VS Code, Eclipse, IntelliJ, etc.)

### Verificación de Instalación
Para verificar que Java está instalado, abre una terminal y ejecuta:
```
java -version
javac -version
```

## Estructura del Proyecto

```
Paillier/
├── Paillier.java              # Implementación base del cifrado Paillier
├── PaillierDemo.java          # Demostración completa de todas las operaciones
├── PaillierCapturas.java      # Programa para capturas de cifrado
├── PaillierDescifrado.java    # Programa para capturas de descifrado
├── PaillierDeterminismo.java  # Programa para verificar determinismo
├── PaillierSuma.java          # Programa para suma homomórfica
└── PaillierMultiplicacion.java # Programa para multiplicación homomórfica
```

## Compilación y Ejecución

### 1. Compilar todos los archivos
```bash
javac *.java
```

### 2. Ejecutar programas individuales

#### Demostración completa:
```bash
java PaillierDemo
```

#### Para capturas de pantalla específicas:
```bash
java PaillierCapturas          # Cifrado de datos
java PaillierDescifrado        # Descifrado de datos
java PaillierDeterminismo      # Verificación de determinismo
java PaillierSuma              # Suma homomórfica
java PaillierMultiplicacion    # Multiplicación homomórfica
```

## Operaciones Implementadas

### 1. CIFRADO DE DATOS
- **Propósito**: Convertir texto plano en texto cifrado
- **Función**: `encrypt(BigInteger m)`
- **Ejemplo**: Cifrar el número 42
- **Comando**: `java PaillierCapturas`

### 2. DESCIFRADO DE DATOS
- **Propósito**: Recuperar texto plano desde texto cifrado
- **Función**: `decrypt(BigInteger c)`
- **Verificación**: Comparar mensaje original con descifrado
- **Comando**: `java PaillierDescifrado`

### 3. VERIFICACIÓN DE DETERMINISMO
- **Propósito**: Verificar si el cifrado es determinista o no
- **Método**: Cifrar el mismo mensaje varias veces
- **Resultado esperado**: Paillier es NO determinista
- **Comando**: `java PaillierDeterminismo`

### 4. SUMA HOMOMÓRFICA
- **Propósito**: Sumar números sin descifrarlos
- **Propiedad**: E(m1) × E(m2) = E(m1 + m2)
- **Operación**: Multiplicar textos cifrados
- **Comando**: `java PaillierSuma`

### 5. MULTIPLICACIÓN HOMOMÓRFICA
- **Propósito**: Multiplicar un número cifrado por un escalar
- **Propiedad**: E(m)^k = E(m × k)
- **Operación**: Exponenciar texto cifrado
- **Comando**: `java PaillierMultiplicacion`

## Capturas de Pantalla Requeridas

Ejecuta cada comando y toma capturas de:

1. **Cifrado**: Ejecutar `java PaillierCapturas`
   - Mostrar mensajes originales y sus cifrados

2. **Descifrado**: Ejecutar `java PaillierDescifrado`
   - Mostrar proceso de descifrado y verificación

3. **Determinismo**: Ejecutar `java PaillierDeterminismo`
   - Mostrar que cifrados del mismo mensaje son diferentes

4. **Suma Homomórfica**: Ejecutar `java PaillierSuma`
   - Mostrar E(42) × E(17) = E(59)

5. **Multiplicación**: Ejecutar `java PaillierMultiplicacion`
   - Mostrar E(15)^4 = E(60)

6. **Demostración Completa**: Ejecutar `java PaillierDemo`
   - Mostrar todas las operaciones en una sola ejecución

## Características del Cifrado Paillier

### Propiedades Criptográficas
- **Seguridad**: Basado en el problema de residuos cuadráticos compuestos
- **Homomorfismo**: Aditivo (permite suma y multiplicación por escalar)
- **Determinismo**: NO determinista (diferentes cifrados para el mismo mensaje)
- **Tamaño de clave**: Configurable (512, 1024, 2048 bits, etc.)

### Operaciones Homomórficas
1. **Suma**: E(m1) × E(m2) mod n² = E(m1 + m2)
2. **Multiplicación por escalar**: E(m)^k mod n² = E(m × k)
3. **Combinación**: E(m1)^k1 × E(m2)^k2 = E(m1×k1 + m2×k2)

## Estructura del Documento Final

Tu documento debe incluir:

1. **Introducción**
   - Explicación del cifrado Paillier
   - Aplicaciones y propiedades

2. **Implementación**
   - Código fuente de `Paillier.java`
   - Explicación de métodos principales

3. **Demostraciones**
   - Capturas de pantalla de cada operación
   - Análisis de resultados

4. **Conclusiones**
   - Verificación de propiedades homomórficas
   - Confirmación de no determinismo
   - Aplicaciones prácticas

## Comandos de Ejecución Rápida

```bash
# Compilar todo
javac *.java

# Ejecutar demostraciones
java PaillierDemo              # Completa
java PaillierCapturas          # Solo cifrado
java PaillierDescifrado        # Solo descifrado
java PaillierDeterminismo      # Solo determinismo
java PaillierSuma              # Solo suma homomórfica
java PaillierMultiplicacion    # Solo multiplicación
```

## Solución de Problemas

### Error: "javac no se reconoce"
- Verificar que Java JDK está instalado
- Agregar Java al PATH del sistema

### Error: "java.lang.Exception"
- Verificar que los mensajes estén en el rango válido
- Asegurar que las claves se generen correctamente

### Números muy largos en la salida
- Es normal, Paillier usa números grandes para seguridad
- Los cifrados son mucho más largos que los mensajes originales
