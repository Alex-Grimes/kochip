package org.kochip.drivers

import javax.swing.JFrame
import javax.swing.JPanel
import java.awt.*
import javax.swing.WindowConstants

const val SCALE = 20
const val CHIP8_WIDTH = 64
const val CHIP8_HEIGHT = 32


class DisplayDriver : JPanel() {
    init {
        preferredSize = Dimension(CHIP8_WIDTH * SCALE, CHIP8_HEIGHT * SCALE)
    }

    var pixels: Array<IntArray>? = null

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        val g2d = g as Graphics2D

        pixels?.let {
            for (y in it.indices) {
                for (x in it[y].indices){
                    val color = if (it[y][x] == 0) Color.BLACK else Color.WHITE
                    g2d.color = color
                    g2d.fillRect(x* SCALE, y* SCALE, SCALE, SCALE)
                }
            }
        }
    }
}

