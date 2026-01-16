package models

class SmartLightDevice(val deviceName: String, val deviceCategory: String) : SmartDevice(deviceName, deviceCategory) {
    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    override var deviceType = "Android TV"

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$deviceName turned on. The brightness level is $brightnessLevel. $deviceType")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$$deviceName turned off. The brightness level is $brightnessLevel.")
    }
}