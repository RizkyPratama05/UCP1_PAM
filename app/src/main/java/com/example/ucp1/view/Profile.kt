package com.example.ucp1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

data class FormData(
    val matkul: String,
    val aktkelas: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilPage(
    OnKembaliBtnClick : () -> Unit,
    OnTambahBtnClick : () -> Unit
){
    val datalist = listOf(
        FormData(
            matkul = "Pengembangan Aplikasi Mobile",
            aktkelas = "23-Kelas A"
        ),
        FormData(
            matkul = "Pengembangan Aplikasi Web",
            aktkelas = "23-Kelas A"
        ),
        FormData(
            matkul = "Web Developer",
            aktkelas = "23-Kelas A"
        ),
        FormData(
            matkul = "Pengembangan Game Mobile",
            aktkelas = "23-Kelas A"
        ),
        FormData(
            matkul = "Cyber Security",
            aktkelas = "23-Kelas A"
        ),
    )
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar( modifier = Modifier,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Blue),
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.fotoku3),
                            contentDescription = null,
                            modifier = Modifier
                                .size(size = 170.dp)
                                .padding(top = 30.dp, bottom = 30.dp)
                        )
                        Column(modifier = Modifier.padding(top = 55.dp, end = 60.dp)) {
                            Text(
                                text = "Rizky Pratama Putra",
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "20230140005",
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            )
        }
    ) {
        isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang),
        ) {
            Text(
                text = "Daftar Presensi MataKuliah",
                fontSize = 25.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier
                    .padding(start = 60.dp, top = 30.dp)
            )

            Spacer(modifier = Modifier.padding(top = 30.dp))

            Card(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(height = 400.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Blue)
            ) {
                LazyColumn(
                    modifier = Modifier,
                    contentPadding = PaddingValues(start = 16.dp, end = 30.dp)
                ) {
                    items(items = datalist) {
                        item ->
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation =8.dp
                            ),
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .padding(start = 10.dp, end = 10.dp, top = 30.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.4f))
                        ) {
                            Column {
                                Text(text = item.matkul,
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(all = 10.dp)
                                )
                                Text(text = item.aktkelas,
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
                                )
                            }
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ElevatedButton(
                    modifier = Modifier
                        .width(160.dp).padding(bottom = 30.dp, top = 30.dp).height(60.dp),
                    shape = MaterialTheme.shapes.small,
                    onClick = OnKembaliBtnClick
                ) {
                    Text(
                        text = "LOGOUT",
                        color = Color.Blue,
                        fontSize = 20.sp
                    )
                }

                ElevatedButton(
                    modifier = Modifier
                        .width(160.dp).padding(bottom = 30.dp, top = 30.dp).height(60.dp),
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    onClick = OnTambahBtnClick
                ) {
                    Text(
                        text = "TAMBAH",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}