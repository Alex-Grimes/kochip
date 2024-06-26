package org.kochip.drivers

import java.awt.event.KeyListener
import javax.swing.SwingUtilities
import javax.swing.WindowConstants
import java.awt.event.KeyEvent
import javax.swing.JFrame

class InputDriver(frame: JFrame) : KeyListener {

    private val keyStates = BooleanArray(16)
    init {
        frame.addKeyListener(this)
    }

    override fun keyTyped(e: KeyEvent?) {
        TODO("Not yet implemented")
    }

    override fun keyPressed(e: KeyEvent?) {
        if (e != null) {
            updateKeyState(e.keyCode, true)
        }
    }

    override fun keyReleased(e: KeyEvent?) {
       if (e != null){
           updateKeyState(e.keyCode, false)
       }
    }

    private fun updateKeyState(keyCode: Int, pressed: Boolean){
        val index = when (keyCode){
            KeyEvent.VK_1 -> 0x1
            KeyEvent.VK_2 -> 0x2
            KeyEvent.VK_3 -> 0x3
            KeyEvent.VK_4 -> 0xC
            KeyEvent.VK_Q -> 0x4
            KeyEvent.VK_W -> 0x5
            KeyEvent.VK_E -> 0x6
            KeyEvent.VK_R -> 0xD
            KeyEvent.VK_A -> 0x7
            KeyEvent.VK_S -> 0x8
            KeyEvent.VK_D -> 0x9
            KeyEvent.VK_F -> 0xE
            KeyEvent.VK_Z -> 0xA
            KeyEvent.VK_X -> 0x0
            KeyEvent.VK_C -> 0xB
            KeyEvent.VK_V -> 0xF
            else -> -1
        }

        if (index != -1){
            keyStates[index] = pressed
        }
    }

    fun poll(): BooleanArray{
        return keyStates.copyOf()

    }
}