package com.example

import android.app.Application
import com.example.trycarstracker.data.cars
import com.example.trycarstracker.repository.CarRepository

class CarReviewerApplication: Application() {

    val carRepository: CarRepository by lazy {
        CarRepository(cars)
    }
}