import models.SmartDevice
import models.SmartLightDevice
import models.SmartTvDevice

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()


//    val trickFunction =trick
//    trickFunction()
//    trick()
//    treat()


//    val treatFunction = trickOrTreat(false)
//    val trickFunction = trickOrTreat(true)
//    treatFunction()
//    trickFunction()


}

val trick = {
    println("No treats!")
}

val treat:()->Unit= {
    println("Have a treat!")
}

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        return treat
    }
}