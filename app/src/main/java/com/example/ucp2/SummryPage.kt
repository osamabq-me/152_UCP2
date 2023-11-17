package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.esjumbo.data.OrderUIState


@Composable
fun SummryPage(
    orderUIState: OrderUIState,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
        ) {
            Text(text = stringResource(id = R.string.name))
            Text(text = orderUIState.name)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = stringResource(id = R.string.nim))
            Text(text = orderUIState.Nim)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = stringResource(id = R.string.focus))
            Text(text = orderUIState.focus)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = stringResource(id = R.string.paper_title))
            Text(text = orderUIState.title)

            Text(text = stringResource(id = R.string.dosen1))
            Text(text = orderUIState.dos1)

            Text(text = stringResource(id = R.string.dosen2))
            Text(text = orderUIState.dos2)




            OutlinedButton(
                onClick = onBackButtonClicked,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.btn_back))
            }
        }




    }
}