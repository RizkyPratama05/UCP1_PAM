package com.example.ucp1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilPage(
    OnKembaliBtnClick : () -> Unit,
    OnTambahBtnClick : () -> Unit
){
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_foreground),
                            contentDescription = null,
                            modifier = Modifier
                                .size(size = 140.dp)
                                .padding(top = 30.dp, bottom = 30.dp)
                        )

                        Text(
                            text = "Rizky Pratama Putra",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 60.dp)
                        )
                    }
                }
            )
        }
    ) {
        isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang)
        ) {  }
    }
}