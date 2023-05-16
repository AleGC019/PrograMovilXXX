package com.example.trycarstracker.repository

import com.example.trycarstracker.data.cars
import com.example.trycarstracker.data.model.CarModel

class CarRepository (private val movies: MutableList<CarModel>){

    fun getCars() = cars

    fun addCar(newCar: CarModel){
        cars.add(newCar)
    }

    fun deleteCar(car: CarModel){
        cars.remove(car)
    }
}