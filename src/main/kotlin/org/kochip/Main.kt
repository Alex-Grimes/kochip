package org.kochip

import org.kochip.drivers.CHIP8_HEIGHT
import org.kochip.drivers.CHIP8_WIDTH
import org.kochip.drivers.DisplayDriver
import org.kochip.drivers.InputDriver
import javax.swing.JFrame
import javax.swing.WindowConstants

fun main() {

    val display = DisplayDriver()
    display.pixels = Array(CHIP8_HEIGHT) { IntArray(CHIP8_WIDTH) }

    val frame = JFrame("CHIP-8")
    frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    frame.contentPane.add(display)
    frame.pack()
    frame.isVisible = true

    display.repaint()
    val input = InputDriver(frame)

    while (true) {
        val keys = input.poll()
        display.repaint()
        Thread.sleep(1000/60)
    }
}
