package com.example.ejercicio5_parcial1_f3

import kotlin.math.PI
import kotlin.math.sqrt

fun functionOfSemicircle(maxRadius: Double, currentRadius: Double): Double {
    return sqrt(maxRadius * maxRadius - currentRadius * currentRadius)
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
        val partitionRadius = functionOfSemicircle(radius, distance)
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
        val partitionRadius = functionOfSemicircle(hemisphereRadius, distance)
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
    println("Disco " + electricFieldOfDisc(1e-6, 0.0001, 5.0))

    println("Hemisferio " + electricFieldOfHemisphere(1e-6, 0.0001, 5.0))
}