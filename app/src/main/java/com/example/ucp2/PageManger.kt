package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.esjumbo.data.DataList
import com.example.esjumbo.data.DataList.dosen1
import com.example.esjumbo.data.DataList.dosen2


enum class PageManager {
    Home,
    form,
    Summary
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),

    ) {
    Scaffold { innerPadding ->
        val uiState by viewModel.stateUi.collectAsState()

        NavHost(
            navController = navController,
            startDestination = PageManager.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PageManager.Home.name){
                Homepage (onStartButtonClicked ={navController.navigate(PageManager.form.name)}
                )
            }

            composable(route = PageManager.form.name){
                val context = LocalContext.current
                val context2 = LocalContext.current

                Formdata(
                    choice1 = dosen1.map { id -> context.resources.getString(id) },
                    choise2 =dosen2.map { id -> context2.resources.getString(id)  } ,
                    onSelectionChanged = { viewModel.setdosen1(it) },
                    onSelectionChanged2 = {viewModel.setdosen2(it)},
                    onConfirmButtonClicked ={
                        viewModel.setContact(it)
                        navController.navigate(PageManager.Summary.name)}
                )
            }

            composable(route = PageManager.Summary.name){
                SummryPage (orderUIState = uiState,onBackButtonClicked ={navController.navigate(PageManager.form.name)}
                )
            }
        }
    }
}