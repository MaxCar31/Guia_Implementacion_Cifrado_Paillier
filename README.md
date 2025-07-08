# TRABAJO PRÁCTICO: CIFRADO PAILLIER

## ✅ REQUISITOS CUMPLIDOS

Este proyecto implementa completamente el cifrado Paillier con todas las operaciones solicitadas:

### 📋 OPERACIONES IMPLEMENTADAS

1. ✅ **Cifrar datos**
2. ✅ **Descifrar datos**  
3. ✅ **Verificar si Paillier es determinista o no determinista**
4. ✅ **Suma de textos cifrados (homomorfismo aditivo)**
5. ✅ **Multiplicación de un texto cifrado por un número en texto plano**

## 🚀 INSTRUCCIONES PARA EJECUTAR

### Paso 1: Verificar Java
```bash
java -version
```
✅ **Ya tienes Java 23 instalado - perfecto!**

### Paso 2: Compilar
```bash
cd "c:\Users\mateo\Documents\Paillier"
javac *.java
```

### Paso 3: Ejecutar para Capturas de Pantalla

#### Para tu documento, ejecuta estos comandos y toma capturas:

```bash
# 1. CIFRADO DE DATOS
java PaillierCapturas

# 2. DESCIFRADO DE DATOS  
java PaillierDescifrado

# 3. VERIFICACIÓN DE DETERMINISMO
java PaillierDeterminismo

# 4. SUMA HOMOMÓRFICA
java PaillierSuma

# 5. MULTIPLICACIÓN HOMOMÓRFICA
java PaillierMultiplicacion

# 6. DEMOSTRACIÓN COMPLETA (OPCIONAL)
java PaillierDemo
```

## 📸 CAPTURAS PARA TU DOCUMENTO

Toma capturas de pantalla de cada ejecución mostrando:

### 1. Cifrado de Datos
- Mensajes originales: 42, 17, 100
- Sus respectivos textos cifrados
- **Comando**: `java PaillierDescifrado`

### 2. Descifrado de Datos
- Proceso completo de cifrado → descifrado
- Verificación de que el descifrado es correcto
- **Comando**: `java PaillierDescifrado`

### 3. Verificación de Determinismo
- Mismo mensaje (25) cifrado 3 veces
- Resultados diferentes → **NO DETERMINISTA**
- Todos descifran al mismo valor original
- **Comando**: `java PaillierDeterminismo`

### 4. Suma Homomórfica
- E(42) × E(17) = E(59)
- Demostración de que la suma funciona sin descifrar
- **Comando**: `java PaillierSuma`

### 5. Multiplicación Homomórfica
- E(15)^4 = E(60) 
- E(7)^6 = E(42)
- **Comando**: `java PaillierMultiplicacion`

## 📊 RESULTADOS ESPERADOS

### ✅ Cifrado/Descifrado
- Los mensajes se cifran a números muy grandes
- El descifrado recupera exactamente el mensaje original

### ✅ No Determinismo
- **CONFIRMADO**: Paillier es NO determinista
- El mismo mensaje produce cifrados diferentes cada vez
- Pero todos descifran al mensaje original

### ✅ Suma Homomórfica
- 42 + 17 = 59 ✅
- La suma se realiza sin descifrar los datos

### ✅ Multiplicación Homomórfica  
- 15 × 4 = 60 ✅
- 7 × 6 = 42 ✅
- La multiplicación funciona correctamente

## 📝 ESTRUCTURA DEL DOCUMENTO

Tu documento debe incluir:

1. **Introducción** - Qué es Paillier y para qué sirve
2. **Código fuente** - `Paillier.java` (ya lo tienes)
3. **Capturas de pantalla** - De cada operación
4. **Análisis de resultados** - Explicar qué demuestran
5. **Conclusiones** - Verificación de propiedades

## 🎯 PUNTOS CLAVE PARA TU DOCUMENTO

### Características de Paillier:
- **Homomórfico aditivo**: Permite sumar sin descifrar
- **No determinista**: Diferentes cifrados del mismo mensaje
- **Seguro**: Basado en problemas matemáticos difíciles
- **Aplicaciones**: Votación electrónica, computación en la nube

### Propiedades Matemáticas:
- **Suma**: E(m₁) × E(m₂) mod n² = E(m₁ + m₂)
- **Multiplicación escalar**: E(m)ᵏ mod n² = E(m × k)

## 🔧 INSTALACIÓN NECESARIA

**¡Solo necesitas Java!** - Ya lo tienes instalado ✅

No necesitas:
- ❌ Bibliotecas adicionales
- ❌ Frameworks especiales  
- ❌ Configuración compleja

## 🚨 COMANDOS RÁPIDOS PARA CAPTURAS

```bash
# Compilar una vez
javac *.java

# Ejecutar para cada captura
java PaillierDescifrado        # Cifrado y descifrado
java PaillierDeterminismo      # Determinismo  
java PaillierSuma              # Suma homomórfica
java PaillierMultiplicacion    # Multiplicación homomórfica
```


