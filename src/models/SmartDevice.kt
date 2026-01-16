package models


open class SmartDevice(val name: String, val category: String) {
    var deviceStatus: String? = null

    open fun turnOn() {

    }

    open fun turnOff() {

    }
}