/*
 * Demostración de suma homomórfica para capturas de pantalla
 */

import java.math.*;
import java.util.*;

public class PaillierSuma {
    
    public static void main(String[] args) {
        try {
            System.out.println("4. SUMA HOMOMÓRFICA DE TEXTOS CIFRADOS");
            System.out.println("======================================");
            
            Paillier paillier = new Paillier(512);
            
            // Mensajes a sumar
            BigInteger mensaje1 = new BigInteger("42");
            BigInteger mensaje2 = new BigInteger("17");
            
            System.out.println("Demostración: E(m1) * E(m2) = E(m1 + m2)");
            System.out.println();
            
            // Cifrar mensajes
            BigInteger cifrado1 = paillier.encrypt(mensaje1);
            BigInteger cifrado2 = paillier.encrypt(mensaje2);
            
            System.out.println("Mensaje 1: " + mensaje1);
            System.out.println("Mensaje 2: " + mensaje2);
            System.out.println("Suma esperada: " + mensaje1 + " + " + mensaje2 + " = " + mensaje1.add(mensaje2));
            System.out.println();
            
            System.out.println("Cifrado del mensaje 1:");
            System.out.println(cifrado1);
            System.out.println();
            
            System.out.println("Cifrado del mensaje 2:");
            System.out.println(cifrado2);
            System.out.println();
            
            // Realizar suma homomórfica (multiplicación de cifrados)
            BigInteger sumaHomomorfica = cifrado1.multiply(cifrado2).mod(paillier.getNsquare());
            
            System.out.println("Suma homomórfica (E(m1) * E(m2) mod n²):");
            System.out.println(sumaHomomorfica);
            System.out.println();
            
            // Descifrar el resultado
            BigInteger resultadoSuma = paillier.decrypt(sumaHomomorfica);
            
            System.out.println("Descifrado del resultado: " + resultadoSuma);
            System.out.println("Suma esperada:           " + mensaje1.add(mensaje2));
            System.out.println("✓ Verificación: " + (resultadoSuma.equals(mensaje1.add(mensaje2)) ? "CORRECTO" : "ERROR"));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
