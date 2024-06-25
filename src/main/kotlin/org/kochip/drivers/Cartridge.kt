package org.kochip.drivers

import java.io.File
import java.io.FileInputStream

class Cartridge(filename: String) {
   val rom: UByteArray
   val size: Int

   init {
       val file = File(filename)
       val buffer = UByteArray(3584)

       val inputStream = FileInputStream(file)
       val bytesRead = inputStream.read(buffer.asByteArray())

       rom = buffer
       size = if (bytesRead != -1) bytesRead else 0

       inputStream.close()
   }
}