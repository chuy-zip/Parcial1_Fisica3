package com.example.ejercicio5_parcial1_f3

import kotlin.math.PI
import kotlin.math.sqrt

fun heightFunctionOfSemicircle(maxRadius: Double, currentDistance: Double): Double {
    return sqrt(maxRadius * maxRadius - currentDistance * currentDistance)
}

//R is the radius of the cone, H the height and x the point in which we want the radius "y"
fun heightFunctionOfCone(R:Double, H: Double, x: Double): Double{
    return (R-(R/H)*x)
}
//R1 is the base or bigger radius, R2 is the second or lower radius, H the height and x the point in which we want the radius "y"
fun heightFunctionOfCutCone(R1:Double, R2: Double, H: Double, x: Double): Double{
    return (R1 + ((R2-R1)/H) * x)
}

fun electricFieldOfDisc(QCharge: Double, distance: Double, radius: Double): Double {
    val Eo = 8.85e-12

    var sumOfElectricField = 0.0
    sumOfElectricField  = (QCharge / (2 * PI * Eo * radius*radius) ) * (1 - distance/sqrt(distance*distance + radius*radius) )

    return sumOfElectricField
}
fun volumeOfSemiCircle(radius: Double) {
    val qtyOfPartitions = 100
    val partitionDistance = radius / qtyOfPartitions

    var distance: Double = partitionDistance

    var sumOfVolumes: Double = 0.0

    while (distance <= radius) {
        val partitionRadius = heightFunctionOfSemicircle(radius, distance)
        val partitionArea = PI * partitionRadius * partitionRadius
        val partitionVolume = (partitionArea * partitionDistance)  // Volume of each partition

        sumOfVolumes += partitionVolume
        distance += partitionDistance
    }

    println("Approximated volume: $sumOfVolumes")
    println("Real volume: ${(2.0 / 3.0) * PI * radius * radius * radius}")
}
fun electricFieldOfHemisphere(charge: Double, pointDistance: Double, hemisphereRadius: Double): Double{
    val qtyOfPartitions = 1000
    val partitionDistance = hemisphereRadius / qtyOfPartitions
    val chargePerPartition = charge / qtyOfPartitions  // Divide the total charge equally

    var distance: Double = partitionDistance
    var sumOfFields = 0.0

    while(distance <= hemisphereRadius){
        val partitionRadius = heightFunctionOfSemicircle(hemisphereRadius, distance)
        val distanceOfPartition =  distance + pointDistance
        val partitionField = electricFieldOfDisc(chargePerPartition, distanceOfPartition, partitionRadius)
        //println("Field: $partitionField")
        //println("Radius: $partitionRadius")
        //println("distance: $distanceOfPartition")
        //println("--------")

        sumOfFields += partitionField
        distance += partitionDistance

    }

    return sumOfFields
}

fun electricFieldOfCone(){

}

fun electricFieldOfCutCone(){

}

fun main() {
    //volumeOfSemiCircle(3.0)
    //println("Disco " + electricFieldOfDisc(1e-6, 0.0001, 5.0))

    //println("Hemisphere " + electricFieldOfHemisphere(1e-6, 0.0001, 5.0))

    println("Height in cone: " + heightFunctionOfCone(5.0,10.0, 3.6))
    println("Height in cut cone: " + heightFunctionOfCutCone(10.0,5.0,5.0,4.8))
}