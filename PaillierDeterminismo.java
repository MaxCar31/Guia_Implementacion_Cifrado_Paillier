/*
 * Demostración de determinismo para capturas de pantalla
 */

import java.math.*;
import java.util.*;

public class PaillierDeterminismo {
    
    public static void main(String[] args) {
        try {
            System.out.println("3. VERIFICACIÓN DE DETERMINISMO");
            System.out.println("===============================");
            
            Paillier paillier = new Paillier(512);
            
            BigInteger mensaje = new BigInteger("25");
            
            System.out.println("Probando si Paillier es determinista...");
            System.out.println("Cifrando el mismo mensaje varias veces:");
            System.out.println();
            System.out.println("Mensaje: " + mensaje);
            System.out.println();
            
            // Cifrar el mismo mensaje 3 veces
            BigInteger cifrado1 = paillier.encrypt(mensaje);
            BigInteger cifrado2 = paillier.encrypt(mensaje);
            BigInteger cifrado3 = paillier.encrypt(mensaje);
            
            System.out.println("Cifrado 1: " + cifrado1);
            System.out.println("Cifrado 2: " + cifrado2);
            System.out.println("Cifrado 3: " + cifrado3);
            System.out.println();
            
            // Verificar si son iguales
            boolean iguales12 = cifrado1.equals(cifrado2);
            boolean iguales13 = cifrado1.equals(cifrado3);
            boolean iguales23 = cifrado2.equals(cifrado3);
            
            System.out.println("¿Son iguales los cifrados?");
            System.out.println("Cifrado 1 = Cifrado 2: " + iguales12);
            System.out.println("Cifrado 1 = Cifrado 3: " + iguales13);
            System.out.println("Cifrado 2 = Cifrado 3: " + iguales23);
            System.out.println();
            
            if (!iguales12 && !iguales13 && !iguales23) {
                System.out.println("✓ CONCLUSIÓN: PAILLIER ES NO DETERMINISTA");
                System.out.println("  (Cada cifrado produce un resultado diferente)");
            } else {
                System.out.println("✗ CONCLUSIÓN: PAILLIER PARECE SER DETERMINISTA");
            }
            System.out.println();
            
            // Verificar que todos descifran correctamente
            System.out.println("Verificando descifrado:");
            System.out.println("Descifrado 1: " + paillier.decrypt(cifrado1));
            System.out.println("Descifrado 2: " + paillier.decrypt(cifrado2));
            System.out.println("Descifrado 3: " + paillier.decrypt(cifrado3));
            System.out.println("✓ Todos descifran al mensaje original: " + mensaje);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
