/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;

import java.util.zip.CRC32;

/**
 *
 * @author Avan
 */
//throw new IllegalArgumentException
public class Utils {
   


    

     public static String calculateCRC32(String input) {
        // Check if input is exactly 12 digits long
        if (input.length() != 12) {
            throw new IllegalArgumentException("Input must be exactly 12 digits long.");
        }

        // Create CRC32 object
        CRC32 crc32 = new CRC32();

        // Update the CRC32 object with the bytes from the input string
        crc32.update(input.getBytes());

        // Get the CRC32 hash value as long
        long crc32Hash = crc32.getValue();

        
        // Ensure the hash value is 6 digits long
        String sixDigitHash = String.format("%06d", crc32Hash % 1000000);
        
        // Convert long to string and return
        return sixDigitHash;
    }
}

//    private static long calculateCRC32Hash(String data) {
//        CRC32 crc32 = new CRC32();
//        crc32.update(data.getBytes());
//        return crc32.getValue();
//    }}
//}
