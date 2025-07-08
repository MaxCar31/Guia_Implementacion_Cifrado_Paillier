/*
 * Demostración de multiplicación homomórfica para capturas de pantalla
 */

import java.math.*;
import java.util.*;

public class PaillierMultiplicacion {
    
    public static void main(String[] args) {
        try {
            System.out.println("5. MULTIPLICACIÓN HOMOMÓRFICA");
            System.out.println("=============================");
            
            Paillier paillier = new Paillier(512);
            
            // Mensaje y escalar
            BigInteger mensaje = new BigInteger("15");
            BigInteger escalar = new BigInteger("4");
            
            System.out.println("Demostración: E(m)^k = E(m * k)");
            System.out.println();
            
            // Cifrar mensaje
            BigInteger cifrado = paillier.encrypt(mensaje);
            
            System.out.println("Mensaje: " + mensaje);
            System.out.println("Escalar: " + escalar);
            System.out.println("Multiplicación esperada: " + mensaje + " * " + escalar + " = " + mensaje.multiply(escalar));
            System.out.println();
            
            System.out.println("Cifrado del mensaje:");
            System.out.println(cifrado);
            System.out.println();
            
            // Realizar multiplicación homomórfica (exponenciación del cifrado)
            BigInteger multiplicacionHomomorfica = cifrado.modPow(escalar, paillier.getNsquare());
            
            System.out.println("Multiplicación homomórfica (E(m)^k mod n²):");
            System.out.println(multiplicacionHomomorfica);
            System.out.println();
            
            // Descifrar el resultado
            BigInteger resultadoMultiplicacion = paillier.decrypt(multiplicacionHomomorfica);
            
            System.out.println("Descifrado del resultado: " + resultadoMultiplicacion);
            System.out.println("Producto esperado:       " + mensaje.multiply(escalar));
            System.out.println("✓ Verificación: " + (resultadoMultiplicacion.equals(mensaje.multiply(escalar)) ? "CORRECTO" : "ERROR"));
            System.out.println();
            
            // Ejemplo adicional
            System.out.println("--- EJEMPLO ADICIONAL ---");
            BigInteger mensaje2 = new BigInteger("7");
            BigInteger escalar2 = new BigInteger("6");
            BigInteger cifrado2 = paillier.encrypt(mensaje2);
            BigInteger mult2 = cifrado2.modPow(escalar2, paillier.getNsquare());
            BigInteger resultado2 = paillier.decrypt(mult2);
            
            System.out.println("Mensaje: " + mensaje2 + ", Escalar: " + escalar2);
            System.out.println("Resultado: " + resultado2 + " (esperado: " + mensaje2.multiply(escalar2) + ")");
            System.out.println("✓ Verificación: " + (resultado2.equals(mensaje2.multiply(escalar2)) ? "CORRECTO" : "ERROR"));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
