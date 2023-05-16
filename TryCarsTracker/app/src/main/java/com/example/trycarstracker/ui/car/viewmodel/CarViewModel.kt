package com.example.trycarstracker.ui.car.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.CarReviewerApplication
import com.example.trycarstracker.data.model.CarModel
import com.example.trycarstracker.repository.CarRepository

class CarViewModel(private val carRepository: CarRepository): ViewModel() {

    var carname = MutableLiveData("")
    var brand = MutableLiveData("")
    var model = MutableLiveData("")
    var year = MutableLiveData("")
    var image = MutableLiveData("")
    var description = MutableLiveData("")
    var status = MutableLiveData("")

    fun getCars() = carRepository.getCars()

    fun addCar(car: CarModel) = carRepository.addCar(car)

    private fun validateData(): Boolean{
        when{
            carname.value.isNullOrEmpty() -> return false
            brand.value.isNullOrEmpty() -> return false
            model.value.isNullOrEmpty() -> return false
            year.value.isNullOrEmpty() -> return false
            image.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createCar(){
        if(!validateData()){
            status.value = CAR_WRONG_DATA
            return
        }
        val newCar = CarModel(
            carname.value.toString(),
            brand.value.toString(),
            model.value.toString(),
            year.value.toString().toInt(),
            image.value.toString(),
            description.value.toString()
        )

        addCar(newCar)
        status.value = CAR_CREATED
    }

    fun clearData(){
        carname.value = ""
        brand.value = ""
        model.value = ""
        year.value = ""
        image.value = ""
        description.value = ""
    }

    fun clearStatus(){
        status.value = CAR_BASE
    }

    fun setSelectedCar(car: CarModel){
        carname.value = car.carname
        brand.value = car.brand
        model.value = car.model
        year.value = car.year.toString()
        image.value = car.img
        description.value = car.description
    }





    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as CarReviewerApplication
                CarViewModel(app.carRepository)
            }
        }

        const val CAR_CREATED = "CAR CREATED"
        const val CAR_WRONG_DATA = "CAR WRONG DATA"
        const val CAR_BASE = ""
    }
}

