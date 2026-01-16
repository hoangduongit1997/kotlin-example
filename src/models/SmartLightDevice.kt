package models

class SmartLightDevice(val deviceName:String, val deviceCategory: String): SmartDevice(deviceName, deviceCategory)  {
    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        deviceStatus = "on"
        brightnessLevel = 2
        println("$deviceName turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        deviceStatus = "off"
        brightnessLevel = 0
        println("$$deviceName turned off. The brightness level is $brightnessLevel.")
    }
}