package com.example.ucp2

import androidx.lifecycle.ViewModel
import com.example.esjumbo.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {

    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUi: StateFlow<OrderUIState> = _stateUI.asStateFlow()


    fun setContact(list: MutableList<String>){
        _stateUI.update {
                statenow-> statenow.copy(
            name = list[0],
            Nim = list[1],
            focus = list[2],
            title = list[3]

        )
        }
    }

    fun setdosen1(dosenselection: String){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(dos1 = dosenselection) }
    }

    fun setdosen2(dosenselection: String){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(dos2 = dosenselection) }
    }
}