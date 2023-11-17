package com.example.ucp2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ucp2.ui.theme.UCP2Theme


@Composable
fun Homepage(
    onStartButtonClicked: () -> Unit

){
    val image = painterResource(id = R.drawable.umy)

    Column (
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop)
        
        Button(onClick = onStartButtonClicked) {
            Text(text = stringResource(id = R.string.btn_Start))
            
        }
    }
}
