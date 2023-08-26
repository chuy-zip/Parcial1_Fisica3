package com.example.ejercicio5_parcial1_f3

import kotlin.math.PI
import kotlin.math.sqrt

fun electricFieldOfDisc(qCharge: Double, distance: Double, radius: Double): Double {
    val e = 8.85e-12
    return (qCharge / (2 * PI * e * radius * radius)) * (1 - distance / sqrt(distance * distance + radius * radius))
}

fun heightFunctionOfSemicircle(maxRadius: Double, currentDistance: Double): Double {
    return sqrt(maxRadius * maxRadius - currentDistance * currentDistance)
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

//R is the radius of the cone, H the height and x the point in which we want the radius "y"
fun heightFunctionOfCone(r:Double, h: Double, x: Double): Double{
    return (r-(r/h)*x)
}
fun electricFieldOfCone(charge: Double, radius:Double, height: Double, pointDistance: Double): Double{
    val qtyOfPartitions = 1000
    val partitionDistance = height / qtyOfPartitions
    val chargePerPartition = charge / qtyOfPartitions

    var distance: Double = partitionDistance
    var sumOfFields = 0.0

    while(distance < height){
        val partitionRadius = heightFunctionOfCone(radius,height,distance)
        val distanceOfPartition = height - distance + pointDistance
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

//R1 is the base or bigger radius, R2 is the second or lower radius, H the height and x the point in which we want the radius "y"
fun heightFunctionOfTruncatedCone(r1:Double, r2: Double, h: Double, x: Double): Double{
    return (r1 + ((r2-r1)/h) * x)
}

fun electricFieldOfTruncatedCone(charge: Double, radius1:Double, radius2:Double, height: Double, pointDistance: Double): Double{
    val qtyOfPartitions = 1000
    val partitionDistance = height / qtyOfPartitions
    val chargePerPartition = charge / qtyOfPartitions

    var distance: Double = partitionDistance
    var sumOfFields = 0.0

    while(distance <= height){
        val partitionRadius = heightFunctionOfTruncatedCone(radius1, radius2, height, distance)
        val distanceOfPartition = height - distance + pointDistance
        val partitionField = electricFieldOfDisc(chargePerPartition, distanceOfPartition, partitionRadius)
        //println("Field: $partitionField")
        //println("Radius: $partitionRadius")
        //println("distance: $distanceOfPartition")
        //println("Height at $distance: $partitionRadius")
        //println("--------")

        sumOfFields += partitionField
        distance += partitionDistance
    }

    return sumOfFields
}

fun main() {
    //volumeOfSemiCircle(3.0)
    println("Disc: " + electricFieldOfDisc(1e-6, 0.0001, 5.0))

    println("Hemisphere: " + electricFieldOfHemisphere(1e-6, 0.0001, 5.0))

    println("Cone: " + electricFieldOfCone(1e-6,5.0,5.0,0.0001))

    println("TruncatedCone: " + electricFieldOfTruncatedCone(1e-6,6.0,5.0,5.0, 0.0001))

}