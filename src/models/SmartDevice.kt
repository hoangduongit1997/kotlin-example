package models


open class SmartDevice(val name: String, val category: String) {
    var deviceStatus: String? = null
    open var deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}