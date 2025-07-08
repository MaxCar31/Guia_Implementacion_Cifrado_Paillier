/*
 * Programa simplificado para generar capturas de pantalla claras
 * para el documento del trabajo de Paillier
 */

import java.math.*;
import java.util.*;

public class PaillierCapturas {
    
    public static void main(String[] args) {
        try {
            System.out.println("TRABAJO: IMPLEMENTACIÓN DEL CIFRADO PAILLIER");
            System.out.println("=============================================");
            System.out.println();
            
            // Inicialización
            Paillier paillier = new Paillier(512);
            System.out.println("✓ Sistema Paillier inicializado (módulo 512 bits)");
            System.out.println();
            
            // PARTE 1: CIFRADO DE DATOS
            System.out.println("1. CIFRADO DE DATOS");
            System.out.println("==================");
            
            BigInteger mensaje1 = new BigInteger("42");
            BigInteger mensaje2 = new BigInteger("17");
            
            System.out.println("Mensaje 1: " + mensaje1);
            BigInteger cifrado1 = paillier.encrypt(mensaje1);
            System.out.println("Cifrado 1: " + cifrado1);
            System.out.println();
            
            System.out.println("Mensaje 2: " + mensaje2);
            BigInteger cifrado2 = paillier.encrypt(mensaje2);
            System.out.println("Cifrado 2: " + cifrado2);
            System.out.println();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
