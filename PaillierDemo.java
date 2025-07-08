/*
 * Demostración de las operaciones del cifrado Paillier
 * Incluye: cifrado, descifrado, verificación de determinismo,
 * suma homomórfica y multiplicación homomórfica
 */

import java.math.*;
import java.util.*;

public class PaillierDemo {
    
    public static void main(String[] args) {
        try {
            System.out.println("=== DEMOSTRACIÓN DEL CIFRADO PAILLIER ===\n");
            
            // Crear una instancia de Paillier con módulo de 512 bits
            System.out.println("1. INICIALIZACIÓN DEL SISTEMA PAILLIER");
            System.out.println("Creando claves con módulo de 512 bits...");
            Paillier paillier = new Paillier(512);
            System.out.println("✓ Claves generadas exitosamente\n");
            
            // Mostrar la clave pública
            Vector publicKey = paillier.publicKey();
            System.out.println("Clave pública (n, g):");
            System.out.println("n = " + publicKey.get(0));
            System.out.println("g = " + publicKey.get(1));
            System.out.println();
            
            // 2. CIFRADO DE DATOS
            System.out.println("2. CIFRADO DE DATOS");
            BigInteger mensaje1 = new BigInteger("42");
            BigInteger mensaje2 = new BigInteger("17");
            BigInteger mensaje3 = new BigInteger("100");
            
            System.out.println("Mensajes a cifrar:");
            System.out.println("Mensaje 1: " + mensaje1);
            System.out.println("Mensaje 2: " + mensaje2);
            System.out.println("Mensaje 3: " + mensaje3);
            System.out.println();
            
            BigInteger cifrado1 = paillier.encrypt(mensaje1);
            BigInteger cifrado2 = paillier.encrypt(mensaje2);
            BigInteger cifrado3 = paillier.encrypt(mensaje3);
            
            System.out.println("Textos cifrados:");
            System.out.println("Cifrado 1: " + cifrado1);
            System.out.println("Cifrado 2: " + cifrado2);
            System.out.println("Cifrado 3: " + cifrado3);
            System.out.println();
            
            // 3. DESCIFRADO DE DATOS
            System.out.println("3. DESCIFRADO DE DATOS");
            BigInteger descifrado1 = paillier.decrypt(cifrado1);
            BigInteger descifrado2 = paillier.decrypt(cifrado2);
            BigInteger descifrado3 = paillier.decrypt(cifrado3);
            
            System.out.println("Verificación del descifrado:");
            System.out.println("Mensaje 1 original: " + mensaje1 + " → Descifrado: " + descifrado1 + " → ✓ " + (mensaje1.equals(descifrado1) ? "CORRECTO" : "ERROR"));
            System.out.println("Mensaje 2 original: " + mensaje2 + " → Descifrado: " + descifrado2 + " → ✓ " + (mensaje2.equals(descifrado2) ? "CORRECTO" : "ERROR"));
            System.out.println("Mensaje 3 original: " + mensaje3 + " → Descifrado: " + descifrado3 + " → ✓ " + (mensaje3.equals(descifrado3) ? "CORRECTO" : "ERROR"));
            System.out.println();
            
            // 4. VERIFICAR DETERMINISMO
            System.out.println("4. VERIFICACIÓN DE DETERMINISMO");
            System.out.println("Cifrando el mismo mensaje varias veces para verificar si es determinista...");
            
            BigInteger mensajePrueba = new BigInteger("25");
            BigInteger cifrado_a = paillier.encrypt(mensajePrueba);
            BigInteger cifrado_b = paillier.encrypt(mensajePrueba);
            BigInteger cifrado_c = paillier.encrypt(mensajePrueba);
            
            System.out.println("Mensaje: " + mensajePrueba);
            System.out.println("Cifrado A: " + cifrado_a);
            System.out.println("Cifrado B: " + cifrado_b);
            System.out.println("Cifrado C: " + cifrado_c);
            
            boolean esIgualAB = cifrado_a.equals(cifrado_b);
            boolean esIgualAC = cifrado_a.equals(cifrado_c);
            boolean esIgualBC = cifrado_b.equals(cifrado_c);
            
            System.out.println();
            System.out.println("¿Son iguales los cifrados?");
            System.out.println("A = B: " + esIgualAB);
            System.out.println("A = C: " + esIgualAC);
            System.out.println("B = C: " + esIgualBC);
            
            if (!esIgualAB && !esIgualAC && !esIgualBC) {
                System.out.println("✓ CONCLUSIÓN: Paillier es NO DETERMINISTA");
                System.out.println("  (Cada cifrado del mismo mensaje produce un resultado diferente)");
            } else {
                System.out.println("✗ CONCLUSIÓN: Paillier parece ser determinista (resultado inesperado)");
            }
            System.out.println();
            
            // Verificar que todos descifran al mismo valor
            System.out.println("Verificando que todos descifran al mismo mensaje:");
            System.out.println("Descifrado A: " + paillier.decrypt(cifrado_a));
            System.out.println("Descifrado B: " + paillier.decrypt(cifrado_b));
            System.out.println("Descifrado C: " + paillier.decrypt(cifrado_c));
            System.out.println();
            
            // 5. SUMA HOMOMÓRFICA
            System.out.println("5. SUMA HOMOMÓRFICA DE TEXTOS CIFRADOS");
            System.out.println("Demostrando que E(m1) * E(m2) = E(m1 + m2)");
            System.out.println();
            
            System.out.println("Usando mensajes: " + mensaje1 + " y " + mensaje2);
            System.out.println("Suma esperada: " + mensaje1 + " + " + mensaje2 + " = " + mensaje1.add(mensaje2));
            System.out.println();
            
            // Multiplicar los textos cifrados (suma homomórfica)
            BigInteger sumaHomomorfica = cifrado1.multiply(cifrado2).mod(paillier.getNsquare());
            BigInteger resultadoSuma = paillier.decrypt(sumaHomomorfica);
            
            System.out.println("Operación homomórfica:");
            System.out.println("E(" + mensaje1 + ") * E(" + mensaje2 + ") mod n² = texto cifrado de la suma");
            System.out.println("Descifrado del resultado: " + resultadoSuma);
            System.out.println("✓ Verificación: " + (resultadoSuma.equals(mensaje1.add(mensaje2)) ? "CORRECTO" : "ERROR"));
            System.out.println();
            
            // 6. MULTIPLICACIÓN POR ESCALAR
            System.out.println("6. MULTIPLICACIÓN DE TEXTO CIFRADO POR ESCALAR");
            System.out.println("Demostrando que E(m)^k = E(m * k)");
            System.out.println();
            
            BigInteger escalar = new BigInteger("3");
            BigInteger mensajeParaMultiplicar = new BigInteger("15");
            BigInteger cifradoParaMultiplicar = paillier.encrypt(mensajeParaMultiplicar);
            
            System.out.println("Mensaje: " + mensajeParaMultiplicar);
            System.out.println("Escalar: " + escalar);
            System.out.println("Multiplicación esperada: " + mensajeParaMultiplicar + " * " + escalar + " = " + mensajeParaMultiplicar.multiply(escalar));
            System.out.println();
            
            // E(m)^k mod n²
            BigInteger multiplicacionHomomorfica = cifradoParaMultiplicar.modPow(escalar, paillier.getNsquare());
            BigInteger resultadoMultiplicacion = paillier.decrypt(multiplicacionHomomorfica);
            
            System.out.println("Operación homomórfica:");
            System.out.println("E(" + mensajeParaMultiplicar + ")^" + escalar + " mod n² = texto cifrado del producto");
            System.out.println("Descifrado del resultado: " + resultadoMultiplicacion);
            System.out.println("✓ Verificación: " + (resultadoMultiplicacion.equals(mensajeParaMultiplicar.multiply(escalar)) ? "CORRECTO" : "ERROR"));
            System.out.println();
            
            // 7. EJEMPLO COMBINADO
            System.out.println("7. EJEMPLO COMBINADO: SUMA Y MULTIPLICACIÓN HOMOMÓRFICA");
            System.out.println("Calculando: (42 * 2) + (17 * 3) = 84 + 51 = 135");
            System.out.println();
            
            BigInteger escalar1 = new BigInteger("2");
            BigInteger escalar2 = new BigInteger("3");
            
            // E(42)^2 * E(17)^3
            BigInteger mult1 = cifrado1.modPow(escalar1, paillier.getNsquare());
            BigInteger mult2 = cifrado2.modPow(escalar2, paillier.getNsquare());
            BigInteger combinado = mult1.multiply(mult2).mod(paillier.getNsquare());
            
            BigInteger resultadoCombinado = paillier.decrypt(combinado);
            BigInteger esperado = mensaje1.multiply(escalar1).add(mensaje2.multiply(escalar2));
            
            System.out.println("Resultado homomórfico: " + resultadoCombinado);
            System.out.println("Resultado esperado: " + esperado);
            System.out.println("✓ Verificación: " + (resultadoCombinado.equals(esperado) ? "CORRECTO" : "ERROR"));
            System.out.println();
            
            System.out.println("=== DEMOSTRACIÓN COMPLETADA EXITOSAMENTE ===");
            
        } catch (Exception e) {
            System.err.println("Error durante la demostración: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
