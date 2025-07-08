/*
 * Demostración de descifrado para capturas de pantalla
 */

import java.math.*;
import java.util.*;

public class PaillierDescifrado {
    
    public static void main(String[] args) {
        try {
            System.out.println("2. DESCIFRADO DE DATOS");
            System.out.println("=====================");
            
            Paillier paillier = new Paillier(512);
            
            // Cifrar algunos mensajes
            BigInteger mensaje1 = new BigInteger("42");
            BigInteger mensaje2 = new BigInteger("17");
            BigInteger mensaje3 = new BigInteger("100");
            
            BigInteger cifrado1 = paillier.encrypt(mensaje1);
            BigInteger cifrado2 = paillier.encrypt(mensaje2);
            BigInteger cifrado3 = paillier.encrypt(mensaje3);
            
            System.out.println("Cifrando y descifrando datos...");
            System.out.println();
            
            // Descifrar
            System.out.println("Mensaje original: " + mensaje1);
            System.out.println("Texto cifrado:   " + cifrado1);
            System.out.println("Descifrado:      " + paillier.decrypt(cifrado1));
            System.out.println("✓ Verificación:  " + (mensaje1.equals(paillier.decrypt(cifrado1)) ? "CORRECTO" : "ERROR"));
            System.out.println();
            
            System.out.println("Mensaje original: " + mensaje2);
            System.out.println("Texto cifrado:   " + cifrado2);
            System.out.println("Descifrado:      " + paillier.decrypt(cifrado2));
            System.out.println("✓ Verificación:  " + (mensaje2.equals(paillier.decrypt(cifrado2)) ? "CORRECTO" : "ERROR"));
            System.out.println();
            
            System.out.println("Mensaje original: " + mensaje3);
            System.out.println("Texto cifrado:   " + cifrado3);
            System.out.println("Descifrado:      " + paillier.decrypt(cifrado3));
            System.out.println("✓ Verificación:  " + (mensaje3.equals(paillier.decrypt(cifrado3)) ? "CORRECTO" : "ERROR"));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
