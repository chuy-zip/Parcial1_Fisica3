package com.example.ejercicio5_parcial1_f3

import kotlin.math.PI
import kotlin.math.sqrt

fun functionOfSemicircle(maxRadius: Double, currentRadius: Double): Double {
    return sqrt(maxRadius * maxRadius - currentRadius * currentRadius)
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

fun electricFieldOfDisc(QCharge: Double, distance: Double, radius: Double): Double {
    val Eo = 8.85e-12

    var sumOfElectricField = 0.0
    sumOfElectricField  = (QCharge / (2 * PI * Eo * radius*radius) ) * (1 - distance/sqrt(distance*distance + radius*radius) )

    return sumOfElectricField

}

fun electricFieldOfHemisphere(){

}

fun main() {
    //volumeOfSemiCircle(3.0)
    println(electricFieldOfDisc(6e-6, 30.0, 10.0))
}