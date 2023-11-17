package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formdata(
    choice1: List<String>,
    choise2: List<String>,
    onSelectionChanged: (String) -> Unit,
    onConfirmButtonClicked: (MutableList<String>) -> Unit,
) {
    var nametxt by remember {
        mutableStateOf("")
    }
    var nimtext by remember {
        mutableStateOf("")
    }
    var focustxt by remember {
        mutableStateOf("")
    }

    var titletxt by remember {
        mutableStateOf("")
    }


    var selecteddosen1 by rememberSaveable {
        mutableStateOf("")
    }

    var selecteddosen2 by rememberSaveable {
        mutableStateOf("")
    }
    var listData: MutableList<String> = mutableListOf(nametxt, nimtext, focustxt, titletxt)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(text = "Coustomer Data", fontWeight = FontWeight.Bold)

        OutlinedTextField(value = nametxt,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { nametxt = it },
            label = { Text(text = stringResource(id = R.string.name)) })


        OutlinedTextField(value = nimtext,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { nimtext = it },
            label = { Text(text = stringResource(id = R.string.nim)) })


        OutlinedTextField(value = focustxt,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { focustxt = it },
            label = { Text(text = stringResource(id = R.string.focus)) })


        OutlinedTextField(value = titletxt,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { titletxt = it },
            label = { Text(text = stringResource(id = R.string.paper_title)) })


        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                choice1.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = selecteddosen1 == item,
                        onClick = {
                            selecteddosen1 = item
                            onSelectionChanged(item)
                        }
                    ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = selecteddosen1 == item,
                            onClick = {
                                selecteddosen1 = item
                                onSelectionChanged(item)
                            }
                        )
                        Text(item)
                    }
                }

            }

            Column {
                choice1.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = selecteddosen2 == item,
                        onClick = {
                            selecteddosen2 = item
                            onSelectionChanged(item)
                        }
                    ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = selecteddosen2 == item,
                            onClick = {
                                selecteddosen2 = item
                                onSelectionChanged(item)
                            }
                        )
                        Text(item)
                    }
                }

            }
        }
        
        Button(onClick = { onConfirmButtonClicked(listData) },
            Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.btn_confirm))
        }
    }
}
