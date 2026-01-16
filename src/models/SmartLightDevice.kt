package models

import delegates.RangeRegulator

class SmartLightDevice(val deviceName: String, val deviceCategory: String) : SmartDevice(deviceName, deviceCategory) {
    var brightnessLevel by RangeRegulator(
        initialValue = 0,
        minValue = 0,
        maxValue = 100,
    )


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